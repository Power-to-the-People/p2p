package nz.org.p2p.security.hibernate;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.WeakHashMap;

import nz.org.p2p.model.hibernate.DataSource.Parameter;
import nz.org.p2p.model.hibernate.DataSourceService;
import nz.org.p2p.model.hibernate.ProxyDataSource;
import nz.org.p2p.security.model.Permission;
import nz.org.p2p.security.model.SID;
import nz.org.p2p.security.model.Securable;
import nz.org.p2p.security.model.SimplePermission;

/**
 * <p>The secure data source class provides secure access to data that may be restricted. .</p>
 * 
 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.security.hibernate package documentation} for more information.</p>
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public class SecureDataSource extends ProxyDataSource {

	/**
	 * <p>The secure iterator class provides an {@link Iterator} implementation for accessing restrictable data objects.</p>
	 * 
	 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
	 * <b>See</b> {@link nz.org.p2p.security.hibernate package documentation} for more information.</p>
	 *
	 * @param <E> the element type
	 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
	 * @author Richard Thomas &lt;richard@kanecta.com&gt;
	 */
	private class SecureIterator<E> implements Iterator<E> {

		/** The index of the next value. */
		int i;

		/** The list to be iterated upon. */
		List<E> list;

		/** The end the end of the iteration range in list. */
		int end;

		/**
		 * Instantiates a new secure iterator.
		 *
		 * @param list the list
		 * @param i the i
		 * @param end the end
		 */
		public SecureIterator(List<E> list, int i, int end) {
			super();
			this.list = list;
			this.i = i;
			this.end = end;
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return i < end;
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public E next() {
			return list.get(i++);
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

	};

	/**
	 * <p>The secure list class provides a list implementation for dealing with  securable data objects.</p>
	 * 
	 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
	 * <b>See</b> {@link nz.org.p2p.security.hibernate package documentation} for more information.</p>
	 *
	 * @param <E> the element type
	 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
	 * @author Richard Thomas &lt;richard@kanecta.com&gt;
	 */
	private class SecureList<E> implements List<E> {

		/** The list. */
		final List<E> list;

		/** The base. */
		final int base;

		/** The length. */
		final int length;

		/** The type. */
		private final Class<E> type;

		/**
		 * Instantiates a new secure list.
		 *
		 * @param list the list
		 * @param type the type
		 */
		public SecureList(List<E> list, Class<E> type) {
			this.list = list;
			this.base = 0;
			this.length = list.size();
			this.type=type;
		}

		/**
		 * Instantiates a new secure list.
		 *
		 * @param list the list
		 * @param type the type
		 * @param base the base
		 * @param length the length
		 */
		public SecureList(List<E> list,Class<E>type, int base, int length) {
			this.list = list;
			this.base = base;
			this.length = length;
			this.type=type;
		}

		/* (non-Javadoc)
		 * @see java.util.List#add(java.lang.Object)
		 */
		@Override
		public boolean add(E e) {
			throw new UnsupportedOperationException();
		}

		/* (non-Javadoc)
		 * @see java.util.List#add(int, java.lang.Object)
		 */
		@Override
		public void add(int index, E element) {
			throw new UnsupportedOperationException();

		}

		/* (non-Javadoc)
		 * @see java.util.List#addAll(java.util.Collection)
		 */
		@Override
		public boolean addAll(Collection<? extends E> c) {
			return addAll(0, c);
		}

		/* (non-Javadoc)
		 * @see java.util.List#addAll(int, java.util.Collection)
		 */
		@Override
		public boolean addAll(int index, Collection<? extends E> c) {
			throw new UnsupportedOperationException();
		}

		/* (non-Javadoc)
		 * @see java.util.List#clear()
		 */
		@Override
		public void clear() {
			throw new UnsupportedOperationException();

		}

		/* (non-Javadoc)
		 * @see java.util.List#contains(java.lang.Object)
		 */
		@Override
		public boolean contains(Object o) {
			return indexOf(o) != -1;
		}

		/* (non-Javadoc)
		 * @see java.util.List#containsAll(java.util.Collection)
		 */
		@Override
		public boolean containsAll(Collection<?> c) {
			HashSet<E> set = new HashSet(c);
			for (int i = 0; i < length; i++) {
				set.remove(list.get(i + base));
			}
			return set.isEmpty();
		}

		/* (non-Javadoc)
		 * @see java.util.List#get(int)
		 */
		@Override
		public E get(int index) {
			Object bean = list.get(index);
			if (bean instanceof Securable) {
				securityService.check(SimplePermission.VIEW,
						((Securable) bean).getSid());
				return securityService.getSecureProxy(type, bean);
			}
			return null;
		}

		/* (non-Javadoc)
		 * @see java.util.List#indexOf(java.lang.Object)
		 */
		@Override
		public int indexOf(Object o) {
			for (int i = 0; i < length; i++) {
				E e = list.get(base + i);
				if (e == o ? e == null : e.equals(o))
					return i;
			}
			return 0;
		}

		/* (non-Javadoc)
		 * @see java.util.List#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			return list.isEmpty();
		}

		/* (non-Javadoc)
		 * @see java.util.List#iterator()
		 */
		@Override
		public Iterator<E> iterator() {
			return new SecureIterator<E>(this, 0, length);
		}

		/* (non-Javadoc)
		 * @see java.util.List#lastIndexOf(java.lang.Object)
		 */
		@Override
		public int lastIndexOf(Object o) {
			for (int i = length - 1; i >= 0; i--) {
				E e = list.get(base + i);
				if (e == o ? e == null : e.equals(o))
					return i;
			}
			return -1;
		}

		/* (non-Javadoc)
		 * @see java.util.List#listIterator()
		 */
		@Override
		public ListIterator<E> listIterator() {
			return listIterator(0);
		}

		/* (non-Javadoc)
		 * @see java.util.List#listIterator(int)
		 */
		@Override
		public ListIterator<E> listIterator(int index) {
			return new SecureListIterator<E>(list, index, base, base + length);
		}

		/* (non-Javadoc)
		 * @see java.util.List#remove(int)
		 */
		@Override
		public E remove(int index) {
			throw new UnsupportedOperationException();
		}

		/* (non-Javadoc)
		 * @see java.util.List#remove(java.lang.Object)
		 */
		@Override
		public boolean remove(Object o) {
			throw new UnsupportedOperationException();
		}

		/* (non-Javadoc)
		 * @see java.util.List#removeAll(java.util.Collection)
		 */
		@Override
		public boolean removeAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		/* (non-Javadoc)
		 * @see java.util.List#retainAll(java.util.Collection)
		 */
		@Override
		public boolean retainAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		/* (non-Javadoc)
		 * @see java.util.List#set(int, java.lang.Object)
		 */
		@Override
		public E set(int index, E element) {
			throw new UnsupportedOperationException();
		}

		/* (non-Javadoc)
		 * @see java.util.List#size()
		 */
		@Override
		public int size() {
			return length;
		}

		/* (non-Javadoc)
		 * @see java.util.List#subList(int, int)
		 */
		@Override
		public List<E> subList(int fromIndex, int toIndex) {
			if (fromIndex < 0)
				throw new IllegalArgumentException("negative fromIndex:"
						+ fromIndex);
			if (fromIndex > length)
				throw new IllegalArgumentException("fromIndex exceeds length:"
						+ fromIndex);
			if (toIndex < 0)
				throw new IllegalArgumentException("negative toIndex:"
						+ toIndex);
			if (toIndex > length)
				throw new IllegalArgumentException("toIndex exceeds bounds:"
						+ toIndex);
			return new SecureList<E>(list, type, this.base + fromIndex, toIndex
					+ base);
		}

		/* (non-Javadoc)
		 * @see java.util.List#toArray()
		 */
		@Override
		public Object[] toArray() {
			Object[] array = new Object[length];
			int i = 0;
			for (Object o : list) {
				try {
					if (o instanceof Securable) {
						securityService.check(SimplePermission.VIEW,
								((Securable) o).getSid());
					}
					array[i++] = o;

				} catch (SecurityException e) {
					array[i++] = null;
				}
			}
			return array;
		}

		/* (non-Javadoc)
		 * @see java.util.List#toArray(T[])
		 */
		@SuppressWarnings("unchecked")
		@Override
		public <T> T[] toArray(T[] a) {
			T[] array;
			if (a.length < this.length)
				array = (T[]) Array.newInstance(
						a.getClass().getComponentType(), this.length);
			array = a;
			for (int i = 0; i < length; i++) {
				Object o = list.get(i + base);
				try {
					if (o instanceof Securable) {
						securityService.check(SimplePermission.VIEW,
								((Securable) o).getSid());
					}
					array[i++] = (T) o;

				} catch (SecurityException e) {
					array[i++] = null;
				}
			}
			return null;
		}
	}

	/**
	 * <p>The secure list iterator class provides... .</p>
	 * 
	 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
	 * <b>See</b> {@link nz.org.p2p.security.hibernate package documentation} for more information.</p>
	 *
	 * @param <E> the element type
	 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
	 * @author Richard Thomas &lt;richard@kanecta.com&gt;
	 */
	private class SecureListIterator<E> implements ListIterator<E> {

		/** The first. */
		int first;

		/** The last. */
		int last;

		/** The i. */
		int i;

		/** The list. */
		List<E> list;

		/**
		 * Instantiates a new secure list iterator.
		 *
		 * @param list the list
		 * @param i the i
		 * @param first the first
		 * @param last the last
		 */
		public SecureListIterator(List<E> list, int i, int first, int last) {
			super();
			this.list = list;
			this.i = i;
			this.first = first;
			this.last = last;
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#add(java.lang.Object)
		 */
		@Override
		public void add(E e) {
			throw new UnsupportedOperationException();

		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return i < last;
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#hasPrevious()
		 */
		@Override
		public boolean hasPrevious() {
			return i > first;
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#next()
		 */
		@Override
		public E next() {
			return list.get(i++);
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#nextIndex()
		 */
		@Override
		public int nextIndex() {
			return i;
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#previous()
		 */
		@Override
		public E previous() {
			return list.get(--i);
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#previousIndex()
		 */
		@Override
		public int previousIndex() {
			return i - 1;
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#remove()
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#set(java.lang.Object)
		 */
		@Override
		public void set(E e) {
			throw new UnsupportedOperationException();

		}

	}

	/** The proxies. */
	Map<Object, Object> proxies=new WeakHashMap<Object, Object>();

	/** The security service. */
	private SecurityService securityService;

	/**
	 * Instantiates a new secure data source.
	 *
	 * @param dss the dss
	 */
	public SecureDataSource(DataSourceService dss) {
		super(dss);
	}

	/**
	 * Check.
	 *
	 * @param rights the rights
	 * @param object the object
	 */
	void check(Permission rights, Object object) {
		if (object instanceof Securable) {
			securityService.check(rights, ((Securable) object).getSid());
		}
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.hibernate.ProxyDataSource#merge(java.lang.Object)
	 */
	@Override
	public <B> B merge(B object) {
		check(SimplePermission.UPDATE, object);
		return super.merge(object);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.hibernate.ProxyDataSource#merge(java.lang.String, java.lang.Object)
	 */
	@Override
	public <B> B merge(String entity, B object) {
		check(SimplePermission.UPDATE, object);
		return super.merge(entity, object);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.hibernate.ProxyDataSource#select(java.lang.Class, java.lang.String, nz.org.p2p.model.hibernate.DataSource.Parameter[])
	 */
	@Override
	public <T> List<T> select(Class<? extends T> type, String hql,
			Parameter... params) {
		SID typeSid = securityService.getTypeSid(type);
		if (typeSid != null) {
			check(SimplePermission.VIEW, typeSid);
		}
		final List<T> result = super.select(type, hql, params);
		List<T> secureResult = new SecureList<T>(result, (Class<T>) type, 0, result.size());
		return secureResult;
	}
}

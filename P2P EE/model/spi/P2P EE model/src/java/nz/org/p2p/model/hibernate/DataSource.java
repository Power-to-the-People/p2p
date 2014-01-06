package nz.org.p2p.model.hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * The data source class provides access to a data repository.
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * 
 */
public class DataSource implements DataSourceService {

	/**
	 * The <code>Boyancy</code> class encapsulates a session's "boyancy" in the
	 * session pool. Session is closed if it has been abandoned too long.
	 *
	 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
	 */
	class Boyancy implements Comparable<Boyancy> {

		/** The expire session will expire after it has been closed. */
		Calendar expire;

		/** The session. */
		Session session;

		/**
		 * Instantiates a new boyancy.
		 *
		 * @param expire the expire
		 * @param session the session
		 */
		public Boyancy(Calendar expire, Session session) {
			super();
			this.expire = expire;
			this.session = session;
		}

		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Boyancy o) {
			int c = 0;
			if (this == o)
				return 0;
			if (c == 0)
				c = expire.compareTo( o.expire);
			if (c == 0)
				c = session.hashCode() - o.session.hashCode();
			return c;
		}
	};

	/**
	 * The parameter class encapsulates  parameter value supplied to a query.
	 *
	 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
	 * @author Richard Thomas &lt;richard@kanecta.com&gt;
	 */
	public static class Parameter {

		/** The type. */
		protected final Type type;

		/** The name. */
		final String name;

		/** The value. */
		private Object value;

		/** The bool value. */
		private boolean boolValue;

		/** The byte value. */
		private byte byteValue;

		/** The char value. */
		private char charValue;

		/** The short value. */
		private short shortValue;

		/** The int value. */
		private int intValue;

		/** The long value. */
		private long longValue;

		/** The big int value. */
		private BigInteger bigIntValue;

		/** The float value. */
		private float floatValue;

		/** The double value. */
		private double doubleValue;

		/** The big decimal value. */
		public BigDecimal bigDecimalValue;

		/**
		 * Instantiates a new parameter.
		 *
		 * @param name the name
		 * @param value the value
		 */
		public Parameter(String name, BigDecimal value) {
			type = Type.BIGECIMAL;
			this.name = name;
			this.bigDecimalValue = value;
		}

		/**
		 * Instantiates a new parameter.
		 *
		 * @param name the name
		 * @param value the value
		 */
		public Parameter(String name, BigInteger value) {
			type = Type.BIGINT;
			this.name = name;
			this.bigIntValue = value;
		}

		/**
		 * Instantiates a new parameter.
		 *
		 * @param name the name
		 * @param value the value
		 */
		public Parameter(String name, boolean value) {
			type = Type.BOOLEAN;
			this.name = name;
			this.boolValue = value;
		}

		/**
		 * Instantiates a new parameter.
		 *
		 * @param name the name
		 * @param value the value
		 */
		public Parameter(String name, byte value) {
			type = Type.BYTE;
			this.name = name;
			this.byteValue = value;
		}

		/**
		 * Instantiates a new parameter.
		 *
		 * @param name the name
		 * @param value the value
		 */
		public Parameter(String name, byte[] value) {
			type = Type.BINARY;
			this.name = name;
			this.value = value;
		}

		/**
		 * Instantiates a new parameter.
		 *
		 * @param name the name
		 * @param value the value
		 */
		public Parameter(String name, Calendar value) {
			type = Type.CALENDAR;
			this.name = name;
			this.value = value;
		}

		/**
		 * Instantiates a new parameter.
		 *
		 * @param name the name
		 * @param value the value
		 */
		public Parameter(String name, char value) {
			type = Type.CHAR;
			this.name = name;
			this.charValue = value;
		}

		/**
		 * Instantiates a new parameter.
		 *
		 * @param name the name
		 * @param value the value
		 */
		public Parameter(String name, double value) {
			type = Type.DOUBLE;
			this.name = name;
			this.doubleValue = value;
		}

		/**
		 * Instantiates a new parameter.
		 *
		 * @param name the name
		 * @param value the value
		 */
		public Parameter(String name, float value) {
			type = Type.FLOAT;
			this.name = name;
			this.floatValue = value;
		}

		/**
		 * Instantiates a new parameter.
		 *
		 * @param name the name
		 * @param value the value
		 */
		public Parameter(String name, int value) {
			type = Type.INT;
			this.name = name;
			this.intValue = value;
		}

		/**
		 * Instantiates a new parameter.
		 *
		 * @param name the name
		 * @param value the value
		 */
		public Parameter(String name, long value) {
			type = Type.LONG;
			this.name = name;
			this.longValue = value;
		}

		/**
		 * Instantiates a new parameter.
		 *
		 * @param name the name
		 * @param value the value
		 */
		public Parameter(String name, Object value) {
			type = Type.PARAM;
			this.name = name;
			this.value = value;
		}

		/**
		 * Instantiates a new parameter.
		 *
		 * @param name the name
		 * @param value the value
		 */
		public Parameter(String name, short value) {
			type = Type.BYTE;
			this.name = name;
			this.shortValue = value;
		}

		/**
		 * Instantiates a new parameter.
		 *
		 * @param name the name
		 * @param value the value
		 */
		public Parameter(String name, String value) {
			type = Type.STRING;
			this.name = name;
			this.value = value;
		}

		/**
		 * Instantiates a new parameter.
		 *
		 * @param type the type
		 * @param name the name
		 * @param value the value
		 */
		protected Parameter(Type type, String name, Object value) {
			this.type = type;
			this.name = name;
			this.value = value;
		}
	}

	/**
	 * The reaper class drown long abandoned sessions by closing them.
	 * Glug glug..
	 *
	 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
	 * @author Richard Thomas &lt;richard@kanecta.com&gt;
	 */
	class Reaper implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
			while ((!pool.isEmpty())&&pool.size()>minimumPool) {
				synchronized (pool) {
					try {
						pool.wait(30000);

						Calendar nowCalendar = Calendar.getInstance();
						while ((!pool.isEmpty())&&pool.size()>minimumPool) {
							Entry<Boyancy, Session> firstEntry = pool
									.firstEntry();
							Boyancy bouyancy = firstEntry.getKey();
							if (nowCalendar.after(bouyancy.expire)) {
								pool.entrySet().remove(firstEntry);
							} else
								break;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
			reaper=null;

		}

	}

	/**
	 * The text parameter class.
	 *
	 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
	 * @author Richard Thomas &lt;richard@kanecta.com&gt;
	 */
	static class TextParameter extends Parameter {

		/**
		 * Instantiates a new text parameter.
		 *
		 * @param name the name
		 * @param text the text
		 */
		public TextParameter(String name, String text) {
			super(Type.TEXT, name, text);
		}
	}

	/**
	 * The time parameter class.
	 *
	 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
	 * @author Richard Thomas &lt;richard@kanecta.com&gt;
	 */
	static class TimeParameter extends Parameter {

		/**
		 * Instantiates a new time parameter.
		 *
		 * @param name the name
		 * @param date the date
		 */
		public TimeParameter(String name, Date date) {
			super(Type.TIME, name, date);
		}
	}

	/**
	 * The time stamp parameter class.
	 *
	 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
	 * @author Richard Thomas &lt;richard@kanecta.com&gt;
	 */
	static class TimeStampParameter extends Parameter {

		/**
		 * Instantiates a new time stamp parameter.
		 *
		 * @param name the name
		 * @param date the date
		 */
		public TimeStampParameter(String name, Date date) {
			super(Type.TIMESTAMP, name, date);
		}
	}

	/**
	 * The type enum.
	 *
	 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
	 * @author Richard Thomas &lt;richard@kanecta.com&gt;
	 */
	enum Type {

		/** The param. */
		PARAM {
			@Override
			void set(Query qry, Parameter p) {
				qry.setParameter(p.name, p.value);
			}
		},

		/** The boolean. */
		BOOLEAN {
			@Override
			void set(Query qry, Parameter p) {
				qry.setBoolean(p.name, p.boolValue);
			}
		},

		/** The byte. */
		BYTE {
			@Override
			void set(Query qry, Parameter p) {
				qry.setByte(p.name, p.byteValue);
			}
		},

		/** The short. */
		SHORT {
			@Override
			void set(Query qry, Parameter p) {
				qry.setShort(p.name, p.shortValue);
			}
		},

		/** The int. */
		INT {
			@Override
			void set(Query qry, Parameter p) {
				qry.setInteger(p.name, p.intValue);
			}
		},

		/** The long. */
		LONG {
			@Override
			void set(Query qry, Parameter p) {
				qry.setLong(p.name, p.longValue);
			}
		},

		/** The bigint. */
		BIGINT {
			@Override
			void set(Query qry, Parameter p) {
				qry.setBigInteger(p.name, p.bigIntValue);
			}
		},

		/** The float. */
		FLOAT {
			@Override
			void set(Query qry, Parameter p) {
				qry.setFloat(p.name, p.floatValue);
			}
		},

		/** The double. */
		DOUBLE {
			@Override
			void set(Query qry, Parameter p) {
				qry.setDouble(p.name, p.doubleValue);
			}
		},

		/** The string. */
		STRING {
			@Override
			void set(Query qry, Parameter p) {
				qry.setString(p.name, (String) p.value);
			}
		},

		/** The bigecimal. */
		BIGECIMAL {
			@Override
			void set(Query qry, Parameter p) {
				qry.setBigDecimal(p.name, p.bigDecimalValue);
			}
		},

		/** The calendar. */
		CALENDAR {
			@Override
			void set(Query qry, Parameter p) {
				qry.setCalendar(p.name, (Calendar) p.value);
			}
		},

		/** The date. */
		DATE {
			@Override
			void set(Query qry, Parameter p) {
				qry.setDate(p.name, (Date) p.value);
			}
		},

		/** The time. */
		TIME {
			@Override
			void set(Query qry, Parameter p) {
				qry.setTime(p.name, (Date) p.value);
			}
		},

		/** The timestamp. */
		TIMESTAMP {
			@Override
			void set(Query qry, Parameter p) {
				qry.setTimestamp(p.name, (Date) p.value);
			}
		},

		/** The binary. */
		BINARY {
			@Override
			void set(Query qry, Parameter p) {
				qry.setBinary(p.name, (byte[]) p.value);
			}
		},

		/** The char. */
		CHAR {
			@Override
			void set(Query qry, Parameter p) {
				qry.setCharacter(p.name, p.charValue);
			}
		},

		/** The text. */
		TEXT {
			@Override
			void set(Query qry, Parameter p) {
				qry.setText(p.name, (String) p.value);
			}
		};

		/**
		 * Sets the {@code $name} property..
		 *
		 * @param qry the qry
		 * @param p the p
		 */
		abstract void set(Query qry, Parameter p);
	}


	/** The reaper. */
	private Thread reaper = null;

	/** The sessions. */
	private final Map<Thread, Session> sessions = new WeakHashMap<Thread, Session>();

	/** The session factory. */
	private final SessionFactory sessionFactory = null;

	/** The pooling. */
	private int pooling;

	/** The pool. */
	private final ConcurrentSkipListMap<Boyancy, Session> pool = new ConcurrentSkipListMap<Boyancy, Session>();

	/** The minimum pool default 5. */
	int minimumPool=5;

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.hibernate.DataSourceService#close()
	 */
	@Override
	public void close() {
		Session session = sessions.get(Thread.currentThread());
		if (session != null) {
			sessions.remove(Thread.currentThread());
			if (pooling > 0) {
				Calendar expire = Calendar.getInstance();
				expire.add(Calendar.MINUTE, pooling);
				pool.put(new Boyancy(expire, session), session);
				if (reaper == null) {
					reaper = new Thread(new Reaper());
					reaper.setPriority(Thread.MIN_PRIORITY);
					reaper.start();
				}
			}
			session = null;
		}
	};


	/**
	 * Creates a query.
	 *
	 * @param hql the hql
	 * @return A query
	 */
	public Query createQuery(String hql) {
		return getSession().createQuery(hql);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.hibernate.DataSourceService#executeUpdate(java.lang.String, nz.org.p2p.model.hibernate.DataSource.Parameter)
	 */
	/**
	 * Execute update.
	 *
	 * @param hql the hql
	 * @param params the params
	 * @return A int
	 */
	public int executeUpdate(String hql, Parameter... params) {
		Query qry = getSession().createQuery(hql);
		for (Parameter p : params) {
			p.type.set(qry, p);
		}
		return qry.executeUpdate();
	}

	/**
	 * Gets The minimum pool property.
	 *
	 * @return A minimum pool
	 */
	public int getMinimumPool() {
		return minimumPool;
	}


	/**
	 * Gets The pooling property.
	 *
	 * @see #setPooling(int)
	 * @return A pooling
	 */
	public int getPooling() {
		return pooling;
	}
	/* (non-Javadoc)
	 * @see nz.org.p2p.model.hibernate.DataSourceService#getSession()
	 */
	@Override
	public Session getSession() {
		Session session = sessions.get(Thread.currentThread());
		if (session == null) {
			if (!pool.isEmpty()) {
				synchronized (pool) {

					Entry<Boyancy, Session> lastEntry = pool.lastEntry();
					session = lastEntry.getValue();
					pool.entrySet().remove(lastEntry);

				}
			}
		}
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.hibernate.DataSourceService#getSessionFactory()
	 */
	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.hibernate.DataSourceService#merge(B)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <B extends Object> B merge(B member) {
		return (B) getSession().merge(member);

	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.hibernate.DataSourceService#merge(java.lang.String, B)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <B extends Object> B merge(String entity, B member) {
		return (B) getSession().merge(entity, member);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.hibernate.DataSourceService#select(java.lang.Class, java.lang.String, nz.org.p2p.model.hibernate.DataSource.Parameter)
	 */
	@Override
	public <T> List<T> select(Class<? extends T> type, String hql, Parameter... params) {
		Session session = getSession();
		Query qry = session.createQuery(hql);
		for (Parameter p : params) {
			p.type.set(qry, p);
		}
		@SuppressWarnings("unchecked")
		List<T> result = qry.list();
		return result;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.hibernate.DataSourceService#select(java.lang.String, nz.org.p2p.model.hibernate.DataSource.Parameter)
	 */
	@Override
	public List<Object> select(String hql, Parameter... params) {
		Session session = getSession();
		Query qry = session.createQuery(hql);
		for (Parameter p : params) {
			p.type.set(qry, p);
		}
		@SuppressWarnings("unchecked")
		List<Object> result = qry.list();
		return result;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.hibernate.DataSourceService#selectUnique(java.lang.Class, java.lang.String, nz.org.p2p.model.hibernate.DataSource.Parameter)
	 */
	@Override
	public <C> C selectUnique(Class<? extends C> type, String hql,
			Parameter... parameters) {

		Query qry=getSession().createQuery(hql);
		for(Parameter p:parameters) {
			p.type.set(qry, p);
		}
		return type.cast(qry.uniqueResult());
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.hibernate.DataSourceService#selectUnique(java.lang.String, nz.org.p2p.model.hibernate.DataSource.Parameter)
	 */
	@Override
	public Object selectUnique(String hql, Parameter... parameters) {
		Query qry=getSession().createQuery(hql);
		for(Parameter p:parameters) {
			p.type.set(qry, p);
		}
		return qry.uniqueResult();
	}

	/**
	 * Sets The minimum pool property.
	 *
	 * @param minimumPool A new minimum pool state
	 */
	public void setMinimumPool(int minimumPool) {
		this.minimumPool = minimumPool;
	}

	/**
	 * Sets The pooling property which defines the time in seconds a session
	 * may stay alive once abandoned without being rescued..
	 *
	 * @param pooling A new pooling state &lt 1 means not pooling.
	 */
	public void setPooling(int pooling) {
		this.pooling = pooling;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.hibernate.DataSourceService#update(B)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <B extends Serializable> B update(B member) {
		Session session = getSession();
		B result = (B) session.save(member);
		return result;

	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.hibernate.DataSourceService#update(java.lang.String, B)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <B extends Object> B update(String entity, B bean) {
		return (B) getSession().save(entity, bean);
	}
};

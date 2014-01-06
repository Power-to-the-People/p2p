package nz.org.p2p.model.hibernate;

import java.io.Serializable;
import java.util.List;

import nz.org.p2p.model.hibernate.DataSource.Parameter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface DataSourceService {

	/**
	 * Close.
	 */
	public abstract void close();

	/**
	 * Gets The session property.
	 *
	 * @return A session
	 */
	public abstract Session getSession();

	/**
	 * Gets The session factory for creating sessions.
	 *
	 * @return A session factory
	 */
	public abstract SessionFactory getSessionFactory();

	/**
	 * Update.
	 *
	 * @param <B> the generic type
	 * @param member the member
	 * @return A serializable
	 */
	public abstract <B extends Object> B merge(B bean);

	/**
	 * Update.
	 *
	 * @param <B> the generic type
	 * @param entity the entity
	 * @param member the member
	 * @return A serializable
	 */
	public abstract <B extends Object> B merge(String entity, B bean);

	/**
	 * Select.
	 *
	 * @param <T> the generic type
	 * @param type the type
	 * @param hql the hql
	 * @param params the params
	 * @return A list
	 */
	public abstract <T> List<T> select(Class<? extends T> type, String hql,
			Parameter... params);

	/**
	 * Select.
	 *
	 * @param hql the hql
	 * @param params the params
	 * @return the list<? extends object>
	 */
	public abstract List<Object> select(String hql, Parameter... params);

	/**
	 * Select unique result return it as an object of the given <@code type>.
	 *
	 * @param hql An HQL selection query to return one object, multiple
	 * columns
	 * return an array as per Hibernate.
	 * @param parameters the parameters
	 * @return A object
	 */
	public abstract <C> C selectUnique(Class<? extends C> type, String hql,
			Parameter... parameters);

	/**
	 * Select unique result return it as an {@link Object}.
	 *
	 * @param hql An HQL selection query to return one object, multiple
	 * columns
	 * return an array as per Hibernate.
	 * @param parameters the parameters
	 * @return An object
	 */
	public abstract Object selectUnique(String hql, Parameter... parameters);

	/**
	 * Update.
	 *
	 * @param <B> the generic type
	 * @param member the member
	 * @return A serializable
	 */
	public abstract <B extends Serializable> B update(B bean);

	/**
	 * Update.
	 *
	 * @param <B> the generic type
	 * @param entity the entity
	 * @param bean a bean
	 * @return A serializable
	 */
	public abstract <B extends Object> B update(String entity, B bean);

}
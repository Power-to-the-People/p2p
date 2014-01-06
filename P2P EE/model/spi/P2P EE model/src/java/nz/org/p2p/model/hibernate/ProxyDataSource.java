package nz.org.p2p.model.hibernate;

import java.io.Serializable;
import java.util.List;

import nz.org.p2p.model.hibernate.DataSource.Parameter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProxyDataSource implements DataSourceService {
	protected final DataSourceService dataSource;
	public ProxyDataSource(DataSourceService dataSource) {
		this.dataSource=dataSource;
	}
	@Override
	public void close() {
		dataSource.close();
	}
	@Override
	public Session getSession() {
		return dataSource.getSession();
	}
	@Override
	public SessionFactory getSessionFactory() {
		return dataSource.getSessionFactory();
	}
	@Override
	public <B> B merge(B bean) {
		return dataSource.merge(bean);
	}
	@Override
	public <B> B merge(String entity, B bean) {
		return dataSource.merge(entity, bean);
	}
	@Override
	public <T> List<T> select(Class<? extends T> type, String hql,
			Parameter... params) {
		return dataSource.select(type, hql, params);
	}
	@Override
	public List<Object> select(String hql, Parameter... params) {
		return dataSource.select(hql, params);
	}
	@Override
	public <C> C selectUnique(Class<? extends C> type, String hql,
			Parameter... parameters) {
		return dataSource.selectUnique(type, hql, parameters);
	}
	@Override
	public Object selectUnique(String hql, Parameter... parameters) {
		return dataSource.selectUnique(hql, parameters);
	}
	@Override
	public <B extends Serializable> B update(B bean) {
		return dataSource.update(bean);
	}
	@Override
	public <B> B update(String entity, B bean) {
		return dataSource.update(entity, bean);
	}

}

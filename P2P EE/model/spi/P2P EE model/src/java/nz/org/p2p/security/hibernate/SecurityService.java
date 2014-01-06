package nz.org.p2p.security.hibernate;

import nz.org.p2p.security.model.Permission;
import nz.org.p2p.security.model.SID;

public interface SecurityService {

	void check(Permission rights, SID sid);
	void check(Permission rights, SID sid, SID authority);
	<E> E getSecureProxy(Class<E> type, Object bean);
	SID getTypeSid(Class<?> type);

}

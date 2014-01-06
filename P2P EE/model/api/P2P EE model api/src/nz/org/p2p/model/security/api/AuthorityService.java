package nz.org.p2p.model.security.api;

public interface AuthorityService {
	String getIdentity();
	RoleService[] getRoles();
}

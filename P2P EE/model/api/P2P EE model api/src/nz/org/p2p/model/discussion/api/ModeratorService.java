package nz.org.p2p.model.discussion.api;

import nz.org.p2p.model.security.api.AuthorityService;

public interface ModeratorService {
	AuthorityService[] getAuthorities();
}

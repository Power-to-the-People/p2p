package nz.org.p2p.model.discussion.api;


public interface DiscussionThreadService {

	DiscussionThreadTypeService getDiscussionThreadType();
	void setDiscussionThreadType(DiscussionThreadTypeService type);
	String getTitle();
	void setTitle(String title);
	long getId();
	void setId(long Id);
	String getGuid();
	void setGuid(String guid);
}

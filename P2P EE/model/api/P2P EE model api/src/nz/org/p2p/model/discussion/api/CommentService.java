package nz.org.p2p.model.discussion.api;

public interface CommentService extends PostService{
	PostService getParentPost();
	void setParentPost(PostService post);
}

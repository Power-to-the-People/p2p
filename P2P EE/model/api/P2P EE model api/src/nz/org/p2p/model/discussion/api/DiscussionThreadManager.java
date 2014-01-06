package nz.org.p2p.model.discussion.api;


public interface DiscussionThreadManager {
	void addPost(DiscussionThreadService thread, PostService post);
	void addReply(DiscussionThreadService discussion, PostService post, CommentService comment, PosterService poster);
	void create(DiscussionThreadTypeService type);
	int likePost(PostService post, PosterService poster);
	void remove(DiscussionThreadService thread);
	void removePost(PostService post, ModeratorService moderator);
	void reportPost(PostService post, PosterService poster, Violation violation, String note);
	int unlikePost(PostService post, PosterService poster);
}

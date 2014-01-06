package nz.org.p2p.model.discussion;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

import nz.org.p2p.model.discussion.api.CommentService;
import nz.org.p2p.model.discussion.api.PostService;

@DiscriminatorValue(value="REPLY")
public class Comment extends Post implements CommentService {

	@Column(name = "parent_post_id")
	PostService parentPost;
	@Override
	public PostService getParentPost() {
		return parentPost;
	}

	@Override
	public void setParentPost(PostService post) {
		this.parentPost=post;

	}

}

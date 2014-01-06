package nz.org.p2p.model.discussion;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import nz.org.p2p.model.discussion.api.CommentService;
import nz.org.p2p.model.discussion.api.PostService;

/**
 * <p>
 * The post class provides... .
 * </p>
 * 
 * <p>
 * This software is offered under the terms of the GNU AFERO GENERAL PUBLIC
 * LICENCE of 2007, <b>See</b> {@link nz.org.p2p.model.discussion package
 * documentation} for more information.
 * </p>
 * 
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
@Entity(name="post")
@DiscriminatorColumn(name="type")
@DiscriminatorValue(value="POST")
public class Post implements PostService {

	class CommentSet extends TreeSet<CommentService>{
		public CommentSet() {
			super(
					new Comparator<CommentService>() {
						@Override
						public int compare(CommentService comment1,
								CommentService comment2) {
							if (comment1 == comment2) {
								Calendar t1 = comment1.getPostTime();
								Calendar t2 = comment2.getPostTime();
								if (t1 != t2) {
									if (t1.before(t2))
										return 1;
									if (t1.after(t2))
										return -1;
								}
								String id1 = comment1.getGuid();
								String id2 = comment2.getGuid();
								if (id1 != id2) {
									if (id1.compareTo(id2) < 0)
										return 1;
									if (id1.compareTo(id2) > 0)
										return -1;
								}
							}
							return 0;
						}

					});
		}
	}
	@Column(name = "deleted")
	boolean deleted = false;
	@Column(name = "guid")
	String guid = UUID.randomUUID().toString().replaceAll("-", "");
	@Column(name = "level")
	int level = 1;
	@Column(name = "lineage")
	String lineage;
	@Column(name = "post_body", columnDefinition = "TEXT")
	String postBody;
	@Column(name = "poster_id")
	long posterId;
	@Column(name = "poster_type_id")
	int posterTypeId = 0;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "post_id")
	long postId;
	@Column(name = "post_time")
	Calendar postTime = Calendar.getInstance();
	@Column(name = "sub_thread_id")
	long subThreadId = 0;
	@Column(name = "thread_id")
	long threadId = 0;;
	CommentSet commentServices = new CommentSet();

	@Override
	public Set<CommentService> getComments() {
		CommentSet commentSet=new CommentSet();
		commentSet.addAll(commentServices);
		return commentSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#getGuid()
	 */
	@Override
	public String getGuid() {
		return guid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#getLevel()
	 */
	@Override
	public int getLevel() {
		return level;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#getLineage()
	 */
	@Override
	public String getLineage() {
		return lineage;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#getPostBody()
	 */
	@Override
	public String getPostBody() {
		return postBody;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#getPosterId()
	 */
	@Override
	public long getPosterId() {
		return posterId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#getPosterTypeId()
	 */
	@Override
	public int getPosterTypeId() {
		return posterTypeId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#getPostId()
	 */
	@Override
	public long getPostId() {
		return postId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#getPostTime()
	 */
	@Override
	public Calendar getPostTime() {
		return postTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#getSubThreadId()
	 */
	@Override
	public long getSubThreadId() {
		return subThreadId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#getThreadId()
	 */
	@Override
	public long getThreadId() {
		return threadId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#isDeleted()
	 */
	@Override
	public boolean isDeleted() {
		return deleted;
	}

	@Override
	public void setComments(Set<CommentService> comments) {
		CommentSet commentSet=new CommentSet();
		commentSet.addAll(comments);
		this.commentServices=commentSet;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#setDeleted(boolean)
	 */
	@Override
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#setGuid(java.lang.String)
	 */
	@Override
	public void setGuid(String guid) {
		this.guid = guid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#setLevel(int)
	 */
	@Override
	public void setLevel(int level) {
		this.level = level;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#setLineage(java.lang.String)
	 */
	@Override
	public void setLineage(String lineage) {
		this.lineage = lineage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nz.org.p2p.model.discussion.PostService#setPostBody(java.lang.String)
	 */
	@Override
	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#setPosterId(long)
	 */
	@Override
	public void setPosterId(long posterId) {
		this.posterId = posterId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#setPosterTypeId(int)
	 */
	@Override
	public void setPosterTypeId(int posterTypeId) {
		this.posterTypeId = posterTypeId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#setPostId(long)
	 */
	@Override
	public void setPostId(long postId) {
		this.postId = postId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#setPostTime(java.util.Date)
	 */
	@Override
	public void setPostTime(Calendar postTime) {
		this.postTime = postTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#setSubThreadId(long)
	 */
	@Override
	public void setSubThreadId(long subThreadId) {
		this.subThreadId = subThreadId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nz.org.p2p.model.discussion.PostService#setThreadId(long)
	 */
	@Override
	public void setThreadId(long threadId) {
		this.threadId = threadId;
	}

}

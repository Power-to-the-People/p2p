package nz.org.p2p.model.discussion.api;

import java.util.Calendar;
import java.util.Set;

public interface PostService {

	public abstract Set<CommentService> getComments();

	public abstract String getGuid();

	public abstract int getLevel();

	public abstract String getLineage();

	public abstract String getPostBody();

	public abstract long getPosterId();

	public abstract int getPosterTypeId();

	public abstract long getPostId();

	public abstract Calendar getPostTime();

	public abstract long getSubThreadId();

	public abstract long getThreadId();

	public abstract boolean isDeleted();

	public abstract void setComments(Set<CommentService> comments);

	public abstract void setDeleted(boolean deleted);

	public abstract void setGuid(String guid);

	public abstract void setLevel(int level);

	public abstract void setLineage(String lineage);

	public abstract void setPostBody(String postBody);

	public abstract void setPosterId(long posterId);

	public abstract void setPosterTypeId(int posterTypeId);

	public abstract void setPostId(long postId);

	public abstract void setPostTime(Calendar postTime);

	public abstract void setSubThreadId(long subThreadId);

	public abstract void setThreadId(long threadId);

}
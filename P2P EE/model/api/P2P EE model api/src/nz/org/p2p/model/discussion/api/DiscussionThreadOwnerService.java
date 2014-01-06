package nz.org.p2p.model.discussion.api;

/**
 * <p>
 * The discussion thread owner service interface provides a locator contract for
 * discussion threads.
 * </p>
 * 
 * <p>
 * This software is offered under the terms of the GNU AFERO GENERAL PUBLIC
 * LICENCE of 2007, <b>See</b> {@link nz.org.p2p.model.discussion.api package
 * documentation} for more information.
 * </p>
 * 
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public interface DiscussionThreadOwnerService {

	/**
	 * Gets the discussion thread id.
	 * 
	 * @return the wall thread id
	 */
	public abstract DiscussionThreadService getDiscussionThread();

	/**
	 * Sets the discussion thread id.
	 * 
	 * @param wallThreadId
	 *            the wall thread id
	 */
	public abstract void setDiscussionThread(
			DiscussionThreadService wallThreadId);

}
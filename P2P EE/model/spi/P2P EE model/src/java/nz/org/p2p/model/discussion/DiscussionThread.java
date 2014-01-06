package nz.org.p2p.model.discussion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import nz.org.p2p.model.discussion.api.DiscussionThreadOwnerService;
import nz.org.p2p.model.discussion.api.DiscussionThreadService;
import nz.org.p2p.model.discussion.api.DiscussionThreadTypeService;

/**
 * <p>
 * The discussion thread class provides a pojo implementation of the
 * {@link DiscussionThreadService}
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
@Entity(name = "discussion_threads")
public class DiscussionThread implements DiscussionThreadService {

	/** The id of this thread. */
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "thread_id")
	private long id = -1;

	/** The title. */
	@Column(name = "title")
	private String title;

	/** The guid. */
	@Column(name = "guid")
	private String guid;

	/** The owner of this thread. */
	@Column(name = "thread_owner_id")
	private DiscussionThreadOwnerService owner;

	/** The type. */
	@Column(name = "thread_type_id")
	private DiscussionThreadTypeService type;

	/**
	 * Gets The discussion thread type property.
	 * 
	 * @return A discussion thread type
	 */
	@Override
	public DiscussionThreadTypeService getDiscussionThreadType() {
		return type;
	}

	/**
	 * Gets The guid property.
	 * 
	 * @return A guid
	 */
	@Override
	public String getGuid() {
		return guid;
	}

	/**
	 * Gets The id property.
	 * 
	 * @return A id
	 */
	@Override
	public long getId() {
		return id;
	}

	/**
	 * Gets The thread owner property.
	 * 
	 * @return A thread owner
	 */
	DiscussionThreadOwnerService getThreadOwner() {
		return owner;
	}

	/**
	 * Gets The title property.
	 * 
	 * @return A title
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * Sets The discussion thread type property.
	 * 
	 * @param type
	 *            A new discussion thread type state
	 */
	@Override
	public void setDiscussionThreadType(DiscussionThreadTypeService type) {
		this.type = type;

	}

	/**
	 * Sets The guid property.
	 * 
	 * @param guid
	 *            A new guid state
	 */
	@Override
	public void setGuid(String guid) {
		this.guid = guid;

	}

	/**
	 * Sets The id property.
	 * 
	 * @param id
	 *            A new id state
	 */
	@Override
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Sets The thread owner property.
	 * 
	 * @param owner
	 *            A new thread owner state
	 */
	void setThreadOwner(DiscussionThreadOwnerService owner) {
		this.owner = owner;
		owner.setDiscussionThread(this);
	}

	/**
	 * Sets The title property.
	 * 
	 * @param title
	 *            A new title state
	 */
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
}

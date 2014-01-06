package nz.org.p2p.model.discussion.api;

/**
 * <p>The discussion thread type service interface provides a contract for
 * discussion tread types classifying discussion threads.</p>
 * 
 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.member.api package documentation} for more information.</p>
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public interface DiscussionThreadTypeService {

	//Convenience constants
	public static final int MEMBER_WALL=1;
	public static final int GROUP_WALL=2;
	public static final int PAGE=3;
	public static final int NEWS=4;
	public static final int EVENT=5;
	public static final int FEATURE=6;
	public static final int COMMUNITY_WALL=7;

	/**
	 * Gets The description property.
	 *
	 * @return A description
	 */
	public String getDescription() ;

	/**
	 * Gets The id property.
	 *
	 * @return A id
	 */
	public int getId() ;

	/**
	 * Gets The thread type name property.
	 *
	 * @return A thread type name
	 */
	public String getThreadTypeName() ;

	/**
	 * Sets The description property.
	 *
	 * @param description A new description state
	 */
	public void setDescription(String description);

	/**
	 * Sets The id property.
	 *
	 * @param id A new id state
	 */
	public void setId(int id);

	/**
	 * Sets The thread type name property.
	 *
	 * @param threadTypeName A new thread type name state
	 */
	public void setThreadTypeName(String threadTypeName) ;
}

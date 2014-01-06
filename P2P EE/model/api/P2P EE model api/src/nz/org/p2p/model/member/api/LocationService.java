package nz.org.p2p.model.member.api;

/**
 * <p>
 * The location service interface provides a data contract for aggregate
 * population participations.
 * </p>
 * 
 * <p>
 * This software is offered under the terms of the GNU AFERO GENERAL PUBLIC
 * LICENCE of 2007, <b>See</b> {@link nz.org.p2p.model.member.api package
 * documentation} for more information.
 * </p>
 * 
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public interface LocationService {

	/**
	 * Adds number of new participants, Implementations of this method must
	 * guarantee thread-safety.
	 * 
	 * @param count
	 *            the count
	 */
	void add(long count);

	/**
	 * Gets The count property.
	 * 
	 * @return A count
	 */
	long getCount();

	/**
	 * Gets The id property.
	 * 
	 * @return A id
	 */
	long getId();

	/**
	 * Gets The name property.
	 * 
	 * @return A name
	 */
	String getName();

	/**
	 * Sets The count property.
	 * 
	 * @param count
	 *            A new count state
	 */
	void setCount(long count);

	/**
	 * Sets The id property.
	 * 
	 * @param id
	 *            A new id state
	 */
	void setId(long id);

	/**
	 * Sets The name property.
	 * 
	 * @param name
	 *            A new name state
	 */
	void setName(String name);
}

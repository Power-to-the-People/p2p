/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.member.api package documentation.
 */
package nz.org.p2p.model.member.api;

/**
 * The email address service interface provides a contract form typesafe
 * email addresses.
 * 
 * This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.member.api package documentation} for more information.
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public interface EmailIdentifierService {

	/**
	 * Gets The address property.
	 *
	 * @return A address
	 */
	String getId();

}

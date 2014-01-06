/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.member.api package documentation.
 */
package nz.org.p2p.model.member.api;

/**
 * The pass key manager service interface defines a contract for retrieving
 * stored PassKeys.
 * 
 * This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.member.api package documentation} for more information.
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public interface PassKeyManagerService {

	/**
	 * Gets a stored pass key.
	 *
	 * @param pk A pk reference.
	 * @return A pass key retrieved from a store.
	 */
	public PassKeyIdentifierService getPassKey(PassKeyIdentifierService pk);

	/**
	 * Gets a stored pass key property using an identifier value.
	 *
	 * @param pk the the identity value of the pass key to return.
	 * @return A stored pass key.
	 */
	public PassKeyIdentifierService getPassKey(String pk);
}

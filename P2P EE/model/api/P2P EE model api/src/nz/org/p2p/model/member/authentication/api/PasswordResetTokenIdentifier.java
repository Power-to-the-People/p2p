/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.member.authentication.api package documentation.
 */
package nz.org.p2p.model.member.authentication.api;


/**
 * The password reset token identifier interface provides a contract for
 * identifying {@link PasswordResetTokenService} objects.
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 */
public interface PasswordResetTokenIdentifier {

	/**
	 * Gets The identifier property.
	 *
	 * @return A identifier
	 */
	String getIdentifier();
}

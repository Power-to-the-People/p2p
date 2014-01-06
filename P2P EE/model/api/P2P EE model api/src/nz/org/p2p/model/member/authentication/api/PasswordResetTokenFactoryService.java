/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.member.authentication.api package documentation.
 */
package nz.org.p2p.model.member.authentication.api;

import nz.org.p2p.model.member.api.MemberService;

/**
 * <p>
 * A factory for generating {@link PasswordResetTokenService tokens} for
 * re-authorisation requests.
 * </p>
 * <p>
 * The tokens created are time limited and will ignored of an attempt to use
 * them after their active period will fail to allow re-authorisation.
 * Optionally an access code may used to identify the token. An account assist
 * dialog can have an option where the user enters the code and is directed to
 * the set pass word page or a pop-up version. This would allow the user to
 * contiue there browsng experience with minimal disrution.
 * 
 * @author <B>John Hutcheson</b> &lt;witerat.test@gmail.com&gt
 */
public interface PasswordResetTokenFactoryService {

	/**
	 * Gets the validity period of generated tokens.
	 * 
	 * @return hours before generated tokens expire
	 */
	public abstract int getLifeSpan();

	/**
	 * Gets a new password reset token that will be valid for a limited period
	 * of time.
	 * 
	 * @param member
	 * 			  The member member requesting re-authorisation.
	 * @return A password reset token
	 */
	public PasswordResetTokenService getPasswordResetToken(MemberService member);

	/**
	 * Sets the validity period of generated tokens.
	 * 
	 * @param lifeSpan
	 *            hours before generated tokens expire
	 */
	public abstract void setLifeSpan(int lifeSpan);
}

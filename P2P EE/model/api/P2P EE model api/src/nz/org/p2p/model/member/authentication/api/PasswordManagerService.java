/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.member.authentication.api package documentation.
 */
package nz.org.p2p.model.member.authentication.api;

import nz.org.p2p.model.member.api.MemberManagerService;

/**
 * The password manager service interface provides a contract for managing
 * password reset processing.
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 */
public interface PasswordManagerService {

	/**
	 * Gets The member manager for sourcing member information.
	 *
	 * @return A member manager
	 */
	public MemberManagerService getMemberManager();

	/**
	 * Gets The password reset token factory property.
	 *
	 * @return A password reset token factory
	 */
	public PasswordResetTokenFactoryService getPasswordResetTokenFactory();

	/**
	 * Sets The member manager property.
	 *
	 * @param memberManager A new member manager state
	 */
	public void setMemberManager(MemberManagerService memberManager);

	/**
	 * Sets the {@code $name} property. password.
	 *
	 * @param token the token
	 * @param Password the password
	 */
	public void setPassword(PasswordResetTokenIdentifier token, String Password);

	/**
	 * Sets The password reset token factory property.
	 *
	 * @param prtf A new password reset token factory state
	 */
	public void setPasswordResetTokenFactory(
			PasswordResetTokenFactoryService prtf);

}

/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.member.api package documentation.
 */
package nz.org.p2p.model.member.api;

import java.sql.SQLException;

import nz.org.p2p.model.discussion.api.DiscussionThreadOwnerService;


/**
 * The member manager service interface provides the contract for managing a
 * set of {@link MemberService member} information.
 *
 * This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.member.api package documentation} for more information.
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 */
public interface MemberManagerService {


	/**
	 * Gets a member using email.
	 *
	 * @param email the email
	 * @return A member
	 */
	public abstract DiscussionThreadOwnerService getMember(EmailIdentifierService email);

	/**
	 * Gets a member identified by database record.
	 *
	 * @param id tuple id
	 * @return A member
	 */
	public abstract DiscussionThreadOwnerService getMember(Long id);

	/**
	 * Gets member associated with a public identifier..
	 *
	 * @param id the id
	 * @return A member
	 */
	public abstract DiscussionThreadOwnerService getMember(MemberIdentifier id);

	/**
	 * Gets a member identified by passkey.
	 *
	 * @param passKey A {@link PassKeyService pass-key} identifying a member.
	 * @return A member
	 */
	public abstract DiscussionThreadOwnerService getMember(PassKeyIdentifierService passKey);

	/**
	 * Save a new member.
	 *
	 * @param member the member
	 * @throws SQLException the sQL exception
	 */
	public abstract void saveMember(MemberService member) throws SQLException;

	/**
	 * Update a member in the repository.
	 *
	 * @param member the member
	 * @throws SQLException the sQL exception
	 */
	public abstract void updateMember(MemberService member) throws SQLException;

}

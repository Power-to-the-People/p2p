/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.member.authentication.api package documentation.
 */
package nz.org.p2p.model.member.authentication.api;


/**
 * The {@code IPasswordResetToken} interface encapsulates token information
 * for password re-authorisation.
 * 
 * @author John Hutcheson <witerat.test@gmail.com>
 * 
 */
public interface PasswordResetTokenService {

	/**
	 * Gets the access code, a code that can be used to frustrate bots.
	 * 
	 * @return the access code - short random string bots can't guess. Users
	 *         should be able to supply this value after having received it via
	 *         alternative media. An MD5 hash of this value can be used to
	 *         Validate it on the client or by the server.
	 */
	public abstract String getAccessCode();

	/**
	 * Sets the commencement date of member re-authorisation. S *
	 * 
	 * @return the commencement date - when this token was created.
	 */
	public abstract long getCommence();

	/**
	 * Gets the completion that this token was used to successfully re-authorise
	 * a member.
	 * 
	 * @return the completion date of this token
	 */
	public abstract long getCompletion();

	/**
	 * Gets the time/date that this token will become unusable.
	 * 
	 * @return the new expiration date of this token.
	 */
	public abstract long getExpiration();

	/**
	 * Gets the id of the database tuple for this token.
	 * 
	 * @return the databases primary key field for this object.
	 */
	public abstract int getId();

	/**
	 * Gets the pass key that identifies the {@link nz.org.p2p.model.member.api.MemberService member} seeking to
	 * re-authorise their access. Must not be transmitted.
	 * 
	 * @return The pass key which links this token to the user who requested.
	 */
	public abstract String getPassKey();

	/**
	 * Gets the request key that publicly identifies this token.
	 * 
	 * @return the request key uniquely identifies this token.
	 */
	public abstract String getRequestKey();

	/**
	 * Sets the access code, should not be transmitted in clear text except by
	 * alternative communication.
	 * 
	 * @param accessCode
	 *            an access code the user should be able to supply, after
	 *            having received it via alternative media.
	 */
	public abstract void setAccessCode(String accessCode);

	/**
	 * Sets the commencement date of member re-authorisation.
	 * 
	 * @param commence
	 *            the commence date for the re-authorisation request - when
	 *            this token was created.
	 */
	public abstract void setCommence(long commence);

	/**
	 * Sets the completion date records the time of the completion of password
	 * re-authorisation using this token.
	 * 
	 * @param completion
	 *            the completion time of the request.
	 */
	public abstract void setCompletion(long completion);

	/**
	 * Sets the expiration date/time password re-authorisation using this token
	 * must be completed before this value.
	 * 
	 * @param expiration
	 *            the expiration time, re-authorisation wil not be accepted
	 *            after this time (ms since 00:00:00 01/01/1970 GMT)
	 */
	public abstract void setExpiration(long expiration);

	/**
	 * Sets the id that identifies the database tuple for this token
	 * 
	 * @param id
	 *            the identity field for the database.
	 */
	public abstract void setId(int id);

	/**
	 * Sets the pass key which identifies the member but is not publicly
	 * revealed.
	 * 
	 * @param passKey
	 *            the pass key a unique reference to the member.
	 */
	public abstract void setPassKey(String passKey);

	/**
	 * Sets the request key that identifies this request.
	 * 
	 * @param requestKey
	 *            a unique public identifier for the re-authorisation request.
	 */
	public abstract void setRequestKey(String requestKey);

}

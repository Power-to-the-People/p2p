package nz.org.p2p.model.member.authentication.mock;

import nz.org.p2p.model.member.authentication.api.PasswordResetTokenService;


/**
 * The mock password token class.
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public class MockPasswordToken implements PasswordResetTokenService {

	/** The access code. */
	String accessCode;

	/** The commence of the request process. */
	long commence;

	/** The completion the date of completion for the request. */
	long completion;

	/** The expiration date/time of the request. attempts to change the
	 * password after this time will fail. */
	long expiration;

	/** The id. */
	int id;

	/** The pass key. */
	String passKey;

	/** The request key. */
	String requestKey;

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenService#getAccessCode()
	 */
	@Override
	public String getAccessCode() {
		return accessCode;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenService#getCommence()
	 */
	@Override
	public long getCommence() {
		return commence;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenService#getCompletion()
	 */
	@Override
	public long getCompletion() {
		return completion;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenService#getExpiration()
	 */
	@Override
	public long getExpiration() {
		return expiration;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenService#getId()
	 */
	@Override
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenService#getPassKey()
	 */
	@Override
	public String getPassKey() {
		return passKey;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenService#getRequestKey()
	 */
	@Override
	public String getRequestKey() {
		return requestKey;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenService#setAccessCode(java.lang.String)
	 */
	@Override
	public void setAccessCode(String accessCode) {
		this.accessCode=accessCode;

	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenService#setCommence(long)
	 */
	@Override
	public void setCommence(long commence) {
		this.commence=commence;

	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenService#setCompletion(long)
	 */
	@Override
	public void setCompletion(long completion) {
		this.completion=completion;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenService#setExpiration(long)
	 */
	@Override
	public void setExpiration(long expiration) {
		this.expiration=expiration;

	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenService#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id=id;

	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenService#setPassKey(java.lang.String)
	 */
	@Override
	public void setPassKey(String passKey) {
		this.passKey=passKey;

	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenService#setRequestKey(java.lang.String)
	 */
	@Override
	public void setRequestKey(String requestKey) {
		this.requestKey=requestKey;

	}

}

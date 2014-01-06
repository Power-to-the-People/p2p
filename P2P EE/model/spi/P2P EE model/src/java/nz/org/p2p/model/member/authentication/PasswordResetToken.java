package nz.org.p2p.model.member.authentication;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import nz.org.p2p.model.member.authentication.api.PasswordResetTokenService;


public class PasswordResetToken implements PasswordResetTokenService {


	/** The access code is used to stop bots the hammering the server with
	 * junk setpw requests. It will be rendered raw in the email, and as md5, in
	 * the in the PasswordResetPage so black hats won't know what has to be
	 * entered from reading the HTML. */
	@Column(name="access_code", columnDefinition="TEXT")
	String accessCode;

	@Column(name="active", columnDefinition="TINYINT(1)")
	boolean active;

	/**The completion date is
	 * the date of successful complete of the request by the registered member.
	 */
	@Column(name="completion_date")
	long completion;

	/** Any attempt to use this reset request after this time will fail. */
	@Column(name="expiration_date")
	long expiration;

	/** The id the row in the data base. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The {@code passkey} property identifies the member requesting the new password. */
	@Column(name="pass_key", columnDefinition="TEXT")
	String passKey;

	/** The {@code requestKey} property publicly identifies this request. */
	@Column(name="request_key", columnDefinition="TEXT")
	String requestKey;

	@Column(name="commence")
	long commence;

	/**
	 * Instantiates a new member reset.
	 */
	public PasswordResetToken(){
	}

	/**
	 * Gets the access code.
	 *
	 * @return the access code
	 */
	@Override
	public String getAccessCode() {
		return accessCode;
	}

	@Override
	public long getCommence() {
		return commence;
	}

	/**
	 * Gets the completion.
	 *
	 * @return the completion gets the completion data of the request.
	 */
	@Override
	public long getCompletion() {
		return completion;
	}

	@Override
	public long getExpiration() {
		return expiration;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * Gets the passkey.
	 *
	 * @return the passkey
	 */
	@Override
	public String getPassKey() {
		return passKey;
	}

	/**
	 * Gets the request key.
	 *
	 * @return the request key
	 */
	@Override
	public String getRequestKey() {
		return requestKey;
	}

	/**
	 * Sets the access code.
	 *
	 * @param accessCode the new access code
	 */
	@Override
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	@Override
	public void setCommence(long commence) {
		this.commence = commence;
	}

	/**
	 * Sets the final completion date of the request.
	 *
	 * @param completion the new value for the  completion date of record..
	 */
	@Override
	public void setCompletion(long completion) {
		this.completion = completion;
	}

	@Override
	public void setExpiration(long expiration) {
		this.expiration = expiration;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the passkey.
	 *
	 * @param passkey the new passkey
	 */
	@Override
	public void setPassKey(String passkey) {
		this.passKey = passkey;
	}

	/**
	 * Sets the request key.
	 *
	 * @param requestKey the new request key
	 */
	@Override
	public void setRequestKey(String requestKey) {
		this.requestKey = requestKey;
	}}

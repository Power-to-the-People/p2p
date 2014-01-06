package nz.org.p2p.model.member;

import nz.org.p2p.model.member.api.PassKeyService;

/**
 * The stored pass key class encapsulates security date for a member account.
 *
 * @author john
 */
public class StoredPassKey implements PassKeyService{

	/** The passkey. */
	String passkey;

	/** The first question. */
	String questionOne;

	/** The second question. */
	String questionTwo;

	/** The first answer. */
	String answerOne;

	/** The second answer. */
	String answerTwo;

	/** The Password. */
	String password;


	/**
	 * create a passkey reference.
	 *
	 * @param manager the manager
	 * @see PassKeyService
	 */
	public StoredPassKey(){
	}

	/**
	 * Gets The answer one property.
	 *
	 * @return A answer one
	 * @see PassKeyService
	 */
	@Override
	public String getAnswerOne() {
		return answerOne;
	}

	/**
	 * Gets The answer two property.
	 *
	 * @return A answer two
	 * @see PassKeyService
	 */
	@Override
	public String getAnswerTwo() {

		return answerTwo;
	}

	/**
	 * Gets The passkey property.
	 *
	 * @return A passkey
	 * @see PassKeyService
	 */
	@Override
	public String getPassKey() {
		return passkey;
	}

	/**
	 * Gets The password property.
	 *
	 * @return A password
	 * @see PassKeyService
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * Gets The question one property.
	 *
	 * @return A question one
	 * @see PassKeyService
	 */
	@Override
	public String getQuestionOne() {
		return questionOne;
	}

	/**
	 * Gets The question two property.
	 *
	 * @return A question two
	 * @see PassKeyService
	 */
	@Override
	public String getQuestionTwo() {
		return questionTwo;
	}

	/**
	 * Sets The answer one property.
	 *
	 * @param answerOne A new answer one state
	 * @see PassKeyService
	 */
	@Override
	public void setAnswerOne(String answerOne) {
		this.answerOne = answerOne;
	}

	/**
	 * Sets The answer two property.
	 *
	 * @param answerTwo A new answer two state
	 * @see PassKeyService
	 */
	@Override
	public void setAnswerTwo(String answerTwo) {
		this.answerTwo = answerTwo;
	}

	/**
	 * Sets The passkey property.
	 *
	 * @param passkey A new passkey state
	 */
	@Override
	public void setPasskey(String passkey) {
		this.passkey = passkey;
	}

	/**
	 * Sets The password property.
	 *
	 * @param password A new password state
	 * @see PassKeyService
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets The question one property.
	 *
	 * @param questionOne A new question one state
	 * @see PassKeyService
	 */
	@Override
	public void setQuestionOne(String questionOne) {
		this.questionOne = questionOne;
	}

	/**
	 * Sets The question two property.
	 *
	 * @param questionTwo A new question two state
	 * @see PassKeyService
	 */
	@Override
	public void setQuestionTwo(String questionTwo) {
		this.questionTwo = questionTwo;
	}
}

/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.member.api package documentation.
 */
package nz.org.p2p.model.member.api;

/**
 * The Interface PassKeyService.
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 */
public interface PassKeyService extends PassKeyIdentifierService {

	/**
	 * Gets The answer one property.
	 *
	 * @return A answer one
	 */
	public abstract String getAnswerOne();

	/**
	 * Gets The answer two property.
	 *
	 * @return A answer two
	 */
	public abstract String getAnswerTwo();

	/**
	 * Gets The password property.
	 *
	 * @return A password
	 */
	public abstract String getPassword();

	/**
	 * Gets The question one property.
	 *
	 * @return A question one
	 */
	public abstract String getQuestionOne();

	/**
	 * Gets The question two property.
	 *
	 * @return A question two
	 */
	public abstract String getQuestionTwo();

	/**
	 * Sets The answer one property.
	 *
	 * @param answerOne A new answer one state
	 */
	public abstract void setAnswerOne(String answerOne);

	/**
	 * Sets The answer two property.
	 *
	 * @param answerTwo A new answer two state
	 */
	public abstract void setAnswerTwo(String answerTwo);

	/**
	 * Sets The passkey property.
	 *
	 * @param passkey A new passkey state
	 */
	public abstract void setPasskey(String passkey);

	/**
	 * Sets The password property.
	 *
	 * @param password A new password state
	 */
	public abstract void setPassword(String password);

	/**
	 * Sets The question one property.
	 *
	 * @param questionOne A new question one state
	 */
	public abstract void setQuestionOne(String questionOne);

	/**
	 * Sets The question two property.
	 *
	 * @param questionTwo A new question two state
	 */
	public abstract void setQuestionTwo(String questionTwo);

}

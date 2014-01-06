/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.member.api package documentation.
 */
package nz.org.p2p.model.member.api;

import java.sql.Timestamp;
import java.util.Date;

import nz.org.p2p.model.discussion.api.DiscussionThreadOwnerService;


/**
 * The member service interface defines
 *         the properties of member user accounts.
 * 
 * This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.member.api package documentation} for more information.
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public interface MemberService extends DiscussionThreadOwnerService {

	/**
	 * Gets the account code.
	 * 
	 * @return the account code
	 */
	public abstract String getAccountCode();

	/**
	 * Gets the avatar file id.
	 * 
	 * @return the avatar file id
	 */
	public abstract long getAvatarFileId();

	/**
	 * Gets the avatar id.
	 * 
	 * @return the avatar id
	 */
	public abstract String getAvatarId();

	/**
	 * Gets the avatar path.
	 * 
	 * @return the avatar path
	 */
	public abstract String getAvatarPath();

	/**
	 * Gets the avatar type.
	 * 
	 * @return the MIME sub-type type of the avatar image
	 */
	public abstract String getAvatarType();

	/**
	 * Gets the birth date.
	 * 
	 * @return the birth date
	 */
	public abstract Date getBirthDate();

	/**
	 * Gets the member's preferred charity.
	 * 
	 * @return the charity
	 */
	public abstract String getCharity();

	/**
	 * Gets the city.
	 * 
	 * @return the city
	 */
	public abstract String getCity();

	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	public abstract String getCountry();

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public abstract String getEmail();

	/**
	 * Gets the email code.
	 * 
	 * @return the email code
	 */
	public abstract String getEmailCode();

	/**
	 * Gets the email confirmation date.
	 * 
	 * @return the email confirmed
	 */
	public abstract Timestamp getEmailConfirmed();

	/**
	 * Gets the email verification code.
	 * 
	 * @return the email verification code
	 */
	public abstract String getEmailVerificationCode();

	/**
	 * Gets the first name.
	 * 
	 * @return the first name
	 */
	public abstract String getFirstName();

	/**
	 * Gets the guid.
	 * 
	 * @return the guid
	 */
	public abstract String getGuid();

	/**
	 * Gets the public identifier identifier of the menber.
	 * 
	 * @return the identifier
	 */
	public abstract String getIdentifier();

	/**
	 * Gets the join date.
	 * 
	 * @return the join date
	 * @see #getJoinTimeStamp() Duplicate?
	 */
	public abstract Date getJoinDate();

	/**
	 * Gets the time-stamp at the time this member joined.
	 * 
	 * @return when the member joined.
	 */
	public abstract Timestamp getJoinTimeStamp();

	/**
	 * Gets the last name.
	 * 
	 * @return the last name
	 */
	public abstract String getLastName();

	/**
	 * Gets the location id.
	 * 
	 * @return the location id
	 */
	public abstract LocationService getLocation();

	/**
	 * Gets the member id.
	 * 
	 * @return the member id
	 */
	public abstract long getMemberId();

	/**
	 * Gets the membership number.
	 * 
	 * @return the membership number
	 */
	public abstract String getMembershipNumber();

	/**
	 * Gets the member type.
	 * 
	 * @return the member type
	 */
	public abstract String getMemberType();

	/**
	 * Gets the middle name.
	 * 
	 * @return the middle name
	 */
	public abstract String getMiddleName();

	/**
	 * Gets the members pass key. This is a unique identifier.for that can only
	 * be exposed to verified users.
	 * 
	 * @return the pass key
	 */
	public abstract String getPassKey();

	/**
	 * Gets the password.This should be store in an encrypted or hashed form
	 * such as MD5. so that neither the clear form nor the transmitted form a
	 * stored in the data base.
	 * 
	 * @return the password
	 */
	public abstract String getPassword();

	/**
	 * Gets the phone.
	 * 
	 * @return the phone
	 */
	public abstract String getPhone();

	/**
	 * Gets the post code.
	 * 
	 * @return the post code
	 */
	public abstract String getPostCode();

	/**
	 * Gets the session id for the members active session
	 * 
	 * @return the session id
	 */
	public abstract String getSessionId();

	/**
	 * Gets the street address.
	 * 
	 * @return the street address
	 */
	public abstract String getStreetAddress();

	/**
	 * Gets the suburb.
	 * 
	 * @return the suburb
	 */
	public abstract String getSuburb();

	/**
	 * Gets the user name.
	 * 
	 * @return the user name
	 */
	public abstract String getUserName();

	/**
	 * Checks if is active.
	 * 
	 * @return true, if checks if is active
	 */
	public abstract boolean isActive();

	/**
	 * Checks if the address has been address verified.
	 * 
	 * @return {@code true}, if the address is verified
	 */
	public abstract boolean isAddressVerified();

	/**
	 * Checks if is identity verification flag.
	 * 
	 * @return {@code true}, if is identity verified
	 */
	public abstract boolean isIdentityVerified();

	/**
	 * Checks this is a verified voter.
	 * 
	 * @return {@code true}, if the voter is verified
	 */
	public abstract boolean isVoterVerified();

	/**
	 * Sets the account code.
	 * 
	 * @param accountCode
	 *            the account code
	 */
	public abstract void setAccountCode(String accountCode);

	/**
	 * Sets the active.
	 * 
	 * @param active
	 *            the active
	 */
	public abstract void setActive(boolean active);

	/**
	 * Sets whether the address has been verified.
	 * 
	 * @param addressVerified
	 *            {@code true} if the address is verified
	 */
	public abstract void setAddressVerified(boolean addressVerified);

	/**
	 * Sets the avatar file id.
	 * 
	 * @param avatarFileId
	 *            the avatar file id
	 */
	public abstract void setAvatarFileId(long avatarFileId);

	/**
	 * Sets the avatar id.
	 * 
	 * @param avatarId
	 *            the avatar id
	 */
	public abstract void setAvatarId(String avatarId);

	/**
	 * Sets the avatar path.
	 * 
	 * @param avatarPath
	 *            the avatar path
	 */
	public abstract void setAvatarPath(String avatarPath);

	/**
	 * Sets the avatar type.
	 * 
	 * @param avatarType
	 *            the MIME sub-type of the avatar image
	 */
	public abstract void setAvatarType(String avatarType);

	/**
	 * Sets the birth date.
	 * 
	 * @param birthDate
	 *            the birth date
	 */
	public abstract void setBirthDate(Date birthDate);

	/**
	 * Sets the member's preferred charity.
	 * 
	 * @param charity
	 *            the charity
	 */
	public abstract void setCharity(String charity);

	/**
	 * Sets the city.
	 * 
	 * @param city
	 *            the city
	 */
	public abstract void setCity(String city);

	/**
	 * Sets the country.
	 * 
	 * @param country
	 *            the country
	 */
	public abstract void setCountry(String country);

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the email
	 */
	public abstract void setEmail(String email);

	/**
	 * Sets the email code.
	 * 
	 * @param emailCode
	 *            the email code
	 */
	public abstract void setEmailCode(String emailCode);

	/**
	 * Sets the email confirmation date.
	 * 
	 * @param emailConfirmed
	 *            the email confirmed
	 */
	public abstract void setEmailConfirmed(Timestamp emailConfirmed);

	/**
	 * Sets the email verification code.
	 * 
	 * @param emailVerificationCode
	 *            the email verification code
	 */
	public abstract void setEmailVerificationCode(String emailVerificationCode);

	/**
	 * Sets the first name.
	 * 
	 * @param firstName
	 *            the first name
	 */
	public abstract void setFirstName(String firstName);

	/**
	 * Sets the guid.
	 * 
	 * @param guid
	 *            the guid
	 */
	public abstract void setGuid(String guid);

	/**
	 * Sets the public identifier of the member.
	 * 
	 * @param identifier {@link java.lang.String String}
	 *            the identifier a value that publicly (and publishably)
	 *            identifies the member
	 */
	public abstract void setIdentifier(String identifier);

	/**
	 * Sets the identity verification flag..
	 * 
	 * @param identityVerified
	 *            the identity verified
	 */
	public abstract void setIdentityVerified(boolean identityVerified);

	/**
	 * Sets the join date.
	 * 
	 * @param joinDate
	 *            the join date
	 * @see #setJoinTimeStamp(Timestamp) duplicate?
	 */
	public abstract void setJoinDate(Date joinDate);

	/**
	 * Sets the time-stamp at the time this member joined.
	 * 
	 * @param joinTimeStamp
	 *            when the member joined, should be about now when called.
	 */
	public abstract void setJoinTimeStamp(Timestamp joinTimeStamp);

	/**
	 * Sets the last name.
	 * 
	 * @param lastName
	 *            the last name
	 */
	public abstract void setLastName(String lastName);

	/**
	 * Sets the location id.
	 * 
	 * @param location
	 *            the location.
	 */
	public abstract void setLocation(LocationService location);

	/**
	 * Sets the member id.
	 * 
	 * @param memberId
	 *            the member id
	 */
	public abstract void setMemberId(long memberId);

	/**
	 * Sets the membership number.
	 * 
	 * @param membershipNumber
	 *            the membership number
	 */
	public abstract void setMembershipNumber(String membershipNumber);

	/**
	 * Sets the member type.
	 * 
	 * @param memberType
	 *            the member type
	 */
	public abstract void setMemberType(String memberType);

	/**
	 * Sets the middle name.
	 * 
	 * @param middleName
	 *            the middle name
	 */
	public abstract void setMiddleName(String middleName);

	/**
	 * Sets the members pass key. This is a unique identifier.for that can only
	 * be exposed to verified users.
	 * 
	 * @param passKey
	 *            the pass key
	 */
	public abstract void setPassKey(String passKey);

	/**
	 * Sets the password.This should be store in an encrypted or hashed form
	 * such as MD5. so that neither the clear form nor the transmitted form a
	 * stored in the data base.
	 * 
	 * @param password
	 *            the password
	 */
	public abstract void setPassword(String password);

	/**
	 * Sets the phone.
	 * 
	 * @param phone
	 *            the phone
	 */
	public abstract void setPhone(String phone);

	/**
	 * Sets the post code.
	 * 
	 * @param postCode
	 *            the post code
	 */
	public abstract void setPostCode(String postCode);

	/**
	 * Sets the session id for the members active session.
	 * 
	 * @param sessionId
	 *            the session id
	 */
	public abstract void setSessionId(String sessionId);

	/**
	 * Sets the street address.
	 * 
	 * @param streetAddress
	 *            the street address
	 */
	public abstract void setStreetAddress(String streetAddress);

	/**
	 * Sets the suburb.
	 * 
	 * @param suburb
	 *            the suburb
	 */
	public abstract void setSuburb(String suburb);

	/**
	 * Sets the user name.
	 * 
	 * @param userName
	 *            the user name
	 */
	public abstract void setUserName(String userName);

	/**
	 * Sets whether this is a verified voter.
	 * 
	 * @param voterVerified
	 *            {@code true}, if the voter is verified
	 */
	public abstract void setVoterVerified(boolean voterVerified);

}

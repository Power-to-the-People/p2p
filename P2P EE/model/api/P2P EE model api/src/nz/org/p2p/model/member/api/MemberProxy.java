/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.member.api package documentation.
 */
package nz.org.p2p.model.member.api;

import java.sql.Timestamp;
import java.util.Date;

import nz.org.p2p.model.discussion.api.DiscussionThreadOwnerService;
import nz.org.p2p.model.discussion.api.DiscussionThreadService;

/**
 * The member proxy class.
 * 
 * This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.member.api package documentation} for more information.
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 */
public class MemberProxy implements DiscussionThreadOwnerService, MemberService {

	/** The member proxy target. */
	public transient final MemberService member;

	/**
	 * Instantiates a new member proxy.
	 *
	 * @param member the member
	 */
	public MemberProxy(MemberService member) {
		this.member=member;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null)return false;
		if(obj==this)return true;
		if(obj instanceof MemberService) {
			DiscussionThreadOwnerService ms;
			for (ms=member;ms instanceof MemberProxy; ms=((MemberProxy)ms).member) {
				if(obj==ms)return true;
				if(!MemberProxy.class.equals(ms.getClass())) {
					if(ms.equals(obj)) return true;
				}
			}
		}
		return super.equals(obj);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getAccountCode()
	 */
	@Override
	public String getAccountCode() {
		return member.getAccountCode();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getAvatarFileId()
	 */
	@Override
	public long getAvatarFileId() {
		return member.getAvatarFileId();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getAvatarId()
	 */
	@Override
	public String getAvatarId() {
		return member.getAvatarId();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getAvatarPath()
	 */
	@Override
	public String getAvatarPath() {
		return member.getAvatarPath();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getAvatarType()
	 */
	@Override
	public String getAvatarType() {
		return member.getAvatarType();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getBirthDate()
	 */
	@Override
	public Date getBirthDate() {
		return member.getBirthDate();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getCharity()
	 */
	@Override
	public String getCharity() {
		return member.getCharity();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getCity()
	 */
	@Override
	public String getCity() {
		return member.getCity();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getCountry()
	 */
	@Override
	public String getCountry() {
		return member.getCountry();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getWallThreadId()
	 */
	@Override
	public DiscussionThreadService getDiscussionThread() {
		return member.getDiscussionThread();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getEmail()
	 */
	@Override
	public String getEmail() {
		return member.getEmail();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getEmailCode()
	 */
	@Override
	public String getEmailCode() {
		return member.getEmailCode();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getEmailConfirmed()
	 */
	@Override
	public Timestamp getEmailConfirmed() {
		return member.getEmailConfirmed();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getEmailVerificationCode()
	 */
	@Override
	public String getEmailVerificationCode() {
		return member.getEmailVerificationCode();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getFirstName()
	 */
	@Override
	public String getFirstName() {
		return member.getFirstName();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getGuid()
	 */
	@Override
	public String getGuid() {
		return member.getGuid();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getIdentifier()
	 */
	@Override
	public String getIdentifier() {
		return member.getIdentifier();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getJoinDate()
	 */
	@Override
	public Date getJoinDate() {
		return member.getJoinDate();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getJoinTimeStamp()
	 */
	@Override
	public Timestamp getJoinTimeStamp() {
		return member.getJoinTimeStamp();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getLastName()
	 */
	@Override
	public String getLastName() {
		return member.getLastName();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getLocationId()
	 */
	@Override
	public LocationService getLocation() {
		return member.getLocation();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getMemberId()
	 */
	@Override
	public long getMemberId() {
		return member.getMemberId();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getMembershipNumber()
	 */
	@Override
	public String getMembershipNumber() {
		return member.getMembershipNumber();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getMemberType()
	 */
	@Override
	public String getMemberType() {
		return member.getMemberType();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getMiddleName()
	 */
	@Override
	public String getMiddleName() {
		return member.getMiddleName();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getPassKey()
	 */
	@Override
	public String getPassKey() {
		return member.getPassKey();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getPassword()
	 */
	@Override
	public String getPassword() {
		return member.getPassword();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getPhone()
	 */
	@Override
	public String getPhone() {
		return member.getPhone();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getPostCode()
	 */
	@Override
	public String getPostCode() {
		return member.getPostCode();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getSessionId()
	 */
	@Override
	public String getSessionId() {
		return member.getSessionId();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getStreetAddress()
	 */
	@Override
	public String getStreetAddress() {
		return member.getStreetAddress();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getSuburb()
	 */
	@Override
	public String getSuburb() {
		return member.getSuburb();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#getUserName()
	 */
	@Override
	public String getUserName() {
		return member.getUserName();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#isActive()
	 */
	@Override
	public boolean isActive() {
		return member.isActive();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#isAddressVerified()
	 */
	@Override
	public boolean isAddressVerified() {
		return member.isAddressVerified();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#isIdentityVerified()
	 */
	@Override
	public boolean isIdentityVerified() {
		return member.isIdentityVerified();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#isVoterVerified()
	 */
	@Override
	public boolean isVoterVerified() {
		return member.isVoterVerified();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setAccountCode(java.lang.String)
	 */
	@Override
	public void setAccountCode(String accountCode) {
		member.setAccountCode(accountCode);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setActive(boolean)
	 */
	@Override
	public void setActive(boolean active) {
		member.setActive(active);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setAddressVerified(boolean)
	 */
	@Override
	public void setAddressVerified(boolean addressVerified) {
		member.setAddressVerified(addressVerified);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setAvatarFileId(long)
	 */
	@Override
	public void setAvatarFileId(long avatarFileId) {
		member.setAvatarFileId(avatarFileId);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setAvatarId(java.lang.String)
	 */
	@Override
	public void setAvatarId(String avatarId) {
		member.setAvatarId(avatarId);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setAvatarPath(java.lang.String)
	 */
	@Override
	public void setAvatarPath(String avatarPath) {
		member.setAvatarPath(avatarPath);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setAvatarType(java.lang.String)
	 */
	@Override
	public void setAvatarType(String avatarType) {
		member.setAvatarType(avatarType);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setBirthDate(java.util.Date)
	 */
	@Override
	public void setBirthDate(Date birthDate) {
		member.setBirthDate(birthDate);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setCharity(java.lang.String)
	 */
	@Override
	public void setCharity(String charity) {
		member.setCharity(charity);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setCity(java.lang.String)
	 */
	@Override
	public void setCity(String city) {
		member.setCity(city);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setCountry(java.lang.String)
	 */
	@Override
	public void setCountry(String country) {
		member.setCountry(country);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setWallThreadId(long)
	 */
	@Override
	public void setDiscussionThread(DiscussionThreadService discussionThread) {
		member.setDiscussionThread(discussionThread);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		member.setEmail(email);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setEmailCode(java.lang.String)
	 */
	@Override
	public void setEmailCode(String emailCode) {
		member.setEmailCode(emailCode);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setEmailConfirmed(java.sql.Timestamp)
	 */
	@Override
	public void setEmailConfirmed(Timestamp emailConfirmed) {
		member.setEmailConfirmed(emailConfirmed);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setEmailVerificationCode(java.lang.String)
	 */
	@Override
	public void setEmailVerificationCode(String emailVerificationCode) {
		member.setEmailVerificationCode(emailVerificationCode);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setFirstName(java.lang.String)
	 */
	@Override
	public void setFirstName(String firstName) {
		member.setFirstName(firstName);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setGuid(java.lang.String)
	 */
	@Override
	public void setGuid(String guid) {
		member.setGuid(guid);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setIdentifier(java.lang.String)
	 */
	@Override
	public void setIdentifier(String identifier) {
		member.setIdentifier(identifier);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setIdentityVerified(boolean)
	 */
	@Override
	public void setIdentityVerified(boolean identityVerified) {
		member.setIdentityVerified(identityVerified);

	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setJoinDate(java.util.Date)
	 */
	@Override
	public void setJoinDate(Date joinDate) {
		member.setJoinDate(joinDate);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setJoinTimeStamp(java.sql.Timestamp)
	 */
	@Override
	public void setJoinTimeStamp(Timestamp joinTimeStamp) {
		member.setJoinTimeStamp(joinTimeStamp);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setLastName(java.lang.String)
	 */
	@Override
	public void setLastName(String lastName) {
		member.setLastName(lastName);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setLocationId(long)
	 */
	@Override
	public void setLocation(LocationService location) {
		member.setLocation(location);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setMemberId(long)
	 */
	@Override
	public void setMemberId(long memberId) {
		member.setMemberId(memberId);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setMembershipNumber(java.lang.String)
	 */
	@Override
	public void setMembershipNumber(String membershipNumber) {
		member.setMembershipNumber(membershipNumber);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setMemberType(java.lang.String)
	 */
	@Override
	public void setMemberType(String memberType) {
		member.setMemberType(memberType);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setMiddleName(java.lang.String)
	 */
	@Override
	public void setMiddleName(String middleName) {
		member.setMiddleName(middleName);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setPassKey(java.lang.String)
	 */
	@Override
	public void setPassKey(String passKey) {
		member.setPassKey(passKey);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setPassword(java.lang.String)
	 */
	@Override
	public void setPassword(String password) {
		member.setPassword(password);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setPhone(java.lang.String)
	 */
	@Override
	public void setPhone(String phone) {
		member.setPhone(phone);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setPostCode(java.lang.String)
	 */
	@Override
	public void setPostCode(String postCode) {
		member.setPostCode(postCode);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setSessionId(java.lang.String)
	 */
	@Override
	public void setSessionId(String sessionId) {
		member.setSessionId(sessionId);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setStreetAddress(java.lang.String)
	 */
	@Override
	public void setStreetAddress(String streetAddress) {
		member.setStreetAddress(streetAddress);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setSuburb(java.lang.String)
	 */
	@Override
	public void setSuburb(String suburb) {
		member.setSuburb(suburb);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setUserName(java.lang.String)
	 */
	@Override
	public void setUserName(String userName) {
		member.setUserName(userName);
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberService#setVoterVerified(boolean)
	 */
	@Override
	public void setVoterVerified(boolean voterVerified) {
		member.setVoterVerified(voterVerified);
	}

}

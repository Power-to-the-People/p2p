package nz.org.p2p.model.member;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import nz.org.p2p.model.discussion.DiscussionThread;
import nz.org.p2p.model.discussion.api.DiscussionThreadOwnerService;
import nz.org.p2p.model.discussion.api.DiscussionThreadService;
import nz.org.p2p.model.discussion.api.PosterService;
import nz.org.p2p.model.member.api.EmailIdentifierService;
import nz.org.p2p.model.member.api.MemberIdentifier;
import nz.org.p2p.model.member.api.MemberProxy;
import nz.org.p2p.model.member.api.MemberService;
import nz.org.p2p.model.member.api.PassKeyIdentifierService;
import nz.org.p2p.model.member.api.PassKeyService;

// TODO: Auto-generated Javadoc
/**
 * <p>The member class provides encapsulation for member users' data.</p>
 * 
 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.member package documentation} for more information.</p>
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
@Entity(name="members")
public class Member implements MemberService, DiscussionThreadOwnerService, PosterService{

	/** The member id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="member_id",unique=true)
	long memberId;

	/** The active flag. */
	@Column(name="active")
	boolean active=false;

	/** The location id. */
	@Column(name="location_id")
	int locationId=0;

	/** The wall thread id. */
	@Column(name="wall_thread_id")
	@OneToOne(targetEntity=DiscussionThread.class)
	DiscussionThreadService dicussionThread;

	/** The membership number. */
	@Column(name="membership_number")
	String membershipNumber;

	/** The user name. */
	@Column(name="user_name")
	String userName;

	/** The first name. */
	@Column(name="first_name")
	String firstName="";

	/** The middle name. */
	@Column(name="middle_name")
	String middleName;

	/** The last name. */
	@Column(name="last_name")
	String lastName="";

	/** The birth date. */
	@Column(name="birth_date")
	Date birthDate;

	/** The street address. */
	@Column(name="street_address")
	String streetAddress;

	/** The suburb. */
	@Column(name="suburb")
	String suburb;

	/** The city. */
	@Column(name="city")
	String city;

	/** The country. */
	@Column(name="country")
	String country;

	/** The post code. */
	@Column(name="post_code")
	String postCode;

	/** The email. */
	@Column(name="email")
	String email;

	/** The phone. */
	@Column(name="phone")
	String phone;

	/** The avatar id. */
	@Column(name="avatar_id")
	String avatarId="default";

	/** The avatar path. */
	@Column(name="avatar_path")
	String avatarPath="default.png";

	/** The avatar file id. */
	@Column(name="avatar_file_id")
	long avatarFileId=0;

	/** The avatar type. */
	@Column(name="avatar_type")
	String avatarType="png";

	/** The account code. */
	@Column(name="account_code",unique=true)
	String accountCode;

	/** The password. */
	@Column(name="password")
	String password;

	/** The guid. */
	@Column(name="guid")
	String guid=UUID.randomUUID().toString().replaceAll("-", "");

	/** The member type. */
	@Column(name="member_type")
	String memberType;

	/** The join date. */
	@Column(name="join_date")
	Date joinDate=new Date();

	/** The charity. */
	@Column(name="charity")
	String charity;

	/** The pass key. */
	@Column(name="pass_key")
	String passKey=UUID.randomUUID().toString().replaceAll("-", "");

	/** The email verification code. */
	@Column(name="email_verification_code")
	String emailVerificationCode=UUID.randomUUID().toString().replaceAll("-", "");

	/** The session id. */
	@Column(name="session_id")
	String sessionId=UUID.randomUUID().toString().replaceAll("-", "");

	/** The email code. */
	@Column(name="email_code")
	String emailCode;

	/** The public identifier. */
	@Column(name="identifier")
	String identifier;

	/** The join time stamp. */
	@Column(name="join_timestamp")
	Timestamp joinTimeStamp;

	/** The voter verified. */
	@Column(name="voter_verified")
	boolean voterVerified;

	/** The address verified. */
	@Column(name="address_verified")
	boolean addressVerified;

	/** The identity verified. */
	@Column(name="identity_verified")
	boolean identityVerified;

	/** The email confirmed. */
	@Column(name="email_confirmed")
	Timestamp emailConfirmed;

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) {
			if(obj instanceof MemberProxy) {
				return ((MemberProxy)obj).equals(this);
			}
			if(obj instanceof EmailIdentifierService) {
				final EmailIdentifierService eas=(EmailIdentifierService) obj;
				return email==null ?eas.getId()==null:
					email.equals(eas.getId());
			}

			if(obj instanceof PassKeyService) {
				final PassKeyIdentifierService pks=(PassKeyIdentifierService) obj;
				return passKey==null ?pks.getPassKey()==null:
					passKey.equals(pks.getPassKey());

			}
			if(obj instanceof MemberIdentifier) {
				final MemberIdentifier mId=(MemberIdentifier) obj;
				return identifier==null ?mId.getIdentifier()==null:
					identifier.equals(mId.getIdentifier());

			}
			if(obj instanceof Long) {
				final Long id=(Long) obj;
				return memberId==id.longValue();

			}
			if(obj instanceof MemberIdentifier) {
				final MemberIdentifier mId=(MemberIdentifier) obj;
				return identifier==null ?mId.getIdentifier()==null:
					identifier.equals(mId.getIdentifier());

			}
			return false;
		}else return true;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getAccountCode()
	 */
	@Override
	public String getAccountCode() {
		return accountCode;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getAvatarFileId()
	 */
	@Override
	public long getAvatarFileId() {
		return avatarFileId;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getAvatarId()
	 */
	@Override
	public String getAvatarId() {
		return avatarId;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getAvatarPath()
	 */
	@Override
	public String getAvatarPath() {
		return avatarPath;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getAvatarType()
	 */
	@Override
	public String getAvatarType() {
		return avatarType;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getBirthDate()
	 */
	@Override
	public Date getBirthDate() {
		return birthDate;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getCharity()
	 */
	@Override
	public String getCharity() {
		return charity;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getCity()
	 */
	@Override
	public String getCity() {
		return city;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getCountry()
	 */
	@Override
	public String getCountry() {
		return country;
	}

	/**
	 * Get the wall discussion thread of this member.
	 * @see nz.org.p2p.model.discussion.api.DiscussionThreadOwnerService#getDiscussionThread()
	 */
	@Override
	public DiscussionThreadService getDiscussionThread() {
		return dicussionThread;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getEmail()
	 */
	@Override
	public String getEmail() {
		return email;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getEmailCode()
	 */
	@Override
	public String getEmailCode() {
		return emailCode;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getEmailConfirmed()
	 */
	@Override
	public Timestamp getEmailConfirmed() {
		return emailConfirmed;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getEmailVerificationCode()
	 */
	@Override
	public String getEmailVerificationCode() {
		return emailVerificationCode;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getFirstName()
	 */
	@Override
	public String getFirstName() {
		return firstName;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getGuid()
	 */
	@Override
	public String getGuid() {
		return guid;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getIdentifier()
	 */
	@Override
	public String getIdentifier() {
		return identifier;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getJoinDate()
	 */
	@Override
	public Date getJoinDate() {
		return joinDate;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getJoinTimeStamp()
	 */
	@Override
	public Timestamp getJoinTimeStamp() {
		return joinTimeStamp;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getLastName()
	 */
	@Override
	public String getLastName() {
		return lastName;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getLocationId()
	 */
	@Override
	public int getLocationId() {
		return locationId;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getMemberId()
	 */
	@Override
	public long getMemberId() {
		return memberId;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getMembershipNumber()
	 */
	@Override
	public String getMembershipNumber() {
		return membershipNumber;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getMemberType()
	 */
	@Override
	public String getMemberType() {
		return memberType;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getMiddleName()
	 */
	@Override
	public String getMiddleName() {
		return middleName;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getPassKey()
	 */
	@Override
	public String getPassKey() {
		return passKey;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getPhone()
	 */
	@Override
	public String getPhone() {
		return phone;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getPostCode()
	 */
	@Override
	public String getPostCode() {
		return postCode;
	}

	/**
	 *  Provide an identifier suitable for identifying post/commentt publishers.
	 */
	@Override
	public String getPosterId() {
		return passKey;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getSessionId()
	 */
	@Override
	public String getSessionId() {
		return sessionId;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getStreetAddress()
	 */
	@Override
	public String getStreetAddress() {
		return streetAddress;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getSuburb()
	 */
	@Override
	public String getSuburb() {
		return suburb;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#getUserName()
	 */
	@Override
	public String getUserName() {
		return userName;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#isActive()
	 */
	@Override
	public boolean isActive() {
		return active;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#isAddressVerified()
	 */
	@Override
	public boolean isAddressVerified() {
		return addressVerified;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#isIdentityVerified()
	 */
	@Override
	public boolean isIdentityVerified() {
		return identityVerified;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#isVoterVerified()
	 */
	@Override
	public boolean isVoterVerified() {
		return voterVerified;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setAccountCode(java.lang.String)
	 */
	@Override
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setActive(boolean)
	 */
	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setAddressVerified(boolean)
	 */
	@Override
	public void setAddressVerified(boolean addressVerified) {
		this.addressVerified = addressVerified;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setAvatarFileId(long)
	 */
	@Override
	public void setAvatarFileId(long avatarFileId) {
		this.avatarFileId = avatarFileId;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setAvatarId(java.lang.String)
	 */
	@Override
	public void setAvatarId(String avatarId) {
		this.avatarId = avatarId;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setAvatarPath(java.lang.String)
	 */
	@Override
	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setAvatarType(java.lang.String)
	 */
	@Override
	public void setAvatarType(String avatarType) {
		this.avatarType = avatarType;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setBirthDate(java.util.Date)
	 */
	@Override
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setCharity(java.lang.String)
	 */
	@Override
	public void setCharity(String charity) {
		this.charity = charity;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setCity(java.lang.String)
	 */
	@Override
	public void setCity(String city) {
		this.city = city;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setCountry(java.lang.String)
	 */
	@Override
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Set the wall discussion of this member.
	 *
	 * @param discussionThread A new discussion thread state
	 * @see nz.org.p2p.model.discussion.api.DiscussionThreadOwnerService#setDiscussionThread(nz.org.p2p.model.discussion.api.DiscussionThreadService)
	 */
	@Override
	public void setDiscussionThread(DiscussionThreadService discussionThread) {
		this.dicussionThread = discussionThread;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setEmailCode(java.lang.String)
	 */
	@Override
	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setEmailConfirmed(java.sql.Timestamp)
	 */
	@Override
	public void setEmailConfirmed(Timestamp emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setEmailVerificationCode(java.lang.String)
	 */
	@Override
	public void setEmailVerificationCode(String emailVerificationCode) {
		this.emailVerificationCode = emailVerificationCode;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setFirstName(java.lang.String)
	 */
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setGuid(java.lang.String)
	 */
	@Override
	public void setGuid(String guid) {
		this.guid = guid;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setIdentifier(java.lang.String)
	 */
	@Override
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setIdentityVerified(boolean)
	 */
	@Override
	public void setIdentityVerified(boolean identityVerified) {
		this.identityVerified = identityVerified;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setJoinDate(java.util.Date)
	 */
	@Override
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setJoinTimeStamp(java.sql.Timestamp)
	 */
	@Override
	public void setJoinTimeStamp(Timestamp joinTimeStamp) {
		this.joinTimeStamp = joinTimeStamp;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setLastName(java.lang.String)
	 */
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setLocationId(long)
	 */
	@Override
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setMemberId(long)
	 */
	@Override
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setMembershipNumber(java.lang.String)
	 */
	@Override
	public void setMembershipNumber(String membershipNumber) {
		this.membershipNumber = membershipNumber;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setMemberType(java.lang.String)
	 */
	@Override
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setMiddleName(java.lang.String)
	 */
	@Override
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setPassKey(java.lang.String)
	 */
	@Override
	public void setPassKey(String passKey) {
		this.passKey = passKey;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setPassword(java.lang.String)
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setPhone(java.lang.String)
	 */
	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setPostCode(java.lang.String)
	 */
	@Override
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setSessionId(java.lang.String)
	 */
	@Override
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setStreetAddress(java.lang.String)
	 */
	@Override
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setSuburb(java.lang.String)
	 */
	@Override
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setUserName(java.lang.String)
	 */
	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.IMember#setVoterVerified(boolean)
	 */
	@Override
	public void setVoterVerified(boolean voterVerified) {
		this.voterVerified = voterVerified;
	}


}

package nz.org.p2p.model.member.authentication.mock;

import java.sql.Timestamp;
import java.util.Date;

import nz.org.p2p.model.discussion.api.DiscussionThreadService;
import nz.org.p2p.model.member.api.LocationService;
import nz.org.p2p.model.member.api.MemberService;

/**
 * Everything is unsupported until we implement it for tests.
 * 
 * @author John Hutcheson <witerat.test@gmail.com>
 *
 */
public class MockMember implements MemberService{
	String passKey;

	@Override
	public String getAccountCode() {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getAvatarFileId() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getAvatarId() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getAvatarPath() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getAvatarType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Date getBirthDate() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getCharity() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getCity() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getCountry() {
		throw new UnsupportedOperationException();
	}

	@Override
	public DiscussionThreadService getDiscussionThread() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getEmail() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getEmailCode() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Timestamp getEmailConfirmed() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getEmailVerificationCode() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getFirstName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getGuid() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getIdentifier() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Date getJoinDate() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Timestamp getJoinTimeStamp() {
		throw new UnsupportedOperationException();

	}

	@Override
	public String getLastName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public LocationService getLocation() {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getMemberId() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getMembershipNumber() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getMemberType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getMiddleName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getPassKey() {
		return passKey;
	}

	@Override
	public String getPassword() {
		throw new UnsupportedOperationException();

	}

	@Override
	public String getPhone() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getPostCode() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getSessionId() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getStreetAddress() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getSuburb() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getUserName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isActive() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isAddressVerified() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIdentityVerified() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isVoterVerified() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAccountCode(String accountCode) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setActive(boolean active) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAddressVerified(boolean addressVerified) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAvatarFileId(long avatarFileId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAvatarId(String avatarId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAvatarPath(String avatarPath) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAvatarType(String avatarType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBirthDate(Date birthDate) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCharity(String charity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCity(String city) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCountry(String country) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDiscussionThread(DiscussionThreadService discussionThread) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setEmail(String email) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setEmailCode(String emailCode) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setEmailConfirmed(Timestamp emailConfirmed) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setEmailVerificationCode(String emailVerificationCode) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setFirstName(String firstName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setGuid(String guid) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIdentifier(String identifier) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIdentityVerified(boolean identityVerified) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setJoinDate(Date joinDate) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setJoinTimeStamp(Timestamp joinTimeStamp) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLastName(String lastName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLocation(LocationService location) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setMemberId(long memberId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setMembershipNumber(String membershipNumber) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setMemberType(String memberType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setMiddleName(String middleName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPassKey(String passKey) {
		this.passKey=passKey;
	}

	@Override
	public void setPassword(String password) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPhone(String phone) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPostCode(String postCode) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSessionId(String sessionId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setStreetAddress(String streetAddress) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSuburb(String suburb) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setUserName(String userName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setVoterVerified(boolean voterVerified) {
		throw new UnsupportedOperationException();
	}

}

package nz.org.p2p.model.member.mock;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

import nz.org.p2p.model.discussion.api.DiscussionThreadOwnerService;
import nz.org.p2p.model.member.api.EmailIdentifierService;
import nz.org.p2p.model.member.api.MemberIdentifier;
import nz.org.p2p.model.member.api.MemberManagerService;
import nz.org.p2p.model.member.api.MemberProxy;
import nz.org.p2p.model.member.api.MemberService;
import nz.org.p2p.model.member.api.PassKeyIdentifierService;

/**
 * The mock member manager class.
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public class MockMemberManager implements MemberManagerService{

	/**
	 * The mock member proxy class.
	 *
	 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
	 * @author Richard Thomas &lt;richard@kanecta.com&gt;
	 */
	class MockMemberProxy extends MemberProxy{

		/**
		 * Instantiates a new mock member proxy.
		 *
		 * @param member the member
		 */
		public MockMemberProxy(MemberService member) {
			super(member);
		}

		/* (non-Javadoc)
		 * @see nz.org.p2p.model.member.api.MemberProxy#setEmail(java.lang.String)
		 */
		@Override
		public void setEmail(String email) {
			membersByEmail.remove(member.getEmail());
			super.setEmail(email);
			membersByEmail.put(email, member);
		}

		/* (non-Javadoc)
		 * @see nz.org.p2p.model.member.api.MemberProxy#setIdentifier(java.lang.String)
		 */
		@Override
		public void setIdentifier(String identifier) {
			membersByIdentifier.remove(member.getIdentifier());
			super.setIdentifier(identifier);
			membersByIdentifier.put(identifier, member);
		}

		/* (non-Javadoc)
		 * @see nz.org.p2p.model.member.api.MemberProxy#setMemberId(long)
		 */
		@Override
		public void setMemberId(long memberId) {
			membersById.remove(member.getMemberId());
			super.setMemberId(memberId);
			membersById.put(memberId, member);
		}

		/* (non-Javadoc)
		 * @see nz.org.p2p.model.member.api.MemberProxy#setPassKey(java.lang.String)
		 */
		@Override
		public void setPassKey(String passKey) {
			membersByPassKey.remove(member.getPassKey());
			super.setPassKey(passKey);
			membersByPassKey.put(passKey, member);

		}

		/* (non-Javadoc)
		 * @see nz.org.p2p.model.member.api.MemberProxy#setUserName(java.lang.String)
		 */
		@Override
		public void setUserName(String userName) {
			membersByUserName.remove(member.getUserName());
			super.setEmail(userName);
			membersByUserName.put(userName, member);
		}
	}

	/** The members by email. */
	Map<String, MemberService> membersByEmail=new LinkedHashMap<String, MemberService>();

	/** The members by pass key. */
	Map<String, MemberService> membersByPassKey=new LinkedHashMap<String, MemberService>();

	/** The members by user name. */
	Map<String, MemberService> membersByUserName=new LinkedHashMap<String, MemberService>();

	/** The members by identifier. */
	Map<String, MemberService> membersByIdentifier=new LinkedHashMap<String, MemberService>();

	/** The members by id. */
	Map<Long, MemberService> membersById=new LinkedHashMap<Long, MemberService>();

	/** The member proxies. */
	Map<MemberService, MemberService> memberProxies=new WeakHashMap<MemberService, MemberService>();

	/** The auto increment. */
	private int autoIncrement;

	/** The save new on update. */
	private boolean saveNewOnUpdate;

	/**
	 * Check unique.
	 *
	 * @param member the member
	 * @throws SQLException the sQL exception
	 */
	private void checkUnique(MemberService member) throws SQLException {
		if(membersByEmail.containsKey(member.getEmail())){
			throw new SQLException(
					MessageFormat.format("index email already contains \"{0}\"", member.getEmail()));
		}
		if(membersByPassKey.containsKey(member.getPassKey())){
			throw new SQLException(
					MessageFormat.format("index pass_key already contains \"{0}\"", member.getPassKey()));

		}
		if(membersByIdentifier.containsKey(member.getIdentifier())){
			throw new SQLException(
					MessageFormat.format("index idenifier already contains \"{0}\"", member.getIdentifier()));

		}
		if(membersById.containsKey(member.getMemberId())){
			throw new SQLException(
					MessageFormat.format("primary key member_id already contains \"{0}\"", member.getMemberId()));

		}
		if(membersByUserName.containsKey(member.getUserName())){
			throw new SQLException(
					MessageFormat.format("index user_name already contains \"{0}\"", member.getUserName()));
		}
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberManagerService#getMember(nz.org.p2p.model.member.api.EmailAddressService)
	 */
	@Override
	public DiscussionThreadOwnerService getMember(EmailIdentifierService email) {
		return getMemberProxy(membersByEmail.get(email.getId()));
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberManagerService#getMember(java.lang.Long)
	 */
	@Override
	public DiscussionThreadOwnerService getMember(Long id){
		return getMemberProxy(membersById.get(id));
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberManagerService#getMember(nz.org.p2p.model.member.api.MemberIdentifier)
	 */
	@Override
	public DiscussionThreadOwnerService getMember(MemberIdentifier id) {
		return getMemberProxy(membersByIdentifier.get(id.getIdentifier()));
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberManagerService#getMember(nz.org.p2p.model.member.api.PassKeyService)
	 */
	@Override
	public DiscussionThreadOwnerService getMember(PassKeyIdentifierService passKey) {
		return getMemberProxy(membersByPassKey.get(passKey.getPassKey()));
	}


	/**
	 * Gets The member proxy property.
	 *
	 * @param member the member
	 * @return A member proxy
	 */
	private DiscussionThreadOwnerService getMemberProxy(MemberService member) {
		MemberService memberProxy;
		if(memberProxies.containsKey(member)){
			memberProxy=memberProxies.get(member);
		}else{
			memberProxy=new MockMemberProxy(member);
			memberProxies.put(member, memberProxy);
		}
		return memberProxy;
	}

	/**
	 * Checks if this mock member manager is save new on update.
	 *
	 * @return {@code true}, if this mock member manager is save new on update.
	 */
	public boolean isSaveNewOnUpdate() {
		return saveNewOnUpdate;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberManagerService#saveMember(nz.org.p2p.model.member.api.MemberService)
	 */
	@Override
	public void saveMember(MemberService member) throws SQLException{
		if (member.getMemberId()<1){
			member.setMemberId(autoIncrement++);
		}
		checkUnique(member);
		membersByEmail.put(member.getEmail(),member);
		membersByPassKey.put(member.getPassKey(), member);
		membersById.put(member.getMemberId(), member);
		membersByIdentifier.put(member.getIdentifier(), member);
		membersByUserName.put(member.getUserName(), member);

	}

	/**
	 * Sets The members property.
	 *
	 * @param members A new members state
	 */
	public void setMembers(Collection<MemberService> members){
		for(MemberService member :members){
			membersByEmail.put(member.getEmail(),member);
			membersByPassKey.put(member.getPassKey(), member);
			membersById.put(member.getMemberId(), member);
			membersByUserName.put(member.getUserName(), member);

		}
	}

	/**
	 * Sets the {@code $name} property. save new on update.
	 *
	 * @param saveNewOnUpdate the save new on update
	 */
	public void setSaveNewOnUpdate(boolean saveNewOnUpdate) {
		this.saveNewOnUpdate = saveNewOnUpdate;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberManagerService#updateMember(nz.org.p2p.model.member.api.MemberService)
	 */
	@Override
	public void updateMember(MemberService member) throws SQLException{
		if (member.getMemberId()<1){
			if(saveNewOnUpdate){
				member.setMemberId(autoIncrement++);
			}else{
				throw new SQLException("Cannot update unsaved member");
			}
		}
		checkUnique(member);
		membersByEmail.put(member.getEmail(),member);
		membersByPassKey.put(member.getPassKey(), member);
		membersById.put(member.getMemberId(), member);
		membersByIdentifier.put(member.getIdentifier(), member);
		membersByUserName.put(member.getUserName(), member);

	}
}

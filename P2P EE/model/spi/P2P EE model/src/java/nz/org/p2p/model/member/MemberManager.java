package nz.org.p2p.model.member;

import java.sql.SQLException;

import nz.org.p2p.model.discussion.api.DiscussionThreadOwnerService;
import nz.org.p2p.model.hibernate.DataSource;
import nz.org.p2p.model.member.api.EmailIdentifierService;
import nz.org.p2p.model.member.api.MemberIdentifier;
import nz.org.p2p.model.member.api.MemberManagerService;
import nz.org.p2p.model.member.api.MemberService;
import nz.org.p2p.model.member.api.PassKeyIdentifierService;

import org.hibernate.Query;

/**
 * <p>
 * The member manager class provides a Hibernate implementation of the
 * {@link MemberManagerService} .
 * </p>
 * 
 * <p>
 * This software is offered under the terms of the GNU AFERO GENERAL PUBLIC
 * LICENCE of 2007, <b>See</b> {@link nz.org.p2p.model.member package
 * documentation} for more information.
 * </p>
 * 
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public class MemberManager implements MemberManagerService{

	/** The hibernate data source. */
	private DataSource hibernateDataSource;

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberManagerService#getMember(nz.org.p2p.model.member.api.EmailIdentifierService)
	 */
	@Override
	public DiscussionThreadOwnerService getMember(EmailIdentifierService email) {
		String hql = "from members where email=:eml";
		Query q= hibernateDataSource.getSession().createQuery(hql)
				.setParameter("eml",email.getId());
		return (DiscussionThreadOwnerService) q.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberManagerService#getMember(java.lang.Long)
	 */
	@Override
	public DiscussionThreadOwnerService getMember(Long id) {
		String hql = "from members where member_id=:id";
		Query q= hibernateDataSource.getSession().createQuery(hql)
				.setParameter("id",id);
		return (DiscussionThreadOwnerService) q.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberManagerService#getMember(nz.org.p2p.model.member.api.MemberIdentifier)
	 */
	@Override
	public DiscussionThreadOwnerService getMember(MemberIdentifier id) {
		String hql = "from members where member_id=:id";
		Query q= hibernateDataSource.getSession().createQuery(hql)
				.setParameter("id",id.getIdentifier());
		return (DiscussionThreadOwnerService) q.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberManagerService#getMember(nz.org.p2p.model.member.api.PassKeyIdentifierService)
	 */
	@Override
	public DiscussionThreadOwnerService getMember(PassKeyIdentifierService passkey) {
		String hql = "from members where pass_key=:pk";
		Query q= hibernateDataSource.getSession().createQuery(hql)
				.setParameter("pk",passkey.getPassKey());
		return (DiscussionThreadOwnerService) q.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberManagerService#saveMember(nz.org.p2p.model.member.api.MemberService)
	 */
	@Override
	public void saveMember(MemberService member) throws SQLException {
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.MemberManagerService#updateMember(nz.org.p2p.model.member.api.MemberService)
	 */
	@Override
	public void updateMember(MemberService member) throws SQLException {
		hibernateDataSource.update("member", member);
	}


}

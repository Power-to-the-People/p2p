package nz.org.p2p.model.member.authentication.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import nz.org.p2p.model.member.api.MemberService;
import nz.org.p2p.model.member.authentication.api.PasswordResetTokenFactoryService;
import nz.org.p2p.model.member.authentication.api.PasswordResetTokenService;

/**
 * A factory for creating MockPasswordResetToken objects.
 */
public class MockPasswordResetTokenFactory implements
PasswordResetTokenFactoryService, Iterable<PasswordResetTokenService> {

	/** The lifespan of token requests. */
	int lifespan;

	/** The mock token fixtures. */
	ArrayList<PasswordResetTokenService> mockTokens=new ArrayList<PasswordResetTokenService>();

	/** The iterator for stepping through token fixtures. */
	Iterator<PasswordResetTokenService> iterator=null;

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenFactoryService#getLifeSpan()
	 */
	@Override
	public int getLifeSpan() {
		return lifespan;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenFactoryService#getPasswordResetToken(nz.org.p2p.model.member.api.MemberService)
	 */
	@Override
	public PasswordResetTokenService getPasswordResetToken(MemberService member) {
		if(iterator==null) iterator=mockTokens.iterator();
		return iterator.next();
	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<PasswordResetTokenService> iterator() {
		final ArrayList<PasswordResetTokenService> tokens=mockTokens;
		return new Iterator<PasswordResetTokenService>(){
			int i=0;
			@Override
			public boolean hasNext() {
				return i<tokens.size();
			}

			@Override
			public PasswordResetTokenService next() {
				return tokens.get(i++);
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();

			}

		};
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.authentication.api.PasswordResetTokenFactoryService#setLifeSpan(int)
	 */
	@Override
	public void setLifeSpan(int lifeSpan) {
		this.lifespan=lifeSpan;

	}

	/**
	 * Sets The mock tokens property.
	 *
	 * @param tokens A new mock tokens state
	 */
	public void setMockTokens(Collection<PasswordResetTokenService> tokens){
		ArrayList<PasswordResetTokenService> mockTokens=new ArrayList<PasswordResetTokenService>();
		mockTokens.addAll(tokens);
		this.mockTokens=mockTokens;
		iterator=null;
	}

	/**
	 * Sets The mock tokens property.
	 *
	 * @param tokens A new mock tokens state
	 */
	public void setMockTokens(PasswordResetTokenService[] tokens){
		ArrayList<PasswordResetTokenService> mockTokens=new ArrayList<PasswordResetTokenService>();
		for(PasswordResetTokenService tkn:tokens){
			mockTokens.add(tkn);
		}
		this.mockTokens=mockTokens;
		iterator=null;
	}
}

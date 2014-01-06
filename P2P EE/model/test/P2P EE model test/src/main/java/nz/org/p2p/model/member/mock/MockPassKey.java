package nz.org.p2p.model.member.mock;

import nz.org.p2p.model.member.api.PassKeyIdentifierService;

// TODO: Auto-generated Javadoc
/**
 * <p>The mock pass key class provides a mock fixture implementation for passKeyIdentifierService.</p>
 * 
 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.member.mock package documentation} for more information.</p>
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public class MockPassKey implements PassKeyIdentifierService{

	/** The pass key. */
	private String passKey;

	/**
	 * Instantiates a new mock pass key.
	 *
	 * @param passkey the passkey
	 */
	public MockPassKey(String passkey) {
		super();
		this.passKey = passkey;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.api.PassKeyIdentifierService#getPassKey()
	 */
	@Override
	public String getPassKey() {
		return passKey;
	}

	/**
	 * Sets The pass key property.
	 *
	 * @param passkey A new pass key state
	 */
	public void setPassKey(String passkey) {
		this.passKey = passkey;
	}
}

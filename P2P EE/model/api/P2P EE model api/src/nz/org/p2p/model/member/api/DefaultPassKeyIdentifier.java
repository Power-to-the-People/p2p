package nz.org.p2p.model.member.api;

import java.util.Map;
import java.util.WeakHashMap;


/**
 * <p>The pass key class provides Provide a type safe object for PassKeys .</p>
 * 
 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.member package documentation} for more information.</p>
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 * @see MemberManagerService#getMember(PassKeyService)
 */
public class DefaultPassKeyIdentifier implements PassKeyIdentifierService{

	/** The passkey. */
	String passKey;

	/** The identifier cache. */
	private static Map<String, PassKeyIdentifierService> passKeys=
			new WeakHashMap<String, PassKeyIdentifierService>();

	/**
	 * Gets a named identifier from a cache or creates a new one.
	 *
	 * @param passKey the address
	 * @return A member identifier
	 */
	public static PassKeyIdentifierService get(String passKey) {
		if(!passKeys.containsKey(passKey)) {
			passKeys.put(passKey, new DefaultPassKeyIdentifier(passKey));
		}
		return passKeys.get(passKey);
	}




	/**
	 * create a passkey key record.
	 *
	 * @param passKey the passkey
	 */
	private DefaultPassKeyIdentifier(String passKey) {
		this.passKey=passKey;
	}

	/**
	 * Gets The passkey property.
	 *
	 * @return A passkey
	 * @see PassKeyService
	 */
	@Override
	public String getPassKey() {
		return passKey;
	}

}

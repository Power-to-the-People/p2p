package nz.org.p2p.model.member.api;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * <p>The default email address identifier class encapsulates type safe identifier objects
 * mapped to discrete values, Objects of this type can be used to identify
 * {@linkplain MemberService members}.</p>
 * 
 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.member.api package documentation} for more information.</p>
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public class DefaultEmailIdentifier implements EmailIdentifierService {

	/** The identifier cache. */
	private static Map<String, EmailIdentifierService> emails=
			new WeakHashMap<String, EmailIdentifierService>();

	/**
	 * Gets a named identifier from a cache or creates a new one.
	 *
	 * @param address the address
	 * @return A member identifier
	 */
	public static EmailIdentifierService get(String address) {
		if(!emails.containsKey(address)) {
			emails.put(address, new DefaultEmailIdentifier(address));
		}
		return emails.get(address);
	}

	/** The identifier value. */
	final String id;

	/**
	 * Instantiates a new email address identifier far an email address.
	 *
	 * @param address the address
	 */
	private  DefaultEmailIdentifier(String address) {
		super();
		this.id = address;
	}

	/**
	 * (non-Javadoc).
	 *
	 * @return A address
	 * @see nz.org.p2p.model.member.api.EmailIdentifierService
	 */
	@Override
	public String getId() {
		return id;
	}


}

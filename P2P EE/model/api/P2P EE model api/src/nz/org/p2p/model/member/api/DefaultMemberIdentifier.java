/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.member.api package documentation.
 */
package nz.org.p2p.model.member.api;

import java.util.Map;
import java.util.WeakHashMap;


/**
 * <p>The default member identifier class encapsulates type safe identifier objects
 * mapped to discrete values, Objects of this type can be used to identify
 * {@linkplain MemberService members}.</p>
 * 
 * <p>This class also provides a factory method creating identifiers for
 * supplied string values.</p>
 * 
 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.member.api package documentation} for more information.</p>
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public class DefaultMemberIdentifier implements MemberIdentifier {

	/** The identifier cache. */
	private static Map<String, MemberIdentifier> identifiers=
			new WeakHashMap<String, MemberIdentifier>();

	/**
	 * Gets a named identifier from a cache or creates a new one.
	 *
	 * @param id the identity value of the identifier
	 * @return A member identifier
	 */
	public static MemberIdentifier get(String id) {
		if(!identifiers.containsKey(id)) {
			identifiers.put(id, new DefaultMemberIdentifier(id));
		}
		return identifiers.get(id);
	}

	/** The identifier value. */
	final String id;

	/**
	 * Instantiates a new default member identifier.
	 *
	 * @param identifier the identifier
	 */
	private DefaultMemberIdentifier(String identifier) {
		super();
		this.id = identifier;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.member.MemberIdentifier#getIdentifier()
	 */
	@Override
	public String getIdentifier() {
		return id;
	}
}

/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.member.authentication.api package documentation.
 */
package nz.org.p2p.model.member.authentication.api;

import java.util.Map;
import java.util.WeakHashMap;


/**
 * The default token identifier class.
 * Provides a factory method creating identifiers for supplied string values.
 * 
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 */
public class DefaultTokenIdentifier implements PasswordResetTokenIdentifier {

	/** The identifier cache. */
	private static Map<String, PasswordResetTokenIdentifier> identifiers=
			new WeakHashMap<String, PasswordResetTokenIdentifier>();

	/**
	 * Gets a token identifier for a token id value.
	 *
	 * @param id the id
	 * @return A event identifier
	 */
	public static PasswordResetTokenIdentifier get(String id) {
		if(!identifiers.containsKey(id)) {
			identifiers.put(id, new DefaultTokenIdentifier(id));
		}
		return identifiers.get(id);
	}

	/** The identity value. */
	private final String id;

	/**
	 * Instantiates a new default token identifier.
	 *
	 * @param id the identity value of the new identifier.
	 */
	private DefaultTokenIdentifier(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.event.EventIdentifier#getIdentifier()
	 */
	@Override
	public String getIdentifier() {
		return id;
	}
}

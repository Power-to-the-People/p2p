/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.event.api package documentation.
 */
package nz.org.p2p.model.event.api;

import java.util.Map;
import java.util.WeakHashMap;



/**
 * The default event identifier class encapsulates type safe identifier objects
 * mapped to discrete values, Objects of this type can be used to identify
 * {@linkplain EventService events}.
 * This class also provides a factory method creating identifiers for supplied string values.
 * 
 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.event.api package documentation} for more information.</p>
 * 
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 */
public class DefaultEventIdentifier implements EventIdentifier {

	/** The identifier cache. */
	private static Map<String, EventIdentifier> identifiers=
			new WeakHashMap<String, EventIdentifier>();

	/**
	 * Gets the {@code $name} property..
	 *
	 * @param id the id
	 * @return A event identifier
	 */
	public static EventIdentifier get(String id) {
		if(!identifiers.containsKey(id)) {
			identifiers.put(id, new DefaultEventIdentifier(id));
		}
		return identifiers.get(id);
	}

	/** The id. */
	private final String id;

	/**
	 * Instantiates a new default event identifier.
	 *
	 * @param id the identity value of the new identifier.
	 */
	private DefaultEventIdentifier(String id) {
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

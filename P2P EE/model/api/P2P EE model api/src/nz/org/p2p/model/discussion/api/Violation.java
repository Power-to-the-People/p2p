package nz.org.p2p.model.discussion.api;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The violation enum provides... .
 * </p>
 * 
 * <p>
 * This software is offered under the terms of the GNU AFERO GENERAL PUBLIC
 * LICENCE of 2007, <b>See</b> {@link nz.org.p2p.model.discussion.api package
 * documentation} for more information.
 * </p>
 * 
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public enum Violation {

	/**
	 * Reported content may be hate speech. "Gays will destroy the world",
	 * "Gays are predators who will take your children."
	 * "Strike of their heads and strike off their fingers"
	 * "If man lies with a man as aman lies with a woman... their blood shall be upon them"
	 * "... niggers...", "kikes*, "spiks", "slant eyes", "chinks" / HATE_SPEECH,
	 * /** Reported content may be spam.
	 */
	SPAM,
	/**
	 * Reported content may be in furtherance of a fraud like selling The
	 * Auckland Harbour bridge to real estate investors or "miracle water"
	 */
	FRAUD,
	/** Reported content may be part of a harassment pattern. */
	HARASSMENT,
	/**
	 * Reported content may be obscene. "... niggers...",
	 * "kikes*, "spiks", "slant eyes", "chinks", "cunts", "slag", "bitch",
	 * "pig", "cracker", naked photos of posters ex, old sex tape,
	 */
	OBSCENITY,
	/**
	 * Reported content may breach terms of service.
	 * child pornography, snuff film, animal crush movies.*/
	TERMS_OF_SERVICE,
	/**
	 * Reported content copyright may breach copyright restrictions. "Fairuse"
	 * policy applies.
	 */
	COPYRIGHT,
	/**
	 * Reported content may be incitement to violence - gay bashing, stoning or
	 * raping. "We should wipe those pesky injuns"
	 * "Kill them all, The lord will recognise his own."
	 */
	INCITEMENT
}

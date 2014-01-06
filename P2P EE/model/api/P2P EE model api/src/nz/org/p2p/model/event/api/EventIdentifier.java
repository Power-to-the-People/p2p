package nz.org.p2p.model.event.api;



/**
 * The event identifier interface provides a contract where objects provide a
 * member identity value useful in {@link EventManagerService} implementations.
 *
 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.event.api package documentation} for more information.</p>
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public interface EventIdentifier {

	/**
	 * Gets The identifier property.
	 *
	 * @return A identifier
	 */
	public abstract String getIdentifier();

}

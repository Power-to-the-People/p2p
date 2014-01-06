/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.event.api package documentation.
 */
package nz.org.p2p.model.event.api;

import java.util.List;


/**
 * <p>The event manager service interface specifies a contract for managing
 * {@linkplain EventService events} in a  repository.</p>
 * 
 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.event.api package documentation} for more information.
 * </p>
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public interface EventManagerService {

	public abstract List<EventService> getActiveInMonth(int month);

	public abstract List<EventService> getActiveInMonth(int year, int month);

	/**
	 * Get events active in a given year.
	 *
	 * @param year the year
	 * @return  a list of events occurring in the specified given year.
	 */
	public List<EventService> getActiveInYear(int year);

	/**
	 * Gets The event property.
	 *
	 * @param Id the id
	 * @return A event
	 */
	public EventService getEvent(EventIdentifier Id) ;

	/**
	 * Gets The event property.
	 *
	 * @param id the id
	 * @return A event
	 */
	public EventService getEvent(long id) ;

	/**
	 * Gets The event property.
	 *
	 * @param EId the e id
	 * @return A event
	 */
	public EventService getEvent(String EId) ;
}
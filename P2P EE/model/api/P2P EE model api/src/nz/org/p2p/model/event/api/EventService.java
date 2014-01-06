/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.event.api package documentation.
 */
package nz.org.p2p.model.event.api;

import java.util.Calendar;



/**
 * The event service interface encapsulates public event information suitable
 * for event promotion and management.
 *
 * This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.event.api package documentation} for more information.
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public interface EventService {

	/**
	 * Gets the closing date/time of the even.
	 *
	 * @return the date finish
	 */
	public Calendar getDateFinish() ;

	/**
	 * Gets the date/time of the event.
	 *
	 * @return the date start
	 */
	public Calendar getDateStart() ;

	/**
	 * Gets the description of the event.
	 *
	 * @return the description
	 */;

	 /**
	  * Gets the eid.
	  *
	  * @return the eid
	  */
	 public String getEid() ;

	 /**
	  * Gets the event id.
	  *
	  * @return the event id
	  */
	 public long getEventId() ;

	 /**
	  * Gets the event identifier.
	  *
	  * @return the event identifier
	  */
	 public String getEventIdentifier() ;

	 /**
	  * Gets the month the event occurs.
	  *
	  * @return the event month
	  */
	 public int getEventMonth() ;

	 /**
	  * Gets the name of the event.
	  *
	  * @return the event name
	  */
	 public String getEventName() ;

	 /**
	  * Gets the link to an external event page.
	  *
	  * @return the link
	  */
	 public String getLink() ;

	 /**
	  * Gets the location.
	  *
	  * @return text describing the location or address of the event
	  * ("TSB Event centre").
	  */
	 public String getLocation() ;

	 /**
	  * Gets the snippit id.
	  *
	  * @return the snippit id
	  */
	 public long getSnippitId() ;

	 /**
	  * Checks if this event service is active.
	  *
	  * @return {@code true}, if this event service is active.
	  */
	 public boolean isActive() ;

	 /**
	  * Sets the {@code $name} property. active.
	  *
	  * @param active the active
	  */
	 public void setActive(boolean active) ;

	 /**
	  * Sets The date finish property.
	  *
	  * @param dateFinish A new date finish
	  */
	 public void setDateFinish(Calendar dateFinish) ;

	 /**
	  * Sets the date start.
	  *
	  * @param dateStart the new date start
	  */
	 public void setDateStart(Calendar dateStart) ;

	 /**
	  * Sets the description.
	  *
	  * @param description the new description
	  */
	 public void setDescription(String description) ;

	 /**
	  * Sets the eid.
	  *
	  * @param eid the new eid
	  */
	 public void setEid(String eid) ;

	 /**
	  * Sets the event id.
	  *
	  * @param eventId the new event id
	  */
	 public void setEventId(long eventId) ;

	 /**
	  * Sets the event identifier.
	  *
	  * @param eventIdentifier the new event identifier
	  */
	 public void setEventIdentifier(String eventIdentifier) ;

	 /**
	  * Sets the event month.
	  *
	  * @param eventMonth the new event month
	  */
	 public void setEventMonth(int eventMonth) ;

	 /**
	  * Sets the event name.
	  *
	  * @param eventName the new event name
	  */
	 public void setEventName(String eventName);

	 /**
	  * Sets the link.
	  *
	  * @param link the new link
	  */
	 public void setLink(String link) ;

	 /**
	  * Sets the location.
	  *
	  * @param location the new location
	  */
	 public void setLocation(String location) ;

	 /**
	  * Sets the snippit id.
	  *
	  * @param snippitId the new snippit id
	  */
	 public void setSnippitId(long snippitId) ;

}
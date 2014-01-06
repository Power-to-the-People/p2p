package nz.org.p2p.model.event;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import nz.org.p2p.model.event.api.EventService;




/**
 * <p>The event class provides... .</p>
 * 
 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.event package documentation} for more information.</p>
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
@Entity(name="event")
public class Event implements EventService {

	/** The event id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="event_id")
	long eventId;

	/** The event name. */
	@Column(name="event_name")
	String eventName;

	/** The active. */
	@Column(name="active")
	boolean active;

	/** The snippit id. */
	@Column(name="snippit_id")
	long snippitId=0;

	/** The eid. */
	@Column(name="eid")
	String eid;

	/** The description. */
	@Column(name="description", columnDefinition="TEXT")
	String description;

	/** The event identifier. */
	@Column(name="event_identifier")
	String eventIdentifier;

	/** The link. */
	@Column(name="link")
	String link;

	/** The location. */
	@Column(name="location")
	String location;

	/** The date start. */
	@Column(name="date_start")
	Calendar dateStart;

	/** The date finish. */
	@Column(name="date_finish")
	Calendar dateFinish;

	/** The event month. */
	@Column(name="event_month")
	int eventMonth;

	/**
	 * Gets the date finish.
	 *
	 * @return the date finish
	 */
	@Override
	public Calendar getDateFinish() {
		return dateFinish;
	}

	/**
	 * Gets the date start.
	 *
	 * @return the date start
	 */
	@Override
	public Calendar getDateStart() {
		return dateStart;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets the eid.
	 *
	 * @return the eid
	 */
	@Override
	public String getEid() {
		return eid;
	}

	/**
	 * Gets the event id.
	 *
	 * @return the event id
	 */
	@Override
	public long getEventId() {
		return eventId;
	}

	/**
	 * Gets the event identifier.
	 *
	 * @return the event identifier
	 */
	@Override
	public String getEventIdentifier() {
		return eventIdentifier;
	}

	/**
	 * Gets the event month.
	 *
	 * @return the event month
	 */
	@Override
	public int getEventMonth() {
		return eventMonth;
	}

	/**
	 * Gets the event name.
	 *
	 * @return the event name
	 */
	@Override
	public String getEventName() {
		return eventName;
	}

	/**
	 * Gets the link.
	 *
	 * @return the link
	 */
	@Override
	public String getLink() {
		return link;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	@Override
	public String getLocation() {
		return location;
	}

	/**
	 * Gets the snippit id.
	 *
	 * @return the snippit id
	 */
	@Override
	public long getSnippitId() {
		return snippitId;
	}

	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	@Override
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Sets the date finish.
	 *
	 * @param dateFinish the new date finish
	 */
	@Override
	public void setDateFinish(Calendar dateFinish) {
		this.dateFinish = dateFinish;
	}

	/**
	 * Sets the date start.
	 *
	 * @param dateStart the new date start
	 */
	@Override
	public void setDateStart(Calendar dateStart) {
		this.dateStart = dateStart;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Sets the eid.
	 *
	 * @param eid the new eid
	 */
	@Override
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * Sets the event id.
	 *
	 * @param eventId the new event id
	 */
	@Override
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	/**
	 * Sets the event identifier.
	 *
	 * @param eventIdentifier the new event identifier
	 */
	@Override
	public void setEventIdentifier(String eventIdentifier) {
		this.eventIdentifier = eventIdentifier;
	}

	/**
	 * Sets the event month.
	 *
	 * @param eventMonth the new event month
	 */
	@Override
	public void setEventMonth(int eventMonth) {
		this.eventMonth = eventMonth;
	}

	/**
	 * Sets the event name.
	 *
	 * @param eventName the new event name
	 */
	@Override
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * Sets the link.
	 *
	 * @param link the new link
	 */
	@Override
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	@Override
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Sets the snippit id.
	 *
	 * @param snippitId the new snippit id
	 */
	@Override
	public void setSnippitId(long snippitId) {
		this.snippitId = snippitId;
	}

}
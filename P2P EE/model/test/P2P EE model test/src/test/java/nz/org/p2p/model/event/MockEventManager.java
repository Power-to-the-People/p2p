package nz.org.p2p.model.event;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import nz.org.p2p.model.event.api.EventIdentifier;
import nz.org.p2p.model.event.api.EventManagerService;
import nz.org.p2p.model.event.api.EventService;

/**
 * The mock event manager class.
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public class MockEventManager implements EventManagerService {

	/** The events by year. */
	private final Map<Integer, List<EventService>> eventsByYear=new LinkedHashMap<Integer, List<EventService>>();
	private final Map<Integer, List<EventService>> eventsByMonth=new LinkedHashMap<Integer, List<EventService>>();
	private final Map<String, EventService> eventsByEId=new LinkedHashMap<String, EventService>();
	private final Map<Long, EventService> eventsById=new LinkedHashMap<Long, EventService>();
	private final Map<String, EventService> eventsByEventIdentifier=new LinkedHashMap<String, EventService>();

	@Override
	public List<EventService> getActiveInMonth(int month) {
		return null;
	}


	@Override
	public List<EventService> getActiveInMonth(int year, int month) {
		return null;
	}
	/* (non-Javadoc)
	 * @see nz.org.p2p.model.event.api.EventManagerService#gatActiveInYear(int)
	 */
	@Override
	public List<EventService> getActiveInYear(int year) {
		return eventsByYear.get(year);
	}

	/**
	 * Gets The event associated with a given identifier.
	 *
	 * @param id the identifier.
	 * @return A event
	 */
	@Override
	public EventService getEvent(EventIdentifier id) {
		return eventsByEventIdentifier.get(id.getIdentifier());
	}

	/**
	 * Gets The event for a get data primary key.
	 *
	 * @param id the id
	 * @return A event
	 */
	@Override
	public EventService getEvent(long id) {
		return eventsById.get(id);
	}


	/**
	 * Gets The event for a given event id.
	 *
	 * @param eid the eid
	 * @return A event
	 */
	@Override
	public EventService getEvent(String eid) {
		return eventsByEId.get(eid);
	}


	/**
	 * Sets The events property.
	 *
	 * @param events A new events state
	 */
	void setEvents(Collection<EventService> events){
		for(EventService e:events){
			Calendar dateStart = e.getDateStart();
			int year = dateStart.get(Calendar.YEAR);
			List<EventService> eby=eventsByYear.get(year);
			List<EventService> ebm=eventsByMonth.get(year);
			if(eby==null) {
				eby=new ArrayList<EventService>();
				ebm=new ArrayList<EventService>();
				eventsByYear.put(year, eby);
				int month=dateStart.get(Calendar.MONTH);
				int months=dateStart.getGreatestMinimum(Calendar.MONTH)
						- dateStart.getMinimum(Calendar.MONTH)+1;
				eventsByMonth.put(year*months+month, ebm);
			}
			eby.add(e);
			ebm.add(e);
			eventsByEId.put(e.getEid(), e);
			eventsById.put(e.getEventId(), e);
			eventsByEventIdentifier.put(e.getEventIdentifier(), e);

		}
	}
}

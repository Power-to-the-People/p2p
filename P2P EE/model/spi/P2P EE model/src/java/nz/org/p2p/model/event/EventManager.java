package nz.org.p2p.model.event;

import java.util.Calendar;
import java.util.List;

import nz.org.p2p.model.event.api.EventIdentifier;
import nz.org.p2p.model.event.api.EventManagerService;
import nz.org.p2p.model.event.api.EventService;
import nz.org.p2p.model.hibernate.DataSource;
import nz.org.p2p.model.hibernate.DataSource.Parameter;

/**
 * <p>The event manager class provides a container for {@linkplain EventService events} .</p>
 * 
 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.event package documentation} for more information.</p>
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public class EventManager implements EventManagerService {

	/** The data source. */
	DataSource dataSource;

	@Override
	public List<EventService> getActiveInMonth(int month) {
		Calendar now = Calendar.getInstance();
		return getActiveInMonth(now.get(Calendar.YEAR), month);
	}

	@Override
	public List<EventService> getActiveInMonth(int year, int month) {
		int monthMin=Calendar.getInstance().getMinimum(Calendar.MONTH);
		int monthMax=Calendar.getInstance().getMaximum(Calendar.MONTH);
		if(month<monthMin)
			throw new IllegalArgumentException("month can't be <"+monthMin+": "+month);
		if(month>12) throw new IllegalArgumentException("month can't be >"+monthMax+": "+month);
		@SuppressWarnings("unchecked")
		List<EventService> itinery = getDataSource().select(
				EventService.class,
				"from events where active=true " +
						"and dateStart.get(java.util.Calendar.YEAR)=:year"+
						"and dateStart.get(java.util.Calendar.MONTH)=:month"
						,new Parameter("yField",Calendar.YEAR)
				,new Parameter("mField",Calendar.MONTH)
				,new Parameter("month", month)
				,new Parameter("year", year));
		return itinery;
	}
	/**
	 * Select the events of a specified year.
	 *
	 * @param year the year selected events will be drawn from.
	 * @return A active in year
	 */
	@Override
	public List<EventService> getActiveInYear(int year) {
		@SuppressWarnings("unchecked")
		List<EventService> itinery = getDataSource().select(
				EventService.class,
				"from events where active=true and dateStart.get(:field)=:year"
				,new Parameter("field",Calendar.YEAR)
				,new Parameter("year", year));
		return itinery;
	}

	/**
	 * Gets The data source property.
	 *
	 * @return A data source
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.event.api.EventManagerService#getEvent(nz.org.p2p.model.event.api.EventIdentifier)
	 */
	@Override
	public EventService getEvent(EventIdentifier id) {
		return dataSource.selectUnique(
				EventService.class,
				"from event where identifier=:id",
				new Parameter("id", id));
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.event.api.EventManagerService#getEvent(long)
	 */
	@Override
	public EventService getEvent(long id) {
		return dataSource.selectUnique(
				EventService.class,
				"from event where eventId=:id",
				new Parameter("id", id));
	}

	/* (non-Javadoc)
	 * @see nz.org.p2p.model.event.api.EventManagerService#getEvent(java.lang.String)
	 */
	@Override
	public EventService getEvent(String eId) {
		return dataSource.selectUnique(
				EventService.class,
				"from event where eId=:id",
				new Parameter("id", eId));
	}

	/**
	 * Sets The data source property.
	 *
	 * @param dataSource A new data source state
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}

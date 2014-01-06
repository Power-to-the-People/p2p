package nz.org.p2p.model.location.api;

import nz.org.p2p.model.member.api.LocationService;

/**
 * <p>The location class provides... .</p>
 * 
 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.location.api package documentation} for more information.</p>
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
public class Location implements LocationService {
	long id;
	long count;
	private String name;
	@Override
	public void add(long count) {
		synchronized (this){
			this.count+=count;

		}

	}

	@Override
	public long getCount() {
		return count;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setCount(long count) {
		this.count=count;

	}

	@Override
	public void setId(long id) {
		this.id=id;

	}

	@Override
	public void setName(String name) {
		this.name=name;

	}

}

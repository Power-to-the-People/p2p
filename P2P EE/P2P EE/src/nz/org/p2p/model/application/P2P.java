

package nz.org.p2p.model.application;


/**
 * The <code>P2P</code> class is a basic application model specifying application 
 * wide properties.
 * @version ${version}
 * @author John Hutcheson <witerat.test<gmail.com>
 * @author Richard Thomas <team@p2p.org.nz>
 *
 */
public class P2P {
	
	/** The instance of the singleton application model. */
	private static P2P instance;
	
	/** The version. By convention we are using the release build date */
	private static final String version = "2013-11-05";
	
	/** The server domain. */
	private String domain;
	/**
	 * The default live domain. 
	 */
	public static final String LIVE_DOMAIN = "p2p.org.nz";
	/**
	 * The default test domain.
	 */
	public static final String TEST_DOMAIN = "localhost:10000";
	
	/** The testMode property. */
	private final boolean testMode;

	/**
	 * Gets the instance of the application model. by default this will be a live instance.
	 * @return an instance of the application model.
	 */
	public static P2P getInstance(){ 
		return getInstance(LIVE_DOMAIN, false);
	}
	
	/**
	 * Gets the instance of the application model. by default this will be a live instance.
	 *
	 * @param domain the domain
	 * @return an instance of the application model.
	 */
	public static P2P getInstance(String domain){ 
		return getInstance(domain, false);
	}
	
	/**
	 * Gets the instance of the application model. If this is the first call, the
	 * application model will created in testing mode if requested.
	 * If this is not the first call the testing parameter is ignored.
	 *
	 * @param domain the domain
	 * @param testing whether the application should run in test mode.
	 * @return the instance of the application model.
	 */
	public static P2P getInstance(String domain, boolean testing){
		if(instance!=null) return instance;
		return new P2P(domain, testing);
	}
	
	/**
	 * Creates and configures the application model to run live on the default live domain.
	 * @see {@link #LIVE_DOMAIN} 
	 */
	private P2P() {
		this(LIVE_DOMAIN, false);
	}

	/**
	 * Creates and configures the application model. 
	 * @param domain the server domain for execution.
	 * @param testing <code>true</code to request development test execution.
	 */
	private P2P(String domain, boolean testing) {
		if (instance != null)
			throw new IllegalStateException(
					"multiple intstances of P2P are not allowed");
		instance = this;
		this.testMode = testing;
		this.domain=domain;
	}

	/**
	 * Gets the domain property.
	 * @return the server domain the application is running on.
	 */
	public final String getDomain() {
		return domain;
	}
	
	/**
	 * Sets the domain property.
	 *
	 * @param domain the new domain
	 */
	final void setDomain(String domain){
		if(!testMode) throw new IllegalStateException("Cannot change domain of a live system");
		this.domain=domain;
	}

	/**
	 * Provides the release info.
	 *
	 * @return a String formatted to indicate the version of the the
	 * application. By historical convention this is the build date of
	 * the release.
	 */
	public final String getVersion() {
		return version;
	}
	
	/**
	 * Checks whether the application is running in test-mode..
	 *
	 * @return <code>true</code> if this is a development test.
	 */
	final public boolean isTestMode(){
		return testMode;
	}
}

package nz.org.p2p.model.member.authentication;

import nz.org.p2p.model.member.api.MemberService;
import nz.org.p2p.model.member.authentication.api.PasswordResetTokenFactoryService;
import nz.org.p2p.model.member.authentication.api.PasswordResetTokenService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Test the function of method {@link PasswordResetTokenFactoryService}
 * implementors.
 * 
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * 
 */

public class PasswordResetTokenFactoryTest {
	String defaultFixturePath = this.getClass().getName().replace(".", "/")
			+ ".beans.xml";
	private PasswordResetTokenFactoryService factory;

	private MemberService member;

	public String getDefaultFixturePath() {
		return defaultFixturePath;
	}

	public void setDefaultFixturePath(String defaultFixturePath) {
		this.defaultFixturePath = defaultFixturePath;
	}

	/**
	 * Load the test target and fixtures from the spring configuration.
	 */
	@Before
	public void setup() {

		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
		xbdr.loadBeanDefinitions(defaultFixturePath);
		factory = dlbf.getBean(PasswordResetTokenFactoryService.class);
		member = dlbf.getBean(MemberService.class);
	}

	/**
	 * Checks that the Token identifies the user.
	 */
	public void testGetPasswordResetToken() {
		PasswordResetTokenService token = factory.getPasswordResetToken(member);
		Assert.assertEquals(member.getPassKey(), token.getPassKey());
	}

	/**
	 * Tests that the lifespan proptery is properly configured.
	 */
	@Test
	public void testLifeSpan() {
		Assert.assertEquals(48, factory.getLifeSpan());
	}

}

package nz.org.p2p.model.member;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import nz.org.p2p.model.member.api.MemberService;
import nz.org.p2p.model.member.mock.MockEmailIdentifier;
import nz.org.p2p.model.member.mock.MockPassKey;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class MemberTest {
	Map<MemberService, Map<String, Boolean>> testEqualsEmailFixtures=
			new LinkedHashMap<MemberService, Map<String,Boolean>>();
	Map<MemberService, Map<String, Boolean>> testEqualsIdentityFixtures=
			new LinkedHashMap<MemberService, Map<String,Boolean>>();

	private final String defaultPath=this.getClass().getName().replace(".", "/")+".beans.xml";

	private String fixturePath;
	public String getFixturePath() {
		return fixturePath==null?defaultPath:fixturePath;
	}
	public void setFixturePath(String fixturePath) {
		this.fixturePath = fixturePath;
	}
	@Before
	public void setup() {
		DefaultListableBeanFactory dlbf=
				new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr=new XmlBeanDefinitionReader(dlbf);
		xbdr.loadBeanDefinitions(getFixturePath());
		testEqualsEmailFixtures=dlbf.getBean("testEqualsEmailFixtures", Map.class);
		testEqualsIdentityFixtures=dlbf.getBean("testEqualsIdentityFixtures", Map.class);

	}
	@Test
	public void testEqualsEmail() {
		for(Entry<MemberService, Map<String, Boolean>> e:testEqualsEmailFixtures.entrySet()) {
			for(Entry<String, Boolean> f:e.getValue().entrySet()) {
				MockEmailIdentifier emailFixture = new MockEmailIdentifier(f.getKey());
				assertEquals(f.getValue(), e.getKey().equals(emailFixture));
			}
		}
	}
	@Test
	public void testEqualsPasskey() {
		for(Entry<MemberService, Map<String, Boolean>> e:testEqualsIdentityFixtures.entrySet()) {
			for(Entry<String, Boolean> f:e.getValue().entrySet()) {
				MockPassKey emailFixture = new MockPassKey(f.getKey());
				assertEquals(f.getValue(), e.getKey().equals(emailFixture));
			}
		}
	}

}

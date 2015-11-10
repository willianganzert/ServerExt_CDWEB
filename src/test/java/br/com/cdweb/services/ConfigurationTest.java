package br.com.cdweb.services;

import org.junit.Before;
import org.junit.Test;

import br.com.cdweb.server.services.Configuration;
import junit.framework.TestCase;

public class ConfigurationTest extends TestCase {
	private Configuration configuration;
	
	public ConfigurationTest() {
		configuration = new Configuration();

	}
	@Test
	public void testeGetIp() {
		String ip = configuration.getIP();
		assertNotNull("IP NULO", ip);
	}
}

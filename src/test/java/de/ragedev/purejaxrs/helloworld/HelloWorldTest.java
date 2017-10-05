package de.ragedev.purejaxrs.helloworld;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.ragedev.purejaxrs.MicroServer;

public class HelloWorldTest {

	@Before
	public void setup() throws Exception 
	{
		MicroServer.start();
	}
	
    @Test
    public void helloWorldOk() throws Exception {
        String result = ClientBuilder.newClient().target("http://localhost:8080/helloworld").request(MediaType.TEXT_PLAIN).get(String.class);
        
        assertEquals("Hello World!", result);
    }
    
    @After
	public void cleanup()
	{
    	MicroServer.stop();
	}
}

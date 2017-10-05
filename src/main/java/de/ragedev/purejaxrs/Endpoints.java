package de.ragedev.purejaxrs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import de.ragedev.purejaxrs.helloworld.HelloWorldEndpoint;
import de.ragedev.purejaxrs.helloworld.SayHelloEndpoint;

public class Endpoints extends Application {
	
    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<>(Arrays.asList(HelloWorldEndpoint.class, SayHelloEndpoint.class));
    }
}

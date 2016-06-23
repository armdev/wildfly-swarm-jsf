package org.wildfly.swarm.examples.jsf.shrinkwrap;

import javax.enterprise.inject.Model;

@Model
public class Message {

    public String say() {
        return "Hello from JSF CDI Request Scoped bean";
    }

    public String getUsername() {
        return "This is a next page!!!!";
    }
}

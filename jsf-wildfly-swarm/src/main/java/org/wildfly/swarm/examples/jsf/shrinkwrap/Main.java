package org.wildfly.swarm.examples.jsf.shrinkwrap;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.undertow.WARArchive;

public class Main {

    public static void main(String[] args) throws Exception {

        Container container = new Container();

        WARArchive deployment = ShrinkWrap.create(WARArchive.class);

        deployment.addClass(Message.class);

        deployment.addAsWebResource(
                new ClassLoaderAsset("index.html", Main.class.getClassLoader()), "index.html");
        deployment.addAsWebResource(
                new ClassLoaderAsset("index.xhtml", Main.class.getClassLoader()), "index.xhtml");

        deployment.addAsWebResource(
                new ClassLoaderAsset("next.xhtml", Main.class.getClassLoader()), "next.xhtml");
        
          deployment.addAsWebResource(
                new ClassLoaderAsset("resources/armenia.png", Main.class.getClassLoader()), "resources/armenia.png");

        deployment.addAsLibrary("resources");
        
        deployment.addAsDirectory("resources");
        //deployment.addAS
        

        deployment.addAsWebInfResource(
                new ClassLoaderAsset("WEB-INF/web.xml", Main.class.getClassLoader()), "web.xml");
        deployment.addAsWebInfResource(
                new ClassLoaderAsset("WEB-INF/template.xhtml", Main.class.getClassLoader()), "template.xhtml");

        deployment.addAllDependencies();

        container.start().deploy(deployment);

    }
}

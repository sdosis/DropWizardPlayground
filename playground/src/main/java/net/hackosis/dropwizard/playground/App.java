package net.hackosis.dropwizard.playground;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import net.hackosis.dropwizard.playground.health.TemplateHealthCheck;
import net.hackosis.dropwizard.playground.resources.PlaygroundResource;

/**
 * Hello world!
 *
 */
public class App  extends Application<PlaygroundConfiguration>
{
    public static void main( String[] args ) throws Exception
    {
        new App().run(args);
    }
    
    @Override
    public String getName(){
    	return "hello-world";
    }
    
    @Override
    public void initialize(Bootstrap<PlaygroundConfiguration> bootstrap){
    	
    }
    
    @Override
    public void run(PlaygroundConfiguration configuration, Environment environment){
    	final PlaygroundResource resource = new PlaygroundResource(
    			configuration.getTemplate(),
    			configuration.getDefaultName()
    			);
    	final TemplateHealthCheck healthCheck = 
    			new TemplateHealthCheck(configuration.getTemplate());
    	environment.healthChecks().register("template", healthCheck);
    	environment.jersey().register(resource);
    }
}

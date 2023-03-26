# imola_module6

https://docs.github.com/en/get-started/getting-started-with-git/about-remote-repositories#cloning-with-https-urls

Elmélet: 
https://www.javainuse.com/spring/spring_eurekaregister
https://www.tutorialspoint.com/spring_boot/spring_boot_service_registration_with_eureka.htm
https://www.tutorialspoint.com/spring_boot/spring_boot_eureka_server.htm 

ACTUATOR
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HEALTH
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
eureka.client.healthcheck.enabled=true   
When this property is enabled, client application will send health status (the same health status reported by /health endpoint of Actuator framework) to the Eureka server, and server will use this status to determine if server should advertise hostname/IP of this particular application to other applications.

management.endpoint.health.show-details 
sets what is visible. Can be ALWAS, NEVER, WHEN_AUTHORISED (this can be further set with: management.endpoint.health.roles)

Writing your own: 
@Component
public class MyClass implements HealthIndicator {

    @Override
    public Health health() {
        ...
    }
    

ENABLE AND EXPOSE
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
all but shutdown is enabled by default. 
However only info and health are exposed on the web by default. 
For enabling: 
management.endpoints.web.exposure.include=*
management.endpoints.web.exposure.exclude=env,beans
(this will enable all endpoints, but environment variables and the list of every bean in the context of the module)    


OTHER ENDPOINTS
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/actuator/mapping --- reveals all the endpoints (anything that has @RequestMapping) and information about them
/actuator/env     --- reveals all the environemnt variables of the module
/actuator/beans   --- reveals all the beans of the module
/actuator/heapdump
/actuator/threaddump
/actuator/configprops --- all the configuration properties evaluated at the start
full list: https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.endpoints

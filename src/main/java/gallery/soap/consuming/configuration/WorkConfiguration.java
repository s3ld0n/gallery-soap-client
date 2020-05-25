package gallery.soap.consuming.configuration;

import gallery.soap.consuming.client.WorkClient;
import gallery.soap.consuming.wsdl.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WorkConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("gallery.soap.consuming.wsdl");
        return marshaller;
    }

    @Bean
    public WorkClient workClient(Jaxb2Marshaller marshaller){
        WorkClient workClient = new WorkClient();
        workClient.setDefaultUri("http://localhost:9090/ws");
        workClient.setMarshaller(marshaller);
        workClient.setUnmarshaller(marshaller);
        return workClient;
    }

    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }
}

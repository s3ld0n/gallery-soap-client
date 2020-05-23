package gallery.soap.consuming;

import gallery.soap.consuming.client.WorkClient;
import gallery.soap.consuming.wsdl.GetWorkResponse;
import gallery.soap.consuming.wsdl.Work;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner lookup(WorkClient workClient) {
        return args ->
        {
            String title = "Goal";

            if (args.length > 0) {
                title = args[0];
            }
            GetWorkResponse response = workClient.getWork(title);
            Work work = response.getWork();
            System.err.println("Work id: " + work.getId() + ", title: " + work.getTitle());
        };
    }
}

package gallery.soap.consuming;

import gallery.soap.consuming.client.WorkClient;
import gallery.soap.consuming.wsdl.AddWorkResponse;
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
    CommandLineRunner getWork(WorkClient workClient) {
        return args ->
        {
            System.err.println("Getting work with title 'Goal'");
            String title = "Goal";

            if (args.length > 0) {
                title = args[0];
            }
            GetWorkResponse response = workClient.getWork(title);
            Work work = response.getWork();
            System.err.println("Found!\n Work id: " + work.getId() + ", title: " + work.getTitle());
        };
    }

    @Bean
    CommandLineRunner addWork(WorkClient workClient) {
        return args ->
        {
            System.err.println("Creating work with title \"Speed and weight\"");
            Work work = new Work();
            work.setTitle("Speed and weight");

            AddWorkResponse response = workClient.addWork(work);
            work.setId((int) response.getId());

            System.out.println("Work created!");
            System.err.println("Work id: " + work.getId() + ", title: " + work.getTitle());
        };
    }
}

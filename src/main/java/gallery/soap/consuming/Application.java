package gallery.soap.consuming;

import gallery.soap.consuming.client.WorkClient;
import gallery.soap.consuming.wsdl.AddWorkResponse;
import gallery.soap.consuming.wsdl.GetWorkResponse;
import gallery.soap.consuming.wsdl.UpdateWorkResponse;
import gallery.soap.consuming.wsdl.Work;
import org.slf4j.Logger;
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
            System.err.println("Getting work with title 'Joy'");
            String title = "Joy";

            if (args.length > 0) {
                title = args[0];
            }
            GetWorkResponse response = workClient.getWork(title);
            Work work = response.getWork();
            System.err.println("Work is found!");
            System.out.println("Work id: " + work.getId() + ", title: " + work.getTitle());
        };
    }

    @Bean
    CommandLineRunner addWork(WorkClient workClient) {
        return args ->
        {
            System.err.println("Creating work with title \"Peace\"");
            Work work = new Work();
            work.setTitle("Peace");

            AddWorkResponse response = workClient.addWork(work);
            work.setId((int) response.getId());

            System.err.println("Work created!");
            System.out.println("Work id: " + work.getId() + ", title: " + work.getTitle());
        };
    }

    @Bean
    CommandLineRunner updateWork(WorkClient workClient) {
        return args ->
        {
            Work work = new Work();
            work.setId(3);
            work.setTitle("Courage");

            UpdateWorkResponse response = workClient.updateWork(work);

            work = response.getWork();
            System.err.println("Work updated!");
            System.out.println("Work id: " + work.getId() + ", title: " + work.getTitle());
        };
    }
}

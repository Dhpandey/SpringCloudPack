package cloudtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dpanw on 7/12/16.
 */

@SpringBootApplication
@EnableTask
public class SpringCloudTask {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new HelloWorldRunner();
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringCloudTask.class, args);
    }
}
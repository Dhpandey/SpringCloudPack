package cloudtask;

import org.springframework.boot.CommandLineRunner;

/**
 * Created by dpanw on 7/29/16.
 */
public class HelloWorldRunner implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Spring Cloud Task Successful!");
    }
}

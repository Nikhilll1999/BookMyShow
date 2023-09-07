package springStarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.nctech.bookmyshow.controllers"})
public class BookMyShowBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowBeApplication.class, args);
    }
}
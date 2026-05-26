package project.day8_ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Day8ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day8ProductServiceApplication.class, args);
    }
}
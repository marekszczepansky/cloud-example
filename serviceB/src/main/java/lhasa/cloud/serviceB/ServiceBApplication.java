package lhasa.cloud.serviceB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ServiceBApplication
{

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder rtb)
	{
		return rtb.build();
	}

	public static void main(String[] args)
	{
		SpringApplication.run(ServiceBApplication.class, args);
	}
}

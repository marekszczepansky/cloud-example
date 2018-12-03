package lhasa.cloud.serviceA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ServiceAApplication
{

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder rtb)
	{
		return rtb.build();
	}

	public static void main(String[] args)
	{
		SpringApplication.run(ServiceAApplication.class, args);
	}
}

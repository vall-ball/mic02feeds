package ru.vallball.mic02feeds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeedApp {
	public static void main(String[] args) {
		SpringApplication.run(FeedApp.class, args);
	}
}

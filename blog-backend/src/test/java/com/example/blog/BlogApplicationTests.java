package com.example.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

@SpringBootTest
@AutoConfigureWebTestClient
class BlogApplicationTests {

	@Autowired
	private WebTestClient client;

	private static final String CORS_DEFAULT_ORIGIN = "http://localhost:4200";

	@Test
	void contextLoads() {
	}

	@Test
	void corsWorks() {
		ResponseSpec response = client.get().uri("/post").header("Origin", CORS_DEFAULT_ORIGIN).exchange();

		response.expectHeader().valueEquals("Access-Control-Allow-Origin", "*");
	}

}

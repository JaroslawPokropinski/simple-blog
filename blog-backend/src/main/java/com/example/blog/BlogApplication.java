package com.example.blog;

import com.example.blog.repository.PostRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.r2dbc.core.DatabaseClient;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	// @Bean
	// ApplicationRunner init(PostRepository repository, DatabaseClient client) {
	// return args -> {
	// client
	// .sql("create table IF NOT EXISTS POST"
	// + "(id SERIAL PRIMARY KEY, description varchar (255) not null, image varchar
	// (255));")
	// .fetch().first().subscribe();
	// client.sql("DELETE FROM POST;").fetch().first().subscribe();
	// };
	// }
}

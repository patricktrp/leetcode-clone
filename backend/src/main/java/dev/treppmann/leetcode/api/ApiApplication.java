package dev.treppmann.leetcode.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.treppmann.leetcode.api.entity.Problem;
import dev.treppmann.leetcode.api.repository.ProblemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProblemRepository repository) {
		return args -> {
			repository.deleteAll();
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Problem>> typeReference = new TypeReference<List<Problem>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/db/problems.json");
			try {
				List<Problem> problems = mapper.readValue(inputStream,typeReference);
				repository.saveAll(problems);
			} catch (IOException e){
				System.out.println(e.getMessage());
			}
		};
	}
}

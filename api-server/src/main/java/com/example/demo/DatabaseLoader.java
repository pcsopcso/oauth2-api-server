/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Pre-load some data using a Spring Boot {@link CommandLineRunner}.
 *
 * @author Daniel
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

	/**
	 * Use Spring to inject a {@link UserRepository} that can then load data. Since this will run
	 * only after the app is operational, the database will be up.
	 *
	 * @param repository
	 */
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
        Arrays.asList(
        		new User("ironman", "$2a$10$Yi7rQ5lpVxNyWPxQXN75vOZeEwFU1pST0Wel3YghW/fsxupFeiKyy", "토니스타크"),
        		new User("hulk", "$2a$10$Yi7rQ5lpVxNyWPxQXN75vOZeEwFU1pST0Wel3YghW/fsxupFeiKyy", "브루스 배너"),
        		new User("antman", "$2a$10$Yi7rQ5lpVxNyWPxQXN75vOZeEwFU1pST0Wel3YghW/fsxupFeiKyy", "스콧"),
        		new User("tor", "$2a$10$Yi7rQ5lpVxNyWPxQXN75vOZeEwFU1pST0Wel3YghW/fsxupFeiKyy", "크리스 헴스워스"),
        		new User("backwidow", "$2a$10$Yi7rQ5lpVxNyWPxQXN75vOZeEwFU1pST0Wel3YghW/fsxupFeiKyy", "스칼릿 조핸슨"),
        		new User("hawkeye", "$2a$10$Yi7rQ5lpVxNyWPxQXN75vOZeEwFU1pST0Wel3YghW/fsxupFeiKyy", "클린트 바튼")
        )
    	.forEach(account -> userRepository.save(account));
        userRepository.findAll().forEach(System.out::println);
	}
}

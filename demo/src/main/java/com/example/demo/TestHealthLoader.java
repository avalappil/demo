package com.example.demo;



import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestHealthLoader implements HealthIndicator {
	
	public static boolean isHealthUp = false;
	private static final Logger logger = LoggerFactory.getLogger(TestHealthLoader.class);
	
	@PostConstruct
	public void setUp() {
		logger.info("setUp Started");
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				isHealthUp = true;
				logger.info("setUp completed");
			}

		}, 60 * 1000);
	}

	@Override
	public Health health() {
		logger.info("TestHealthLoader: " + isHealthUp);
		return isHealthUp ?Health.up().build():Health.down().build();
	}

}

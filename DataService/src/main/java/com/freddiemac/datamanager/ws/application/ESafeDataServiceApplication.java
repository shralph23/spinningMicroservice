package com.freddiemac.datamanager.ws.application;

import static com.freddiemac.datamanager.ws.constant.ServiceConstants.APPLICATION_CONTEXT;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

import com.freddiemac.datamanager.ws.config.ApplicationLogger;
import com.freddiemac.datamanager.ws.config.EnvCommonAppProperties;
import com.freddiemac.datamanager.ws.config.EnvSpecificAppProperties;

import co.elastic.apm.attach.ElasticApmAttacher;

@SpringBootApplication
@EnableRetry
@EnableAsync
@ImportResource({ APPLICATION_CONTEXT })
public class ESafeDataServiceApplication implements CommandLineRunner {

	private static final Logger LOGGER = ApplicationLogger.getLogger(ESafeDataServiceApplication.class);

	@Autowired
	EnvCommonAppProperties envCommonAppProperties;

	@Autowired
	EnvSpecificAppProperties envSpecificAppProperties;

	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(ESafeDataServiceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		LOGGER.info("Properties loaded status for SLID Retrieval Service Application");
		envCommonAppProperties.logAllPropertyValues();
		envSpecificAppProperties.logAllPropertyValues();
	}
}

package com.copyonwrite.currencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyConversionApplication {

	public static void main(String[] args) {
		if (System.getenv(Constants.OPEN_EXCHANGE_APP_URL).isEmpty()) {
			System.err.println("Must set \"OPEN_EXCHANGE_APP_URL\" environment variable.");
			System.exit(1);
		} else {
			System.out.println(String.format("\"OPEN_EXCHANGE_APP_URL\":= %s", System.getenv(Constants.OPEN_EXCHANGE_APP_URL)));
			SpringApplication.run(CurrencyConversionApplication.class, args);
		}
	}
}

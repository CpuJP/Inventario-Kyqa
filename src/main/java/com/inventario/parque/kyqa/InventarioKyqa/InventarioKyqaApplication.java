package com.inventario.parque.kyqa.InventarioKyqa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class InventarioKyqaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioKyqaApplication.class, args);
	}

}

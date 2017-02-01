package com.aukhatov.vaccinations.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.aukhatov.vaccinations.service"})
public class SpringRootConfig {
}

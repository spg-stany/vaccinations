package com.aukhatov.vaccinations.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan("com.aukhatov.vaccinations.dao")
public class BaseService {

    private static final Logger logger = LoggerFactory.getLogger(BaseService.class);
}

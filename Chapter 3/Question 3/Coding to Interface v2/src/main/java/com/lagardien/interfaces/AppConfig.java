package com.lagardien.interfaces;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ijaaz Lagardien
 * Group 3A
 * Dr B. Kabaso
 * Date: 12/03/2016
 */
@Configuration
public class AppConfig {
    @Bean(name = "calc")
    public Calculator getService()
    {
        return new CalculatorImpl();
    }

}

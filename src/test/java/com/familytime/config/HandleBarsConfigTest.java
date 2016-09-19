package com.familytime.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("tests")
@Configuration
public class HandleBarsConfigTest extends HandleBarsConfig {

}

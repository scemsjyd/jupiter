package com.jinadam.jupiter.common.integration.redis;


import lombok.extern.slf4j.Slf4j;
import org.redisson.config.Config;
import org.redisson.spring.starter.RedissonAutoConfigurationCustomizer;
import org.springframework.context.annotation.Configuration;

/**
 * @author Adam
 * 2025-09-05 16:23
 */
@Configuration
@Slf4j
public class RedisConfiguration implements RedissonAutoConfigurationCustomizer {
    @Override
    public void customize(Config configuration) {
        log.info("customize redisson");
    }
}

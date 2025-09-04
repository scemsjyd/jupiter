package com.jinadam.jupiter.api.tracker;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Adam
 * 2025-09-03 12:36
 */
@SpringBootApplication(
        scanBasePackages = {
                "com.jinadam.jupiter.api.tracker",
                "com.jinadam.jupiter.core",
                "com.jinadam.jupiter.common",
                "com.jinadam.jupiter.biz"
        })
@MapperScan("com.jinadam.jupiter.common")
public class TrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrackerApplication.class, args);
    }
}

package com.java.springboot_dynamodb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@Configuration
public class DynamoDbLocalClient {

    @Value("${aws.region}")
    private String region;

    @Value("${aws.dynamodb.endpoint}")
    private String endpoint;

    @Bean
    @Primary
    public DynamoDbClient localClient() {

        return DynamoDbClient.builder()
                .endpointOverride(URI.create(endpoint))
                .region(Region.of(region))
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                                AwsBasicCredentials.create(
                                        "dummy",
                                        "dummy"
                                )
                        )
                )
                .build();
    }
}

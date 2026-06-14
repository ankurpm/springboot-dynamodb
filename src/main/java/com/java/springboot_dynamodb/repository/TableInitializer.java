package com.java.springboot_dynamodb.repository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

@Component
@RequiredArgsConstructor
public class TableInitializer {

    private final DynamoDbClient dynamoDbClient;

    @PostConstruct
    public void createTable() {

        try {

            dynamoDbClient.createTable(
                    CreateTableRequest.builder()
                            .tableName("users")
                            .attributeDefinitions(
                                    AttributeDefinition.builder()
                                            .attributeName("id")
                                            .attributeType(ScalarAttributeType.S)
                                            .build()
                            )
                            .keySchema(
                                    KeySchemaElement.builder()
                                            .attributeName("id")
                                            .keyType(KeyType.HASH)
                                            .build()
                            )
                            .billingMode(BillingMode.PAY_PER_REQUEST)
                            .build()
            );

        } catch (ResourceInUseException ignored) {
        }
    }
}

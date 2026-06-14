package com.java.springboot_dynamodb.repository;

import com.java.springboot_dynamodb.model.User;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;

@Repository
public class UserRepository {

    private final DynamoDbTable<User> table;

    public UserRepository(DynamoDbEnhancedClient client) {

        this.table = client.table(
                "users",
                TableSchema.fromBean(User.class)
        );
    }

    public void save(User user) {
        table.putItem(user);
    }

    public User findById(String id) {
        return table.getItem(
                Key.builder()
                        .partitionValue(id)
                        .build()
        );
    }

    public List<User> findAll(){
        return table.scan()
                .items()
                .stream()
                .toList();
    }
}

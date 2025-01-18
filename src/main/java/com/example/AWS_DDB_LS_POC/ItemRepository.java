package com.example.AWS_DDB_LS_POC;

import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class ItemRepository {

    private final DynamoDbTable<ItemTable> table;

    public ItemRepository (DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.table = dynamoDbEnhancedClient.table("ItemTable", TableSchema.fromBean(ItemTable.class));

    }

    public void save(ItemTable itemTable) {
        table.putItem(itemTable);

    }

    public ItemTable getById(String id) {
        return table.getItem(r -> r.key(Key.builder().partitionValue(id).build()));
    }
}
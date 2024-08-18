package com.epam.module3;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SerializationTask {
    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        DerivedClassA objA = new DerivedClassA(101, "ObjectA", "This is A", 99.99);
        DerivedClassB objB = new DerivedClassB( 202, "ObjectB","This is B", 12345L);

        // Serialize objects
        String jsonA = objectMapper.writeValueAsString(objA);
        String jsonB = objectMapper.writeValueAsString(objB);

        log.info("Serialized DerivedClassA: {}", jsonA);
        log.info("Serialized DerivedClassB: {}", jsonB);

        // Deserialize objects
        DerivedClassA deserializedObjA = objectMapper.readValue(jsonA, DerivedClassA.class);
        DerivedClassB deserializedObjB = objectMapper.readValue(jsonB, DerivedClassB.class);

        log.info("Deserialized DerivedClassA: {}, {}", deserializedObjA.getName(), deserializedObjA.getDescription());
        log.info("Deserialized DerivedClassB: {}, {}", deserializedObjB.getName(), deserializedObjB.getDetails());
    }
}
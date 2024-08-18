package com.epam.module3;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerializationTaskTest {
    ObjectMapper objectMapper ;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @SneakyThrows
    void testSerialization() {
        DerivedClassA objA = new DerivedClassA(111,"TestA", "DescriptionA", 55.55);

        String jsonA = objectMapper.writeValueAsString(objA);

        assertTrue(jsonA.contains("name"));
        assertTrue(jsonA.contains("description"));
        assertFalse(jsonA.contains("id"));
        assertFalse(jsonA.contains("value"));
    }

    @Test
    @SneakyThrows
    void testDeserialization() {
        String json = "{\"name\":\"TestB\",\"description\":\"DescriptionB\"}";

        DerivedClassA deserializedObj = objectMapper.readValue(json, DerivedClassA.class);
        assertEquals("TestB", deserializedObj.getName());
        assertEquals("DescriptionB", deserializedObj.getDescription());
    }

}
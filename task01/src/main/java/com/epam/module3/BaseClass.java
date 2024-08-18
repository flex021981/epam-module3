package com.epam.module3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseClass {
    @JsonIgnore
    private int id; // Numerical field to be excluded from serialization
    private String name;
}

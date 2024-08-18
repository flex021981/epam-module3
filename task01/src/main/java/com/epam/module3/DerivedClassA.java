package com.epam.module3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DerivedClassA extends BaseClass {
    private  String description;
    @JsonIgnore
    private double value; // Numerical field to be excluded from serialization

    public DerivedClassA(int id, String name, String description, double value) {
        super(id, name);
        this.description = description;
        this.value = value;
    }
}

package com.epam.module3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DerivedClassB extends BaseClass {
    private String details;
    @JsonIgnore
    private long count; // Numerical field to be excluded from serialization

    public DerivedClassB(int id, String name, String details, long count) {
        super(id, name);
        this.details = details;
        this.count = count;
    }
}

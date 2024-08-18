package com.epam.module3;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Configuration {
    private static final Configuration INSTANCE = new Configuration();

    private final String defaultPath = "c:\\Users\\Aleksei_Zakharov1\\.m2";
    private final int defaultFunctionNumber = 1;

    public static Configuration getInstance() {
        return INSTANCE;
    }
}

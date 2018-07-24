package com.simple.test.dataProviders;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

public class DataProvider {
    public static Stream<Arguments> rule1() {
        return Stream.of(
            of("1234", 1),
            of("5678", 2)
        );
    }
}

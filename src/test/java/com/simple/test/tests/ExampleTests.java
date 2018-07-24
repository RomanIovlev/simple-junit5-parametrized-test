package com.simple.test.tests;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ExampleTests {
    private void scenario(String productId, int num) {

    }
    @Test
    public void simpleTest() {
        System.out.println("==== TESTS =====");
    }

    @ParameterizedTest(name = "Enrich product for Rule1: Model, Material Way and Factory combination present in previous season. ProductId: {arguments}")
    @MethodSource("DataProvider#rule1")
    public void paramTest(String productId, int num) {
        System.out.println("==== PARMETRIZED =====" + productId);
    }

}

package com.adidas.fct.be.dataProviders;

import com.adidas.fct.be.data.Article;
import com.adidas.fct.be.data.EnrichData;
import com.adidas.fct.be.data.Season;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

public class EnrichmentProvider {
    public static Stream<Arguments> rule1() {
        return Stream.of(
            of("1234", new Article(), new Season(),new EnrichData())/*,
            of("1234", new Article(), new Season(),new EnrichData()),
            of("1234", new Article(), new Season(),new EnrichData()),
            of("1234", new Article(), new Season(),new EnrichData()),
            of("1234", new Article(), new Season(),new EnrichData())*/
        );
    }

    public static Stream<Arguments> rule2() {
        return Stream.of(
                of("1234", new Article(), new Season(),new EnrichData()),
                of("1234", new Article(), new Season(),new EnrichData()),
                of("1234", new Article(), new Season(),new EnrichData()),
                of("1234", new Article(), new Season(),new EnrichData()),
                of("1234", new Article(), new Season(),new EnrichData())
        );
    }

    public static Stream<Arguments> rule3() {
        return Stream.of(
                of("1234", new Article(), new Season(),new EnrichData()),
                of("1234", new Article(), new Season(),new EnrichData()),
                of("1234", new Article(), new Season(),new EnrichData()),
                of("1234", new Article(), new Season(),new EnrichData()),
                of("1234", new Article(), new Season(),new EnrichData())
        );
    }

    public static Stream<Arguments> mismatchRules() {
        return Stream.of(
                of("1234", new Article(), new Season(),new EnrichData()),
                of("1234", new Article(), new Season(),new EnrichData()),
                of("1234", new Article(), new Season(),new EnrichData()),
                of("1234", new Article(), new Season(),new EnrichData()),
                of("1234", new Article(), new Season(),new EnrichData())
        );
    }
}

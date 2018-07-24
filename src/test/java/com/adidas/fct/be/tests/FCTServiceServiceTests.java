package com.adidas.fct.be.tests;

import com.adidas.fct.be.data.Article;
import com.adidas.fct.be.data.EnrichData;
import com.adidas.fct.be.data.Season;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.adidas.fct.be.api.base.FCTServices.bolService;
import static com.adidas.fct.be.api.base.FCTServices.costingService;

public class FCTServiceServiceTests {
    private static final String ENRICH_SUCCESSFUL = "{\"hasErrors\":false,\"message\":\"Costing Base Enriched Successfully\",\"content\":null}";

    private void enrichScenario(String productId, Article article, Season season,
                                EnrichData expectedEnrichement) {
        costingService.postEnrich(productId)
            .verifyBody(ENRICH_SUCCESSFUL);

        costingService.getArticleBase(article.id)
            .verifyBody(expectedEnrichement.articlBase);
        costingService.getCostingBase()
            .verifyBody(expectedEnrichement.costingBase);
        bolService.getCostingFramework(productId)
            .verifyBody(expectedEnrichement.costingFramework);
        bolService.getCriteriaValues(season.data)
            .verifyBody(expectedEnrichement.criteriaValues);
        bolService.getCuttobox(productId)
            .verifyBody(expectedEnrichement.cuttobox);
    }
    @Test
    public void simpleTest() {
        System.out.println("==== TESTS =====");
    }

    @ParameterizedTest(name = "Enrich product for Rule1: Model, Material Way and Factory combination present in previous season. ProductId: {arguments}")
    @MethodSource("com.adidas.fct.be.dataProviders.EnrichmentProvider#rule1")
    public void enrichRule_1_Validation(String productId, Article article, Season season,
            EnrichData expectedEnrichement) {
        System.out.println("==== PARMETRIZED =====" + productId);
        enrichScenario(productId, article, season, expectedEnrichement);
    }
/*
    @ParameterizedTest(name = "Enrich product for Rule2: Model, Material Way combination present in previous season in a different factory. ProductId: {arguments}")
    @MethodSource("com.adidas.fct.be.dataProviders.EnrichmentProvider#rule2")
    public void enrichRule_2_Validation(String productId, Article article, Season season,
                                        EnrichData expectedEnrichement) {
        enrichScenario(productId, article, season, expectedEnrichement);
    }

    @ParameterizedTest(name = "Enrich product for Rule3: Article present in previous season but in a different material way(material way movement). ProductId: {arguments}")
    @MethodSource("com.adidas.fct.be.dataProviders.EnrichmentProvider#rule3")
    public void enrichRule_3_Validation(String productId, Article article, Season season,
            EnrichData expectedEnrichement) {
        enrichScenario(productId, article, season, expectedEnrichement);
    }

    @ParameterizedTest(name = "No rules match. Default values")
    @MethodSource("com.adidas.fct.be.dataProviders.EnrichmentProvider#mismatchRules")
    public void enrichFailRuleValidation(String productId, Article article, Season season,
            EnrichData expectedEnrichement) {
        enrichScenario(productId, article, season, expectedEnrichement);
    }
    */
}

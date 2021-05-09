package com.promotion.engine;


import com.promotion.engine.model.Amount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.promotion.engine.PromotionEngineTestData.buildAmount;
import static com.promotion.engine.PromotionEngineTestData.buildPromotionRules;
import static com.promotion.engine.PromotionEngineTestData.buildShoppingCartScenarioA;
import static com.promotion.engine.PromotionEngineTestData.buildShoppingCartScenarioB;

public class PromotionEngineTest extends Assertions {

    private static PromotionEngine promotionEngine;

    @BeforeAll
    public static void setUp() {
        promotionEngine = new PromotionEngineImpl(buildPromotionRules());
    }

    @Test
    @DisplayName("Calculate Total order  with Shopping cart A(1)+B(1)+C(1)+D(1), returns Total order value = 100")
    void testScenarioA() {
        assertThat(promotionEngine.calculateTotalOrderValue(buildShoppingCartScenarioA())).isEqualTo(buildAmount(BigDecimal.valueOf(100)));
    }

    @Test
    @DisplayName("Calculate Total order  with Shopping cart A(5)+B(5)+C(1)+D(1), returns Total order value = 370")
    void testScenarioB() {
        assertThat(promotionEngine.calculateTotalOrderValue(buildShoppingCartScenarioB())).isEqualTo(buildAmount(BigDecimal.valueOf(370)));
    }

}

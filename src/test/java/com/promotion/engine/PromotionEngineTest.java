package com.promotion.engine;


import com.promotion.engine.model.ShoppingCart;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.promotion.engine.PromotionEngineTestData.buildAmount;
import static com.promotion.engine.PromotionEngineTestData.buildPromotionRules;
import static com.promotion.engine.PromotionEngineTestData.buildShoppingCartScenarioA;
import static com.promotion.engine.PromotionEngineTestData.buildShoppingCartScenarioB;
import static com.promotion.engine.PromotionEngineTestData.buildShoppingCartScenarioC;

public class PromotionEngineTest extends Assertions {

    private static PromotionEngine promotionEngine;

    @BeforeAll
    public static void setUp() {
        promotionEngine = new PromotionEngineImpl(buildPromotionRules());
    }

    @Test
    @DisplayName("Calculate Total order  with Shopping cart A(1)+B(1)+C(1), returns Total order value = 100.00")
    void testScenarioA() {
        assertThat(promotionEngine.calculateTotalOrderValue(buildShoppingCartScenarioA())).isEqualTo(buildAmount(BigDecimal.valueOf(100)));
    }

    @Test
    @DisplayName("Calculate Total order  with Shopping cart A(5)+B(5)+C(1), returns Total order value = 370.00")
    void testScenarioB() {
        assertThat(promotionEngine.calculateTotalOrderValue(buildShoppingCartScenarioB())).isEqualTo(buildAmount(BigDecimal.valueOf(370)));
    }

    @Test
    @DisplayName("Calculate Total order  with Shopping cart A(3)+B(5)+C(1)+D(1), returns Total order value = 280.00")
    void testScenarioC() {
        assertThat(promotionEngine.calculateTotalOrderValue(buildShoppingCartScenarioC())).isEqualTo(buildAmount(BigDecimal.valueOf(280.00)));
    }

    @Test
    @DisplayName("Calculate Total order  with empty Shopping cart, throws IllegalArgumentException")
    void testScenario_with_empty_cart() {
        assertThatIllegalArgumentException().isThrownBy(() -> promotionEngine.calculateTotalOrderValue(ShoppingCart.with().build()))
                .withMessage("Empty Cart");
    }

}

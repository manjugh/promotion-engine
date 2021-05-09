package com.promotion.engine;


import com.promotion.engine.model.Amount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PromotionEngineTest extends Assertions {

    @Test
    @DisplayName("Calculate Total order  with Shopping cart A(1)+B(1)+C(1)+D(1), returns Total order value = 100")
    void testScenarioA() {
        PromotionEngine promotionEngine = new PromotionEngineImpl();
        assertThat(promotionEngine.calculateTotalOrderValue()).isEqualTo(Amount.with().value(BigDecimal.valueOf(100)).build());

    }

}

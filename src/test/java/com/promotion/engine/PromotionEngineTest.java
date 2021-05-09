package com.promotion.engine;


import com.promotion.engine.model.Amount;
import com.promotion.engine.model.Item;
import com.promotion.engine.model.ShoppingCart;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class PromotionEngineTest extends Assertions {

    @Test
            @DisplayName("Calculate Total order  with Shopping cart A(1)+B(1)+C(1)+D(1), returns Total order value = 100")
    void testScenarioA() {
        PromotionEngine promotionEngine = new PromotionEngineImpl();
        assertThat(promotionEngine.calculateTotalOrderValue(buildShoppingCartScenarioA())).isEqualTo(Amount.with().value(BigDecimal.valueOf(100)).build());
    }

    public static ShoppingCart buildShoppingCartScenarioA() {
        return ShoppingCart.with().items(List.of(buildItemA(1), buildItemB(1), buildItemC(1))).build();
    }

    private static Item buildItemA(int quantity) {
        return Item.with().sku('A').price(Amount.with().value(BigDecimal.valueOf(50)).build()).quantity(quantity).build();
    }

    private static Item buildItemB(int quantity) {
        return Item.with().sku('B').price(Amount.with().value(BigDecimal.valueOf(30)).build()).quantity(quantity).build();
    }

    private static Item buildItemC(int quantity) {
        return Item.with().sku('C').price(Amount.with().value(BigDecimal.valueOf(20)).build()).quantity(quantity).build();
    }

    private static Item buildItemD(int quantity) {
        return Item.with().sku('D').price(Amount.with().value(BigDecimal.valueOf(15)).build()).quantity(quantity).build();
    }

}

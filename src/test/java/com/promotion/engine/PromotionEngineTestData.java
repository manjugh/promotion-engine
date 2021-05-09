package com.promotion.engine;

import com.promotion.engine.model.Amount;
import com.promotion.engine.model.Item;
import com.promotion.engine.model.ShoppingCart;
import com.promotion.engine.rules.PromotionRule;
import com.promotion.engine.rules.SingleItemPromotionRule;

import java.math.BigDecimal;
import java.util.List;

final class PromotionEngineTestData {
    private PromotionEngineTestData() {
    }

    static List<PromotionRule> buildPromotionRules() {
        SingleItemPromotionRule skuAPromotionRule = SingleItemPromotionRule.with().sku('A').quantity(3).discountAmount(Amount.with().value(BigDecimal.valueOf(20)).build()).build();
        SingleItemPromotionRule skuBPromotionRule = SingleItemPromotionRule.with().sku('B').quantity(2).discountAmount(Amount.with().value(BigDecimal.valueOf(15)).build()).build();
        return List.of(skuAPromotionRule, skuBPromotionRule);
    }

    static Amount buildAmount(final BigDecimal amount){
        return Amount.with().value(amount).build();
    }
    static ShoppingCart buildShoppingCartScenarioA() {
        return ShoppingCart.with().items(List.of(buildItemA(1), buildItemB(1), buildItemC(1))).build();
    }
    static ShoppingCart buildShoppingCartScenarioB() {
        return ShoppingCart.with().items(List.of(buildItemA(5), buildItemB(5), buildItemC(1))).build();
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

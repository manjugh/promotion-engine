package com.promotion.engine;

import com.promotion.engine.model.Amount;
import com.promotion.engine.model.ShoppingCart;
import com.promotion.engine.rules.PromotionRule;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PromotionEngineImpl implements PromotionEngine {
    private List<PromotionRule> promotionRules;

    @Override
    public Amount calculateTotalOrderValue(final ShoppingCart shoppingCart) {
        return Amount.with().build();
    }
}

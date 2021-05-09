package com.promotion.engine;

import com.promotion.engine.model.Amount;
import com.promotion.engine.model.ShoppingCart;

public class PromotionEngineImpl implements PromotionEngine {
    @Override
    public Amount calculateTotalOrderValue(final ShoppingCart shoppingCart) {
        return Amount.with().build();
    }
}

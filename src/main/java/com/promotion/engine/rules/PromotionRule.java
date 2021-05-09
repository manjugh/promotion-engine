package com.promotion.engine.rules;

import com.promotion.engine.model.Amount;
import com.promotion.engine.model.ShoppingCart;

public interface PromotionRule {
    Amount calculatePromotionDiscount(ShoppingCart shoppingCart);
}

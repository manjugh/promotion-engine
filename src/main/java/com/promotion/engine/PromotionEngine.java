package com.promotion.engine;

import com.promotion.engine.model.Amount;
import com.promotion.engine.model.ShoppingCart;

public interface PromotionEngine {

    Amount calculateTotalOrderValue(ShoppingCart shoppingCart);
}

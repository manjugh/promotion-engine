package com.promotion.engine.rules;

import com.promotion.engine.model.Amount;
import com.promotion.engine.model.ShoppingCart;
import lombok.Builder;
import lombok.Getter;

@Builder(builderMethodName = "with")
@Getter
public class SingleItemPromotionRule implements PromotionRule {
    private final char sku;

    private final int quantity;

    private final Amount discountAmount;

    @Override
    public Amount calculatePromotionDiscount(final ShoppingCart shoppingCart) {
        return Amount.with().build();
    }
}


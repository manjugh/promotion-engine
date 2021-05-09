package com.promotion.engine.rules;

import com.promotion.engine.model.Amount;
import com.promotion.engine.model.ShoppingCart;
import lombok.Builder;
import lombok.Getter;

@Builder(builderMethodName = "with")
@Getter
public class ComboPromotionRule implements PromotionRule {
    private final char[] skus;
    private final Amount discountAmount;
    private final int quantity;

    @Override
    public Amount calculatePromotionDiscount(final ShoppingCart shoppingCart) {
        return Amount.with().build();
    }
}

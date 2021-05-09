package com.promotion.engine.rules;

import com.promotion.engine.model.Amount;
import com.promotion.engine.model.ShoppingCart;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Builder(builderMethodName = "with")
@Getter
@ToString
public class ComboPromotionRule implements PromotionRule {
    private final char[] skus;
    private final Amount discountAmount;
    private final int quantity;

    @Override
    public Amount calculatePromotionDiscount(final ShoppingCart shoppingCart) {
        boolean match = false;
        for (char sku : skus) {
            match = shoppingCart.findItem(sku).isPresent();
        }
        if (match) {
            return discountAmount;
        }
        return Amount.with().value(BigDecimal.ZERO).build();
    }
}

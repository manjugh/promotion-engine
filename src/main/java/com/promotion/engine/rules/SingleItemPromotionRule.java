package com.promotion.engine.rules;

import com.promotion.engine.model.Amount;
import com.promotion.engine.model.Item;
import com.promotion.engine.model.ShoppingCart;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Optional;

@Builder(builderMethodName = "with")
@Getter
public class SingleItemPromotionRule implements PromotionRule {
    private final char sku;

    private final int quantity;

    private final Amount discountAmount;

    @Override
    public Amount calculatePromotionDiscount(final ShoppingCart shoppingCart) {
        Optional<Item> promotionItem = shoppingCart.findItem(sku);
        if (promotionItem.isEmpty()) {
            return Amount.with().value(BigDecimal.ZERO).build();
        }
        return getDiscountedAmount(promotionItem.get());
    }

    private Amount getDiscountedAmount(Item promotionItem) {
        return discountAmount.multiply(BigDecimal.valueOf(getDiscountMultiplicationFactor(promotionItem.getQuantity())));

    }

    private int getDiscountMultiplicationFactor(final int noOfItems) {
        return noOfItems / quantity;
    }
}


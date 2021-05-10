package com.promotion.engine;

import com.promotion.engine.model.Amount;
import com.promotion.engine.model.ShoppingCart;
import com.promotion.engine.rules.PromotionRule;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
public class PromotionEngineImpl implements PromotionEngine {
    private List<PromotionRule> promotionRules;

    @Override
    public Amount calculateTotalOrderValue(final ShoppingCart shoppingCart) {
        if (isShoppingCartEmpty(shoppingCart)) {
            throw new IllegalArgumentException("Empty Cart");
        }
        return shoppingCart.calculateTotalOrderValue().subtract(getTotalDiscountAmount(shoppingCart));
    }

    private boolean isShoppingCartEmpty(final ShoppingCart shoppingCart) {
        return shoppingCart == null || shoppingCart.isEmpty();
    }

    private BigDecimal getTotalDiscountAmount(final ShoppingCart shoppingCart) {
        return promotionRules.isEmpty() ? BigDecimal.ZERO : executePromotionRules(shoppingCart);
    }

    private BigDecimal executePromotionRules(final ShoppingCart shoppingCart) {
        return promotionRules.stream().map(promotionRule -> promotionRule.calculatePromotionDiscount(shoppingCart).getValue())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

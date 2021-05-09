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
        if(shoppingCart == null || shoppingCart.isEmpty()){
            throw new IllegalArgumentException("Empty Cart");
        }
        Amount totalOrderAmount = shoppingCart.calculateTotalOrderValue();
        BigDecimal discount = getTotalDiscountAmount(shoppingCart);
        return totalOrderAmount.subtract(discount);
    }

    private BigDecimal getTotalDiscountAmount(final ShoppingCart shoppingCart) {
        BigDecimal discount = BigDecimal.ZERO;
        if (!promotionRules.isEmpty()) {
            for (PromotionRule promotionRule : promotionRules) {
                discount = discount.add(promotionRule.calculatePromotionDiscount(shoppingCart).getValue());
            }

        }
        return discount;
    }
}

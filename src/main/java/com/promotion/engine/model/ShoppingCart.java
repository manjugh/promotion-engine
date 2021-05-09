package com.promotion.engine.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Builder(builderMethodName = "with")
@Getter
public class ShoppingCart {
    private final List<Item> items;

    public Amount calculateTotalOrderValue() {
        BigDecimal totalOrderValue = items.stream()
                .map(this::calculateTotalPriceForEachItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return Amount.with().value(totalOrderValue).build();
    }

    private BigDecimal calculateTotalPriceForEachItem(final Item item) {
        return item.getPrice().getValue().multiply(BigDecimal.valueOf(item.getQuantity()));
    }


    public Optional<Item> findItem(final char sku){
        return items.stream().filter(item -> item.matchesSku(sku)).findAny();
    }
}

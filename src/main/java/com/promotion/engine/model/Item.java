package com.promotion.engine.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder(builderMethodName = "with")
@Getter
@ToString
public class Item {
    private final char sku;

    private final Amount price;

    private final int quantity;

    public boolean matchesSku(final char sku) {
        return this.sku == sku;
    }

}

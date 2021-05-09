package com.promotion.engine.model;

import lombok.Builder;
import lombok.Getter;

@Builder(builderMethodName = "with")
@Getter
public class Item {
    private final char sku;

    private final Amount price;

    private final int quantity;

}

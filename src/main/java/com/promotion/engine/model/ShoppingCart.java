package com.promotion.engine.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder(builderMethodName = "with")
@Getter

public class ShoppingCart {
    private final List<Item> items;
}

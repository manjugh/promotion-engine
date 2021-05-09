package com.promotion.engine.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder(builderMethodName = "with")
@Getter
public class Amount {
    private final BigDecimal value;
}

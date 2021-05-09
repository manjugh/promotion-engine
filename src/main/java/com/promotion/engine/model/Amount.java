package com.promotion.engine.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder(builderMethodName = "with")
@Getter
public class Amount {
    private final BigDecimal value;

    public Amount subtract(final BigDecimal amount) {
        return Amount.with().value(value.subtract(amount)).build();
    }
}

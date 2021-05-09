package com.promotion.engine.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Builder(builderMethodName = "with")
@Getter
@EqualsAndHashCode
@ToString
public class Amount {
    private final BigDecimal value;

    public Amount subtract(final BigDecimal amount) {
        return Amount.with().value(value.subtract(amount)).build();
    }

    public Amount multiply(final BigDecimal amount) {
        return Amount.with().value(value.multiply(amount)).build();
    }
}

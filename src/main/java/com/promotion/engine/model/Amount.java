package com.promotion.engine.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Builder(builderMethodName = "with")
@Getter
@EqualsAndHashCode
@ToString
public class Amount {
    private final BigDecimal value;

    public Amount subtract(final BigDecimal amount) {
        return amount == null ? this : Amount.with().value(setScale(value.subtract(amount))).build();
    }

    public Amount multiply(final BigDecimal amount) {
        return amount == null ? this : Amount.with().value(setScale(value.multiply(amount))).build();
    }

    private BigDecimal setScale(final BigDecimal amount) {
        return amount.setScale(2, RoundingMode.HALF_UP);
    }
}

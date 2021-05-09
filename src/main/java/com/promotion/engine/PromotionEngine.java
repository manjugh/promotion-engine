package com.promotion.engine;

import com.promotion.engine.model.Amount;

import java.math.BigDecimal;

public interface PromotionEngine {

    Amount calculateTotalOrderValue();
}

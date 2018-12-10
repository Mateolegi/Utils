package com.mateolegi.mapper.number_cast.impl;

import com.mateolegi.mapper.number_cast.NumberCast;

import java.math.BigDecimal;

public class BigDecimalCast implements NumberCast {
    @Override
    public Number cast(Object o) {
        if (o instanceof BigDecimal) {
            return (BigDecimal) o;
        } else if (o instanceof String) {
            return new BigDecimal((String) o);
        } else if (o instanceof Number) {
            return BigDecimal.valueOf(((Number) o).doubleValue());
        } if (o == null) {
            return null;
        } else {
            throw new ClassCastException("Can not cast " + o.getClass().getName() + " to java.math.BigDecimal");
        }
    }
}

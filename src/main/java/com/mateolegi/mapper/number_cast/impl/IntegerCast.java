package com.mateolegi.mapper.number_cast.impl;

import com.mateolegi.mapper.number_cast.NumberCast;

public class IntegerCast implements NumberCast {
    @Override
    public Number cast(Object o) {
        if (o instanceof Integer) {
            return (Integer) o;
        } else if (o instanceof String) {
            return Integer.valueOf((String) o);
        } else if (o instanceof Number) {
            return ((Number) o).intValue();
        } if (o == null) {
            return null;
        } else {
            throw new ClassCastException("Can not cast " + o.getClass().getName() + " to java.lang.Integer");
        }
    }
}

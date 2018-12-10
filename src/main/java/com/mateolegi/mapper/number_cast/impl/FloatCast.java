package com.mateolegi.mapper.number_cast.impl;

import com.mateolegi.mapper.number_cast.NumberCast;

public class FloatCast implements NumberCast {
    @Override
    public Number cast(Object o) {
        if (o instanceof Float) {
            return (Float) o;
        } else if (o instanceof String) {
            return Long.valueOf((String) o);
        } else if (o instanceof Number) {
            return ((Number) o).floatValue();
        } if (o == null) {
            return null;
        } else {
            throw new ClassCastException("Can not cast " + o.getClass().getName() + " to java.lang.Float");
        }
    }
}

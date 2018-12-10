package com.mateolegi.mapper.number_cast.impl;

import com.mateolegi.mapper.number_cast.NumberCast;

public class DoubleCast implements NumberCast {
    @Override
    public Number cast(Object o) {
        if (o instanceof Double) {
            return (Double) o;
        } else if (o instanceof String) {
            return Double.valueOf((String) o);
        } else if (o instanceof Number) {
            return ((Number) o).doubleValue();
        } if (o == null) {
            return null;
        } else {
            throw new ClassCastException("Can not cast " + o.getClass().getName() + " to java.lang.Double");
        }
    }
}

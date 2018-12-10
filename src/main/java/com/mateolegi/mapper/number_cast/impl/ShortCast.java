package com.mateolegi.mapper.number_cast.impl;

import com.mateolegi.mapper.number_cast.NumberCast;

public class ShortCast implements NumberCast {
    @Override
    public Number cast(Object o) {
        if (o instanceof Short) {
            return (Short) o;
        } else if (o instanceof String) {
            return Short.valueOf((String) o);
        } else if (o instanceof Number) {
            return ((Number) o).shortValue();
        } if (o == null) {
            return null;
        } else {
            throw new ClassCastException("Can not cast " + o.getClass().getName() + " to java.lang.Short");
        }
    }
}

package com.mateolegi.mapper.number_cast.impl;

import com.mateolegi.mapper.number_cast.NumberCast;

public class LongCast implements NumberCast {
    @Override
    public Number cast(Object o) {
        if (o instanceof Long) {
            return (Long) o;
        } else if (o instanceof String) {
            return Long.valueOf((String) o);
        } else if (o instanceof Number) {
            return ((Number) o).longValue();
        } if (o == null) {
            return null;
        } else {
            throw new ClassCastException("Can not cast " + o.getClass().getName() + " to java.lang.Long");
        }
    }
}

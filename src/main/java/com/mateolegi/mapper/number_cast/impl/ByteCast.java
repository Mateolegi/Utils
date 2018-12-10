package com.mateolegi.mapper.number_cast.impl;

import com.mateolegi.mapper.number_cast.NumberCast;

public class ByteCast implements NumberCast {
    @Override
    public Number cast(Object o) {
        if (o instanceof Byte) {
            return (Byte) o;
        } else if (o instanceof String) {
            return Byte.valueOf((String) o);
        } else if (o instanceof Number) {
            return ((Number) o).byteValue();
        } if (o == null) {
            return null;
        } else {
            throw new ClassCastException("Can not cast " + o.getClass().getName() + " to java.lang.Byte");
        }
    }
}

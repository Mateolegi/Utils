package com.mateolegi.mapper.number_cast;

import com.mateolegi.mapper.number_cast.impl.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class NumberUtil {

    private static final Map<Class<?>, NumberCast> CAST_NUMBER_MAP;

    static {
        CAST_NUMBER_MAP = new HashMap<>();
        CAST_NUMBER_MAP.put(BigDecimal.class, new BigDecimalCast());
        CAST_NUMBER_MAP.put(Byte.class, new ByteCast());
        CAST_NUMBER_MAP.put(Double.class, new DoubleCast());
        CAST_NUMBER_MAP.put(Float.class, new FloatCast());
        CAST_NUMBER_MAP.put(Integer.class, new IntegerCast());
        CAST_NUMBER_MAP.put(Long.class, new LongCast());
        CAST_NUMBER_MAP.put(Short.class, new ShortCast());
    }

    public static Number castNumber(Class<?> expected, Object o) {
        return CAST_NUMBER_MAP.get(expected).cast(o);
    }
}

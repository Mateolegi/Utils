package com.mateolegi.mapper;

import com.mateolegi.mapper.number_cast.NumberUtil;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static <T> T map(Object[] o, Class<T> tClass) {
        List<Class<?>> oClasses = Arrays.asList(o).stream()
                .map(i -> i.getClass())
                .collect(Collectors.toList());
        Constructor<?> constructor = getConstructor(oClasses, tClass);
        if (constructor == null) {
            String params = Arrays.stream(o).map(i -> i.getClass().getName()).collect(Collectors.joining(", "));
            throw new IllegalArgumentException("A constructor was not found for the parameters: " + params);
        }
        try {
            return (T) constructor.newInstance(castParams(o, Arrays.asList(constructor.getParameterTypes())));
        } catch (Exception e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    private static Object[] castParams(Object[] o, List<Class<?>> expectedClasses) {
        List<Object> castedParam = new ArrayList<>();
        for (int i = 0; i < expectedClasses.size(); i++) {
            if (isNumber(expectedClasses.get(i))) {
                castedParam.add(NumberUtil.castNumber(expectedClasses.get(i), o[i]));
            } else if (isString(expectedClasses.get(i))) {
                castedParam.add(o[i].toString());
            } else {
                castedParam.add(expectedClasses.get(i).cast(o[i]));
            }
        }
        return castedParam.toArray();
    }

    private static <T> Constructor<?> getConstructor(List<Class<?>> parametersObject, Class<T> tClass) {
        Constructor<?>[] constructors = tClass.getConstructors();
        return Arrays.stream(constructors)
                .filter(i -> compareParametersConstructor(Arrays.asList(i.getParameterTypes()), parametersObject))
                .findFirst()
                .orElse(null);
    }

    private static boolean compareParametersConstructor(List<Class<?>> parametersClass, List<Class<?>> parametersObject) {
        try {
            for (int i = 0; i < parametersObject.size(); i++) {
                if ((!isNumber(parametersClass.get(i)) || !isNumber(parametersObject.get(i)))
                        && parametersClass.get(i) != String.class
                        && parametersClass.get(i) != parametersObject.get(i)) {
                    return false;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    private static boolean isNumber(Class<?> aClass) {
        return aClass == Number.class || aClass.getSuperclass() == Number.class;
    }

    private static boolean isString(Class<?> aClass) {
        return aClass == String.class;
    }
}

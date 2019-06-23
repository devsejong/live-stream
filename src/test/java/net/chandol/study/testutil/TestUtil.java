package net.chandol.study.testutil;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

import static org.springframework.util.ReflectionUtils.findField;

public class TestUtil {
    public static void setId(Object target, long value) {
        Field idField = findField(target.getClass(), "id");
        idField.setAccessible(true);
        ReflectionUtils.setField(idField, target, value);
    }
}

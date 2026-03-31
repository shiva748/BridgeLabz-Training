package org.dbms.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;

public class ResultSetMapper {

    public static <T> T map(ResultSet rs, Class<T> cls) {
        try {
            T obj = cls.getDeclaredConstructor().newInstance();

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);

                try {
                    Field field = cls.getDeclaredField(columnName);
                    field.setAccessible(true);

                    Object value = rs.getObject(columnName);

                    if (value != null) {
                        Class<?> type = field.getType();

                        if (type == LocalDate.class) {
                            value = rs.getDate(columnName).toLocalDate();
                        }
                        else if (type == long.class || type == Long.class) {
                            value = ((Number) value).longValue();
                        }
                        else if (type == int.class || type == Integer.class) {
                            value = ((Number) value).intValue();
                        }
                        else if (type == double.class || type == Double.class) {
                            value = ((Number) value).doubleValue();
                        }
                        else if (type == boolean.class || type == Boolean.class) {
                            value = rs.getBoolean(columnName);
                        }
                    }

                    field.set(obj, value);

                } catch (NoSuchFieldException ignored) {
                    // Column exists in DB but not in POJO → skip
                }
            }

            return obj;

        } catch (Exception e) {
            throw new RuntimeException("ResultSet mapping failed", e);
        }
    }
}

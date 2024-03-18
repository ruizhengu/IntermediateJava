package uk.ac.sheffield.com1003.cafe.utils;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class Util {
    /**
     * Get all class fields with their values including superclass fields.
     *
     * @param o Object of whose we want to extract fields with values
     * @return Returns Map containing entries where the key is a field
     * and the value is value of that field parsed as Object instance. Returns null
     * if param is null.
     */
    public static Map<Field, Object> getAllClassFields(Object o) {
        if(o == null) return null;
        Field[] superClassFields = o.getClass().getSuperclass().getDeclaredFields();
        Field[] classFields = o.getClass().getDeclaredFields();
        int allFieldsSize = classFields.length + superClassFields.length;

        Map<Field, Object> allFields = new LinkedHashMap<>();
        for(int i = 0; i < allFieldsSize; i++){
            Field currentField;
            if(i < superClassFields.length) {
                currentField = superClassFields[i];
            } else {
                currentField = classFields[i - superClassFields.length];
            }

            currentField.setAccessible(true);
            Object currentFieldValue;
            try {
                currentFieldValue = currentField.get(o);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            allFields.put(currentField, currentFieldValue);
        }

        return allFields;
    }
}

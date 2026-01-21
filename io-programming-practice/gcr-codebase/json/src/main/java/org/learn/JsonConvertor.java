package org.learn;

import org.json.JSONObject;

import java.lang.reflect.Field;

public class JsonConvertor {
    static JSONObject convert(Object object) {
        JSONObject jsonObject = new JSONObject();
        Class<?> cls = object.getClass();
        Field[] fields = cls.getDeclaredFields();

        try {
            for (Field field : fields) {
                Object value = field.get(object);
                field.setAccessible(true);
                jsonObject.put(field.getName(), value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    public static void main(String[] args) {
        Car car = new Car("Suzuki", "Swift", "White", "2016", "999cc", "CNG", 82, 162);
        JSONObject carJson = convert(car);
        System.out.println(carJson);
    }
}

class Car{
    String brand;
    String model;
    String color;
    String year;
    String engineSize;
    String fuelType;
    Integer enginePower;
    Integer topSpeed;

    Car(String brand, String model, String color, String year, String engineSize, String fuelType, Integer enginePower, Integer topSpeed) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.engineSize = engineSize;
        this.fuelType = fuelType;
        this.enginePower = enginePower;
        this.topSpeed = topSpeed;
    }
}
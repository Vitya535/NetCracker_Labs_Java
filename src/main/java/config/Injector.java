package config;


import org.apache.log4j.Logger;
import repository.RepositoryForHumans;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;

/**
 * Injector class for dynamic injection of objects
 *
 * @author Kushnerenko Victor
 */
public class Injector {
    /**
     * private object of class Logger for logging class RepositoryForHumans
     */
    private static final Logger logger = Logger.getLogger(RepositoryForHumans.class);


    /**
     * That method injects object fields, which marked with annotation {@link AutoInjectable}
     *
     * @param object - object, whose fields or field need to dynamically inject
     */
    public void inject(Object object) {
        logger.debug("method inject invoked with params: " + object);
        Class objectClass = object.getClass();
        Field[] objectFields = objectClass.getDeclaredFields();
        logger.info("reading .properties file");
        Properties properties = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("inject fields of object");
        for (Field objectField : objectFields) {
            if (objectField.isAnnotationPresent(AutoInjectable.class)) {
                for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                    if (entry.getKey().equals(objectField.getType().getName())) {
                        try {
                            Class<?> fieldClass = Class.forName((String) entry.getValue());
                            Constructor<?> constructor = fieldClass.getConstructor();
                            Object objectOfField = constructor.newInstance();
                            objectField.setAccessible(true);
                            objectField.set(object, objectOfField);
                        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

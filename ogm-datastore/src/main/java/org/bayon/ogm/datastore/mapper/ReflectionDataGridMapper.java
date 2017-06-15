package org.bayon.ogm.datastore.mapper;

import com.google.appengine.api.datastore.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by nm on 7/6/17.
 */
public class ReflectionDataGridMapper<T> implements DataGridMapper<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionDataGridMapper.class);

    public T map(Entity entity, Class<T> clazz) {
        if (entity == null) {
            return null;
        }

        T domain;
        try {
            domain = clazz.newInstance();
        } catch (InstantiationException e) {
            LOGGER.error("Unable to instantiate default constructor.", e);
            throw new RuntimeException("Unable to instantiate default constructor.", e);
        } catch (IllegalAccessException e) {
            LOGGER.error("Unable to access default constructor.", e);
            throw new RuntimeException("Unable to access default constructor.", e);
        }

        try {
            Field id = clazz.getDeclaredField(__ID_PROPERTY__);
            id.setAccessible(true);
            if (entity.getKey() != null) {
                id.set(domain, entity.getKey().getId());
            }
        } catch (NoSuchFieldException e) {
            LOGGER.error("Unable to find 'id' property.");
            throw new RuntimeException("Unable to find 'id' property.", e);
        } catch (IllegalAccessException e) {
            LOGGER.error("Unable to access 'id' property.");
            throw new RuntimeException("Unable to access default constructor.", e);
        }

        for (Method setter : clazz.getDeclaredMethods()) {
            mapProperty(entity, domain, setter);
        }
        return domain;
    }

    public Entity map(T domain, Class<T> clazz) {
        Entity entity;
        try {
            Field id = clazz.getDeclaredField(__ID_PROPERTY__);
            id.setAccessible(true);
            Long value = (Long) id.get(domain);
            if (value == null) {
                entity = new Entity(clazz.getSimpleName());
            } else {
                entity = new Entity(clazz.getSimpleName(), value);
            }
        } catch (NoSuchFieldException e) {
            LOGGER.error("Unable to find 'id' property.");
            throw new RuntimeException("Unable to find 'id' property.", e);
        } catch (IllegalAccessException e) {
            LOGGER.error("Unable to access 'id' property.");
            throw new RuntimeException("Unable to access default constructor.", e);
        }

        for (Method getter : clazz.getDeclaredMethods()) {
            mapProperty(domain, entity, getter);
        }
        return entity;
    }

    protected void mapProperty(T source, Entity destination, Method getter) {
        if (isGetter(getter)) {

            StringBuilder property = new StringBuilder();
            if (getter.getName().startsWith("is")) {
                property.append(Character.toLowerCase(getter.getName().charAt(2)));
                property.append(getter.getName().substring(3));
            } else {
                property.append(Character.toLowerCase(getter.getName().charAt(3)));
                property.append(getter.getName().substring(4));
            }

            try {
                if (!property.toString().equals(__ID_PROPERTY__)) {
                    destination.setProperty(property.toString(), getter.invoke(source));
                }
            } catch (InvocationTargetException e) {
                LOGGER.warn(e.getMessage());
            } catch (IllegalAccessException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    protected void mapProperty(Entity source, T destination, Method setter) {
        if (isSetter(setter)) {
            StringBuilder property = new StringBuilder();
            property.append(Character.toLowerCase(setter.getName().charAt(3)));
            property.append(setter.getName().substring(4));

            try {
                if (!property.toString().equals(__ID_PROPERTY__)) {
                    setter.invoke(destination, source.getProperty(property.toString()));
                }
            } catch (InvocationTargetException e) {
                LOGGER.warn(e.getMessage());
            } catch (IllegalAccessException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    protected boolean isGetter(Method getter) {
        Class returnType = getter.getReturnType();
        return !returnType.equals(void.class) && !returnType.equals(Void.class) &&
                (getter.getName().startsWith("get") || getter.getName().startsWith("is")) &&
                getter.getParameterTypes().length == 0;
    }

    protected boolean isSetter(Method setter) {
        return setter.getReturnType().equals(void.class) &&
                setter.getName().startsWith("set") &&
                setter.getParameterTypes().length == 1;
    }
}

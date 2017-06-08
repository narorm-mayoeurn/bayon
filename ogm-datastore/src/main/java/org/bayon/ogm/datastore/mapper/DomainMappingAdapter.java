package org.bayon.ogm.datastore.mapper;

import com.google.appengine.api.datastore.Entity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

/**
 * Created by nm on 7/6/17.
 */
public class DomainMappingAdapter<T> implements MappingAdapter<T> {

    boolean setDomainProperty(Class<T> clazz, T domain, String property, Object value) {
        try {
            StringBuilder setter = new StringBuilder("set");
            setter.append(Character.toUpperCase(property.charAt(0)));
            setter.append(property.substring(1));

            Method m = clazz.getMethod(setter.toString(), value.getClass());
            if (Modifier.isPublic(m.getModifiers()) && m.getReturnType().equals(void.class)) {
                m.invoke(domain, value);
                return true;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    public T map(Entity entity, Class<T> clazz) {
        T domain;
        try {
            domain = clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Unable to instantiate default constructor.", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to access default constructor.", e);
        }
        setDomainProperty(clazz, domain, __ID_PROPERTY__, entity.getKey().getId());
        for (Map.Entry<String, Object> property : entity.getProperties().entrySet()) {
            setDomainProperty(clazz, domain, property.getKey(), property.getValue());
        }
        return domain;
    }

    boolean isGetter(Method m) {
        if (Modifier.isPublic(m.getModifiers()) && m.getParameterTypes().length == 0) {
            if (m.getName().startsWith("get") && !m.getReturnType().equals(void.class))
                return true;
            if (m.getName().startsWith("is") && m.getReturnType().equals(boolean.class))
                return true;
        }
        return false;
    }

    public Entity map(T domain, Class<T> clazz) {
        Entity entity = new Entity(clazz.getSimpleName());
        for (Method m : clazz.getMethods()) {
            if (isGetter(m)) {

            }
        }
        return entity;
    }
}

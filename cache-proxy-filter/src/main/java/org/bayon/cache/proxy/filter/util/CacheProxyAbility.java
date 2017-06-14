package org.bayon.cache.proxy.filter.util;

/**
 * Created by Chandara Leang on 6/14/2017.
 */

public enum CacheProxyAbility {

    PUBLIC("public"),
    PRIVATE("private");
    private final String value;

    private CacheProxyAbility(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
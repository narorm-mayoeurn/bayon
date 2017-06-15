package org.bayon.cache.proxy.filter.util;

/**
 * Created by Chandara Leang on 6/14/2017.
 */

public enum CacheProxyConfigParameter {

    EXPIRATION("expiration"),
    PRIVATE("private"),
    MUST_REVALIDATE("must-revalidate"),
    VARY("vary");

    private final String name;

    private CacheProxyConfigParameter(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
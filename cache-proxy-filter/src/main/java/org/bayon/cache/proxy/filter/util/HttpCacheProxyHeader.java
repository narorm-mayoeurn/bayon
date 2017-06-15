package org.bayon.cache.proxy.filter.util;

/**
 * Created by Chandara Leang on 6/14/2017.
 */

public enum HttpCacheProxyHeader {

    CACHE_CONTROL("Cache-Control"),
    EXPIRES("Expires"),
    PRAGMA("Pragma"),
    ETAG("ETag"),
    VARY("Vary");

    private final String name;

    private HttpCacheProxyHeader(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
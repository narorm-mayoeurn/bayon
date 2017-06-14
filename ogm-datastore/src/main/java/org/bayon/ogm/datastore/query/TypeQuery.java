package org.bayon.ogm.datastore.query;

import com.google.appengine.api.datastore.Query;

/**
 * Created by nm on 14/6/17.
 */
public class TypeQuery {

    private Query query;

    TypeQuery(Query query) {
        this.query = query;
    }

    public Query getQuery() {
        return query;
    }
}

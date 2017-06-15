package org.bayon.ogm.datastore.query;

import com.google.appengine.api.datastore.Projection;
import com.google.appengine.api.datastore.Query;

/**
 * Created by nm on 14/6/17.
 */
public class TypeQuery implements Cloneable {

    private Query query;

    TypeQuery(Query query) {
        this.query = query;
    }

    public Query getQuery() {
        return query;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Query clone = new Query(query.getKind());
        for (Projection projection : query.getProjections()) {
            clone.addProjection(projection);
        }
        clone.setFilter(query.getFilter());
        for (Query.SortPredicate sortPredicate : query.getSortPredicates()) {
            clone.addSort(sortPredicate.getPropertyName(), sortPredicate.getDirection());
        }
        return clone;
    }
}

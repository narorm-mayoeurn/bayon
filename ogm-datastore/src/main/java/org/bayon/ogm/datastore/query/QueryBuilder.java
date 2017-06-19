package org.bayon.ogm.datastore.query;

import java.util.Map;

/**
 * Created by nm on 19/6/17.
 */
public interface QueryBuilder<T> {

    QueryBuilderImpl select(Map<String, Class> projections);

    QueryBuilderImpl selectOnly(String property, Class returnType);

    QueryBuilderImpl<T> and(String property, Filter.Operator operator, Object value);

    QueryBuilderImpl<T> and(Filter... filters);

    QueryBuilderImpl<T> or(String property, Filter.Operator operator, Object value);

    QueryBuilderImpl<T> or(Filter... filters);

    QueryBuilderImpl<T> addOrder(String property);

    QueryBuilderImpl<T> addOrder(String property, boolean asc);

    TypeQuery toQuery();

}

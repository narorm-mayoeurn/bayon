package org.bayon.ogm.datastore.query;

import com.google.appengine.api.datastore.PropertyProjection;
import com.google.appengine.api.datastore.Query;

import java.util.Map;

/**
 * Created by nm on 10/6/17.
 */
public final class QueryBuilderImpl<T> implements  QueryBuilder<T> {

    private Class<T> clazz;
    private Query query;

    public QueryBuilderImpl(Class<T> clazz) {
        this.clazz = clazz;
        query = new Query(clazz.getSimpleName());
    }

    Query.Filter get(String property, Filter.Operator operator, Object value) {
        Query.Filter filter;
        switch (operator) {
            case EQUAL: filter = new Query.FilterPredicate(property, Query.FilterOperator.EQUAL, value); break;
            case LESS_THAN: filter = new Query.FilterPredicate(property, Query.FilterOperator.LESS_THAN, value); break;
            case LESS_THAN_OR_EQUAL: filter = new Query.FilterPredicate(property, Query.FilterOperator.LESS_THAN_OR_EQUAL, value); break;
            case GREATER_THAN: filter = new Query.FilterPredicate(property, Query.FilterOperator.GREATER_THAN, value); break;
            case GREATER_THAN_OR_EQUAL: filter = new Query.FilterPredicate(property, Query.FilterOperator.GREATER_THAN_OR_EQUAL, value); break;
            case NOT_EQUAL : filter = new Query.FilterPredicate(property, Query.FilterOperator.NOT_EQUAL, value); break;
            case IN: filter = new Query.FilterPredicate(property, Query.FilterOperator.IN, value); break;
            default: throw new IllegalArgumentException("Illegal operator argument.");
        }
        return filter;
    }

    public QueryBuilderImpl select(Map<String, Class> projections) {
        for (Map.Entry<String, Class> entry : projections.entrySet()) {
            query.addProjection(new PropertyProjection(entry.getKey(), entry.getValue()));
        }
        return this;
    }

    public QueryBuilderImpl selectOnly(String property, Class returnType) {
        query.addProjection(new PropertyProjection(property, returnType));
        return this;
    }

    public QueryBuilderImpl<T> and(String property, Filter.Operator operator, Object value) {
        Query.Filter filter = get(property, operator, value);
        if (query.getFilter() == null) {
            query.setFilter(filter);
        } else {
            query.setFilter(Query.CompositeFilterOperator.and(query.getFilter(), filter));
        }
        return this;
    }

    public QueryBuilderImpl<T> and(Filter... filters) {
        for (Filter filter : filters) {
            and(filter.getProperty(), filter.getOperator(), filter.getValue());
        }
        return this;
    }

    public QueryBuilderImpl<T> or(String property, Filter.Operator operator, Object value) {
        Query.Filter filter = get(property, operator, value);
        if (query.getFilter() == null) {
            query.setFilter(filter);
        } else {
            query.setFilter(Query.CompositeFilterOperator.or(query.getFilter(), filter));
        }
        return this;
    }

    public QueryBuilderImpl<T> or(Filter... filters) {
        for (Filter filter : filters) {
            or(filter.getProperty(), filter.getOperator(), filter.getValue());
        }
        return this;
    }

    public QueryBuilderImpl<T> addOrder(String property) {
        query.addSort(property);
        return this;
    }

    public QueryBuilderImpl<T> addOrder(String property, boolean asc) {
        query.addSort(property, asc ? Query.SortDirection.ASCENDING : Query.SortDirection.DESCENDING);
        return this;
    }

    public TypeQuery toQuery() {
        return new TypeQuery(query);
    }
}

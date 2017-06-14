package org.bayon.ogm.datastore.query;

import com.google.appengine.api.datastore.Query;

/**
 * Created by nm on 10/6/17.
 */
public final class QueryBuilder<T> {

    private Class<T> clazz;
    private Query query;

    public QueryBuilder(Class<T> clazz) {
        this.clazz = clazz;
        query = new Query(clazz.getSimpleName());
    }

    Query.Filter get(String property, Condition.Operator operator, Object value) {
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

    public QueryBuilder<T> and(String property, Condition.Operator operator, Object value) {
        Query.Filter filter = get(property, operator, value);
        if (query.getFilter() == null) {
            query.setFilter(filter);
        } else {
            query.setFilter(Query.CompositeFilterOperator.and(query.getFilter(), filter));
        }
        return this;
    }

    public QueryBuilder<T> and(Condition... conditions) {
        for (Condition condition : conditions) {
            and(condition.getProperty(), condition.getOperator(), condition.getValue());
        }
        return this;
    }

    public QueryBuilder<T> or(String property, Condition.Operator operator, Object value) {
        Query.Filter filter = get(property, operator, value);
        if (query.getFilter() == null) {
            query.setFilter(filter);
        } else {
            query.setFilter(Query.CompositeFilterOperator.or(query.getFilter(), filter));
        }
        return this;
    }

    public QueryBuilder<T> or(Condition... conditions) {
        for (Condition condition : conditions) {
            or(condition.getProperty(), condition.getOperator(), condition.getValue());
        }
        return this;
    }

    public QueryBuilder<T> addOrder(String property) {
        query.addSort(property);
        return this;
    }

    public QueryBuilder<T> addOrder(String property, boolean asc) {
        query.addSort(property, asc ? Query.SortDirection.ASCENDING : Query.SortDirection.DESCENDING);
        return this;
    }

    public Query toQuery() {
        return query;
    }
}

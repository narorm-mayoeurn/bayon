package org.bayon.ogm.datastore.query;

import java.util.Iterator;
import java.util.List;

/**
 * Created by nm on 14/6/17.
 */
public class Page<T> {
    private List<T> items;
    private int offset;
    private int limit;
    private int total;

    public Page() {}

    public Page(List<T> items, int offset, int limit, int total) {
        this.items = items;
        this.offset = offset;
        this.limit = limit;
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Iterator<Integer> getOffsetIterator() {
        return new OffsetIterator();
    }

    class OffsetIterator implements Iterator<Integer> {

        @Override
        public Integer next() {
            return offset + limit;
        }

        @Override
        public boolean hasNext() {
            if (offset + limit < total) {
                return true;
            }
            return false;
        }

        @Override
        public void remove() {
        }
    }
}

package org.pfragatina.shared.infrastructure.hibernate;

import java.util.List;
import java.util.Objects;

public final class PaginatedResult<T> {

    private final List<T> data;
    private final Long total;
    private final Integer limit;
    private final Integer offset;

    public PaginatedResult(List<T> data, Long total, Integer limit, Integer offset) {
        this.data = data;
        this.total = total;
        this.limit = limit;
        this.offset = offset;
    }

    public PaginatedResult(List<T> data, Long total) {
        this.data = data;
        this.total = total;
        this.limit = null;
        this.offset = null;
    }

    public List<T> data() {
        return data;
    }

    public Long total() {
        return total;
    }

    public Integer limit() {
        return limit;
    }

    public Integer offset() {
        return offset;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        PaginatedResult<?> that = (PaginatedResult<?>) o;
        return Objects.equals(data, that.data) && Objects.equals(total, that.total) && Objects.equals(limit,
                that.limit) && Objects.equals(offset, that.offset);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(data);
        result = 31 * result + Objects.hashCode(total);
        result = 31 * result + Objects.hashCode(limit);
        result = 31 * result + Objects.hashCode(offset);
        return result;
    }
}

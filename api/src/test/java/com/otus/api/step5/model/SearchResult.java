package com.otus.api.step5.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchResult implements Serializable {

    private int pageSize;
    private String next;
    private String previous;
    private int page;
    private int count;
    private List<Summary> summaries = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2461159705164905700L;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Summary> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<Summary> summaries) {
        this.summaries = summaries;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("pageSize", pageSize).append("next", next).append("previous", previous).append("page", page).append("count", count).append("summaries", summaries).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(count).append(previous).append(page).append(additionalProperties).append(next).append(pageSize).append(summaries).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SearchResult) == false) {
            return false;
        }
        SearchResult rhs = ((SearchResult) other);
        return new EqualsBuilder().append(count, rhs.count).append(previous, rhs.previous).append(page, rhs.page).append(additionalProperties, rhs.additionalProperties).append(next, rhs.next).append(pageSize, rhs.pageSize).append(summaries, rhs.summaries).isEquals();
    }

}
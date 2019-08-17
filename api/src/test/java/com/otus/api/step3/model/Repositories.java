package com.otus.api.step3.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repositories implements Serializable {

    private int count;
    private String next;
    private Object previous;
    private List<Repository> results = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3974776313562377562L;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<Repository> getResults() {
        return results;
    }

    public void setResults(List<Repository> results) {
        this.results = results;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("count", count).append("next", next).append("previous", previous).append("results", results).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(results).append(previous).append(count).append(additionalProperties).append(next).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Repositories) == false) {
            return false;
        }
        Repositories rhs = ((Repositories) other);
        return new EqualsBuilder().append(results, rhs.results).append(previous, rhs.previous).append(count, rhs.count).append(additionalProperties, rhs.additionalProperties).append(next, rhs.next).isEquals();
    }

}
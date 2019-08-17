package com.otus.api.step3.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class LogoUrl implements Serializable {

    private String small;
    private String small2x;
    private String large;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8174492728683167566L;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getSmall2x() {
        return small2x;
    }

    public void setSmall2x(String small2x) {
        this.small2x = small2x;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("small", small).append("small2x", small2x).append("large", large).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(small2x).append(small).append(large).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LogoUrl) == false) {
            return false;
        }
        LogoUrl rhs = ((LogoUrl) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(small2x, rhs.small2x).append(small, rhs.small).append(large, rhs.large).isEquals();
    }

}
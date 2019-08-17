package com.otus.api.step4.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Repository implements Serializable {

    private String user;
    private String name;
    private String namespace;
    private Object repositoryType;
    private int status;
    private String description;
    private boolean isPrivate;
    private boolean isAutomated;
    private boolean canEdit;
    private int starCount;
    private int pullCount;
    private Object lastUpdated;
    private boolean isMigrated;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6982586660277268285L;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public Object getRepositoryType() {
        return repositoryType;
    }

    public void setRepositoryType(Object repositoryType) {
        this.repositoryType = repositoryType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public boolean isIsAutomated() {
        return isAutomated;
    }

    public void setIsAutomated(boolean isAutomated) {
        this.isAutomated = isAutomated;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public int getPullCount() {
        return pullCount;
    }

    public void setPullCount(int pullCount) {
        this.pullCount = pullCount;
    }

    public Object getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Object lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean isIsMigrated() {
        return isMigrated;
    }

    public void setIsMigrated(boolean isMigrated) {
        this.isMigrated = isMigrated;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("user", user).append("name", name).append("namespace", namespace).append("repositoryType", repositoryType).append("status", status).append("description", description).append("isPrivate", isPrivate).append("isAutomated", isAutomated).append("canEdit", canEdit).append("starCount", starCount).append("pullCount", pullCount).append("lastUpdated", lastUpdated).append("isMigrated", isMigrated).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(isMigrated).append(pullCount).append(status).append(lastUpdated).append(canEdit).append(isAutomated).append(namespace).append(repositoryType).append(isPrivate).append(additionalProperties).append(description).append(name).append(starCount).append(user).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Repository) == false) {
            return false;
        }
        Repository rhs = ((Repository) other);
        return new EqualsBuilder().append(isMigrated, rhs.isMigrated).append(pullCount, rhs.pullCount).append(status, rhs.status).append(lastUpdated, rhs.lastUpdated).append(canEdit, rhs.canEdit).append(isAutomated, rhs.isAutomated).append(namespace, rhs.namespace).append(repositoryType, rhs.repositoryType).append(isPrivate, rhs.isPrivate).append(additionalProperties, rhs.additionalProperties).append(description, rhs.description).append(name, rhs.name).append(starCount, rhs.starCount).append(user, rhs.user).isEquals();
    }

}
package com.otus.api.step4.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Summary implements Serializable {

    private String id;
    private String name;
    private String slug;
    private String type;
    private Publisher publisher;
    private String createdAt;
    private String updatedAt;
    private String shortDescription;
    private String source;
    private int popularity;
    private List<Category> categories = null;
    private List<OperatingSystem> operatingSystems = null;
    private List<Architecture> architectures = null;
    private LogoUrl logoUrl;
    private String certificationStatus;
    private int starCount;
    private String filterType;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7968440228076557997L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<OperatingSystem> getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(List<OperatingSystem> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public List<Architecture> getArchitectures() {
        return architectures;
    }

    public void setArchitectures(List<Architecture> architectures) {
        this.architectures = architectures;
    }

    public LogoUrl getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(LogoUrl logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCertificationStatus() {
        return certificationStatus;
    }

    public void setCertificationStatus(String certificationStatus) {
        this.certificationStatus = certificationStatus;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("slug", slug).append("type", type).append("publisher", publisher).append("createdAt", createdAt).append("updatedAt", updatedAt).append("shortDescription", shortDescription).append("source", source).append("popularity", popularity).append("categories", categories).append("operatingSystems", operatingSystems).append("architectures", architectures).append("logoUrl", logoUrl).append("certificationStatus", certificationStatus).append("starCount", starCount).append("filterType", filterType).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(logoUrl).append(type).append(operatingSystems).append(publisher).append(updatedAt).append(id).append(architectures).append(source).append(shortDescription).append(additionalProperties).append(createdAt).append(certificationStatus).append(name).append(starCount).append(categories).append(slug).append(filterType).append(popularity).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Summary) == false) {
            return false;
        }
        Summary rhs = ((Summary) other);
        return new EqualsBuilder().append(logoUrl, rhs.logoUrl).append(type, rhs.type).append(operatingSystems, rhs.operatingSystems).append(publisher, rhs.publisher).append(updatedAt, rhs.updatedAt).append(id, rhs.id).append(architectures, rhs.architectures).append(source, rhs.source).append(shortDescription, rhs.shortDescription).append(additionalProperties, rhs.additionalProperties).append(createdAt, rhs.createdAt).append(certificationStatus, rhs.certificationStatus).append(name, rhs.name).append(starCount, rhs.starCount).append(categories, rhs.categories).append(slug, rhs.slug).append(filterType, rhs.filterType).append(popularity, rhs.popularity).isEquals();
    }

}
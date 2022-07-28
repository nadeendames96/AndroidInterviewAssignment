package com.example.penguinin.Models;

import java.time.OffsetDateTime;

public class Result {
    private String id;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private OffsetDateTime promotedAt;
    private long width;
    private long height;
    private String color;
    private String blurHash;
    private String description;
    private String altDescription;
    private Urls urls;
    private ResultLinks links;
    private Object[] categories;
    private long likes;
    private boolean likedByUser;
    private Object[] currentUserCollections;
    private Object sponsorship;
    private TopicSubmissions topicSubmissions;
    private User user;
    private Tag[] tags;

    public String getID() { return id; }
    public void setID(String value) { this.id = value; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime value) { this.createdAt = value; }

    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(OffsetDateTime value) { this.updatedAt = value; }

    public OffsetDateTime getPromotedAt() { return promotedAt; }
    public void setPromotedAt(OffsetDateTime value) { this.promotedAt = value; }

    public long getWidth() { return width; }
    public void setWidth(long value) { this.width = value; }

    public long getHeight() { return height; }
    public void setHeight(long value) { this.height = value; }

    public String getColor() { return color; }
    public void setColor(String value) { this.color = value; }

    public String getBlurHash() { return blurHash; }
    public void setBlurHash(String value) { this.blurHash = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public String getAltDescription() { return altDescription; }
    public void setAltDescription(String value) { this.altDescription = value; }

    public Urls getUrls() { return urls; }
    public void setUrls(Urls value) { this.urls = value; }

    public ResultLinks getLinks() { return links; }
    public void setLinks(ResultLinks value) { this.links = value; }

    public Object[] getCategories() { return categories; }
    public void setCategories(Object[] value) { this.categories = value; }

    public long getLikes() { return likes; }
    public void setLikes(long value) { this.likes = value; }

    public boolean getLikedByUser() { return likedByUser; }
    public void setLikedByUser(boolean value) { this.likedByUser = value; }

    public Object[] getCurrentUserCollections() { return currentUserCollections; }
    public void setCurrentUserCollections(Object[] value) { this.currentUserCollections = value; }

    public Object getSponsorship() { return sponsorship; }
    public void setSponsorship(Object value) { this.sponsorship = value; }

    public TopicSubmissions getTopicSubmissions() { return topicSubmissions; }
    public void setTopicSubmissions(TopicSubmissions value) { this.topicSubmissions = value; }

    public User getUser() { return user; }
    public void setUser(User value) { this.user = value; }

    public Tag[] getTags() { return tags; }
    public void setTags(Tag[] value) { this.tags = value; }
}

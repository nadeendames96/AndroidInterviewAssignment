package com.example.penguinin.Models;
import java.time.OffsetDateTime;

public class User {
    private String id;
    private OffsetDateTime updatedAt;
    private String username;
    private String name;
    private String firstName;
    private String lastName;
    private String twitterUsername;
    private String portfolioURL;
    private String bio;
    private String location;
    private UserLinks links;
    private ProfileImage profileImage;
    private String instagramUsername;
    private long totalCollections;
    private long totalLikes;
    private long totalPhotos;
    private boolean acceptedTos;
    private boolean forHire;
    private Social social;

    public String getID() { return id; }
    public void setID(String value) { this.id = value; }

    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(OffsetDateTime value) { this.updatedAt = value; }

    public String getUsername() { return username; }
    public void setUsername(String value) { this.username = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String value) { this.firstName = value; }

    public String getLastName() { return lastName; }
    public void setLastName(String value) { this.lastName = value; }

    public String getTwitterUsername() { return twitterUsername; }
    public void setTwitterUsername(String value) { this.twitterUsername = value; }

    public String getPortfolioURL() { return portfolioURL; }
    public void setPortfolioURL(String value) { this.portfolioURL = value; }

    public String getBio() { return bio; }
    public void setBio(String value) { this.bio = value; }

    public String getLocation() { return location; }
    public void setLocation(String value) { this.location = value; }

    public UserLinks getLinks() { return links; }
    public void setLinks(UserLinks value) { this.links = value; }

    public ProfileImage getProfileImage() { return profileImage; }
    public void setProfileImage(ProfileImage value) { this.profileImage = value; }

    public String getInstagramUsername() { return instagramUsername; }
    public void setInstagramUsername(String value) { this.instagramUsername = value; }

    public long getTotalCollections() { return totalCollections; }
    public void setTotalCollections(long value) { this.totalCollections = value; }

    public long getTotalLikes() { return totalLikes; }
    public void setTotalLikes(long value) { this.totalLikes = value; }

    public long getTotalPhotos() { return totalPhotos; }
    public void setTotalPhotos(long value) { this.totalPhotos = value; }

    public boolean getAcceptedTos() { return acceptedTos; }
    public void setAcceptedTos(boolean value) { this.acceptedTos = value; }

    public boolean getForHire() { return forHire; }
    public void setForHire(boolean value) { this.forHire = value; }

    public Social getSocial() { return social; }
    public void setSocial(Social value) { this.social = value; }
}

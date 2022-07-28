package com.example.penguinin.Models;

public class Social {
    private String instagramUsername;
    private String portfolioURL;
    private String twitterUsername;
    private Object paypalEmail;

    public String getInstagramUsername() { return instagramUsername; }
    public void setInstagramUsername(String value) { this.instagramUsername = value; }

    public String getPortfolioURL() { return portfolioURL; }
    public void setPortfolioURL(String value) { this.portfolioURL = value; }

    public String getTwitterUsername() { return twitterUsername; }
    public void setTwitterUsername(String value) { this.twitterUsername = value; }

    public Object getPaypalEmail() { return paypalEmail; }
    public void setPaypalEmail(Object value) { this.paypalEmail = value; }
}

package com.example.penguinin.Models;
import java.time.OffsetDateTime;

public class ArtsCulture {
    private String status;
    private OffsetDateTime approvedOn;

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }

    public OffsetDateTime getApprovedOn() { return approvedOn; }
    public void setApprovedOn(OffsetDateTime value) { this.approvedOn = value; }
}

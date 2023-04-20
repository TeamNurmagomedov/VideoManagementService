package miniyoutube.com.videomanagementservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class LikeModel {
    @jakarta.persistence.Id
    private String Id = UUID.randomUUID().toString();
    @Column(
            name = "VideoId",
            nullable = false
    )
    private String VideoId;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getVideoId() {
        return VideoId;
    }

    public void setVideoId(String videoId) {
        VideoId = videoId;
    }

    public LikeModel() {
    }

    public LikeModel(String videoId) {
        VideoId = videoId;
    }
}

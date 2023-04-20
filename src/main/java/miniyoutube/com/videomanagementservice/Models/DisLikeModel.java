package miniyoutube.com.videomanagementservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class DisLikeModel {
    @jakarta.persistence.Id
    private String Id = UUID.randomUUID().toString();
    @Column(
            name = "VideoId",
            nullable = false
    )
    private String VideoId;

    public DisLikeModel(String videoId) {
        VideoId = videoId;
    }

    public DisLikeModel() {

    }

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
}


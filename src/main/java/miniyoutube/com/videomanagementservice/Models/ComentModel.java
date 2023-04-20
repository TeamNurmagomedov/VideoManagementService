package miniyoutube.com.videomanagementservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.UUID;
@Entity
public class ComentModel {
    @jakarta.persistence.Id
    private String Id = UUID.randomUUID().toString();
    @Column(
            name = "VideoId",
            nullable = false
    )
    private String VideoId;
    private String Coment;

    public ComentModel(String videoId, String coment) {
        VideoId = videoId;
        Coment = coment;
    }

    public ComentModel() {

    }

    public String getVideoId() {
        return VideoId;
    }

    public void setVideoId(String videoId) {
        VideoId = videoId;
    }

    public String getComent() {
        return Coment;
    }

    public void setComent(String coment) {
        Coment = coment;
    }
}

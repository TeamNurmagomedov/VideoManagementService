package miniyoutube.com.videomanagementservice.Models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class VidoeModel {

    @Id
    private String Id = UUID.randomUUID().toString();
    @Column(
            name = "Path",
            nullable = false
    )
    private String Path;
    @Column(
            name = "UserId",
            nullable = false
    )
    private String UserId;

    public VidoeModel() {
    }

    public VidoeModel(String id, String path, String userId) {
        Id = id;
        Path = path;
        UserId = userId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}

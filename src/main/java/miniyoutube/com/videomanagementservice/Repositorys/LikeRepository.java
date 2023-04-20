package miniyoutube.com.videomanagementservice.Repositorys;

import miniyoutube.com.videomanagementservice.Models.LikeModel;
import miniyoutube.com.videomanagementservice.Models.VidoeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeModel, String> {
}

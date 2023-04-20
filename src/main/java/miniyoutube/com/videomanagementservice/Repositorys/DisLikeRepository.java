package miniyoutube.com.videomanagementservice.Repositorys;

import miniyoutube.com.videomanagementservice.Models.DisLikeModel;
import miniyoutube.com.videomanagementservice.Models.LikeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisLikeRepository extends JpaRepository<DisLikeModel, String> {
}

package miniyoutube.com.videomanagementservice.Repositorys;

import miniyoutube.com.videomanagementservice.Models.ComentModel;
import miniyoutube.com.videomanagementservice.Models.DisLikeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<ComentModel, String> {
}

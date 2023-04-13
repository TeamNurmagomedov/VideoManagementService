package miniyoutube.com.videomanagementservice.Repositorys;

import miniyoutube.com.videomanagementservice.Models.VidoeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VidoeModel, Long> {
}

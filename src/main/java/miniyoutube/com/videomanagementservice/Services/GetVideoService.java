package miniyoutube.com.videomanagementservice.Services;

import miniyoutube.com.videomanagementservice.Models.VidoeModel;
import miniyoutube.com.videomanagementservice.Repositorys.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

@Service
public class GetVideoService implements GetVideoI {
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public String GetVideo(String videoId) {

        VidoeModel video = videoRepository.getById(videoId);
        return video.getPath();
    }
}

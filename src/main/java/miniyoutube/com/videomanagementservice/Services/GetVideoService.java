package miniyoutube.com.videomanagementservice.Services;

import miniyoutube.com.videomanagementservice.DTO.ComentDto;
import miniyoutube.com.videomanagementservice.Models.ComentModel;
import miniyoutube.com.videomanagementservice.Models.DisLikeModel;
import miniyoutube.com.videomanagementservice.Models.LikeModel;
import miniyoutube.com.videomanagementservice.Models.VidoeModel;
import miniyoutube.com.videomanagementservice.Repositorys.CommentRepository;
import miniyoutube.com.videomanagementservice.Repositorys.DisLikeRepository;
import miniyoutube.com.videomanagementservice.Repositorys.LikeRepository;
import miniyoutube.com.videomanagementservice.Repositorys.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

@Service

public class GetVideoService implements GetVideoI {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private DisLikeRepository disLikeRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public String GetVideo(String videoId) {

        VidoeModel video = videoRepository.getById(videoId);
        return video.getPath();
    }

    @Override
    public String likeVideo(String videoId) {
        LikeModel like = new LikeModel(videoId);
        likeRepository.save(like);
        return "it is saved";
    }

    @Override
    public String DislikeVideo(String videoId) {
        DisLikeModel like = new DisLikeModel(videoId);
        disLikeRepository.save(like);
        return "it is saved";

    }

    @Override
    public String Coment(ComentDto comentDto) {
        ComentModel comment = new ComentModel(comentDto.videoId, comentDto.comment);
        commentRepository.save(comment);
        return "it is saved";
    }
}

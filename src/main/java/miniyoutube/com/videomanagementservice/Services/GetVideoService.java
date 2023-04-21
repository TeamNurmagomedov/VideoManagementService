package miniyoutube.com.videomanagementservice.Services;

import miniyoutube.com.videomanagementservice.Config.WebClientConfig;
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
import org.springframework.kafka.core.KafkaTemplate;
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
    @Autowired
    private WebClientConfig webClientConfig;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public GetVideoService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String returnUserName(String id){
        String userName= webClientConfig.webClient()
                .get()
                .uri("http://localhost:9095/user/email?id="+id)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return userName;
    }
    public String returnUserEmail(String id){
        String userEmail= webClientConfig.webClient()
                .get()
                .uri("http://localhost:9095/user/email?id="+id)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return userEmail;
    }
    @Override
    public String GetVideo(String videoId ) {
        VidoeModel video = videoRepository.getById(videoId);
        return video.getPath();
    }

    @Override
    public String likeVideo(String videoId,String id ) {
        String name = returnUserName(id);
        String email = returnUserEmail(id);
        System.out.println(name);
        kafkaTemplate.send("events-topic", "Like/ " + videoId + "/" +  name + "/" + email);
        LikeModel like = new LikeModel(videoId);
        likeRepository.save(like);
        return "it is saved";
    }

    @Override
    public String DislikeVideo(String videoId,String id) {
        String name = returnUserName(id);
        String email = returnUserEmail(id);
        DisLikeModel like = new DisLikeModel(videoId);
        kafkaTemplate.send("events-topic", "Dislike/ " + videoId + "/" +  name + "/" + email);
        disLikeRepository.save(like);
        return "it is saved";

    }

    @Override
    public String Coment(ComentDto comentDto) {
        String name = returnUserName(comentDto.id);
        String email = returnUserEmail(comentDto.id);
        ComentModel comment = new ComentModel(comentDto.videoId, comentDto.comment);
        kafkaTemplate.send("events-topic", "Comment/ " + comentDto.videoId + "/" +  name + "/" + email + "/" + comentDto.comment);
        commentRepository.save(comment);
        return "it is saved";
    }
}

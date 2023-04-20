package miniyoutube.com.videomanagementservice.Services;

import miniyoutube.com.videomanagementservice.DTO.ComentDto;

public interface GetVideoI {
    String GetVideo(String videoId);
    String likeVideo(String videoId);
    String DislikeVideo(String videoId);
    String Coment(ComentDto comentDto);
}

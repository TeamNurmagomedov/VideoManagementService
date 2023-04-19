package miniyoutube.com.videomanagementservice.Services;

import java.io.IOException;
import java.util.UUID;

import com.amazonaws.services.s3.AmazonS3;
import miniyoutube.com.videomanagementservice.Models.VidoeModel;
import miniyoutube.com.videomanagementservice.Repositorys.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Service
public class AWSS3Service implements FileService{

    @Autowired
    private AmazonS3 amazonS3;
    @Autowired
    private  VideoRepository videoRepository;

    @Override
    public String uploadFile(MultipartFile file) {
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String key = UUID.randomUUID().toString()+"." + extension;

        ObjectMetadata metaData = new ObjectMetadata();
        metaData.setContentLength(file.getSize());
        metaData.setContentType(file.getContentType());

        try{
            amazonS3.putObject("hasbul",key,file.getInputStream(),metaData);

        }
        catch (IOException e ){
            throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured while saving the vidoe ");
        }

        //amazonS3.setObjectAcl("hasbul",key, CannedAccessControlList.PublicRead);
        amazonS3.setObjectAcl("hasbul", key, CannedAccessControlList.PublicRead);

        String url = amazonS3.getUrl("hasbul", key).toString();

        VidoeModel fileEntity = new VidoeModel( url, "Ivo");
        videoRepository.save(fileEntity);

        return url;

    }
}

package miniyoutube.com.videomanagementservice.Controllers;

import miniyoutube.com.videomanagementservice.Services.S3BucketStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@RestController
@RequestMapping(path = "video")
public class VideoController {

    @Autowired
    S3BucketStorageService service;


    @PostMapping("/file/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("fileName") String fileName,
                                             @RequestParam("file")  MultipartFile file) {
        return new ResponseEntity<>(service.uploadFile(fileName, file), HttpStatus.OK);
    }
}
package miniyoutube.com.videomanagementservice.Controllers;

import miniyoutube.com.videomanagementservice.Services.FileService;
import miniyoutube.com.videomanagementservice.Services.GetVideoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(path = "video")
public class VideoController {


    @Autowired
    private FileService fileService;
    @Autowired
    private GetVideoI getVideoI;

    @PostMapping("/file/upload")
    public ResponseEntity<Map<String,String>> uploadFile(@RequestParam("file")  MultipartFile file) {
        String publicURL = fileService.uploadFile(file);
        Map<String,String> response = new HashMap<>();
        response.put("PublicURL",publicURL);
        return new ResponseEntity<Map<String,String>>(response,HttpStatus.CREATED);
    }
    @GetMapping("/file/GetVideo")
    public ResponseEntity<Map<String,String>> GetVideo(@RequestParam("id") String id) {
        String uuidString = "2815519d-5fa4-44e7-bf3c-e307045ffb58";


        String publicURL = getVideoI.GetVideo(id);
        Map<String,String> response = new HashMap<>();
        response.put("PublicURL",publicURL);
        return new ResponseEntity<Map<String,String>>(response,HttpStatus.CREATED);
    }

}
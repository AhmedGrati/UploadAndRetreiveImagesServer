package com.example.UploadDownloadImages.Controllers;

import com.example.UploadDownloadImages.Services.ImageService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "api/images")
public class ImageController {

    @Autowired
    public ImageService imageService;
    @PostMapping(value ="upload")
    public ResponseEntity uploadImage(@RequestParam MultipartFile file){
        return this.imageService.uploadToLocalFileSystem(file);
    }
    @GetMapping(
            value = "getImage/{imageName:.+}",
            produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_PNG_VALUE}
    )
    public @ResponseBody byte[] getImageWithMediaType(@PathVariable(name = "imageName") String fileName) throws IOException {
        return this.imageService.getImageWithMediaType(fileName);
    }
}



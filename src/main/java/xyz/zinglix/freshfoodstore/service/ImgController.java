package xyz.zinglix.freshfoodstore.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang3.*;
import xyz.zinglix.freshfoodstore.util.BadRequestException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ImgController {
    @Value("${xyz.zinglix.freshfoodstore.imgpath}")
    String imgPath;

    @PostMapping("/upload/products")
    @ResponseBody
    Map<String,String> uploadProductImage(@RequestParam("file") MultipartFile file){
        Map<String,String> response=new HashMap<>();
        response.put("filename",saveFile(file,"products"));
        return response;
    }

    @PostMapping("/upload/avatar")
    Map<String,String> uploadAvatarImage(@RequestParam("file") MultipartFile file){
        Map<String,String> response=new HashMap<>();
        response.put("filename",saveFile(file,"avatar"));
        return response;
    }

    String saveFile(MultipartFile file,String category){
        if(file.isEmpty()) throw new BadRequestException("文件不能为空");
        String fileName = RandomStringUtils.randomAlphanumeric(16);
        fileName+=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        File dest = new File(imgPath+category+"/" + fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new BadRequestException("上传失败，请稍后重试！");
        }
        return fileName;
    }
}

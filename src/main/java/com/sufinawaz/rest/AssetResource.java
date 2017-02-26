package com.sufinawaz.rest;

import com.sufinawaz.model.WebMessage;
import com.sufinawaz.service.S3AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AssetResource {
    @Autowired
    private S3AssetService s3AssetService;

    @PostMapping("/asset/upload")
    @ResponseBody
    public WebMessage assetUpload(@RequestParam("file") MultipartFile file) {
        s3AssetService.upload(file);
        return new WebMessage("Great Success");
    }

    @RequestMapping("/asset/test")
    @ResponseBody
    public WebMessage assetUpload() {
        return new WebMessage("Jolly Good!");
    }
}

package com.sufinawaz.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.UUID;

@Service
public class S3AssetService {
    @Value("${aws.accessKeyId}")
    private String accessKeyId;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.bucket}")
    private String bucket;

    @Value("${aws.url}")
    private String awsUrl;

    private AmazonS3Client client;

    @PostConstruct
    public void init() {
        client = new AmazonS3Client(new BasicAWSCredentials(accessKeyId, secretKey));
    }

    public void upload(final MultipartFile upload) {
        try {
            final String fileName = UUID.randomUUID().toString() + "-" + upload.getOriginalFilename();
            // upload the file
            client.putObject(bucket, fileName, upload.getInputStream(), null);
            // set the permission of file to be public
            client.setObjectAcl(bucket, fileName, CannedAccessControlList.PublicRead);
        } catch (AmazonClientException | IOException ie) {
            throw new RuntimeException(ie.getMessage());
        }
    }
}

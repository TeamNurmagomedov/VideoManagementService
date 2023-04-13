package miniyoutube.com.videomanagementservice.Config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

    @Value("${cloud.aws.credentials.accessKey}")
    private String awsId;

    @Value("${cloud.aws.credentials.secretKey}")
    private String awsKey;

    @Value("${cloud.aws.region.static}")
    private String region;
    //private String accessKeyID = "AKIAQIPEBO7UI6Q5GDL5";
    //private String secretKey = "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";
    @Bean
    public AmazonS3 s3client() {

        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(awsId , awsKey );
        AmazonS3 amazonS3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.EU_CENTRAL_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

        return amazonS3Client;
    }



}

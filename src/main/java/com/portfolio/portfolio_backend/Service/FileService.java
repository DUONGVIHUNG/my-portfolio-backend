package com.portfolio.portfolio_backend.Service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class FileService {
    public Optional<Resource> loadCvFileAsResource(String fileName){
        try{
            Path path = Paths.get("src/main/resources/static").resolve(fileName).normalize();
            Resource resource = new UrlResource(path.toUri());

            if (resource.exists() && resource.isReadable()){
                return Optional.of(resource);
            }
            else {
                return Optional.empty();
            }
        } catch(MalformedURLException e){
            System.err.println("エラー：誤ったファイルURLを入力しました。"+e.getMessage());
            return Optional.empty();
        }
    }
}

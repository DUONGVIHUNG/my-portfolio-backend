package com.portfolio.portfolio_backend.Controller;

import com.portfolio.portfolio_backend.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://localhost:3000")
@RequestMapping("/api")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadCv(@PathVariable String fileName){
        Optional<Resource> fileResourceOptional = fileService.loadCvFileAsResource(fileName);

        return fileResourceOptional.map(resource->{
           String contentType = "application/octet-stream";

           String fileNameToLowerCase = fileName.toLowerCase();
           if(fileNameToLowerCase.endsWith(".pdf")) {
               contentType = MediaType.APPLICATION_PDF_VALUE;
           }else if (fileNameToLowerCase.endsWith(".xlsx")){
               contentType = "application/vns.openxmlformats-officedocument.spreadsheetml.sheet";
           }else if(fileNameToLowerCase.endsWith(".xls")){
               contentType= "application/vns.ms-excel";
           }
           return ResponseEntity.ok()
                   .contentType(MediaType.parseMediaType(contentType))
                   .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename =\""+ resource.getFilename()+"\"")
                   .body(resource);
        }).orElse(ResponseEntity.notFound().build());

    }
}

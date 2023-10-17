package com.projetopm.veterinaria.controller;

import com.projetopm.veterinaria.model.entities.Cliente;
import com.projetopm.veterinaria.model.entities.Imagem;
import com.projetopm.veterinaria.service.ClienteService;
import com.projetopm.veterinaria.service.ImagemService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.SQLException;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;


@RestController
@RequestMapping("/api/imagem")
public class ImagemController {

//    public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";

    @Autowired
    private ImagemService service;

//    @PostMapping("/upload/{id}")
//    public ResponseEntity<String> uploadFiles(@RequestParam("file")MultipartFile file, @PathVariable("id") Integer id) throws IOException {
//
//            String filename = StringUtils.cleanPath(id+"."+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1));
//            System.out.println(filename);
//            Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
//            System.out.println(fileStorage);
//            copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
//            return ResponseEntity.ok().body(filename);
//
//    }

//    @GetMapping("exibir/{filename}")
//    public ResponseEntity<Resource> downloadFiles(@PathVariable("filename") String filename) throws IOException {
//        Path filePath = get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
//        System.out.println("FilePath"+ filePath);
//        if(!Files.exists(filePath)) {
//            throw new FileNotFoundException(filename + " was not found on the server");
//        }
//        Resource resource = new UrlResource(filePath.toUri());
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("File-Name", filename);
//        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
//        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
//                .headers(httpHeaders).body(resource);
//    }

    @GetMapping("/exibir/{id}")
    public ResponseEntity<byte[]> displayImage(@PathVariable("id") Integer id) throws IOException, SQLException
    {
        Imagem image = service.viewById(id);
        byte [] imageBytes = null;
        imageBytes = image.getImage().getBytes(1,(int) image.getImage().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }


    @PostMapping("/upload")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Imagem> addImagePost(@RequestParam("file") MultipartFile file) throws IOException, SQLException {
        byte[] bytes = file.getBytes();
        Blob blob = new SerialBlob(bytes);

        Imagem image = new Imagem();
        image.setImage(blob);
        service.create(image);
        return ResponseEntity.ok().body(image);
    }

}

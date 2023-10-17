package com.projetopm.veterinaria.controller;

import com.projetopm.veterinaria.model.entities.Assinatura;
import com.projetopm.veterinaria.model.entities.Imagem;
import com.projetopm.veterinaria.service.AssinaturaService;
import com.projetopm.veterinaria.service.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;


@RestController
@RequestMapping("/api/assinatura")
public class AssinaturaController {

//    public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";

    @Autowired
    private AssinaturaService service;

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
        Assinatura image = service.viewById(id);
        byte [] imageBytes = null;
        imageBytes = image.getImage().getBytes(1,(int) image.getImage().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }


    @PostMapping("/upload")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Assinatura> addImagePost(@RequestParam("file") MultipartFile file) throws IOException, SQLException {
        byte[] bytes = file.getBytes();
        Blob blob = new SerialBlob(bytes);

        Assinatura image = new Assinatura();
        image.setImage(blob);
        service.create(image);
        return ResponseEntity.ok().body(image);
    }

}

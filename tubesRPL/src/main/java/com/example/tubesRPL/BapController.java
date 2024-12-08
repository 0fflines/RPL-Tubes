package com.example.tubesRPL;
import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class BapController {
    //nama entity buat upload ke db dan download file dari db
    private final FileService fileHandler = new FileService();

    @PostMapping
    //ResponseEntity buat response fileUpload berhasil atau error
    //id untuk TugasAkhirnya
    public ResponseEntity<String> uploadPDF(@RequestParam("file") MultipartFile file, @RequestParam("id") int id){
        //try catch untuk pastiin file yang di upload beneran pdf
        try{
            if(!file.getContentType().equalsIgnoreCase("application/pdf")){
                //error message untuk client side
                return ResponseEntity.badRequest().body("Tidak bisa upload file selain pdf");
            }            
            fileHandler.saveFile(file, id);
            return ResponseEntity.ok().body("File berhasil diupload");
        }catch(IOException e){
            //error message untuk server side 
            return ResponseEntity.internalServerError().body("File upload gagal "+e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<byte[]> downloadFile(@RequestParam int id){
        try {
            //fungsi buat manggil filenya pake id
            byte[] fileContent = fileHandler.getFile(id);
            org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
            header.setContentType(MediaType.APPLICATION_PDF);
            header.setContentDisposition(ContentDisposition.attachment().filename("BAP").build());
            return ResponseEntity.ok().headers(header).body(fileContent);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}


class FileService{
    @Autowired
    private TugasAkhirRepository tugasAkhirRepository;

    public void saveFile(MultipartFile file, int id) throws IOException{
        tugasAkhirRepository.updateBapFile(id, file.getBytes());
    }


    //belum tau nama class file
    //throw exception buat kemungkinan g ada filenya
    public byte[] getFile(int id) throws Exception{
        return tugasAkhirRepository.getBapFile(id);
    }
}
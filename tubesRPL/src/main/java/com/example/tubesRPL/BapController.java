package com.example.tubesRPL;
import java.io.File;
import java.io.IOException;
import java.net.http.HttpHeaders;
import org.springframework.http.ContentDisposition;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javassist.bytecode.stackmap.BasicBlock.Catch;
@Controller
public class BapController {
    //line 19, 32, 34 dibuat pake asumsi filenya
    //FileUploadDownload nunggu database dibuat
    //taro tempat naro file pdfnya disini
    private final String pdfFileDirectory = "";
    //nama entity buat upload ke db dan download file dari db
    private final FileUploadDownload fileHandler = new FileUploadDownload();
    @PostMapping
    //ResponseEntity buat response fileUpload berhasil atau error
    public ResponseEntity<String> uploadPDF(@RequestParam("file") MultipartFile file){
        //try catch untuk pastiin file yang di upload beneran pdf
        try{
            if(!file.getContentType().equalsIgnoreCase("application/pdf")){
                //error message untuk client side
                return ResponseEntity.badRequest().body("Tidak bisa upload file selain pdf");
            }
            
            //nyimpen ke database
            Long fileId = fileHandler.saveFile(file);
            return ResponseEntity.ok().body("File berhasil diupload");
        }catch(IOException e){
            //error message untuk server side 
            return ResponseEntity.internalServerError().body("File upload gagal "+e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<byte[]> downloadFile(@RequestParam Long id){
        try {
            //fungsi buat manggil filenya pake id
            // MultipartFile file = fileHandler.getFile(id);
            //belum bisa pake content disposition gara gara g bisa import
        } catch (Exception e) {
            // TODO: handle exception
            ResponseEntity.internalServerError().body("File tidak dapat ditemukan");
        }
    }
}
class FileUploadDownload{
    public Long saveFile(MultipartFile file) throws IOException{
        //bagian buat nge save ke database
        //return idnya
        return 1L;
    }
    //belum tau nama class file
    //throw exception buat kemungkinan g ada filenya
    public void getFile(Long id) throws Exception{
    }
}
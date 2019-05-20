package com.tt.stack.controller;

import com.tt.stack.entity.Photo;
import com.tt.stack.entity.PhotoAlbum;
import com.tt.stack.service.AlbumService;
import com.tt.stack.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequestMapping("/admin")
@Controller
public class Admin_PhotoController {

    @Autowired
    PhotoService photoService;

    @Autowired
    AlbumService albumService;

    @RequestMapping("/photos")
    public String photoManager(Model model){
        List<PhotoAlbum> albums = albumService.getAllAlbum();
        model.addAttribute("albums" ,albums);
        return "admin_photo";
    }

    @RequestMapping("/photos/{id}")
    public String photoByAlbum(@PathVariable("id") Integer id,Model model){
        PhotoAlbum album = albumService.getAlbumById(id);
        List<Photo> photos = photoService.getPhotoByAlbumId(id);
        List<PhotoAlbum> albums = albumService.getAllAlbum();
        model.addAttribute("albums" ,albums);
        model.addAttribute("album",album);
        model.addAttribute("photos",photos);
        return "admin_photo";
    }

    @GetMapping("/photo")
    public String toAddPhoto(Model model){
        List<PhotoAlbum> albums = albumService.getAllAlbum();
        model.addAttribute("albums",albums);
        return "admin_photo_add";
    }

    @PostMapping("/photo")
    public String addAlbum(Photo photo, @RequestParam("image") MultipartFile image, RedirectAttributes ra, HttpServletRequest request) throws IOException {

        if (image.isEmpty()){
            ra.addFlashAttribute("msg","请选择图片");
            return "redirect:/admin/photo";
        }

        String fileName = new SimpleDateFormat("yyyyMMdd").format(new Date())+"_"
                + UUID.randomUUID().toString().replace("-","_")+"_"+image.getOriginalFilename();
        //获取跟目录
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) path = new File("");
        System.out.println("path:"+path.getAbsolutePath());
//如果上传目录为/static/images/upload/，则可以如下获取：
        File upload = new File(path.getAbsolutePath(),"static/images/upload/");
        if(!upload.exists()) upload.mkdirs();
        File file = new File(upload+"/"+fileName);
        try {
            image.transferTo(file);
        }catch (IOException e){
            ra.addFlashAttribute("msg","上传失败");
            return "redirect:/admin/photo";
        }

        String imgPath = file.getPath().split("static",2)[1];
        photo.setImgsrc(imgPath);
        photoService.addPhoto(photo);
        return "redirect:/admin/photos/"+photo.getAlbumid().getId();
    }

    @GetMapping("/photo/{id}")
    public String toEditPhoto(Model model,@PathVariable("id") Integer id){
        Photo photo = photoService.getPhotoById(id);
        model.addAttribute("photo",photo);
        List<PhotoAlbum> albums = albumService.getAllAlbum();
        model.addAttribute("albums",albums);
        return "admin_photo_add";
    }

    @PutMapping("/photo")
    public String editPhoto(Photo photo){
        photoService.editPhoto(photo);
        return "redirect:/admin/photos/"+photo.getAlbumid().getId();
    }

    @DeleteMapping("/photo/{id}")
    public String deletePhoto(@PathVariable("id") Integer id){
        int albumid = photoService.getPhotoById(id).getAlbumid().getId();
        photoService.deletePhoto(id);
        return "redirect:/admin/photos/"+albumid;
    }

}

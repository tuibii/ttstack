package com.tt.stack.controller;

import com.tt.stack.entity.PhotoAlbum;
import com.tt.stack.service.AlbumService;
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

@Controller
@RequestMapping("/admin")
public class Admin_AlbumController {

    @Autowired
    AlbumService albumService;

    @GetMapping("/albums")
    public String albumManager(Model model){
        List<PhotoAlbum> allAlbum = albumService.getAllAlbum();
        model.addAttribute("albums",allAlbum);
        return "admin_album";
    }

    @GetMapping("/album")
    public String toAddAlbum(){
        return "admin_album_add";
    }

    @GetMapping("/album/{id}")
    public String toEditAlbum(Model model,@PathVariable("id") Integer id){
        PhotoAlbum album = albumService.getAlbumById(id);
        model.addAttribute("album",album);
        return "admin_album_add";
    }

    @PostMapping("/album")
    public String addAlbum(PhotoAlbum photoAlbum, @RequestParam("cover") MultipartFile cover, Model model, HttpServletRequest request) throws IOException {

        if (photoAlbum.getName().trim().equals("") || photoAlbum.getName().equals(null)){
            model.addAttribute("msg","没有相册名");
            return "admin_album_add";
        }
        if (cover.isEmpty()){
            model.addAttribute("msg","没有封面图");
            return "admin_album_add";
        }

        String fileName = new SimpleDateFormat("yyyyMMdd").format(new Date())+"_"
                + UUID.randomUUID().toString().replace("-","_")+"_"+cover.getOriginalFilename();

        //获取跟目录
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) path = new File("");
        System.out.println("path:"+path.getAbsolutePath());
//如果上传目录为/static/images/upload/，则可以如下获取：
        File upload = new File(path.getAbsolutePath(),"static/images/upload/");
        if(!upload.exists()) upload.mkdirs();

        File file = new File(upload+"/"+fileName);
        try {
            cover.transferTo(file);
        }catch (IOException e){
            model.addAttribute("msg","上传失败");
            return "admin_album_add";
        }

        String imgPath = file.getPath().split("static",2)[1];
        photoAlbum.setImg(imgPath);
        albumService.addAlbum(photoAlbum);
        return "redirect:/admin/albums";
    }

    @PutMapping("/album")
    public String editAlbum(PhotoAlbum photoAlbum,Model model){
        if (photoAlbum.getName().trim().equals("") || photoAlbum.getName().equals(null)){
            model.addAttribute("msg","没有相册名");
            PhotoAlbum album = albumService.getAlbumById(photoAlbum.getId());
            model.addAttribute("album",album);
            return "admin_album_add";
        }
        albumService.updateAlbum(photoAlbum);
        return "redirect:/admin/albums";
    }

    @DeleteMapping("/album/{id}")
    public String deleteAlbum(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        if (albumService.hasPhotoByAlbumId(id)) {
            redirectAttributes.addFlashAttribute("msgButton",id);
            redirectAttributes.addFlashAttribute("msg","相册中还有图片 无法删除");
            return "redirect:/admin/albums";
        }
        albumService.deleteAlbum(id);
        return "redirect:/admin/albums";
    }
}

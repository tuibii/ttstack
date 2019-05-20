package com.tt.stack.controller;

import com.tt.stack.entity.Photo;
import com.tt.stack.service.AlbumService;
import com.tt.stack.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @Autowired
    AlbumService albumService;

    @RequestMapping("/photo/{id}")
    public String list(@PathVariable("id") Integer id, Model model){
        String AlbumName = albumService.getAlbumById(id).getName();
        List<Photo> photos = photoService.getPhotoByAlbumId(id);
        model.addAttribute("name",AlbumName);
        model.addAttribute("photos",photos);
        return "list";
    }
}

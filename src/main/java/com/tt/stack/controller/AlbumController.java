package com.tt.stack.controller;

import com.tt.stack.entity.PhotoAlbum;
import com.tt.stack.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @RequestMapping(value = {"/hello","/"})
    public String hello(Model model){

        List<PhotoAlbum> allAlbum = albumService.getAllAlbum();
        model.addAttribute("albums",allAlbum);
        return "index";
    }

    @ResponseBody
    @RequestMapping("/test")
    public List<PhotoAlbum> JsonTest(){
        List<PhotoAlbum> allAlbum = albumService.getAllAlbum();
        return allAlbum;
    }

}

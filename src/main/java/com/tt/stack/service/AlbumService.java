package com.tt.stack.service;

import com.tt.stack.entity.PhotoAlbum;

import java.util.List;

public interface AlbumService {

    public List<PhotoAlbum> getAllAlbum();
    public PhotoAlbum getAlbumById(Integer id);
    public void addAlbum(PhotoAlbum photoAlbum);
    public void updateAlbum(PhotoAlbum photoAlbum);
    public boolean hasPhotoByAlbumId(Integer id);
    public void deleteAlbum(Integer id);
}

package com.tt.stack.service;

import com.tt.stack.entity.Photo;

import java.util.List;

public interface PhotoService {
    public List<Photo> getPhotoByAlbumId(Integer id);
    public void addPhoto(Photo photo);
    public Photo getPhotoById(Integer id);
    public void editPhoto(Photo photo);
    public void deletePhoto(Integer id);
}

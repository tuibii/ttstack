package com.tt.stack.service.serviceImpl;

import com.tt.stack.dao.AlbumDao;
import com.tt.stack.entity.PhotoAlbum;
import com.tt.stack.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumDao albumDao;

    @Override
    public List<PhotoAlbum> getAllAlbum() {
        return albumDao.getAllAlbum();
    }

    @Override
    public PhotoAlbum getAlbumById(Integer id) {
        return albumDao.getAlbumById(id);
    }

    @Override
    public void deleteAlbum(Integer id) {
        albumDao.deleteAlbum(id);
    }

    @Override
    public boolean hasPhotoByAlbumId(Integer id) {
        int num = albumDao.getPhotoNmber(id);
        if (num > 0 )
            return true;
        else
            return false;
    }

    @Override
    public void updateAlbum(PhotoAlbum photoAlbum) {
        albumDao.editAlbum(photoAlbum);
    }

    @Override
    public void addAlbum(PhotoAlbum photoAlbum) {
        albumDao.addAlbum(photoAlbum);
    }
}

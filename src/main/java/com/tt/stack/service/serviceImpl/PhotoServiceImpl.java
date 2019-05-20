package com.tt.stack.service.serviceImpl;

import com.tt.stack.dao.PhotoDao;
import com.tt.stack.entity.Photo;
import com.tt.stack.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoDao photoDao;

    @Override
    public void addPhoto(Photo photo) {
        photoDao.addPhoto(photo);
    }

    @Override
    public List<Photo> getPhotoByAlbumId(Integer id) {
        return photoDao.getPhotoByAlbumId(id);
    }

    @Override
    public Photo getPhotoById(Integer id) {
        return photoDao.getPhotoById(id);
    }

    @Override
    public void editPhoto(Photo photo) {
        photoDao.editPhoto(photo);
    }

    @Override
    public void deletePhoto(Integer id) {
        photoDao.deletePhoto(id);
    }
}

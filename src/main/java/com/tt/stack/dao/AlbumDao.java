package com.tt.stack.dao;

import com.tt.stack.entity.PhotoAlbum;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AlbumDao {

    @Select("select * from photo_album")
    public List<PhotoAlbum> getAllAlbum();

    @Select("select * from photo_album where id = #{id}")
    public PhotoAlbum getAlbumById(Integer id);

    @Insert("INSERT INTO photo_album(name,info,tip,img) VALUES(#{name},#{info},#{tip},#{img})")
    public void addAlbum(PhotoAlbum photoAlbum);

    @Update("UPDATE photo_album SET `name` = #{name}, `info` = #{info}, `tip` = #{tip} WHERE `id` = #{id}")
    public void editAlbum(PhotoAlbum photoAlbum);

    @Select("SELECT COUNT(id) FROM photo WHERE albumid = #{id}")
    public int getPhotoNmber(Integer id);

    @Delete("DELETE FROM photo_album WHERE id = #{id}")
    public void deleteAlbum(Integer id);

}

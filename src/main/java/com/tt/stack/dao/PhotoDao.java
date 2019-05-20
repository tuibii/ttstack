package com.tt.stack.dao;

import com.tt.stack.entity.Photo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PhotoDao {

    @Select("select * from photo where albumid = #{albumid}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "imgname",property = "imgname"),
            @Result(column = "imgsrc",property = "imgsrc"),
            @Result(column = "imgtext",property = "imgtext"),
            @Result(column = "imgurl",property = "imgurl"),
            @Result(column = "albumid",property = "albumid",one = @One(select = "com.tt.stack.dao.AlbumDao.getAlbumById",fetchType = FetchType.EAGER))})
    public List<Photo> getPhotoByAlbumId(Integer albumid);

    @Insert("INSERT INTO photo(imgname,imgsrc,imgtext,imgurl,albumid) VALUES(#{imgname},#{imgsrc},#{imgtext},#{imgurl},#{albumid.id})")
    public void addPhoto(Photo photo);

    @Select("select * from photo where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "imgname",property = "imgname"),
            @Result(column = "imgsrc",property = "imgsrc"),
            @Result(column = "imgtext",property = "imgtext"),
            @Result(column = "imgurl",property = "imgurl"),
            @Result(column = "albumid",property = "albumid",one = @One(select = "com.tt.stack.dao.AlbumDao.getAlbumById",fetchType = FetchType.EAGER))})
    public Photo getPhotoById(Integer id);

    @Update("UPDATE photo SET imgname = #{imgname},  " +
            "imgtext = #{imgtext},imgurl=#{imgurl},albumid= #{albumid.id} WHERE id = #{id}")
    public void editPhoto(Photo photo);

    @Delete("delete from photo where id = #{id}")
    public void deletePhoto(Integer id);
}

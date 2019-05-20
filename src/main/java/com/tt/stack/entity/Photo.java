package com.tt.stack.entity;

public class Photo {

    private Integer id;
    private String imgname;
    private String imgsrc;
    private String imgtext;
    private String imgurl;
    private PhotoAlbum albumid;

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", imgname='" + imgname + '\'' +
                ", imgsrc='" + imgsrc + '\'' +
                ", imgtext='" + imgtext + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", albumid=" + albumid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getImgtext() {
        return imgtext;
    }

    public void setImgtext(String imgtext) {
        this.imgtext = imgtext;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public PhotoAlbum getAlbumid() {
        return albumid;
    }

    public void setAlbumid(PhotoAlbum albumid) {
        this.albumid = albumid;
    }
}

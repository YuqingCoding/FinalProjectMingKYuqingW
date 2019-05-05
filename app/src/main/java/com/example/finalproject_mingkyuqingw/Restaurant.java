package com.example.finalproject_mingkyuqingw;

public class Restaurant  {

    public int name;
    public int photoId;


    public int getName(){
        return name;
    }

    public void setName(int question){
        this.name = name;
    }

    public int getPhotoId(){
        return photoId;
    }

    public void setPhotoId(int photoId){
        this.photoId = photoId;
    }

    public Restaurant (int name, int photoId){
        this.name = name;
        this.photoId = photoId;

    }

}

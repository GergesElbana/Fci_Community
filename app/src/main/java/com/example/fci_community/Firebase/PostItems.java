package com.example.fci_community.Firebase;

import android.provider.ContactsContract;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PostItems {

    private String postText;
    private String postPhoto;
    private String postId;
    private Long timeStamp;

    public PostItems(String postText, String postPhoto) {
        this.postText = postText;
        this.postPhoto = postPhoto;
        timeStamp =new Date().getTime();
    }

    public PostItems() {
    }

    public String getPostKey() {
        return postId;
    }

    public void setPostKey(String postKey) {
        this.postId = postKey;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getPostPhoto() {
        return postPhoto;
    }

    public void setPostPhoto(String postPhoto) {
        this.postPhoto = postPhoto;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Exclude // @Exclude :-> to no add the method to firebase
    public String getFormattedTime()
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyy/MM/dd");
        Date date=new Date();
        date.setTime(timeStamp);
        return sdf.format(date);
    }

}

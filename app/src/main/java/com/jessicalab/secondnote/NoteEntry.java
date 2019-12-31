package com.jessicalab.secondnote;

import java.util.Date;
import java.util.UUID;

public class NoteEntry {
    private final UUID mId;
    private String mTitle;
    private Date mDate;
    private String mFolderName;
    private String mContents;

    public NoteEntry() {
        this(UUID.randomUUID());
    }

    public NoteEntry(UUID id) {
        mId = id;
        mDate = new Date();
        mTitle = "Test";
        mFolderName = "Life";
        mContents = "I am doing good";
    }

    public UUID getId() {
        return mId;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getFolderName() {
        return mFolderName;
    }

    public void setFolderName(String folderName) {
        mFolderName = folderName;
    }

    public String getContents() {
        return mContents;
    }

    public void setContents(String contents) {
        mContents = contents;
    }
}

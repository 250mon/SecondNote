package com.jessicalab.secondnote;

import java.time.Instant;
import java.util.UUID;

public class NoteEntry {
    private UUID mId;
    private String mTitle;
    private Instant mDate;

    public NoteEntry() {
        SecndNote(UUID.randomUUID());
    }

    public NoteEntry(UUID id) {
        mId = id;
        mDate = Instant.now();
    }

    public UUID getId() {
        return mId;
    }

    public Instant getDate() {
        return mDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}

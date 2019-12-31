package com.jessicalab.secondnote;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class NoteLab {
    private static NoteLab sNoteLab;
    private final List<NoteEntry> mNoteList;
    private final Context mContext;

    private NoteLab(Context context) {
        mContext = context;
        mNoteList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            NoteEntry noteEntry = new NoteEntry();
            noteEntry.setTitle("Title " + i);
            mNoteList.add(noteEntry);
        }
    }

    public static NoteLab get(Context context) {
        if (sNoteLab == null) {
            sNoteLab = new NoteLab(context);
        }
        return sNoteLab;
    }

    public List<NoteEntry> getNoteList() {
        return mNoteList;
    }

    public NoteEntry getNoteEntry(UUID id) {
        int index = 0;
        while (index < mNoteList.size() && !mNoteList.get(index).getId().equals(id)) {
            index++;
        }

        return (index < mNoteList.size()) ? mNoteList.get(index) : null;
    }
}

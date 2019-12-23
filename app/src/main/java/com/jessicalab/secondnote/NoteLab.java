package com.jessicalab.secondnote;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NoteLab {
    private static NoteLab sNoteLab;
    private List<NoteEntry> mNoteList;
    private Context mContext;

    private NoteLab(Context context) {
        mContext = context;
        mNoteList = new ArrayList<>(20);

        int num = 0;
        for (NoteEntry noteEntry : mNoteList) {
            noteEntry.setTitle("" + num);
            num++;
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
        return mNoteList.parallelStream()
                .filter(n -> n.getId().equals(id))
                .findAny()
                .orElse(null);
    }
}

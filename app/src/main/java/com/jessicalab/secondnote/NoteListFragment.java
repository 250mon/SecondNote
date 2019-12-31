package com.jessicalab.secondnote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteListFragment extends Fragment {
    private RecyclerView mNoteRecyclerView;
    private NoteAdapter mAdapter;

    public static NoteListFragment newInstance() {
        return new NoteListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);

        mNoteRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_note_list_recycler_view);
        mNoteRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        List<NoteEntry> noteList = NoteLab.get(getActivity()).getNoteList();

        if (mAdapter == null) {
            mAdapter = new NoteAdapter(noteList);
            mNoteRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setNoteList(noteList);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class NoteHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mDateTextView;
        private TextView mTitleTextView;
        private TextView mFolderTextView;
        private TextView mContentsTextView;

        public NoteHolder(View itemView) {
            super(itemView);

            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_date_text_view);
            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_title_text_view);
            mFolderTextView = (TextView) itemView.findViewById(R.id.list_item_folder_text_view);
            mContentsTextView = (TextView) itemView.findViewById(R.id.list_item_contents_text_view);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }

        public void bindNote(NoteEntry noteEntry) {
            mDateTextView.setText(noteEntry.getDate().toString());
            mTitleTextView.setText(noteEntry.getTitle());
            mFolderTextView.setText(noteEntry.getFolderName());
            mContentsTextView.setText(noteEntry.getContents());
        }
    }

    private class NoteAdapter extends RecyclerView.Adapter<NoteHolder> {
        private List<NoteEntry> mNoteList;

        public NoteAdapter(List<NoteEntry> noteList) {
            mNoteList = noteList;
        }

        @NonNull
        @Override
        public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View itemView = layoutInflater.inflate(R.layout.list_item_note_entry, parent, false);
            return new NoteHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
            NoteEntry noteEntry = mNoteList.get(position);
            holder.bindNote(noteEntry);
        }

        @Override
        public int getItemCount() {
            return mNoteList.size();
        }

        public void setNoteList(List<NoteEntry> noteList) {
            mNoteList = noteList;
        }
    }
}

package com.example.hw_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NoteDetailFragment extends Fragment {
    private static final String ARG_TITLE = "title";
    private static final String ARG_DESC = "description";
    private static final String ARG_DATE = "date";

    public static NoteDetailFragment newInstance(Note note) {
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, note.getTitle());
        args.putString(ARG_DESC, note.getDescription());
        args.putString(ARG_DATE, note.getDate());

        NoteDetailFragment fragment = new NoteDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_detail, container, false);

        TextView title = view.findViewById(R.id.titleTextView);
        TextView desc = view.findViewById(R.id.descriptionTextView);
        TextView date = view.findViewById(R.id.dateTextView);

        Bundle args = getArguments();
        if (args != null) {
            title.setText(args.getString(ARG_TITLE));
            desc.setText(args.getString(ARG_DESC));
            date.setText(args.getString(ARG_DATE));
        }

        return view;
    }
}


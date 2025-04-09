package com.example.hw_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteListFragment extends Fragment {
    private RecyclerView recyclerView;
    private NoteAdapter adapter;
    private List<Note> notes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewNotes);

        notes = new ArrayList<>();
        notes.add(new Note("Заметка 1", "Описание 1", "2025-04-03"));
        notes.add(new Note("Заметка 2", "Описание 2", "2025-04-02"));

        adapter = new NoteAdapter(notes, note -> {
            // Обработка нажатия, вызов другого фрагмента
            openNoteDetail(note);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void openNoteDetail(Note note) {
        Fragment detailFragment = NoteDetailFragment.newInstance(note);
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit();
    }
}

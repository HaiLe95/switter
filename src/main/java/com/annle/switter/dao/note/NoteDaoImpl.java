package com.annle.switter.dao.note;

import com.annle.switter.model.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NoteDaoImpl implements NoteDao {

    private List<Note> database = new ArrayList<>();

    @Override
    public List<Note> getAll() {
        return database;
    }

    @Override
    public List<Note> getAllByUsername(String username) {
        return database
                .stream()
                .filter(note -> note.getUsername().equals(username))
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> getAllByHashtag(String hashtag) {
        return database
                .stream()
                .filter(note -> note.getHashtag().equals(hashtag))
                .collect(Collectors.toList());
    }

    @Override
    public void add(Note note) {
        database.add(note);
    }

}

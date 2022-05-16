package com.annle.switter.dao.note;

import com.annle.switter.model.Note;

import java.util.List;

public interface NoteDao {

    List<Note> getAll();

    List<Note> getAllByUsername(String username);

    List<Note> getAllByHashtag(String hashtag);

    void add(Note note);

}

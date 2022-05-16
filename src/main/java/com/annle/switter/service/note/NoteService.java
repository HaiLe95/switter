package com.annle.switter.service.note;

import com.annle.switter.model.Note;

import java.util.List;

public interface NoteService {

    List<Note> getAll();

    List<Note> getAllByUsername(String username);

    List<Note> getAllByHashtag(String hashtag);

    void add(Note note);

}

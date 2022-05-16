package com.annle.switter.service.note;

import com.annle.switter.dao.note.NoteDaoImpl;
import com.annle.switter.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDaoImpl noteDao;

    @Override
    public List<Note> getAll() {
        return noteDao.getAll();
    }

    @Override
    public List<Note> getAllByUsername(String username) {
        return noteDao.getAllByUsername(username);
    }

    @Override
    public List<Note> getAllByHashtag(String hashtag) {
        return noteDao.getAllByHashtag(hashtag);
    }

    @Override
    public void add(Note note) {
        noteDao.add(note);
    }
}

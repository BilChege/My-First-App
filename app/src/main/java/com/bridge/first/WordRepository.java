package com.bridge.first;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    private WordDAO wordDAO;
    private LiveData<List<Word>> words;

    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        wordDAO = db.wordDAO();
        words = wordDAO.getAlphabetized();
    }

    public LiveData<List<Word>> getWords() {
        return words;
    }

    void insert(Word word) {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            wordDAO.insert(word);
        });
    }
}

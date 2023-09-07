package com.nctech.bookmyshow.repositories;

import java.util.List;

public interface BaseRepository<T> {
    public void save(T type);

    public List<T> get();

    public List<T> toArrayList();

    public List<T> readFromFiles();

    public void saveToFile();

    public void loadData();
}

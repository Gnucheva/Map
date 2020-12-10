package ru.netology;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor

public class FileOpenManager {
    HashMap<String, String> map = new HashMap<>();

    public HashMap<String, String> getMap() {
        return map;
    }

    public void registerApp(String file, String app) {
        map.put(file, app);
    }

    public String getApp(String file) {
        return map.get(file);
    }

    public void removeApp(String file) {
        map.remove(file);
    }

    public List<String> getAllKeys() {
        Set<String> files = new HashSet<>(map.keySet());
        ArrayList<String> listFiles = new ArrayList<>(files);
        return listFiles;
    }

    public List<String> getAllValues() {
        Set<String> files = new HashSet<>(map.values());
        ArrayList<String> listFiles = new ArrayList<>(files);
        return listFiles;
    }

}

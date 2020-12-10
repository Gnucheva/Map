package ru.netology;

import java.util.*;

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
        listFiles.sort(Comparator.naturalOrder());
        return listFiles;
    }

    public List<String> getAllValues() {
        Set<String> files = new HashSet<>(map.values());
        ArrayList<String> listFiles = new ArrayList<>(files);
        listFiles.sort(Comparator.naturalOrder());
        return listFiles;
    }

}

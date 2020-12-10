package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileOpenManagerTest {
    private FileOpenManager manager = new FileOpenManager();

    private String html = "html";
    private String safari = "Safari";
    private String xml = "xml";
    private String google = "Google";
    private String img = "img";
    private String viewer = "Viewer";
    private String dox = "dox";

    @Nested
    public class EmptyManager {

        @Test
        void mustReturnEmptyIfNothingToRemove() {
            Map<String, String> expected = new HashMap<>();
            manager.removeApp(html);
            HashMap<String, String> actual = manager.getMap();
            assertEquals(expected, actual);
        }

        @Test
        void mustReturnNullIfNoApp() {
            String expected = null;
            String actual = manager.getApp(html);
            assertEquals(expected, actual);
        }

        @Test
        void mustReturnEmptyIfNoKeys() {
            List<String> expected = new ArrayList<>();
            List<String> actual = manager.getAllKeys();
            assertEquals(expected, actual);
        }

        @Test
        void mustReturnEmptyIfNoValues() {
            List<String> expected = new ArrayList<>();
            List<String> actual = manager.getAllValues();
            assertEquals(expected, actual);
        }
    }

    @Nested
    public class SingleItemManager {

        @Test
        void mustRegisterApp() {
            manager.registerApp(html, safari);
            String expected = safari;
            String actual = manager.getApp(html);
            assertEquals(expected, actual);
        }

        @Test
        void mustRemoveApp() {
            manager.registerApp(html, safari);
            Map<String, String> expected = new HashMap<>();
            manager.removeApp(html);
            HashMap<String, String> actual = manager.getMap();
            assertEquals(expected, actual);
        }

        @Test
        void mustReturnOneKey() {
            manager.registerApp(html, safari);
            List<String> expected = new ArrayList<>(List.of(html));
            List<String> actual = manager.getAllKeys();
            assertEquals(expected, actual);
        }

        @Test
        void mustReturnOneValue() {
            manager.registerApp(html, safari);
            List<String> expected = new ArrayList<>(List.of(safari));
            List<String> actual = manager.getAllValues();
            assertEquals(expected, actual);
        }
    }

    @Nested
    public class MultipleItemsManager {

        @BeforeEach
        void setup() {
            manager = new FileOpenManager();
            manager.registerApp(html, safari);
            manager.registerApp(xml, google);
            manager.registerApp(img, viewer);
        }

        @Test
        void mustAddAll() {
            HashMap<String, String> expected = new HashMap<>();
            expected.put(html, safari);
            expected.put(xml, google);
            expected.put(img, viewer);
            HashMap<String, String> actual = manager.getMap();
            assertEquals(expected, actual);
        }

        @Test
        void mustReturnOneApp() {
            String expected = safari;
            String actual = manager.getApp(html);
            assertEquals(expected, actual);
        }

        @Test
        void mustReturnNullIfInvalidKey() {
            String expected = null;
            String actual = manager.getApp(dox);
            assertEquals(expected, actual);
        }

        @Test
        void mustRemoveKey() {
            manager.removeApp(xml);
            Map<String, String> expected = new HashMap<>();
            expected.put(html, safari);
            expected.put(img, viewer);
            HashMap<String, String> actual = manager.getMap();
            assertEquals(expected, actual);
        }

        @Test
        void mustNotRemoveKeyIfInvalid() {
            manager.removeApp(dox);
            Map<String, String> expected = new HashMap<>();
            expected.put(html, safari);
            expected.put(xml, google);
            expected.put(img, viewer);
            HashMap<String, String> actual = manager.getMap();
            assertEquals(expected, actual);
        }
    }
}

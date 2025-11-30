package org.example;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private final List<String> items = new ArrayList<String>();

    public void add(String item) {
        if (item != null) {
            item = item.trim();

            if (!item.isEmpty())
                items.add(item);
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public List<String> getAll() {
        return new ArrayList<>(items);
    }

    public int size() {
        return items.size();
    }

    public void clear() {
        if (!items.isEmpty())
            items.clear();
    }

    public String done(int index) {
        if (index < 0 || index >= items.size())
            return "Index out of range";

        String task = items.get(index);
        String doneTask = task + " +";
        items.set(index, doneTask);
        return doneTask;
    }

    public String search(String subStr) {
        if (subStr == null || subStr.isEmpty())
            return "Input string is empty";
        for (String item : items) {
            if (item != null && item.trim().toLowerCase().contains(subStr.trim().toLowerCase()))
                return item;
        }
        return "Task not found";
    }
}



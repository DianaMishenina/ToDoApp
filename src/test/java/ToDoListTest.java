import org.example.ToDoList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {
    @Test
    void addAndList() {
        ToDoList toDoList = new ToDoList();
        toDoList.add("  task1  ");

        assertEquals(1, toDoList.size());
        assertEquals("task1", toDoList.getAll().getFirst());
    }

    @Test
    void remove() {
        ToDoList toDoList = new ToDoList();
        toDoList.add("a");
        toDoList.add("b");

        assertTrue(toDoList.remove(0));
        assertEquals(1, toDoList.size());
        assertFalse(toDoList.remove(10));
    }

    @Test
    void addEmptyIgnored() {
        ToDoList toDoList = new ToDoList();
        toDoList.add("   ");

        assertEquals(0, toDoList.size());
    }

    @Test
    void clear() {
        ToDoList toDoList = new ToDoList();
        toDoList.add("a");
        toDoList.add("b");
        toDoList.clear();

        assertNotEquals(2, toDoList.size());
    }

    @Test
    void done() {
        ToDoList toDoList = new ToDoList();
        toDoList.add("a");
        toDoList.add("b");
        toDoList.done(0);

        assertEquals("a +", toDoList.getAll().getFirst());
    }

    @Test
    void search() {
        ToDoList toDoList = new ToDoList();
        toDoList.add("ABCDE");
        toDoList.add("fg7d7777d7");

        String searchResult = toDoList.search("abc");

        assertEquals("ABCDE", searchResult);
        assertNotEquals("fg7d7777d7", searchResult);
    }
}


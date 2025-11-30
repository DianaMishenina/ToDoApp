package org.example;

import java.util.List;
import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simple todo CLI. Commands: add <task>, remove <index>, list, exit, " +
                "clear, done <index>, search <substring>");

        while (true) {
            System.out.println("> ");

            if (!scanner.hasNextLine())
                break;

            String line = scanner.nextLine().trim();
            if (line.isEmpty())
                continue;

            String[] parts = line.split(" ", 2);
            String cmd = parts[0].toLowerCase();

            switch (cmd) {
                case "add":
                    if (parts.length > 1) {
                        toDoList.add(parts[1]);
                        System.out.println("Added");
                    } else {
                        System.out.println("Usage: add <task>");
                    }
                    break;
                case "remove":
                    if (parts.length > 1) {
                        try {
                            int idx = Integer.parseInt(parts[1]);
                            if (toDoList.remove(idx))
                                System.out.println("Removed");
                            else
                                System.out.println("Index out of range");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid index");
                        }
                    } else
                        System.out.println("Usage: remove <index>");
                    break;
                case "list":
                    List<String> all = toDoList.getAll();

                    for (int i = 0; i < all.size(); i++) {
                        System.out.printf("%d: %s%n", i, all.get(i));
                    }
                    if (all.isEmpty())
                        System.out.println("(empty)");
                    break;
                case "exit":
                    System.out.println("Bye!");
                    scanner.close();
                    return;
                case "clear":
                    toDoList.clear();
                    System.out.println("The list is empty!");
                    break;
                case "done":
                    if (parts.length > 1) {
                        try {
                            int idx = Integer.parseInt(parts[1]);
                            System.out.println(toDoList.done(idx));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid index");
                        }
                    } else
                        System.out.println("Usage: done <index>");
                    break;
                case "search":
                    if (parts.length > 1) {
                        System.out.println(toDoList.search(parts[1]));
                    }
                    break;
                default:
                    System.out.println("Unknown command. Commands: add, remove, list, exit");

            }
        }
    }
}




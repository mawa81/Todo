package com.codersbay;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        ArrayList<Task> todos = new ArrayList<>();
        TaskDAO taskDAO = new TaskDAO();
        ArrayList<Task> tasks = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        while (!exit) {
            System.out.println("[1] List all Todo's\n[2] show Todo\n[3] new Todo \n[4] edit Todo\n[5] delete Todo\n[q] Quit");
            switch (scan.next()) {
                case "1":
                    printAllTodos();
                    break;
                case "2":
                    printTodo();
                    break;
                case "3":
                    addNewTodo();
                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "q":
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong entry!");
            }
        }


/*
        System.out.println(todoDAO.selectAllTodos());
        todoDAO.deleteTodo("test");
        System.out.println(todoDAO.selectAllTodos());
        Todo diyproject = new Todo("knitting machine","Building an open knitting machine", new ArrayList<Task>());
        diyproject.addTask(new Task("research","how does it work"));
        diyproject.addTask(new Task("parts","what do we need"));
        diyproject.addTask(new Task("build machine","build the hardware"));
        diyproject.addTask(new Task("code","write the controller software and build the GUI"));

        System.out.println(diyproject.getTaskList());

        todoDAO.insertTodo(diyproject);*/
    }

    public static void addNewTodo() {
        TodoDAO todoDAO = new TodoDAO();
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease enter the title of your todo-list: ");
        Todo todo = new Todo();
        if (scan.hasNext()) {
            todo.setTitle(scan.next());
        }
        System.out.println("\nPlease enter the description of your todo-list: ");
        if (scan.hasNext()) {
            todo.setDescription(scan.next());
        }
        todoDAO.insertTodo(todo);

        TaskDAO taskDAO = new TaskDAO();
        boolean addMore = true;
        while (addMore) {
            Task task = new Task();
            Scanner scan2 = new Scanner(System.in);
            System.out.println("\nPlease enter the task: ");
            if (scan2.hasNext()) {
                task.setTitle(scan2.next());
            }
            System.out.println("\nPlease enter the description of your task: ");
            if (scan2.hasNext()) {
                task.setDescription(scan2.next());
            }
            taskDAO.insertTask(task, todoDAO.getID());
            boolean error = false;
            //  while(!error) {
            System.out.println("\nAdd another task[y][n]: ");
            Scanner scan3 = new Scanner(System.in);
            if (scan3.hasNext()) {
                switch (scan3.next()) {
                    case "y":
                        addMore = true;
                        error = false;
                        break;
                    case "n":
                        addMore = false;
                        error = false;
                        break;
                    default:
                        System.out.println("Wrong input! Please try again!");
                        error = true;
                }
            }
            // }
        }

    }

    private static void printTodo() {
        Scanner scan4 = new Scanner(System.in);
        TaskDAO taskDAO = new TaskDAO();
        ArrayList<Task> tasks;
        tasks = taskDAO.selectAllTasks();     // ID abfragen von Datenbank aus Todo
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void printAllTodos() {
        TodoDAO todoDAO = new TodoDAO();
        ArrayList<Todo> todos;
        todos = todoDAO.selectAllTodos();
        for (Todo t : todos) {
            System.out.println(t);
        }
    }
}

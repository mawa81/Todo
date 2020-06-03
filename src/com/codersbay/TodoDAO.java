package com.codersbay;

import java.sql.*;
import java.util.ArrayList;

public class TodoDAO {
    private static final String CONNECTION_STRING = "jdbc:derby:C:/Users/codersbay/IdeaProjects/TodoList/db;create=true";
    private Connection conn;

    public TodoDAO() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertTodo(Todo toInsert) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO todo(title,description) VALUES(?,?)");
            ps.setString(1, toInsert.getTitle());
            ps.setString(2, toInsert.getDescription());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTodo(String toDelete) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM todo WHERE title = ?");
            ps.setString(1, toDelete);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getTasks(int id) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM task WHERE todo2_id = ?");
            ps.setInt(1, id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getID() {
        int todoID = -1;
        try {
            ArrayList<Todo> todoList = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(("SELECT todo_id FROM todo"));
            ps.execute();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                todoID = rs.getInt("todo_id");
            }
            return todoID;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoID;
    }

    public ArrayList<Todo> selectAllTodos() {
        try {
            ArrayList<Todo> todoList = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(("SELECT * FROM todo"));
            ps.execute();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                int todoID = rs.getInt("todo_id");
                TaskDAO taskDAO = new TaskDAO();
                ArrayList<Task> taskList = new ArrayList<>();
                taskList = taskDAO.selectAllTasks(todoID);
                Todo t = new Todo(title, description, taskList);
                todoList.add(t);
            }
            return todoList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


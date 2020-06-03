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

    private void insertTodo(Todo toInsert) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO todo VALUES(?,?,?)");
            ps.setString(1, toInsert.getTitle());
            ps.setString(2, toInsert.getDescription());
            ps.setInt(3, toInsert.getTODOID());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Task> selectAllTodos() {
        try {
            ArrayList<Task> todoList = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(("SELECT * FROM task"));
            ps.execute();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                int todoID = rs.getInt("todo_id");

                Task t = new Task(title, description);
                todoList.add(t);
            }
            return todoList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


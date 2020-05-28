package com.codersbay;

import java.sql.*;
import java.util.ArrayList;

public class TaskDAO {
    private static final String CONNECTION_STRING = "jdbc:derby:C:/Users/codersbay/IdeaProjects/TodoList/db;create=true";
    private Connection conn;

    public TaskDAO() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertTask(Task toInsert) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO task VALUES(?,?,?)");
            ps.setString(1, toInsert.getTitle());
            ps.setString(2, toInsert.getDescription());
            ps.setInt(3, toInsert.getTODOID());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Task> selectAllTasks() {
        try {
            ArrayList<Task> taskList = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(("SELECT * FROM task"));
            ps.execute();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                int todoID = rs.getInt("todo_id");

                Task t = new Task(title, description);
                taskList.add(t);
            }
            return taskList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

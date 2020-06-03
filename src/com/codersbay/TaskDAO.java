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

    public void insertTask(Task toInsert, int id) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO task(todo2_id,title,description) VALUES(?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, toInsert.getTitle());
            ps.setString(3, toInsert.getDescription());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(String toDelete) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM task WHERE title = ?");
            ps.setString(1, toDelete);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Task> selectAllTasks(int id) {
        try {
            ArrayList<Task> taskList = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(("SELECT * FROM task WHERE todo2_id = ?"));
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                int todoID = rs.getInt("todo2_id");

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

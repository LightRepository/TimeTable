package com.example.myapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

    private Connection connection;

    private final String host = "10.0.2.2";

    private final String database = "northwind";
    private final int port = 5432;
    private final String user = "postgres";
    private final String pass = "Tydi5112";
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;
    public String[] lesson_name_arr = new String[2];
    public String[] lesson_number_arr = new String[8];
    public String[] group_name_arr = new String[2];
    public String[] cabinet_number_arr = new String[8];
    public int[] id_arr = new int[8];
    public String[] lesson_time_arr = new String[8];
    private int i = 0;

    public Database()
    {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();
        getExtraConnection();
        //this.disconnect();
        System.out.println("connection status:" + status);
    }


    private void connect()
    {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                Statement stmt = null;
                try
                {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    System.out.println("connected:" + status);
                    stmt = connection.createStatement();
                    String sql = "SELECT id, lesson_time, lesson_name, lesson_number, group_name, cabinet_number FROM zhuikov";
                    ResultSet rs = stmt.executeQuery(sql);
                    //STEP 5: Extract data from result set
                    while(rs.next()){
                        //Retrieve by column name
                         id_arr[i]  = rs.getInt("id");
                         lesson_time_arr[i] = rs.getString("lesson_time");
                         lesson_name_arr[i] = rs.getString("lesson_name");
                         lesson_number_arr[i] = rs.getString("lesson_number");
                         group_name_arr[i] = rs.getString("group_name");
                         cabinet_number_arr[i] = rs.getString("cabinet_number");
                        //Display values

                        i++;
                    }
                    rs.close();
                }
                catch (Exception e)
                {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try
        {
            thread.join();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            this.status = false;
        }
    }

    public Connection getExtraConnection()
    {
        Connection c = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, user, pass);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return c;
    }



}
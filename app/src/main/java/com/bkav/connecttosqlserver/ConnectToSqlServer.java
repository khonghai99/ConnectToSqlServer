package com.bkav.connecttosqlserver;


import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToSqlServer {
    private Connection mConnection;
    private String mUser;
    private String mPass;
    private String mIp;
    private String mPort;
    private String mDatabase;

    @SuppressLint("NewApi")
    public Connection ConnectionClass() {
        mIp = "172.1.1.0";
        mDatabase = "ConectAndroid";
        mPort = "1433";
        mUser = "sa";
        mPass = "123123";
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String connectionURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionURL = "jdbc:jtds:sqlserver://" + mIp + ":" + mPort + ";" + "databasename="
                    + mDatabase + ";user=" + mUser + ";password=" + mPass + ";";
            Log.i("HaiKH", "ConnectionClass:1 "+connectionURL);
            connection = DriverManager.getConnection(connectionURL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Log.i("HaiKH", "ConnectionClass: "+connection);
        return connection;
    }


}

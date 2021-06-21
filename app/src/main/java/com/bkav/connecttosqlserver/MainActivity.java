package com.bkav.connecttosqlserver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    private Connection mConnection;
    private String mConnectionResult;
    private TextView mTextViewName;
    private Button mButtonConnect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mButtonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataFromSqlServer();
            }
        });
    }

    private void init(){
        mTextViewName = findViewById(R.id.text_view_name);
        mButtonConnect = findViewById(R.id.button_connect);
    }

    private void getDataFromSqlServer(){
        try {
            ConnectToSqlServer connectToSqlServer = new ConnectToSqlServer();
            mConnection = connectToSqlServer.ConnectionClass();
            Log.i("HaiKH", "getDataFromSqlServer:11111111111111 "+mConnection);
            if (connectToSqlServer != null){
                String queryToSql = "SELECT * FROM Account";
                Statement statement = mConnection.createStatement();
                ResultSet resultSet = statement.executeQuery(queryToSql);

                while (resultSet.next()){
                    mTextViewName.setText(resultSet.getString(1));
                }
            }
        }catch (Exception e){
            Log.i("HaiKH", "getDataFromSqlServer: "+ e);
        }
    }
}
package com.ctucs310.macandcheezary;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class CheckOutActivity extends Activity {
    ListView userList;
    UserCustomAdapter userAdapter;
    ArrayList<User> userArray = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * add item in arraylist
         */
//        userArray.add(new User("Mumer", "Spain", "Spain"));//       userArray.add(new User("Jon", "EW", "USA"));
//        userArray.add(new User("Broom", "Span", "SWA"));
//        userArray.add(new User("Lee", "Aus", "AUS"));
        userArray.add(new User("Mac Pizza", "$.99", "Full of JUICY Yellow BOOGERS!"));
        userArray.add(new User("Polish Cajun", "$10.49", "Rich tastes with slightly burnt Turd Links"));
        userArray.add(new User("Buffalo", "$9/99", "The OFFICIAL Barnyard Pimp"));
        userArray.add(new User("Colorado Favorite", "$9.99", "We just COULDNT forget Rocky Mtn Oysters!"));

        /**
         * set item into adapter
         */
        userAdapter = new UserCustomAdapter(CheckOutActivity.this, R.layout.row,
                userArray);
        userList = (ListView) findViewById(R.id.listView);
        userList.setItemsCanFocus(false);
        userList.setAdapter(userAdapter);
        
        /**
         * get on item click listener
         */
        userList.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    final int position, long id) {
                Log.i("List View Clicked", "**********");
                Toast.makeText(CheckOutActivity.this,
                        "List View Clicked:" + position, Toast.LENGTH_LONG)
                        .show();
            }
        });

    }

}

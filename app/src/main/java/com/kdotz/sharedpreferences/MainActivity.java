package com.kdotz.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.kdotz.sharedpreferences", Context.MODE_PRIVATE);

//        ArrayList<String> friends = new ArrayList<>();
//        friends.add("Napoleon");
//        friends.add("Drew");
//        friends.add("Lily");
//        friends.add("Meghana");
//
//        try {
//            sharedPreferences.edit().putString("friends", ObjectSerializer.serialize(friends)).apply();
//            Log.i("friends", ObjectSerializer.serialize(friends));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        ArrayList<String> newFriends = new ArrayList<>();

        try {
            newFriends = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends", ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        String username =sharedPreferences.getString("username", "");
//
        Log.i("New Friends ", newFriends.toString());

    }
}

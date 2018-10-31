package com.example.consultants.week2_daily2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.consultants.week2_daily2.Model.UserMessage;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class AddMessage extends Activity {

    private EditText etString;
    private ListView lvStrMessage;
    private MessageDatabase messageDatabase;

    ArrayList<String> TRYME = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_message);
        Log.d(TAG, "onCreate: ");
        bindViews();
//        TRYME = (ArrayList < String > getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        ArrayAdapter<String> strAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, new ArrayList<String>());


//        strList = (ArrayList<String>) getIntent().getExtras().get("")

    }

    //view (XML) bound with variables
    private void bindViews() {
        etString = findViewById(R.id.et_String);
        lvStrMessage = findViewById(R.id.lv_stringList);
    }

    public void msgSharedPreference(View view) {
        String appliedInput = etString.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("SaveStringPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        UserMessage userInput = new UserMessage(appliedInput);

        switch (view.getId()) {
            case R.id.btn_SaveStr:
                editor.apply();
                long rowID = messageDatabase.saveString(userInput);
//                Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
                Toast.makeText(this, String.valueOf(rowID), Toast.LENGTH_LONG).show();
                etString.setText("");
                break;
            case R.id.btn_DisplayStr:
                ArrayAdapter<String> stringAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, messageDatabase.getListStrings());

                lvStrMessage.setAdapter(stringAdapter);

//                Needs to return all of the strings to be viewed
//                ListView lvMessage = sharedPreferences.getString("editText", "Default String");
//                for (Message : messageDatabase.getListStrings()){
//
//                }

        }

    }
}

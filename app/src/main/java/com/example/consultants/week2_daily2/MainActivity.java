package com.example.consultants.week2_daily2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.consultants.week2_daily2.Model.UserMessage;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<String>inputList = new ArrayList<>();

    private EditText etString;
    private EditText etStrFile;
    private TextView txtStrFile;
    private ListView lvMessages;
    private MessageDatabase messageDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        messageDatabase = new MessageDatabase(getApplicationContext());

//        ArrayAdapter<String> stringAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, new ArrayList<String>());
//        lvMessages.setAdapter(stringAdapter);
    }

    //view (XML) bound with variables
    private void bindViews() {
//        etString = findViewById(R.id.et_String);
        etStrFile = findViewById(R.id.et_File);
        txtStrFile = findViewById(R.id.txt_File);
        lvMessages = findViewById(R.id.lvMessage);
    }


//    public void onSharedPreference(View view) {
//        SharedPreferences sharedPreferences = getSharedPreferences("SaveItemsPref",Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        switch (view.getId()) {
//            case R.id.btn_SaveStr:
//                editor.apply();
//                Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
//                etString.setText("");
//                break;
//            case R.id.btn_DisplayStr:
////                Needs to return all of the strings to be viewed
////                ListView lvMessage = sharedPreferences.getString("editText", "Default String");
//
//        }
//
//
//    }

    public void onSQLiteDatabase(View view) {
        String userMessage = etString.getText().toString();

        UserMessage leMessage = new UserMessage(userMessage);

        switch (view.getId()){
            case R.id.btn_SaveStr:
                long rowID = messageDatabase.saveString(leMessage);
                Toast.makeText(this, String.valueOf(userMessage),Toast.LENGTH_LONG).show();
                break;

            case R.id.btn_DisplayStr:
//                ArrayAdapter<String> stringAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, new ArrayList<String>());
                ArrayAdapter<String> stringAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, messageDatabase.getListStrings());

                lvMessages.setAdapter(stringAdapter);

//                for(UserMessage TryMe : messageDatabase.getListStrings() ) {
//                    Log.d(TAG, "onSQLiteDatabase: " + TryMe.toString());
//                }
                break;

            case R.id.btn_CreateDatabase:

                break;

            case R.id.btn_ReadDatabase:
                ArrayList<UserMessage>inputList = (ArrayList<UserMessage>) messageDatabase.leDisplayDB();
                lvMessages
                break;

            case R.id.btn_UpdateDatabase:

                break;

            case R.id.btn_DestroyDatabase:
                break;

        }
    }


    public void onAddString(View view) {
        Intent goTo = new Intent(getApplicationContext(), AddMessage.class);
        startActivity(goTo);

    }

    public void onWriteToFile(View view) {
        ReadWriteFile file = new ReadWriteFile();
        file.WriteBtn(view,getApplicationContext(),etStrFile);
    }

    public void onReadToFile(View view) {
        ReadWriteFile file = new ReadWriteFile();
        txtStrFile.setText(file.ReadBtn(view, getApplicationContext()));
    }
}

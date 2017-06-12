package com.example.suraj.spiderappdevtask1;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    public int count=0;
    public EditText editTxt;
    public Button btn;
    public ListView list;
    public ArrayAdapter<String> adapter;
    public ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        editTxt = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.button);
        list = (ListView) findViewById(R.id.list);
        arrayList = new ArrayList<String>();


        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.listviewlayout, arrayList);

        list.setAdapter(adapter);

        list.setOnItemClickListener(this);
    }

    public void add (View v)
    {
        count++;

        arrayList.add(editTxt.getText().toString());
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.listviewlayout, arrayList);
        list.setAdapter(adapter);
        editTxt.setText("");
        list.setSelection(adapter.getCount() - 1);

        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

    }

    public void remove (View v)
    {
        if (Integer.parseInt(editTxt.getText().toString())<=count)
        {
            count--;
            arrayList.remove(Integer.parseInt(editTxt.getText().toString())-1);
            adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.listviewlayout, arrayList);
            list.setAdapter(adapter);
            editTxt.setText("");
            list.setSelection(adapter.getCount() - 1);

            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

        }

        else
        {
            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            editTxt.setText("");
            Toast t = Toast.makeText(this,"Item not available!",Toast.LENGTH_LONG);
            t.show();
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        TextView temp = (TextView) view;
        CharSequence c = temp.getText();

        Intent i = new Intent(this,secActivity.class);
        i.putExtra("data",c);
        startActivity(i);

    }


}


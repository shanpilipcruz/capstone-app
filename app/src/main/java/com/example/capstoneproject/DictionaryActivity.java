package com.example.capstoneproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.capstoneproject.dictionaryBackend.DbBackend;

import java.util.Arrays;

public class DictionaryActivity extends HomeActivity{
    private EditText filterText;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.capstone_dictionary_activity, frameLayout);
        setTitle("Dictionary");

        filterText = findViewById(R.id.editText);
        ListView itemList = findViewById(R.id.listView);

        final DbBackend dbBackend = new DbBackend(DictionaryActivity.this);
        final String[] terms = dbBackend.dictionaryWords();

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, terms);

        itemList.setAdapter(listAdapter);
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // make Toast when click
                String itemName = (String) parent.getItemAtPosition(position);
                int position_of_item = Arrays.asList(terms).indexOf(itemName);
                Toast.makeText(getApplicationContext(), "position " + (position_of_item), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DictionaryActivity.this, DictionaryActivity_Main.class);
                intent.putExtra("DICTIONARY_ID", position_of_item);
                startActivity(intent);
            }
        });

        filterText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                DictionaryActivity.this.listAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}

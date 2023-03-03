package com.example.menutype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    Button btn_menu;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Popup Menu
        btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btn_menu, Gravity.RIGHT);
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.mn_login:
                                Intent intent = new Intent(getApplicationContext(), Add.class);
                                startActivity(intent);
                                break;
                            case R.id.mn_info:
                                Intent intent1 = new Intent(getApplicationContext(), Delete.class);
                                startActivity(intent1);
                                break;
                            case R.id.mn_exit:
                                Intent intent2 = new Intent(getApplicationContext(), Edit.class);
                                startActivity(intent2);
                                break;
                        }
                        return false;
                    }
                });
            }
        });

        //Context Menu
        registerForContextMenu(btn_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Option Menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mn_add:
                Intent intent = new Intent(getApplicationContext(), Add.class);
                startActivity(intent);
                break;
            case R.id.mn_delete:
                Intent intent1 = new Intent(getApplicationContext(), Delete.class);
                startActivity(intent1);
                break;
            case R.id.mn_edit:
                Intent intent2 = new Intent(getApplicationContext(), Edit.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mn_login:
                Intent intent = new Intent(getApplicationContext(), Add.class);
                startActivity(intent);
                break;
            case R.id.mn_info:
                Intent intent1 = new Intent(getApplicationContext(), Delete.class);
                startActivity(intent1);
                break;
            case R.id.mn_exit:
                Intent intent2 = new Intent(getApplicationContext(), Edit.class);
                startActivity(intent2);
                break;
        }
        return super.onContextItemSelected(item);
    }
}

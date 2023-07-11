package com.example.hp.librarymanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by HP on 08-09-2022.
 */
public class DisplayBook_page extends AppCompatActivity {
    Spinner dept,sem;
    String usr_dept,usr_sem;
    Button search;
    SharedPrefHandler shr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaybook_page);
        dept=(Spinner)findViewById(R.id.spr_dept);
        sem=(Spinner)findViewById(R.id.spr_sem);
        shr=new SharedPrefHandler(this);
        search=(Button)findViewById(R.id.bt);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr_dept=dept.getSelectedItem().toString();
                usr_sem=sem.getSelectedItem().toString();
                shr.setSharedPreferences("dept",usr_dept);
                shr.setSharedPreferences("sem",usr_sem);
                if (usr_dept.isEmpty()||usr_sem.isEmpty()) {
                    Toast.makeText(DisplayBook_page.this, "Fill the details", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(getApplication(),Book_name_list.class);
                    startActivity(i);
                    Toast.makeText(DisplayBook_page.this, "displayed successfully"+usr_dept+usr_sem, Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}

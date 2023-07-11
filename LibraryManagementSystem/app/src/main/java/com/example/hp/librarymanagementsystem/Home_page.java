package com.example.hp.librarymanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by HP on 08-09-2022.
 */
public class Home_page extends AppCompatActivity {
    Button btn_AddBook,btn_DispBook,btn_DelBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);


        btn_AddBook=(Button)findViewById(R.id.bt1);
        btn_DispBook=(Button)findViewById(R.id.bt2);
        btn_DelBook=(Button)findViewById(R.id.bt3);
        
        btn_AddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),AddBook_page.class);
                startActivity(i);

            }
        });
        btn_DispBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),DisplayBook_page.class);
                startActivity(i);

            }
        });
        btn_DelBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),DeleteBook_page.class);
                startActivity(i);

            }
        });
        
    }
}

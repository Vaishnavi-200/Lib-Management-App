package com.example.hp.librarymanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by HP on 08-09-2022.
 */
public class Flash_page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_page);
        Thread th = new Thread(){
            @Override
            public void run() {
                super.run();{
                    try{
                        sleep(3000);
                        Intent i = new Intent(getApplication(),Home_page.class);
                        startActivity(i);
                    }
                    catch (Exception e)
                    {

                    }
                }
            }
        };
        th.start();
    }
}

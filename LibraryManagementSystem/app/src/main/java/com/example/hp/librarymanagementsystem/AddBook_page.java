package com.example.hp.librarymanagementsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 08-09-2022.
 */
public class AddBook_page extends AppCompatActivity {
    EditText bookid;
    String usr_bookid;
    EditText bookname;
    String usr_bookname;
    EditText authorname;
    String usr_authorname;
    EditText sem;
    String usr_sem;
    EditText dept;
    String usr_dept;
    EditText publishyear;
    String usr_publishyear;
    Button ADD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbook_page);
        bookid = (EditText) findViewById(R.id.et);
        bookname = (EditText) findViewById(R.id.et1);
        authorname = (EditText) findViewById(R.id.et2);
        sem = (EditText) findViewById(R.id.et3);
        dept = (EditText) findViewById(R.id.et4);
        publishyear = (EditText) findViewById(R.id.et5);
        ADD = (Button) findViewById(R.id.bt);
        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr_bookid = bookid.getText().toString();
                usr_bookname = bookname.getText().toString();
                usr_authorname = authorname.getText().toString();
                usr_sem = sem.getText().toString();
                usr_dept = dept.getText().toString();
                usr_publishyear = publishyear.getText().toString();
                if (usr_bookid.isEmpty() || usr_bookname.isEmpty() || usr_authorname.isEmpty() || usr_sem.isEmpty() || usr_dept.isEmpty() || usr_publishyear.isEmpty()) {

                    Toast.makeText(AddBook_page.this, "Enter the details", Toast.LENGTH_SHORT).show();
                } else {
                    CreateUserAccount();
                    Toast.makeText(AddBook_page.this, "Added Successfully"+"bookid"+"bookname"+"authorname"+"sem"+"dept"+"publishyear", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //This function is used to post application data to the server using post method and help of retrofit library(HTTP protocol)
    private void CreateUserAccount() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<IsExist> call = api.AddBook_page(
                usr_bookid,
                usr_bookname,
                usr_authorname,
                usr_sem,
                usr_dept,
                usr_publishyear
        );

        call.enqueue(new Callback<IsExist>() {
            @Override
            public void onResponse(Call<IsExist> call, Response<IsExist> response) {
                IsExist responseResult = response.body();

                Boolean isSuccess = false;
                if (responseResult != null) {
                    isSuccess = responseResult.getSuccess();
                }

                if (isSuccess) {

                } else {
                    // Show Creation Failed Message

                }
            }

            @Override
            public void onFailure(Call<IsExist> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
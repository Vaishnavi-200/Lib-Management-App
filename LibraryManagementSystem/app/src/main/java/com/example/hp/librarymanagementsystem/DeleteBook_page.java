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
public class DeleteBook_page extends AppCompatActivity {
    EditText Bookid;
    String usr_Bookid;
    Button Delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletebook_page);
        Bookid=(EditText)findViewById(R.id.et);
        Delete =(Button)findViewById(R.id.bt);
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr_Bookid = Bookid.getText().toString();
                if (usr_Bookid.isEmpty()) {
                    Toast.makeText(DeleteBook_page.this, "Enter Book id", Toast.LENGTH_SHORT).show();
                }
                else {
                    CreateUserAccount();
                    Toast.makeText(DeleteBook_page.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
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

        Api api= retrofit.create(Api.class);

        Call<IsExist> call = api.DeleteBook_page(
                usr_Bookid
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

package com.example.hp.librarymanagementsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 09-09-2022.
 */
public class Book_name_list extends AppCompatActivity{
    ListView list;
    SharedPrefHandler shr;
    String sem,dept;
    String[] products;
    List<Book_array> productList;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_name_list);
        list=(ListView)findViewById(R.id.lv);
        shr=new SharedPrefHandler(this);
        dept=shr.getSharedPreferences("dept");
        sem=shr.getSharedPreferences("sem");
        Toast.makeText(Book_name_list.this, "Success" + dept + sem, Toast.LENGTH_SHORT).show();
        getProductByCode(dept,sem);
    }

    private void getProductByCode(final  String dept,final String sem) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Book_array>> call = api.Booknamelist(dept, sem);

        call.enqueue(new Callback<List<Book_array>>() {
            @Override
            public void onResponse(Call<List<Book_array>> call, Response<List<Book_array>> response) {
                // List<Product> responseResult = response.body();
                productList = response.body();

                Boolean isSuccess = false;
                if(productList != null) {
                    isSuccess = true;
                }

                if(isSuccess) {

                    // responseResult.getSuccess();
                    // Update all field with result data

                    loadProductListView();

                } else {


                }
            }

            @Override
            public void onFailure(Call<List<Book_array>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }





    private void loadProductListView() {
        //Creating an String array for the ListView
        products = new String[productList.size()];



        //looping through all the products and inserting the names inside the string array
        for (int i = 0; i < productList.size(); i++) {
            products[i] = productList.get(i).getBookname();
        }

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.bookname, products);
        list.setAdapter(adapter);





    }

}

package com.example.hp.librarymanagementsystem;

/**
 * Created by HP on 09-09-2022.
 * */
 import java.util.List;

 import retrofit2.Call;
 import retrofit2.http.GET;
 import retrofit2.http.POST;
 import retrofit2.http.Query;

 public interface Api
 {
 String BASE_URL = "https://courant-conversion.000webhostapp.com/API/";


 @POST("insert_book.php")
 Call<IsExist> AddBook_page(
 @Query("f1") String usr_bookid,
 @Query("f2") String usr_bookname,
 @Query("f3") String usr_authorname,
 @Query("f4") String usr_sem,
 @Query("f5") String usr_dept,
 @Query("f6") String usr_publishyear
 );

  @POST("delete_Book.php")
  Call<IsExist> DeleteBook_page(
          @Query("f1") String usr_bookid
  );
  @GET("https://courant-conversion.000webhostapp.com/API/Book_name_list.php")
  Call<List<Book_array>> Booknamelist(@Query("f1") String dept,@Query("f2") String sem);


 }



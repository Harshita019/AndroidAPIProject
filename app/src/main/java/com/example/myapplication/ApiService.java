package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @POST("save")
    @FormUrlEncoded
    Call<dataModel> savePost(@Field("employeename") String empName,
                             @Field("email") String email,
                             @Field("password") String password);


}

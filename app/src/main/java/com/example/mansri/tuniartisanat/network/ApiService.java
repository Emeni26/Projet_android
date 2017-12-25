package com.example.mansri.tuniartisanat.network;





import com.example.mansri.tuniartisanat.entities.AccessToken;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by mansr on 11/12/2017.
 */

public interface ApiService {

    //on enverra nos données en POST sur la route register
    @POST("register")
    @FormUrlEncoded
    Call<AccessToken> register(@Field("name")String name, @Field("email")String email, @Field("password") String password);



}



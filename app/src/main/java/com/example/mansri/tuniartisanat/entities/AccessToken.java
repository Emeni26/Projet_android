package com.example.mansri.tuniartisanat.entities;

import com.squareup.moshi.Json;

/**
 * Created by mansr on 11/12/2017.
 */

public class AccessToken {

    //Récupérer tous les paramètres de Postman
    @Json(name = "token_type")
    String tokenType;


    @Json(name = "expires_in")
    int expiresIn;


    @Json(name = "access_token")
    String accessToken;

    @Json(name = "refresh_token")
    String refreshToken;


}

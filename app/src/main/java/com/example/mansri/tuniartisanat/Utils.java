package com.example.mansri.tuniartisanat;

import com.example.mansri.tuniartisanat.entities.ApiError;
import com.example.mansri.tuniartisanat.network.RetrofitBuilder;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by mansr on 13/12/2017.
 */

public class Utils {


    public static ApiError converErrors(ResponseBody response){

        Converter<ResponseBody, ApiError> converter = RetrofitBuilder.getRetrofit().responseBodyConverter(ApiError.class, new Annotation[0]);

        ApiError apiError = null;

        try {
            apiError = converter.convert(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apiError;

    }
}

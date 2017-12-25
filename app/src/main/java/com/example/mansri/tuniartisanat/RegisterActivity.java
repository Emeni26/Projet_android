package com.example.mansri.tuniartisanat;

import android.nfc.Tag;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mansri.tuniartisanat.entities.AccessToken;
import com.example.mansri.tuniartisanat.entities.ApiError;
import com.example.mansri.tuniartisanat.network.ApiService;
import com.example.mansri.tuniartisanat.network.RetrofitBuilder;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";

    @BindView(R.id.til_name)
    TextInputLayout tilName;
    @BindView(R.id.til_email)
    TextInputLayout tilEmail;
    @BindView(R.id.til_password)
    TextInputLayout tilPassword;

    ApiService service;
    Call<AccessToken> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.layout.activity_register);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        service = RetrofitBuilder.createService(ApiService.class);
    }

    @OnClick(R.id.btn_register)
    void Register() {
        String name=tilName.getEditText().getText().toString();
        String emai=tilEmail.getEditText().getText().toString();
        String password=tilName.getEditText().getText().toString();

        tilName.setError(null);
        tilEmail.setError(null);
        tilPassword.setError(null);

        call = service.register(name,emai,password);
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.isSuccessful()){

                    Log.w(TAG, "onResponse: " + response);

                }else
                {
                    handleErrors(response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                Log.w(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void handleErrors(ResponseBody response) {

        ApiError apiError = Utils.converErrors(response);

        for (Map.Entry<String, List<String>> error : apiError.getErrors().entrySet()) {
            if (error.getKey().equals("name")) {
                tilName.setError(error.getValue().get(0));
            }
            if (error.getKey().equals("email")) {
                tilEmail.setError(error.getValue().get(0));
            }
            if (error.getKey().equals("password")) {
                tilPassword.setError(error.getValue().get(0));
            }
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (call != null) {
            call.cancel();
            call = null;
        }
    }
}
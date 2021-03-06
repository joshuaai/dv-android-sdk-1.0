package androidsdk.devless.io.devlesssdkofficial;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidsdk.devless.io.devless.main.Devless;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences sp = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);


        String appUrl = "http://afterpush.herokuapp.com";
        String serviceName = "new_service";
        String devlessToken = "f9372bad91503a3d4da8824ef6e9ebe6";
        String tableName = "names";

        Map<String, Object> params = new HashMap<>();
        params.put("name", "finney");
        params.put("stage", 0);

        Devless devless = new Devless(this, appUrl, devlessToken);


        devless.addUserToken(sp);




        devless.where("name", "finney").size(2).queryData(serviceName,tableName,new Devless.SearchResponse() {
            @Override
            public void OnSuccess(String response) {
                Log.e("search response two==", response);
            }
        });

        devless.where("stage", "0").queryData(serviceName,tableName, new Devless.SearchResponse() {
            @Override
            public void OnSuccess(String response) {
                Log.e("search response all==", response);
            }
        });




        /*
        devless.getData(serviceName, tableName, new Devless.RequestResponse() {
            @Override
            public void OnSuccess(String response) {
                Log.e("Query response", response);
            }
        });


        devless.postData(serviceName, tableName, params, new Devless.RequestResponse() {
            @Override
            public void OnSuccess(String response) {
                Log.e("Messge", response);
            }
        });

        devless.edit(serviceName, tableName, params, "13", new Devless.RequestResponse() {
            @Override
            public void OnSuccess(String response) {
                Log.e("Messge13", response);
            }
        });

        devless.delete(serviceName, tableName, "13", new Devless.RequestResponse() {
            @Override
            public void OnSuccess(String response) {
                Log.e("Delete13", response);
            }
        });

        devless.deleteAll(serviceName, tableName, new Devless.RequestResponse() {
            @Override
            public void OnSuccess(String response) {
                Log.e("deletall", response);
            }
        });

        devless.logout(new Devless.LogoutResponse() {
            @Override
            public void OnLogOutSuccess(String response) {
                Log.e("Log Out", response);
            }
        });

        devless.signUpWithEmailAndPassword("meko@gmail.com", "password", sp, new Devless.SignUpResponse() {
            @Override
            public void OnSignUpSuccess(String payload) {
                //Toast your success message here
                Log.e("SignUp success", payload);
            }

            @Override
            public void OnSignUpFailed(String errorMessage) {
                Log.e("SignuPFailure", errorMessage);
            }
        });

        devless.signUpWithUsernameAndPassword("mikko", "password", sp, new Devless.SignUpResponse() {
            @Override
            public void OnSignUpSuccess(String payload) {
                Log.e("UsernamePassSignUpSucc", payload);
            }

            @Override
            public void OnSignUpFailed(String errorMessage) {
                Log.e("UnamPassSignUpFailed", errorMessage);
            }
        });


        devless.loginWithEmailAndPassword("meko@gmail.com", "password", sp, new Devless.LoginResponse() {
            @Override
            public void OnLogInSuccess(String payload) {
                Log.e("UsernamePassLogInSucc", payload);
            }

            @Override
            public void OnLogInFailed(String error) {
                Log.e("UsernamePassLoginSucc", error);
            }
        });

        devless.loginWithUsernameAndPassword("mikko", "password", sp, new Devless.LoginResponse() {
            @Override
            public void OnLogInSuccess(String payload) {
                Log.e("UsernamePassLogInSucc", payload);
            }

            @Override
            public void OnLogInFailed(String error) {
                Log.e("UsernamePassLoginSucc", error);
            }
        })
        */




    }




}

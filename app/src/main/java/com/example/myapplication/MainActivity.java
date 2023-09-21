package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    
    EditText emp_name, email, password;
    Button submit;
    private ApiService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        emp_name = findViewById(R.id.et_emp_name);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        
        submit = findViewById(R.id.bt_submit);

        mAPIService = ApiUtils.getAPIService();
        
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Working", Toast.LENGTH_SHORT).show();

                String str_empName = emp_name.getText().toString();
                String str_email = email.getText().toString();
                String str_password = password.getText().toString();

                mAPIService.savePost(str_empName, str_email, str_password).enqueue(new Callback<dataModel>() {
                    @Override
                    public void onResponse(Call<dataModel> call, Response<dataModel> response) {
                        dataModel data = response.body();
                        Log.d("Response1", "Response" + data.toString());
                        if(response.isSuccessful()){
                            Log.d("MyTag", "Succeed"+data);
                        }
                    }

                    @Override
                    public void onFailure(Call<dataModel> call, Throwable t) {
                        Log.d("MyTag", t.getMessage());
                        Toast.makeText(MainActivity.this, "onFailure"+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
package com.example.saran.jsoninserting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b;
    String url = "https://zerocostforall.000webhostapp.com/php/insert.php";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        e4 = (EditText) findViewById(R.id.editText4);

        b = (Button)findViewById(R.id.button);

        requestQueue = Volley.newRequestQueue(MainActivity.this);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(MainActivity.this, "success"+response, Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, "error"+error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }




                )
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String, String>();
                        String name = e1.getText().toString();
                        String email = e2.getText().toString();
                        String gender = e3.getText().toString();
                        String password = e4.getText().toString();

                        params . put("name",name);
                        params . put("email",email);
                        params . put("gender",gender);
                        params . put("password",password);
                        return params;




                    }
                };

            requestQueue.add(stringRequest);
            }
        });





    }
}

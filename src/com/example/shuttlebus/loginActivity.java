package com.example.shuttlebus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class loginActivity extends Activity {
	Button loginButton = null;
	EditText userName = null;
	EditText password = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		loginButton = (Button) this.findViewById(R.id.btn_login);
		userName = (EditText) this.findViewById(R.id.et_zhanghao);
		password = (EditText) this.findViewById(R.id.et_mima);
		loginButton.setOnClickListener(new OnClickListener(){  
  
            public void onClick(View arg0) {  
                String  username=userName.getText().toString();  
                String  pwd=password.getText().toString();  
                if(username.equals("123")&&pwd.equals("123")){  
                 //密码确认  
                Intent intent=new Intent(loginActivity.this,RoutActivity.class);  
                startActivity(intent);}  
            }  
              
        }); 
	}
	
}

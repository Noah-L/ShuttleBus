package com.example.shuttlebus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.oocl.shuttlebus.common.SharePreferenceHelper;
import com.oocl.shuttlebus.model.User;

public class LoginActivity extends Activity {
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
                 if("".equals(username) || "".equals(pwd)){
                 	Toast.makeText(getApplicationContext(), "请输入用户名和密码", 2).show();
                 }else{
                 	User user = new User();
                 	user.setPassword(password.getText().toString());
                 	user.setUserName(userName.getText().toString());
                 	SharePreferenceHelper.saveUser(getApplicationContext(), user);
                 	Intent intent=new Intent(LoginActivity.this,IndexActivity.class);  
                     startActivity(intent);
                 }  
            }  
              
        }); 
	}
	
}

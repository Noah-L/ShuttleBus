package com.example.shuttlebus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class IndexActivity extends Activity {
	Button bookDutyRoute = null;
	Button bookOffDutyRoute = null;
	Button checkMyTicket = null;
	Button routeStatistics = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);
		bookDutyRoute = (Button) this.findViewById(R.id.bookDutyRoute);
		bookOffDutyRoute = (Button) this.findViewById(R.id.bookOffDutyRoute);
		checkMyTicket = (Button) this.findViewById(R.id.checkMyTicket);
		routeStatistics = (Button) this.findViewById(R.id.routeStatistics);
		
		bookDutyRoute.setOnClickListener(new OnClickListener(){  
  
            public void onClick(View arg0) {  
                Intent intent=new Intent(IndexActivity.this,RouteActivity.class);  
                Bundle bundle = new Bundle();
    			bundle.putString("routeType", "上班");
    			intent.putExtras(bundle);
                startActivity(intent);
            }  
              
        }); 
		bookOffDutyRoute.setOnClickListener(new OnClickListener(){  
  
            public void onClick(View arg0) {  
                Intent intent=new Intent(IndexActivity.this,RouteActivity.class);  
                Bundle bundle = new Bundle();
    			bundle.putString("routeType", "下班");
    			intent.putExtras(bundle);
                startActivity(intent);
            }  
              
        }); 
		checkMyTicket.setOnClickListener(new OnClickListener(){  
  
            public void onClick(View arg0) {  
             //   Intent intent=new Intent(IndexActivity.this,RoutActivity.class);  
             //   startActivity(intent);
            }  
              
        }); 
		routeStatistics.setOnClickListener(new OnClickListener(){  
  
            public void onClick(View arg0) {  
            	Toast.makeText(getApplicationContext(), "shuttle bus的统计信息已经发到您的邮箱.", 2).show();
            }  
              
        }); 
	}
	
}

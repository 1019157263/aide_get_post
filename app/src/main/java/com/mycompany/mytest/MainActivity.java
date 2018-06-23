package com.mycompany.mytest;

import android.app.*;
import android.os.*;
import android.view.*;
import com.squareup.okhttp.*;
import java.io.*;
import android.widget.*;

public class MainActivity extends Activity 
{  
    View text;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
    }

	public void onCookiesButtonClick(View view) 
    {
		final TextView text = (TextView) findViewById(R.id.mainTextView1);
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				
				String url="http://www.xuehuai.wang:8888/time";
				OkHttpClient client=new OkHttpClient();
				Request req= new Request.Builder()
				         .url(url)
						 .get()
						 .build();
						 
				   try{
					   Response response=client.newCall(req).execute();
					   final String str=response.body().string();
					   runOnUiThread(new Runnable(){
						   @Override
						   public void run() {
							   text.setText(str);
							   
						   }
					   });
				   }catch (IOException e)
				   {}
			}		
			
		}).start();				
        }
		
	public void onnosButtonClick(View view) 
    {
		final TextView text1 = (TextView) findViewById(R.id.mainEditText1);
		
		new Thread(new Runnable(){
				@Override
				public void run() {

					String url="http://www.xuehuai.wang:8888/time";
					OkHttpClient client=new OkHttpClient();
					Request req= new Request.Builder()
						.url(url)
						.get()
						.build();

					try{
						Response response=client.newCall(req).execute();
						final String str=response.body().string();
						runOnUiThread(new Runnable(){
								@Override
								public void run() {
									text1.setText(str);

								}
							});
					}catch (IOException e)
					{}
				}		

			}).start();				
		

	}
	public void onYesButtonClick(View view) 
    {
	
		
		final TextView text1 = (TextView) findViewById(R.id.mainEditText1);

		new Thread(new Runnable(){
				@Override
				public void run() {

					String url="http://127.0.0.1:8888/admin";
					OkHttpClient client=new OkHttpClient();
					RequestBody formBody = new FormEncodingBuilder()
						.add("username", "admin")
						.add("pwd", "root")
						.build();
					Request req= new Request.Builder()
						.url(url)
						.post(formBody)
						.build();

					try{
						Response response=client.newCall(req).execute();
						final String str=response.body().string();
						runOnUiThread(new Runnable(){
								@Override
								public void run() {
									text1.setText(str);

								}
							});
					}catch (IOException e)
					{
						//这里到下面为异常处理
						//如果异常就set一xxx
						//如果不异常就set一个网站源码
						runOnUiThread(new Runnable(){
								@Override
								public void run() {
									text1.setText("未知错误");

								}
							});
							//到这里
					}
				}		

			}).start();				
		
		
		
		
		
		
}	
		
}
    



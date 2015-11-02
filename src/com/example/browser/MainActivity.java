package com.example.browser;



import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private WebView webView;
	Button home;
	Button go;
	String url_text;
	String url_head = "http://";
	EditText url;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    
    {
    	// 隐藏标题栏.
    			requestWindowFeature(Window.FEATURE_NO_TITLE);		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      //////////////
        //找到view中home id
        home=(Button)findViewById(R.id.home);
        //设置home button的点击事件
        home.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		webView.loadUrl(" http://shaodalovewall.sinaapp.com/w/");
				
			}
		});
       /////////// 
        //找到go 按钮的id
        //找到edit 按钮的id
        go=(Button)findViewById(R.id.go);
        url=(EditText)findViewById(R.id.urltext);
        //设置 button的点击事件
        go.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			url_text=url.getText().toString();
			if(!url_text.contains("http://")){
				url_text=url_head.concat(url_text);	
			}
			//这里修改增加.com
			webView.loadUrl(url_text+".com");
		
				
			}
		});
        
        
        /////////// 
        webView = (WebView) findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				
				view.loadUrl(url);
			
				return true;
			}
		});
		webView.loadUrl("http://m.hao123.com");
    
    }

    
    
    
    
//返回键的处理:我们打开多个网页后,点击返回目的是返回上一个网页,
    //但是事实上会关闭当前activity,于是要对返回键做处理
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {  
            webView.goBack();  
            return true;  
        } else  
            return super.onKeyDown(keyCode, event);  
    }  
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        getMenuInflater().inflate(R.menu.first, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.add_item:
    	Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
    	break;
    	case R.id.close:
    		//退出app
    		finish();
    	//Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
    	break;
    	default:
    	}
    	return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}





    
}

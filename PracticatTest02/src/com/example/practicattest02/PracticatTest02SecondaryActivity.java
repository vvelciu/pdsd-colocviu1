package com.example.practicattest02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticatTest02SecondaryActivity extends Activity {
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	
	private class ButtonClickListener implements Button.OnClickListener {
	 
	    @Override
	    public void onClick(View view) {
	      switch(view.getId()) {
	        case R.id.button1:
	          setResult(RESULT_OK, new Intent());
	          finish();
	          break;
	        case R.id.button2:
	          setResult(RESULT_CANCELED, new Intent());
	          finish();
	          break;
	      }
	    }
	  }  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practicat_test02_secondary);
		
		TextView numberOfClicksTextView = (TextView)findViewById(R.id.editText1);
		 
		    Intent intent = getIntent();
		    if (intent != null) {
		      String numberOfClicks = intent.getStringExtra("number_of_clicks");
		      if (numberOfClicks != null) {
		        numberOfClicksTextView.setText(numberOfClicks);
		      }
		    }
		    
		 Button buttonOk = (Button)findViewById(R.id.button1);
		    buttonOk.setOnClickListener(buttonClickListener);
		    Button buttonCancel = (Button)findViewById(R.id.button2);
		    buttonCancel.setOnClickListener(buttonClickListener);      
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practicat_test02_secondary, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

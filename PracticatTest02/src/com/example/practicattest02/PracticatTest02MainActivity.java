package com.example.practicattest02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticatTest02MainActivity extends Activity {
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	
	int leftClick = 0;
	int rightClick = 0;
	 @Override
	  public void onActivityResult(int requestCode, int resultCode, Intent intent) { 
	    Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
	  }
	 
	private class ButtonClickListener implements Button.OnClickListener {
	 
	    @Override
	    public void onClick(View view) {
	      
	      switch(view.getId()) {
	        case R.id.button1:
	          //Navigate
	        	 Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest02SecondaryActivity");
	        	 intent.putExtra("number_of_clicks", (leftClick + rightClick) + "");
	        	 startActivityForResult(intent, 1);
	          break;
	        default:
	        	EditText txt = (EditText)findViewById(R.id.editText1);
	        	Button btn = (Button) view;
	        	txt.append(btn.getText());
	        	txt.append(",");
	        	break;
	      }
	      
	      switch(view.getId()) {
	        case R.id.button4:
	          leftClick++;
	          break;
	        case R.id.button6:
		          rightClick++;
		          break;
	        default:
	        	break;
	      }
	    }
	  } 
	
	@Override
	  protected void onSaveInstanceState(Bundle savedInstanceState) {
	    savedInstanceState.putString("leftCount", leftClick + "");
	    savedInstanceState.putString("rightCount", rightClick + "");
	  }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practicat_test02_main);
		
		if (savedInstanceState != null) {
		      String leftCount = savedInstanceState.getString("leftCount");
		      String rightCount = savedInstanceState.getString("rightCount");
		      
		      if(leftCount != null)
		    	  leftClick = Integer.parseInt(leftCount);
		      if(rightCount != null)
		    	  rightClick = Integer.parseInt(rightCount);
		}
		
		Toast.makeText(this, "Top left: " + leftClick + "; Top right " + rightClick, Toast.LENGTH_LONG).show();
		
		Button btn1 = (Button) findViewById(R.id.button1);
		btn1.setOnClickListener(buttonClickListener);
		Button btn2 = (Button) findViewById(R.id.button2);
		btn2.setOnClickListener(buttonClickListener);
		Button btn3 = (Button) findViewById(R.id.button3);
		btn3.setOnClickListener(buttonClickListener);
		Button btn4 = (Button) findViewById(R.id.button4);
		btn4.setOnClickListener(buttonClickListener);
		Button btn5 = (Button) findViewById(R.id.button5);
		btn5.setOnClickListener(buttonClickListener);
		Button btn6 = (Button) findViewById(R.id.button6);
		btn6.setOnClickListener(buttonClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practicat_test02_main, menu);
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

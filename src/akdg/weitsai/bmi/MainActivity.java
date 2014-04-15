package akdg.weitsai.bmi;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText editHeight, editWidth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 findViews();
	}

	private void findViews() {
		editHeight = (EditText) findViewById(R.id.edit_height);
		editWidth = (EditText) findViewById(R.id.edit_width);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void submit(View v) {
		 String height = editHeight.getText().toString();
		 String width = editWidth.getText().toString();
		 if ("".equals(height) | "".equals(width)) {
		 showEditNullToast();
		 }
	}

	private void showEditNullToast() {
		Toast.makeText(this, "請輸入身高和體重", Toast.LENGTH_SHORT).show();
	}

}

package akdg.weitsai.bmi;

import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText editHeight, editWidth;
	private TextView result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViews();
	}

	private void findViews() {
		editHeight = (EditText) findViewById(R.id.edit_height);
		editWidth = (EditText) findViewById(R.id.edit_width);
		result = (TextView) findViewById(R.id.result);
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
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		double bmi = bmi(height, width);
		String bmiStr = nf.format(bmi);
		result.setText(bmiStr);
	}

	private void showEditNullToast() {
		Toast.makeText(this, "請輸入身高和體重", Toast.LENGTH_SHORT).show();
	}

	/**
	 * 
	 * @param height
	 * @param width
	 * @return
	 */
	private double bmi(String height, String width) {
		double h = Double.parseDouble(height);
		double w = Double.parseDouble(width);
		return bmi(h, w);
	}

	/**
	 * 
	 * @param height
	 * @param width
	 * @return
	 */
	private double bmi(double height, double width) {
		double bmi = (width / Math.pow(height, 2)) * 10000;
		return bmi;
	}

}

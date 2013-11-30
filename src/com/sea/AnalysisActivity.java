package com.sea;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.GridView;

public class AnalysisActivity extends Activity {

	private Button fromDate;
	private Button toDate;
	private Button go;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnFromButton();
		addListenerOnToButton();
		addListenerOnGoButton();
	}

	private void addListenerOnGoButton() {
		go = (Button) findViewById(R.id.go);

		go.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				final String[] numbers = new String[] { "A", "B", "C", "D",
						"E", "F", };

				GridView gridHeader = (GridView) findViewById(R.id.gridHeader);

				ArrayAdapter<String> adapter = new ArrayAdapter<String>(
						AnalysisActivity.this,
						android.R.layout.simple_list_item_1, numbers);

				gridHeader.setAdapter(adapter);

				final String[] data = new String[] { "A", "B", "C", "D", "E",
						"F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
						"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

				GridView gridView = (GridView) findViewById(R.id.gridView);

				ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
						AnalysisActivity.this,
						android.R.layout.simple_list_item_1, data);

				gridView.setAdapter(adapter1);

			}

		});

	}

	private void addListenerOnToButton() {
		toDate = (Button) findViewById(R.id.toDate);

		toDate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Calendar calender = Calendar.getInstance();
				Dialog mDialog = new DatePickerDialog(AnalysisActivity.this,
						toDateListener, calender.get(Calendar.YEAR), calender
								.get(Calendar.MONTH), calender
								.get(Calendar.DAY_OF_MONTH));

				mDialog.show();
			}

		});

	}

	private void addListenerOnFromButton() {
		fromDate = (Button) findViewById(R.id.fromDate);

		fromDate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Calendar calender = Calendar.getInstance();
				Dialog mDialog = new DatePickerDialog(AnalysisActivity.this,
						fromDateListener, calender.get(Calendar.YEAR), calender
								.get(Calendar.MONTH), calender
								.get(Calendar.DAY_OF_MONTH));

				mDialog.show();
			}

		});

	}

	private DatePickerDialog.OnDateSetListener fromDateListener = new OnDateSetListener() {

		public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
			arg2 = arg2 + 1;

			String my_date = arg1 + "-" + arg2 + "-" + arg3;

			fromDate.setText(my_date);
		}
	};

	private DatePickerDialog.OnDateSetListener toDateListener = new OnDateSetListener() {

		public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
			arg2 = arg2 + 1;

			String my_date = arg1 + "-" + arg2 + "-" + arg3;

			toDate.setText(my_date);
		}
	};

}

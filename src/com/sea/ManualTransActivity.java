package com.sea;

import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class ManualTransActivity extends Activity {

	private Button transactionDate;
	private Button okButton;
	private Button cancelButton;
	private Dialog dialog;
	private DatePicker datePicker;
	private TimePicker timePicker;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manual_transaction);
		dialog = new Dialog(ManualTransActivity.this);
		dialog.setCancelable(true);
		dialog.setContentView(R.layout.custom_date_picker);
		dialog.setTitle("Custom Dialog");
		datePicker = (DatePicker) dialog.findViewById(R.id.datePicker1);
		timePicker = (TimePicker) dialog.findViewById(R.id.timePicker1);

		transactionDate = (Button) findViewById(R.id.TransDate);
		transactionDate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				setCurrentDateTimeOnView();
				dialog.show();
			}
		});

		okButton = (Button) dialog.findViewById(R.id.okButton);
		okButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				int day = datePicker.getDayOfMonth();
				int month = datePicker.getMonth() + 1;
				int year = datePicker.getYear();
				int hrs = timePicker.getCurrentHour();
				int min = timePicker.getCurrentMinute();

				transactionDate.setText(day + "-" + month + "-" + year + " "
						+ hrs + ":" + min);
				dialog.hide();
			}
		});

		cancelButton = (Button) dialog.findViewById(R.id.cancelButton);
		cancelButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				dialog.hide();
			}
		});

	}

	// display current date
	public void setCurrentDateTimeOnView() {

		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);

		// set current date into datepicker
		datePicker.init(year, month, day, null);

		// set current time into timepicker
		timePicker.setCurrentHour(hour);
		timePicker.setCurrentMinute(minute);

	}

}
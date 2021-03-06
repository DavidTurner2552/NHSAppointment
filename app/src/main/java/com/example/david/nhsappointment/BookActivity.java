package com.example.david.nhsappointment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton home_button;
    private ImageButton profile_button;
    private Button book_button;
    private CalendarView calender;
    private ListView lv;
    private String timeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        home_button = (ImageButton) findViewById(R.id.home_button);
        home_button.setOnClickListener(this);
        profile_button = (ImageButton) findViewById(R.id.profile_button);
        profile_button.setOnClickListener(this);
        book_button = (Button) findViewById(R.id.book_button);
        book_button.setOnClickListener(this);

        calender = (CalendarView) findViewById(R.id.calenderA);
        calender.setDate(1520676000000L);
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
                Toast.makeText(getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
            }
        });
        lv = (ListView) findViewById(R.id.listofTimes);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                Variables.availableTimes );

        lv.setAdapter(arrayAdapter);
        lv.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
               // timeText = lv.getAdapter().getItem();
                return false;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                timeText = lv.getItemAtPosition(i).toString();
            }
        });
        setListViewHeightBasedOnChildren(lv);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.home_button) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.profile_button) {
            Intent i = new Intent(this, ProfilePage.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.book_button){
            String timeToRemove = timeText;
            boolean found = false;
            int loc = 0;
            for (String element : Variables.availableTimes) {
                if (timeToRemove.equals(element)) {
                    found = true;
                    Toast.makeText(BookActivity.this, "Your appointment has been booked for" + timeToRemove, Toast.LENGTH_SHORT).show();
                    Variables.bookedTimes.add(timeToRemove);
                    break;
                }
                loc++;
            }
            if (!found) {
                Toast.makeText(BookActivity.this, "Please select a date before pressing book", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}

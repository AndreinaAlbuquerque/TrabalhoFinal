package codewithcal.au.calendarappexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalTime;

public class EventEditActivity extends AppCompatActivity {


    private EditText eventNameET;

    private EditText eventServET;
    private TextView eventDateTV,eventTimeTV;

    private LocalTime time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        iniWigets();
        time = LocalTime.now();
        eventDateTV.setText("Data: "+ CalendarUtils.formateDate(CalendarUtils.selectedDate));
        eventTimeTV.setText("Hora: "+ CalendarUtils.formateTime(time));
    }

    private void iniWigets() {
        eventNameET = findViewById(R.id.eventNameET);
        eventServET = findViewById(R.id.eventServET);
        eventDateTV = findViewById(R.id.eventDateTV);
        eventTimeTV = findViewById(R.id.eventTimeTV);
    }

    public void saveEventAction(View view) {
        String eventName  = eventNameET.getText().toString();
        String eventServ = eventServET.getText().toString();
        Event newEvent = new Event(eventName,eventServ,CalendarUtils.selectedDate, time);
        Event.eventsList.add(newEvent);
        finish();
    }
}
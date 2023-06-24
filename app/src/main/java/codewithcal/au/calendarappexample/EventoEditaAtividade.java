package codewithcal.au.calendarappexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalTime;

public class EventoEditaAtividade extends AppCompatActivity {


    private EditText eventNameET;

    private EditText eventServET;

    private EditText eventHoraET;
    private TextView eventDateTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atividade_evento_edita);
        iniWigets();
        eventDateTV.setText("Data: "+ UtilizcaoCalendario.formateDate(UtilizcaoCalendario.selectedDate));
        }

    private void iniWigets() {
        eventNameET = findViewById(R.id.eventNameET);
        eventServET = findViewById(R.id.eventServET);
        eventDateTV = findViewById(R.id.eventDateTV);
        eventHoraET = findViewById(R.id.eventHoraET);
    }

    public void saveEventAction(View view) {
        String eventName  = eventNameET.getText().toString();
        String eventServ = eventServET.getText().toString();
        String eventHora = eventHoraET.getText().toString();
        Evento newEvento = new Evento(eventName,eventServ,UtilizcaoCalendario.selectedDate,eventHora);
        Evento.eventsList.add(newEvento);
        finish();
    }
}
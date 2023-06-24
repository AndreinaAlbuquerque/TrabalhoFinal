package codewithcal.au.calendarappexample;

import static codewithcal.au.calendarappexample.UtilizcaoCalendario.daysInWeekArray;
import static codewithcal.au.calendarappexample.UtilizcaoCalendario.monthYearFromDate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;

public class VizualizarAtividadeSemana extends AppCompatActivity implements AdaptarCalendario.OnItemListener{

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private ListView eventListView;


    
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aividade_semana_vizualizaca);
        initWidgets();
        setWeekView();
    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
        eventListView = findViewById(R.id.eventListView);
    }

    private void setWeekView()
    {
        monthYearText.setText(monthYearFromDate(UtilizcaoCalendario.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(UtilizcaoCalendario.selectedDate);

        AdaptarCalendario adaptarCalendario = new AdaptarCalendario(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(adaptarCalendario);
        setEvetAdpater();
    }



    public void previousWeekAction(View view) {
        UtilizcaoCalendario.selectedDate = UtilizcaoCalendario.selectedDate.minusWeeks(1);
        setWeekView();
    }

    public void nextWeekAction(View view) {
        UtilizcaoCalendario.selectedDate = UtilizcaoCalendario.selectedDate.plusWeeks(1);
        setWeekView();
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {

            UtilizcaoCalendario.selectedDate = date;
            setWeekView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setEvetAdpater();
    }

    private void setEvetAdpater() {
        ArrayList<Evento> dailyEventos = Evento.eventsForDate(UtilizcaoCalendario.selectedDate);
        AdaptarEvento adaptarEvento = new AdaptarEvento(getApplicationContext(), dailyEventos);
        eventListView.setAdapter(adaptarEvento);
    }

    public void newEventAction(View view) {

    startActivity(new Intent(this, EventoEditaAtividade.class));

    }
}
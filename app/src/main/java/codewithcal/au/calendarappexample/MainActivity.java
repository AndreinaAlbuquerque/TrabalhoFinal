package codewithcal.au.calendarappexample;

import static codewithcal.au.calendarappexample.UtilizcaoCalendario.daysInMonthArray;
import static codewithcal.au.calendarappexample.UtilizcaoCalendario.monthYearFromDate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptarCalendario.OnItemListener
{
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private LocalDate selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        UtilizcaoCalendario.selectedDate = LocalDate.now();
        setMonthView();
    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
    }

    private void setMonthView()
    {
        monthYearText.setText(monthYearFromDate(UtilizcaoCalendario.selectedDate));
        ArrayList<LocalDate> daysInMonth = daysInMonthArray(UtilizcaoCalendario.selectedDate);

        AdaptarCalendario adaptarCalendario = new AdaptarCalendario(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(adaptarCalendario);
    }



    public void previousMonthAction(View view)
    {
        UtilizcaoCalendario.selectedDate = UtilizcaoCalendario.selectedDate.minusMonths(1);
        setMonthView();
    }

    public void nextMonthAction(View view)
    {
        UtilizcaoCalendario.selectedDate = UtilizcaoCalendario.selectedDate.plusMonths(1);
        setMonthView();
    }



    @Override
    public void onItemClick(int position, LocalDate date)
    {

        if(date != null) {

            UtilizcaoCalendario.selectedDate = date;
            setMonthView();
        }
    }

public void weeklyAction(View view){
    startActivity(new Intent(this, VizualizarAtividadeSemana.class));

}


}









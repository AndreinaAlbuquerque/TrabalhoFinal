package codewithcal.au.calendarappexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdaptarEvento extends ArrayAdapter<Evento> {


    public AdaptarEvento(@NonNull Context context, List<Evento> eventos) {
        super(context, 0, eventos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Evento evento = getItem(position);

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.evento_cell,parent,false);

        TextView eventCellTV = convertView.findViewById(R.id.eventCellTV);

        String eventTitle = evento.getName() + " " + evento.getServico() + " "+ evento.getHora();
        eventCellTV.setText(eventTitle);
        return convertView;
    }
}

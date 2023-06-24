package codewithcal.au.calendarappexample;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Evento {

    public static ArrayList<Evento> eventsList = new ArrayList<>();

    public static ArrayList<Evento> eventsForDate(LocalDate date){
        ArrayList<Evento> eventos = new ArrayList<>();
        for(Evento evento : eventsList){
            if(evento.getDate().equals(date))
                eventos.add(evento);
        }

        return eventos;
    }



    private String name,servico,hora;

    private LocalDate date;

    public Evento(String name, String servico, LocalDate date, String hora) {
        this.name = name;
        this.servico = servico;
        this.date = date;
        this.hora = hora;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}

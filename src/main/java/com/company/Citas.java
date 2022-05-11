package com.company;

import java.util.Date;

public class Citas {
    int id;
    Date fechaCita;
    int idDoctor;
    int idPaciente;
    String motivoCita;

    public Citas (Date fecha, int doctorId, int pacienteId, String motivo){
        fechaCita = fecha;
        idDoctor = doctorId;
        idPaciente = pacienteId;
        motivoCita = motivo;


    }
}
package com.company;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        
        String path = System.getProperty("user.dir");
        path=(new StringBuilder()).append(path).append("\\db").toString();
        
        String outputDoctores = (new StringBuilder()).append(path).append("\\Doctores.csv").toString();
        String outputPacientes = (new StringBuilder()).append(path).append("\\Pacientes.csv").toString();
        String outputCitas = (new StringBuilder()).append(path).append("\\Citas.csv").toString();

        BufferedWriter bwDoc = new BufferedWriter(new FileWriter(outputDoctores, true));
        BufferedWriter bwPac = new BufferedWriter(new FileWriter(outputPacientes, true));
        BufferedWriter bwCitas = new BufferedWriter(new FileWriter(outputCitas, true));
        String line;
        Scanner in = new Scanner(System.in);

        boolean seguir = true;
        
        while (seguir) {
            System.out.println("¿Qué proceso deseas realizar? \n Presiona D para dar de alta a un doctor nuevo \n Presiona P para dar de alta a un paciente nuevo\n Presiona C para agendar una cita nueva");

            line = in.next();
            if (line.equalsIgnoreCase("D")) {
                System.out.print("Ingresa el nombre del doctor\n");
                String nombreDoctor = in.next();
                System.out.print("Ingresa la especialidad del doctor\n");
                String especialidadDoctor = in.next();
                System.out.print("Ingresa el ID del doctor\n");
                String idDoctor = in.next();
                Doctor doctorInfo = new Doctor(Integer.parseInt(idDoctor), nombreDoctor, especialidadDoctor);
                creaDoctor(doctorInfo, bwDoc);
            } else if (line.equalsIgnoreCase("P")) {
                System.out.print("Ingresa el nombre del paciente\n");
                String nombrePaciente = in.next();
                System.out.print("Ingresa el id del paciente\n");
                String idPaciente = in.next();
                Pacientes pacienteInfo = new Pacientes(Integer.parseInt(idPaciente), nombrePaciente);
                creaPaciente(pacienteInfo, bwPac);

            } else if (line.equalsIgnoreCase("C")) {
                System.out.print("Ingresa la fecha de tu cita\n");
                String fechaCitaString = in.next();
                Date fechaCita = new SimpleDateFormat("dd/MM/yyyy").parse(fechaCitaString);
                System.out.print("Ingresa el motivo de tu cita\n");
                in.nextLine();
                String motivoCita = in.nextLine();
                System.out.print("Ingresa el id del doctor\n");
                String idDoctor = in.next();
                System.out.print("Ingresa el id del paciente\n");
                String idPaciente = in.next();
                Citas citaInfo = new Citas(fechaCita, Integer.parseInt(idDoctor), Integer.parseInt(idPaciente), motivoCita);
                creaCita(citaInfo, bwCitas);

            } else {
                System.out.print("selecciona una de las opciones disponibles");
            }

            System.out.println("¿Quieres realizar otro proces? \n Y \t N");
            line = in.next();

            if (line.equalsIgnoreCase("y")) {
                seguir = true;
            } else if (line.equalsIgnoreCase("n")) {
                seguir = false;
            }
        }
    }

    public static void creaDoctor(Doctor doctorInfo, BufferedWriter bw) throws IOException {
        bw.write(doctorInfo.id);
        bw.write(",");
        bw.write(doctorInfo.nombreDoctor);
        bw.write(",");
        bw.write(doctorInfo.esp);
        bw.write("\n");
        bw.close();

    }

    public static void creaPaciente(Pacientes pacienteInfo, BufferedWriter bw) throws IOException {
        bw.write(pacienteInfo.id);
        bw.write(",");
        bw.write(pacienteInfo.nombrePaciente);
        bw.write("\n");
        bw.close();

    }

    public static void creaCita(Citas citaInfo, BufferedWriter bw) throws IOException {
        bw.write(citaInfo.id);
        bw.write(",");
        bw.write(citaInfo.fechaCita.toString());
        bw.write(",");
        bw.write(citaInfo.motivoCita);
        bw.write(",");
        bw.write(citaInfo.idDoctor);
        bw.write(",");
        bw.write(citaInfo.idPaciente);
        bw.write("\n");
        bw.close();

    }
}

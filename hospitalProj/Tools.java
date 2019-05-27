import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Tools {




    static public Floor[] floor = new Floor[2];
    static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    static ArrayList<Nurse> nurses = new ArrayList<Nurse>();



    Bed b = new Bed();

public static void creatTest (){
    floor[0]=new Floor();
    for (int i=0 ; i<6 ; i++){
        floor[0].eroom[i] = new Emergency();
    }
    floor[1] = new Floor();
    for (int i=0 ; i<3 ; i++){
        floor[1].icuroom[i] = new IntensiveCare();
        floor[1].sroom[i] = new Streise();
    }

    /////////////for personnel





}

    String patientfile = "PatientFile.txt",personnelfile = "PersonnelFile.txt";


    public void creatFile () throws Exception{

        File file1 = new File(patientfile);
        File file2 = new File(personnelfile);
        if (file1.createNewFile()) {
            System.out.println("file1 created...");
        }
        else
            System.out.println("File1 already exists.");

        if (file2.createNewFile()) {
            System.out.println("file1 created...");
        }
        else
            System.out.println("File1 already exists.");
    }

    /////////////for read


    public void read() throws Exception {
        Scanner scpatientfile = new Scanner(new File(patientfile));
        Scanner scpersonnelfile = new Scanner(new File(personnelfile));


        while (scpatientfile.hasNext()) {
            String sfile = scpatientfile.next();
            StringTokenizer st = new StringTokenizer(sfile,"_");


            int roomnumber ;
            String roomtype = st.nextToken();

            if (roomtype.equals("1")) {
                Bed b = new Bed();
                roomnumber = Integer.parseInt(st.nextToken());
                b.getPatient(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),roomnumber);
                floor[0].eroom[roomnumber].beds.add(b);
            }
            else if(roomtype.equals("2")){
                Bed b = new Bed();
                roomnumber = Integer.parseInt(st.nextToken());
                b.getPatient(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),roomnumber);
                floor[1].icuroom[roomnumber].beds.add(b);
            }
            else{
                Bed b = new Bed();
                roomnumber = Integer.parseInt(st.nextToken());
                b.getPatient(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),roomnumber);
                floor[1].sroom[roomnumber].beds.add(b);
            }


        }

        while (scpersonnelfile.hasNext()){
            String sfile = scpersonnelfile.next();
            StringTokenizer st = new StringTokenizer(sfile,"_");

            if(st.nextToken().equals("1")){
                doctors.add(new Doctor(st.nextToken(),st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken())));
            }
            else{
                nurses.add(new Nurse(st.nextToken(),st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken())));
            }
        }

    }







/////////////////for save
    public void savePatientToFile () throws IOException {
        FileWriter writer = new FileWriter(patientfile);
        BufferedWriter buffer = new BufferedWriter(writer);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < floor[0].eroom[i].beds.size(); j++) {
                buffer.write("1" + floor[0].eroom[i].beds.get(j).patient.saveToFile());
                buffer.newLine();
            }

        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < floor[1].icuroom[i].beds.size(); j++) {
                buffer.write("2" + floor[1].icuroom[i].beds.get(j).patient.saveToFile());
                buffer.newLine();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < floor[1].sroom[i].beds.size(); j++) {
                buffer.write("3" + floor[1].sroom[i].beds.get(j).patient.saveToFile());
                buffer.newLine();
            }
        }
        buffer.close();
        writer.close();
    }


    public void savePersonnelToFile () throws IOException {
        FileWriter writer = new FileWriter(personnelfile);
        BufferedWriter buffer = new BufferedWriter(writer);

        for(int i = 0 ; i <doctors.size() ; i++) {
            buffer.write(doctors.get(i).saveToFile());
            buffer.newLine();
        }
        for(int i = 0 ; i < nurses.size() ; i++) {
            buffer.write(nurses.get(i).saveToFile());
            buffer.newLine();
        }
        buffer.close();
        writer.close();
    }



}

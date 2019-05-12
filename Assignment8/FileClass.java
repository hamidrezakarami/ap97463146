import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


    public class FileClass {
        String filename = "file.txt";


        public void creatFile () throws Exception{

            File file = new File(filename);
            if (file.createNewFile()) {
                System.out.println("file created...");
            }
            else
                System.out.println("File already exists.");
        }






        public ArrayList<Student> read() throws Exception {
            ArrayList<Student> students = new ArrayList<Student>();
            Scanner scfile = new Scanner(new File(filename));



            for (int i = 0;scfile.hasNext();i++) {
            String sfile = scfile.next();
            StringTokenizer st = new StringTokenizer(sfile,"_");


                if (st.nextToken().equals("0")) {
                    students.add(new Graduated());
                }
                else{
                    students.add(new Studying());
                }
                students.get(i).setName(st.nextToken());
                students.get(i).setFname(st.nextToken());
                students.get(i).setStudentid(Long.parseLong(st.nextToken()));
                students.get(i).setEntering_year(Integer.parseInt(st.nextToken()));
                students.get(i).set(Integer.parseInt(st.nextToken()));
                }
            return students;
        }







        public void saveToFile(ArrayList<Student> s) throws Exception{

            FileWriter writer = new FileWriter(filename);
            BufferedWriter buffer = new BufferedWriter(writer);

            for ( int i = 0 ; i < s.size() ; i++){

                buffer.write(s.get(i).sendToFile());
                buffer.newLine();
            }
            buffer.close();
            writer.close();
            System.out.println("SUCCSSFULLY SAVED!");
        }

    }







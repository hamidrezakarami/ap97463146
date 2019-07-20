package Project;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileClass {


    public String filename = "Project.txt";

    public void creatFile() throws IOException {
        File file = new File(filename);
        if (file.createNewFile()) {
            System.out.println("file1 created...");
        } else
            System.out.println("File1 already exists.");

    }

    public void saveToFile() {
        try {
            Main m = new Main();

            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            /*
            first line for manager
            0 at first for studentlist in main
            3_i_0 at first for courses in student

            1 at first for teacherlist in main
            4_i_1 at first for courses in teacher

            2 for corselist in main
            khat baadi teacher in corseslist
            5_i_0 for studentlist in corse

            */
            bw.write(m.manager.saveToFile());
            bw.newLine();
            for (int i = 0; i < m.studentlist.size(); i++) {
                bw.write(m.studentlist.get(i).saveToFile());
                bw.newLine();
                for (int j = 0; j < m.studentlist.get(i).corses.size(); j++) {
                    bw.write("3_" + i + "_" + m.studentlist.get(i).corses.get(j).saveToFile());
                    bw.newLine();
                    bw.write(m.studentlist.get(i).corses.get(j).teacher.saveToFile());
                    bw.newLine();
                }
            }
            for (int i = 0; i < m.teacherlist.size(); i++) {
                bw.write(m.teacherlist.get(i).saveToFile());
                bw.newLine();
                for (int j = 0; j < m.teacherlist.get(i).corses.size(); j++) {
                    bw.write("4_" + i + "_" + m.teacherlist.get(i).corses.get(j).saveToFile());
                    bw.newLine();
                    bw.write(m.teacherlist.get(i).corses.get(j).teacher.saveToFile());
                    bw.newLine();
                }
            }
            for (int i = 0; i < m.corselist.size(); i++) {
                bw.write(m.corselist.get(i).saveToFile());
                bw.newLine();
                bw.write(m.corselist.get(i).teacher.saveToFile());
                bw.newLine();
                /////////////////////////////////
                for (int j = 0; j < m.corselist.get(i).studentlist.size(); j++) {
                    bw.write("5_" + i +"_"+ m.corselist.get(i).studentlist.get(j).saveToFile());
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void read() {
        Main m = new Main();

        try {
            Scanner sc = new Scanner(new File(filename));
            String readfile;
            String firstp, secondp, thirdp;
            if (sc.hasNext()) {
                readfile = sc.next();
                StringTokenizer token = new StringTokenizer(readfile, "_");
                m.manager.setName(token.nextToken());
                m.manager.setPassword(token.nextToken());


                while (sc.hasNext()) {

                    readfile = sc.next();
                    token = new StringTokenizer(readfile, "_");
                    firstp = token.nextToken();
                    secondp = token.nextToken();
                    thirdp = token.nextToken();
                    System.out.println(firstp + secondp + thirdp);
                    if (firstp.equals("0")) {
                        Student s = new Student(secondp, thirdp, token.nextToken(), Long.parseLong(token.nextToken()));
                        m.studentlist.add(s);
                    } else if (firstp.equals("3")) {
                        //System.out.println(m.studentlist.get(0).corses.get(0).saveToFile());


                        String p1 = token.nextToken(), p2 = token.nextToken(), p3 = token.nextToken(), p4 = token.nextToken(), p5 = token.nextToken(), p = sc.next();
                        StringTokenizer tokenizer = new StringTokenizer(p, "_");
                        System.out.println(p1 + p2 + p3 + p4 + p5);
                        System.out.println(p);
                        String a0 = tokenizer.nextToken(), a1 = tokenizer.nextToken(), a2 = tokenizer.nextToken(), a3 = tokenizer.nextToken(), a4 = tokenizer.nextToken();
                        Teacher teacher = new Teacher(a1, a2, a3, Long.parseLong(a4));
                        System.out.println(a1 + a2 + a3 + a4);
                        Corse course = new Corse(Integer.parseInt(p1), p2, teacher, Integer.parseInt(p3), p4, Float.parseFloat(p5));
                        m.studentlist.get(Integer.parseInt(secondp)).corses.add(course);
                    } else if (firstp.equals("1")) {
                        Teacher teacher = new Teacher(secondp, thirdp, token.nextToken(), Long.parseLong(token.nextToken()));
                        m.teacherlist.add(teacher);
                    } else if (firstp.equals("4")) {
                        String p1 = token.nextToken(), p2 = token.nextToken(), p3 = token.nextToken(), p4 = token.nextToken(), p5 = token.nextToken(), p = sc.next();
                        StringTokenizer tokenizer = new StringTokenizer(p, "_");
                        String a0 = tokenizer.nextToken(), a1 = tokenizer.nextToken(), a2 = tokenizer.nextToken(), a3 = tokenizer.nextToken(), a4 = tokenizer.nextToken();
                        Teacher teacher = new Teacher(a1, a2, a3, Long.parseLong(a4));
                        Corse course = new Corse(Integer.parseInt(p1), p2, teacher, Integer.parseInt(p3), p4, Float.parseFloat(p5));
                        m.teacherlist.get(Integer.parseInt(secondp)).corses.add(course);

                    } else if (firstp.equals("2")) {
                        System.out.println("ggggggggggggggggggggggggg");
                        String p1 = token.nextToken(), p2 = token.nextToken(), p3 = token.nextToken(), p = sc.next();
                        StringTokenizer tokenizer = new StringTokenizer(p, "_");
                        String a0 = tokenizer.nextToken(), a1 = tokenizer.nextToken(), a2 = tokenizer.nextToken(), a3 = tokenizer.nextToken(), a4 = tokenizer.nextToken();
                        Teacher teacher = new Teacher(a1, a2, a3, Long.parseLong(a4));
                        Corse course = new Corse(Integer.parseInt(secondp), thirdp, teacher, Integer.parseInt(p1), p2, Float.parseFloat(p3));
                        m.corselist.add(course);
                    } else if (firstp.equals("5")) {
                        Student student = new Student(token.nextToken(),token.nextToken(),token.nextToken(),Long.parseLong(token.nextToken()));
                        m.corselist.get(Integer.parseInt(secondp)).studentlist.add(student);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

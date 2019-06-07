package assingment9;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<String,String> map = new HashMap<>();

    static boolean isfind = false;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileadd;
        Long startTime=System.currentTimeMillis();
        boolean conti=true;
        boolean mapfound;

        while(conti) {
            isfind = false;
            mapfound = false;
            System.out.println("Please Enter Directory :");
            fileadd = sc.next();


            System.out.println("Please Enter Layer :");
            int layer = sc.nextInt();

            System.out.println("Search ...");
            String search = sc.next();
            if(map.containsKey(search)){
                System.out.println(map.get(search));
                mapfound = true;
                isfind = true;
            }
            if(mapfound == false)
                find(fileadd, search, layer);

            if(isfind == false)
                System.out.println("!!!Can Not Found Any Things!!!");

            System.out.println((System.currentTimeMillis()-startTime)+" ms");

            System.out.println("Do You Want To Continue ? (y/n)");

            String cont = sc.next();
            if(cont.equals("n"))
                conti = false;



        }

    }


    public static void find(String d, String search,int layer){
        try {

            File dir = new File(d);
            for (File a : dir.listFiles()) {
                if (a.isDirectory() && layer > 0) {
                    layer--;
                    find(a.toString(), search, layer);
                }
                String name = a.toString().replace(dir.toString(), "");
                if (name.contains(search)) {
                    map.put(search, a.toString());
                    System.out.println(a.toString() + "\n");
                    isfind = true;
                }
            }
        }

        catch (Exception e){
        }

    }


}


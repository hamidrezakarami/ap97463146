package Assinment10;

import java.io.*;
import java.net.URL;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.stream.Stream;


public class Main {

    static int number = 0, total = 0;
    static Scanner sc = new Scanner(System.in);
    static boolean istrue = true;
    static Set linksset = new HashSet();
    static ArrayList<String> linklist = new ArrayList<>();

    public static void main(String[] args) {

        Main main = new Main();
        String link;
        String savepath;
        int numofpage;

        System.out.println("Please Enter a link:(like : https://www.google.ru/)");
        link = sc.next();
        System.out.println("please Enter path for save: (D:\\game)");
        savepath = sc.next();
        System.out.println("how many page you want download?");
        numofpage = sc.nextInt();
        System.out.println("please waiting...");


        main.knowAndRemoveRepetitiveLinks(link);

        main.downloadlink(link, savepath);
        System.out.println("Download links:");
        System.out.println(link);
        for (int i = 0; (i < numofpage) && (i < linklist.size() - 1); i++) {
            System.out.println(linklist.get(i));
            main.downloadlink(linklist.get(i), savepath);
            if (i % 2 == 0) {
                System.out.println(number + " links download and " + (total-number) + " links left");
            }
        }
        if (istrue)
            System.out.println("complete  ( " + number + " links download )");
        else
            System.out.println("!!! ERROR !!!");

    }


    public void knowAndRemoveRepetitiveLinks(String link1) {
        URL url;
        String h;

        try {
            url = new URL(link1);
            Document doc = Jsoup.connect(String.valueOf(url)).get();             //links
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                String L = link.attr("href");
                if (Stream.of(url).anyMatch(s -> L.startsWith(String.valueOf(s)))) {
                    linksset.add(L);
                }
            }

            String l = linksset.toString().replace("[", "");
            l = l.replace("]", "");
            StringTokenizer stoken = new StringTokenizer(l, ",");
            total = linksset.size();
            for (int i = 0; i < linksset.size(); i++) {
                h=stoken.nextToken();
                linklist.add(h);
               // knowAndRemoveRepetitiveLinks(h);
            }
        } catch (Exception e) {
            System.out.println(e);
            istrue = false;
        }
    }


    public void downloadlink(String link, String savepath) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        int filename = link.hashCode();

        try {

            File f = new File(savepath + "\\" + filename + ".html");

            FileWriter writer = new FileWriter(f);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            url = new URL(link);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            number++;
            bufferedWriter.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
            istrue = false;
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                istrue = false;
            }
        }
    }
}

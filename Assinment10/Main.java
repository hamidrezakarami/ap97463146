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


    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Main main = new Main();
        ArrayList<String> linklist = new ArrayList<>();
        String link;
        String savepath;
        int numofpage;

        System.out.println("Please Enter a link:");
        link = sc.next();
        System.out.println("please Enter path for save:");
        savepath = sc.next();
        System.out.println("how mane page you want download ...............");
        numofpage = sc.nextInt();


        linklist = main.knowAndRemoveRepetitiveLinks(link);

        main.downloadlink(link, savepath);
        System.out.println("Download links:");
        System.out.println(link);
        for (int i = 0; (i < numofpage) && (i < linklist.size() - 1); i++) {
            System.out.println(linklist.get(i));
            main.downloadlink(linklist.get(i), savepath);
        }
        System.out.println("complete");

    }


    public ArrayList<String> knowAndRemoveRepetitiveLinks(String link1) {
        URL url;
        Set linksset = new HashSet();
        ArrayList<String> linklist = new ArrayList<>();
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
            System.out.println(l);
            for (int i = 0; i < linksset.size(); i++) {
                linklist.add(stoken.nextToken());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return linklist;
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
            bufferedWriter.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
            }
        }
    }
}

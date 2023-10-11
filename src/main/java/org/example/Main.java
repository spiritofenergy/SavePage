package org.example;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;


public class Main {
    public static void main(String[] args) throws Exception {

        String sourceCode17 = downloadWebPage("https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D0%BE%D0%B1%D0%BB%D0%B5%D0%BC%D0%B0_2000_%D0%B3%D0%BE%D0%B4%D0%B0");
        String sourceCode18 = downloadWebPage("https://ru.wikipedia.org/wiki/%D0%9A%D0%BD%D1%83%D1%82,_%D0%94%D0%BE%D0%BD%D0%B0%D0%BB%D1%8C%D0%B4_%D0%AD%D1%80%D0%B2%D0%B8%D0%BD");

        writeToFile17(sourceCode17);
        writeToFile18(sourceCode18.replaceAll("Кнут" , " Пряник"));
    }
    private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                result.append(line);
            }

        }
        return result.toString();

    }
    public static void writeToFile17(String str) throws Exception {
        BufferedWriter writer17 = new BufferedWriter(new FileWriter("C:\\Users\\Marat\\Desktop\\test\\2000.html"));
        writer17.write(str);
        writer17.close();
    }
        public static void writeToFile18(String str) throws Exception{
        BufferedWriter writer18 = new BufferedWriter(new FileWriter("C:\\Users\\Marat\\Desktop\\test\\Knut.html"));
        writer18.write(str);
        writer18.close();
    }
}


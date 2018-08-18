package com.grupa4.sda.narzedzia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.grupa4.sda.narzedzia.Ustawienia;

import static com.grupa4.sda.narzedzia.Ustawienia.PLIK_Z_LISTA_KLIENTOW;

public class OperacjeNaPlikach {

    public void zapisz(String filePath, int number){

    }
    public static void odczyt(String filePath) throws FileNotFoundException {
        File file = new File (filePath);
        Scanner in = new Scanner(file);
        String linia = in.nextLine();
        System.out.println(linia);



    }
    public static List<String> readFileToList(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> odczytanaListaStringow = new ArrayList<>();

        String textLine = bufferedReader.readLine();
        do {
//            System.out.println(textLine);
            odczytanaListaStringow.add(textLine);

            textLine = bufferedReader.readLine();
        } while(textLine != null);

        bufferedReader.close();
        return odczytanaListaStringow;
    }
//=============================================================================
    public void writeFile(String filePath, List<String> textLines)
            throws IOException {

        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        try {
            for (String line : textLines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } finally {
            bufferedWriter.close();
        }
    }
}

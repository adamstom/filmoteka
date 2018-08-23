package com.grupa4.sda;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.grupa4.sda.narzedzia.OperacjeNaPlikach;

import static com.grupa4.sda.narzedzia.Ustawienia.PLIK_Z_UNIKALNE_ID_MAX;

public class UnikalneId {
    public static Integer unikalneId;

    public UnikalneId()throws IOException {
        FileReader fileReader = new FileReader(PLIK_Z_UNIKALNE_ID_MAX);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String odczytanaLiniaStringow= bufferedReader.readLine();

        this.unikalneId=Integer.parseInt(odczytanaLiniaStringow);

        bufferedReader.close();
    }

    public void zapiszDoPliku() throws Throwable {
        //zapisujemy aktualną wartość do pliku
        FileWriter fileWriter = new FileWriter(PLIK_Z_UNIKALNE_ID_MAX);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        try {
            bufferedWriter.write(String.valueOf(this.unikalneId));
//            System.out.println("zapisuje max id do pliku"+this.unikalneId);
        } finally {
            bufferedWriter.close();
        }
    }
}

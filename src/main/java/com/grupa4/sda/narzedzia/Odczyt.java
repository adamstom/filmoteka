package com.grupa4.sda.narzedzia;

import java.util.Scanner;

public class Odczyt {

    public String odczytStringa() {

        String odczytywanyText;
        Scanner odczyt = new Scanner(System.in);

        odczytywanyText = odczyt.nextLine();

        return odczytywanyText;
    }

    public int odczytInta() {

        int odczytywanaLiczba;
        Scanner odczyt = new Scanner(System.in);

        odczytywanaLiczba = odczyt.nextInt();

        return odczytywanaLiczba;

    }


}

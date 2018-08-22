package com.grupa4.sda.narzedzia;

import com.grupa4.sda.UzytkownikFunkcja;
import com.grupa4.sda.narzedzia.Odczyt;

public final class Logowanie {
    public static UzytkownikFunkcja uzytkownikZalogowany;

    public static void zaloguj(){
        Odczyt odczyt = new Odczyt();
        System.out.println("Zaloguj jako: ");
        System.out.println("1 - Administrator");
        System.out.println("2 - Pracownik");
        System.out.println("3 - Klient");
        System.out.println("0 - Exit");
        System.out.print("Wybierz opcje wpisujac jej numer w klawiaturze: ");


        switch (odczyt.odczytInta()) {
            case 1:
                uzytkownikZalogowany=UzytkownikFunkcja.ADMINISTRATOR;
                break;
            case 2:
                uzytkownikZalogowany=UzytkownikFunkcja.PRACOWNIK;
                break;
            case 3:
                uzytkownikZalogowany=UzytkownikFunkcja.KLIENT;
                break;
            case 0:
                System.out.println("======= Wybrano exit ======= ");
                System.out.printf("program zakończył działanie");
                System.exit(0);
                break;

            default:
                System.out.println("Wyświetlam nieprzewidziane zdarzenie! LOGOWANIE");
        }
    };
}

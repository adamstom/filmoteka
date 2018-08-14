package com.grupa4.sda.menu;
import com.grupa4.sda.narzedzia.Odczyt;
import com.grupa4.sda.menu.MenuAdmin;

public class MenuGlowne {
    Odczyt odczyt = new Odczyt() {};



    public void wyswietlMenuLogowania() {

        System.out.println("Zaloguj jako: ");
        System.out.println("1 - Administrator");
        System.out.println("2 - Pracownik");
        System.out.println("3 - Klient");
        System.out.print("Wybierz opcje wpisujac jej numer w klawiaturze: ");


        switch (odczyt.odczytInta()) {
            case 1:
                MenuAdmin menuAdmin = new MenuAdmin();
                menuAdmin.wyswietlMenu();
                break;
            case 2:
                MenuPracownik menuPracownik = new MenuPracownik();
                menuPracownik.wyswietlMenu();
                break;
            case 3:
                System.out.printf("to bedzie menu dla klienta");
                break;
            default:
                System.out.println("Wyświetlam nieprzewidziane menu!!!");
        }
    }
}

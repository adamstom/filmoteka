package com.grupa4.sda;

import com.grupa4.sda.menu.MenuGlowne;
import com.grupa4.sda.narzedzia.Odczyt;
import com.grupa4.sda.menu.MenuAdmin;
import com.grupa4.sda.menu.MenuGlowne;

public class App {
    public static void main(String[] args) {

        Odczyt odczyt = new Odczyt() {
        };
        MenuGlowne menuGlowne = new MenuGlowne();
        menuGlowne.wyswietlMenuLogowania();
        boolean exit = false;
        switch (odczyt.odczytInta()) {

            case 1:
                //ADMIN
                MenuAdmin menuAdmin = new MenuAdmin();
                menuAdmin.wyswietlMenu();
                break;
            case 2:
                //PRACOWNIK
                break;
            case 3:
                //KLIENT
                break;

            case 0:
                exit = true;

            default:
                System.out.println("Wyświetlam nieprzewidziane menu!!!");
        }

//        UzytkownikFunkcja ZALOGOWANY_UZYTKOWNIK;
//        System.out.println("tu mamy logowanie i wskazujemy role użytkownika");
//        UzytkownikFunkcja zalogowany = UzytkownikFunkcja.ADMINISTRATOR;
//        MenuGlowne.wyswietlMenu(zalogowany, 3);
//        MenuGlowne.wyswietlMenu(zalogowany, 1);
    }
}

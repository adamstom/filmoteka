package com.grupa4.sda.menu;

import com.grupa4.sda.narzedzia.Logowanie;
import com.grupa4.sda.narzedzia.Odczyt;
import com.grupa4.sda.menu.MenuAdmin;

import java.io.IOException;

public class MenuGlowne {
    Odczyt odczyt = new Odczyt() {
    };

    public void wyswietlMenuPoZalogowaniu(int odczytaneMenu) {

//        System.out.println("Zaloguj jako: ");
//        System.out.println("1 - Administrator");
//        System.out.println("2 - Pracownik");
//        System.out.println("3 - Klient");
//        System.out.println("0 - Exit");
//        System.out.print("Wybierz opcje wpisujac jej numer w klawiaturze: ");

        switch (Logowanie.uzytkownikZalogowany) {
            case ADMINISTRATOR:
                MenuAdmin menuAdmin = new MenuAdmin();
                menuAdmin.wyswietlMenu(odczytaneMenu);
//                try {
//                    menuAdmin.wyswietlMenu();
//                } catch (IOException e) {
//                    System.out.println("Błąd pliku");
//                }
                break;
            case PRACOWNIK:
                MenuPracownik menuPracownik = new MenuPracownik();
                menuPracownik.wyswietlMenu(odczytaneMenu);
                break;
            case KLIENT:
                MenuKlient menuKlient =new MenuKlient();
                menuKlient.wyswietlMenu(odczytaneMenu);
                break;
            default:
                System.out.println("Wyświetlam nieprzewidziane zdarzenie! LOGOWANIE");
        }
    }
}

package com.grupa4.sda.procesy;

import com.grupa4.sda.procesy.admin.MenuAdmin;
import com.grupa4.sda.UzytkownikFunkcja;

public class Menu {

    private static MenuAdmin menuAdmin = new MenuAdmin();


    public static void wyswietlMenu(UzytkownikFunkcja uzytkownikFunkcja, int numerMenu) {

        switch (uzytkownikFunkcja) {
            case ADMINISTRATOR:
                menuAdmin.wyswietlMenuAdmin(numerMenu);
                break;
            case PRACOWNIK:
                break;
            case KLIENT:
                break;
            default:
                System.out.println("Wyświetlam nieprzewidziane menu!!!");
        }
    }
}

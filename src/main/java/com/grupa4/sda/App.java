package com.grupa4.sda;

import com.grupa4.sda.procesy.Menu;

public class App {
    public static void main(String[] args) {
        static UzytkownikFunkcja ZALOGOWANY_UZYTKOWNIK;

        System.out.println("tu mamy logowanie i wskazujemy role użytkownika");
        UzytkownikFunkcja zalogowany = UzytkownikFunkcja.ADMINISTRATOR;
        Menu.wyswietlMenu(zalogowany, 3);
        Menu.wyswietlMenu(zalogowany, 1);




    }
}

package com.grupa4.sda;
import com.grupa4.sda.narzedzia.Logowanie;
import com.grupa4.sda.narzedzia.Odczyt;
import com.grupa4.sda.menu.MenuAdmin;
import com.grupa4.sda.menu.MenuGlowne;
import com.grupa4.sda.narzedzia.OperacjeNaPlikach;
import com.grupa4.sda.procesy.Klient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static com.grupa4.sda.narzedzia.Ustawienia.PLIK_Z_LISTA_KLIENTOW;

public class App {
    public static void main(String[] args) throws IOException {

        //logowanie uzytkownika
        Logowanie.zaloguj();
        System.out.println("Jesteś zalogowany jako: "+Logowanie.uzytkownikZalogowany);

        //wstępne ustawienia i inicjacja zmiennych
        List<String> listaStringow = new ArrayList<>();
        OperacjeNaPlikach operacjeNaPlikach = new OperacjeNaPlikach();
        //wczytanie listy klientów z pliku
        listaStringow=operacjeNaPlikach.readFileToList(PLIK_Z_LISTA_KLIENTOW);

        Set<Klient> listaKlientow = new HashSet<>();
        listaKlientow=Klient.tworzeListeKlientowZListyStringow(listaStringow);


//        System.out.println("Odczytujemy dane z pliku");
//        for(String i : listaStringow){
//            System.out.println(i);
//        }

        //wyswietlam liste klientow
//        for(Klient klient : listaKlientow){
//            System.out.println(klient.toString());
//        }
        //zapisuje liste klientow do listy stringow
//        listaStringow=Klient.tworzeListeStringowZListyKlientow(listaKlientow);
        //zapisuje liste stringow z dodanym klientem do pliku
//        OperacjeNaPlikach.writeFile(PLIK_Z_LISTA_KLIENTOW,listaStringow);


        MenuGlowne menuGlowne = new MenuGlowne();
        //główna pętla programu
        int odczytaneMenu=0;
        do {
            menuGlowne.wyswietlMenuPoZalogowaniu();
            odczytaneMenu=Odczyt.odczytInta();
            //tu dodamy wykonywanie polecen
        }while(odczytaneMenu!=0);


        }
    }


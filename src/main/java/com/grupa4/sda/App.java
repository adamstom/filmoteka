package com.grupa4.sda;
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

        List<String> listaStringow = new ArrayList<>();

        List<String> listaStringowOdczytanaZPliku = new ArrayList<>();
        Set<Klient> listaKlientow = new HashSet<>();



        OperacjeNaPlikach operacjeNaPlikach = new OperacjeNaPlikach();

        listaStringowOdczytanaZPliku=operacjeNaPlikach.readFileToList(PLIK_Z_LISTA_KLIENTOW);

        System.out.println("Odczytujemy dane z pliku");
        for(String i : listaStringowOdczytanaZPliku){
            System.out.println(i);
        }

        listaKlientow=Klient.tworzeListeKlientowZListyStringow(listaStringowOdczytanaZPliku);
        //wyswietlam liste klientow
        for(Klient klient : listaKlientow){
            System.out.println(klient.toString());
        }
        //dodaje klienta do odczytanej listy klientow
        listaKlientow.add(new Klient("Tomasz","Huk","peseltomka333"));
        //zapisuje liste klientow do listy stringow
        listaStringow=Klient.tworzeListeStringowZListyKlientow(listaKlientow);
        //zapisuje liste stringow z dodanym klientem do pliku
        OperacjeNaPlikach.writeFile(PLIK_Z_LISTA_KLIENTOW,listaStringow);
        System.out.println("Sprawdz plik "+PLIK_Z_LISTA_KLIENTOW+" powinien być dopisany nowy klient");


//NIE KASOWAC
//        MenuGlowne menuGlowne = new MenuGlowne();
//        menuGlowne.wyswietlMenuLogowania();


        }
    }


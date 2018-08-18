package com.grupa4.sda;
import com.grupa4.sda.narzedzia.Odczyt;
import com.grupa4.sda.menu.MenuAdmin;
import com.grupa4.sda.menu.MenuGlowne;
import com.grupa4.sda.narzedzia.OperacjeNaPlikach;
import com.grupa4.sda.procesy.Klient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.grupa4.sda.narzedzia.Ustawienia.PLIK_Z_LISTA_KLIENTOW;

public class App {
    public static void main(String[] args) throws IOException {

        List<String> listaStringow = new ArrayList<>();
//        listaStringow.add("Jan|Nowak|6546435645");
//        listaStringow.add("Piotr|Kowalski|543843");

        List<String> listaStringowOdczytanaZPliku = new ArrayList<>();
        List<Klient> listaKlientow = new ArrayList<>();



        OperacjeNaPlikach operacjeNaPlikach = new OperacjeNaPlikach();
//        operacjeNaPlikach.writeFile(PLIK_Z_LISTA_KLIENTOW, listaStringow);

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

//NIE KASOWAC
//        MenuGlowne menuGlowne = new MenuGlowne();
//        menuGlowne.wyswietlMenuLogowania();


        }
    }


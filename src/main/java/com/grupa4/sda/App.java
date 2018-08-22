package com.grupa4.sda;
import com.grupa4.sda.narzedzia.Logowanie;
import com.grupa4.sda.narzedzia.Odczyt;
import com.grupa4.sda.menu.MenuAdmin;
import com.grupa4.sda.menu.MenuGlowne;
import com.grupa4.sda.narzedzia.OperacjeNaPlikach;
import com.grupa4.sda.procesy.Klient;
import com.grupa4.sda.procesy.WeryfikacjaUprawnien;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static com.grupa4.sda.narzedzia.Ustawienia.PLIK_Z_LISTA_KLIENTOW;

public class App {
    public static void main(String[] args) throws IOException {

        //logowanie uzytkownika
        Logowanie.zaloguj();
        System.out.println("Jesteś zalogowany jako: "+Logowanie.uzytkownikZalogowany);
        // zainicjowanie listy  uprawnieniami
        WeryfikacjaUprawnien weryfikacjaUprawnien = new WeryfikacjaUprawnien();

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
        int odczytanePodMenu=0;
        do {
            menuGlowne.wyswietlMenuPoZalogowaniu(odczytaneMenu);
            odczytaneMenu=Odczyt.odczytInta();
            //tu dodamy wykonywanie polecen
            switch (odczytaneMenu) {
                case -1://koniec programu
                    if(weryfikacjaUprawnien.sprawdzUprawnienie(Logowanie.uzytkownikZalogowany,odczytaneMenu)){
                        System.out.println("KONIEC PROGRAMU Masz do tego uprawnienie");
                        System.out.println("tu dopisać operacje do wykonania przy zakończeniu programu: np zapisanie danych");
                    }
                    else{
                        System.out.println("Nie masz do tego uprawnienia");
                    }
                    break;
                case 0:
                    break;
                case 1:
                    if(weryfikacjaUprawnien.sprawdzUprawnienie(Logowanie.uzytkownikZalogowany,odczytaneMenu)){
                        System.out.println("LISTA FILMÓW - Masz do tego uprawnienie");
                        System.out.println("tu dopisać operacje w kolejnej pętli");
                        {
                            do {
                                menuGlowne.wyswietlMenuPoZalogowaniu(odczytaneMenu);
                                odczytanePodMenu = Odczyt.odczytInta();
//                            odczytaneMenu=Odczyt.odczytInta();
                                switch (odczytanePodMenu) {
//                            switch (odczytaneMenu) {
                                    case 0:
                                        odczytaneMenu=0;
                                        break;
                                    case 11:
                                        System.out.println("jestem w 11 wyswietlam liste filmow");
                                        break;
                                    case 12:
                                        System.out.println("jestem w 12 - wysukuje film");
                                        break;
                                    case 13:
                                        System.out.println("jestem w 13 - dodanie film");
                                        break;
                                    case 14:
                                        System.out.println("jestem w 14 - edycja film");
                                        break;
                                    case 15:
                                        System.out.println("jestem w 15 - skasowanie film");
                                        break;
                                    default:
                                        break;//koniec programu
                                }
                            }while(odczytanePodMenu!=0);

                        }
                    }
                    else{
                        System.out.println("LISTA FILMOW Nie masz do tego uprawnienia");
                    }
                    break;
                case 2:
                    if(weryfikacjaUprawnien.sprawdzUprawnienie(Logowanie.uzytkownikZalogowany,odczytaneMenu)){
                        System.out.println("LISTA KLIENT - Masz do tego uprawnienie");
                        System.out.println("tu dopisać operacje w kolejnej pętli");
                    }
                    else{
                        System.out.println("LISTA KLIENT Nie masz do tego uprawnienia");
                    }
                    break;
                case 3:
                    if(weryfikacjaUprawnien.sprawdzUprawnienie(Logowanie.uzytkownikZalogowany,odczytaneMenu)){
                        System.out.println("LISTA CENNIK - Masz do tego uprawnienie");
                        System.out.println("tu dopisać operacje w kolejnej pętli");
                    }
                    else{
                        System.out.println("LISTA CENNIK Nie masz do tego uprawnienia");
                    }
                    break;
                case 4:
                    if(weryfikacjaUprawnien.sprawdzUprawnienie(Logowanie.uzytkownikZalogowany,odczytaneMenu)){
                        System.out.println("LISTA FINANSE - Masz do tego uprawnienie");
                        System.out.println("tu dopisać operacje w kolejnej pętli");
                    }
                    else{
                        System.out.println("LISTA FINANSE Nie masz do tego uprawnienia");
                    }
                    break;
                default:
                    break;

            }
        }while(odczytaneMenu!=-1);


        }
    }


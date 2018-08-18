package com.grupa4.sda.procesy;
import com.grupa4.sda.narzedzia.Odczyt;
import com.grupa4.sda.narzedzia.OperacjeNaPlikach;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.grupa4.sda.narzedzia.Ustawienia.PLIK_Z_LISTA_KLIENTOW;


public class KlientAdd {

    List<Klient> listaKlientow =new ArrayList<Klient>(); //zbiornik na klientów
    {
        listaKlientow.add(new Klient("Wiesiek","Nowak", ""));
        listaKlientow.add(new Klient("Jan","Kowalski",""));
        listaKlientow.add(new Klient("Matylda","Kaczmarek",""));

    }

    public void  dodajKlienta(Klient klient){

        System.out.print("Podaj imię nowego klienta: ");
        klient.setImie(Odczyt.odczytStringa());

        System.out.print("Podaj jego nazwisko: ");
        klient.setNazwisko(Odczyt.odczytStringa());

        listaKlientow.add(klient);
        System.out.println("++++++++ Dodano pacjenta ++++++++");
        System.out.println("Klient: " + klient.getImie() + " " + klient.getNazwisko() + " " );
    }
    public void wyswietlListeKlientow() throws IOException {
        OperacjeNaPlikach.readFileToList(PLIK_Z_LISTA_KLIENTOW);
//        System.out.println("++++++++ Lista Klientow ++++++++");
//        System.out.println("ilość pozycji: "+listaKlientow.size());
//        System.out.println(listaKlientow);
    }




}

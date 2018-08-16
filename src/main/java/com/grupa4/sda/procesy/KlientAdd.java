package com.grupa4.sda.procesy;
import com.grupa4.sda.narzedzia.Odczyt;
import java.util.ArrayList;
import java.util.List;


public class KlientAdd extends Odczyt {

    List<Klienci> listaKlientow =new ArrayList<Klienci>(); //zbiornik na klientów

    public void  dodajKlienta(Klienci klient){

        System.out.print("Podaj imię nowego klienta: ");
        klient.setImie(odczytStringa());

        System.out.print("Podaj jego nazwisko: ");
        klient.setNazwisko(odczytStringa());

        listaKlientow.add(klient);
        System.out.println("++++++++ Dodano pacjenta ++++++++");
        System.out.println("Klient: " + klient.getImie() + " " + klient.getNazwisko() + " " );
    }
    public void wyswietlListeKlientow(Klienci klienci){
        System.out.println("++++++++ Lista Klientow ++++++++");
        System.out.println("ilość pozycji: "+listaKlientow.size());
        System.out.println(listaKlientow);
    }
}

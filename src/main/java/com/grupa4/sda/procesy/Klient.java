package com.grupa4.sda.procesy;

import com.grupa4.sda.narzedzia.Odczyt;

import java.util.*;

public class Klient {
    private String imie;
    private String nazwisko;
    private String pesel;

    public Klient(String imie, String nazwisko, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Klient)) return false;
        Klient klient = (Klient) o;
        return Objects.equals(getImie(), klient.getImie()) &&
                Objects.equals(getNazwisko(), klient.getNazwisko()) &&
                Objects.equals(getPesel(), klient.getPesel());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getImie(), getNazwisko(), getPesel());
    }

    @Override
    public String toString() {
        return "Klient{" +
                "imie='" + this.imie + '\'' +
                ", nazwisko='" + this.nazwisko + '\'' +
                ", pesel='" + this.pesel + '\'' +
                '}';
    }


    public static Set<Klient> tworzeListeKlientowZListyStringow(List<String> listaStringow) {

        Set<Klient> listaKlientow = new HashSet<>();
//        listaKlientow.add(new Klient("Maj","Kolka","292873766"));

        for (String linia : listaStringow) {
//            String splitedArray = null;
//            splitedArray = linia.split("|")[0];
            listaKlientow.add(new Klient(linia.split("\\|")[0], linia.split("\\|")[1], linia.split("\\|")[2]));
//            listaKlientow.add(new Klient(splitedArray[0], splitedArray[1], splitedArray[2]));
//            System.out.println("sprawdzamy klase Klient metoda tworzeListeKlientowZListyStringow");
//            System.out.println("imie"+splitedArray[0]);
//            System.out.println("nazwisko"+splitedArray[1]);
//            System.out.println("pesel"+splitedArray[2]);
        }
        return listaKlientow;
    }

    public static List<String > tworzeListeStringowZListyKlientow(Set<Klient>listaKlientow){
        List<String> listaString = new ArrayList<>();
        for(Klient klient : listaKlientow){
            listaString.add(klient.imie+"|"+klient.nazwisko+"|"+klient.pesel);
        }
        return listaString;
    }

}


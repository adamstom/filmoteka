package com.grupa4.sda.procesy;

import com.grupa4.sda.Status;
import com.grupa4.sda.UnikalneId;
import com.grupa4.sda.narzedzia.Odczyt;
import com.grupa4.sda.narzedzia.OperacjeNaPlikach;

import java.io.IOException;
import java.util.*;

import static com.grupa4.sda.narzedzia.Ustawienia.PLIK_Z_LISTA_FILMOW;

public class Film {
    private int idFilmu;
    private String tytul;
    private Status dostepnosc;

    public Film(int idFilmu, String tytul, Status dostepnosc) {
        this.idFilmu = idFilmu;
        this.tytul = tytul;
        this.dostepnosc = dostepnosc;
    }

    public static Set<Film> tworzeListeFilmowZListyStringow(List<String> listaStringow) {

        Set<Film> listaFilmow = new HashSet<>();

        for (String linia : listaStringow) {
            int idFilmuTemp=Integer.parseInt(linia.split("\\|")[0]);
            String tytulTemp = linia.split("\\|")[1];
            Status dostepnoscTemp;
            switch (linia.split("\\|")[2]){
                case "DOSTEPNY":
                    dostepnoscTemp=Status.DOSTEPNY;
                    break;
                case "ZAJETY":
                    dostepnoscTemp=Status.ZAJETY;
                    break;
                case "NULL":
                    dostepnoscTemp=Status.NULL;
                    break;
                default:
                    dostepnoscTemp=Status.NULL;

            }
            listaFilmow.add(new Film(idFilmuTemp, tytulTemp, dostepnoscTemp));
        }
        return listaFilmow;
    }

    public static List<String > tworzeListeStringowZListyFilmow(Set<Film>listaFilmow){
        List<String> listaString = new ArrayList<>();
        for(Film film : listaFilmow){
            listaString.add(String.valueOf(film.idFilmu)+"|"+film.tytul+"|"+film.dostepnosc.name());
        }
        return listaString;
    }

    public static void wyswietlListeFilmow(Set<Film>listaFilmow){
        for(Film film : listaFilmow){
            System.out.println(film.toString());
        }
    }

    public static void dopiszFilmDoListyFilmow(Set<Film>listaFilmow) throws IOException {
//        Set<Film> listaFilmowTemp = new HashSet<>();
        System.out.println("Dopisujemy nowy film do listy.");
        System.out.println("Podaj tytuł filmu");
        String odczytanyTytul=Odczyt.odczytStringa();
        UnikalneId.unikalneId++;
        listaFilmow.add(new Film(UnikalneId.unikalneId,odczytanyTytul,Status.DOSTEPNY));
        //zapisuje zmodyfikowana liste do pliku
        List<String> listaStringowTemp = new ArrayList<>();
        listaStringowTemp=tworzeListeStringowZListyFilmow(listaFilmow);
        OperacjeNaPlikach.writeFile(PLIK_Z_LISTA_FILMOW,listaStringowTemp);
        System.out.println("Film dopisano do listy");
    }

    public int getIdFilmu() {
        return idFilmu;
    }

    public void setIdFilmu(int idFilmu) {
        this.idFilmu = idFilmu;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Status getDostepnosc() {
        return dostepnosc;
    }

    public void setDostepnosc(Status dostepnosc) {
        this.dostepnosc = dostepnosc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        Film film = (Film) o;
        return getIdFilmu() == film.getIdFilmu() &&
                Objects.equals(getTytul(), film.getTytul()) &&
                getDostepnosc() == film.getDostepnosc();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdFilmu(), getTytul(), getDostepnosc());
    }

    @Override
    public String toString() {
        return "Film{" +
                "idFilmu=" + idFilmu +
                ", tytul='" + tytul + '\'' +
                ", dostepnosc=" + dostepnosc +
                '}';
    }
}

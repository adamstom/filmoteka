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

    public static Set<Film> wyszukajlListeFilmow(Set<Film>listaFilmow){
        Set<Film> zwracanaListaFilmow = new HashSet<>();
        System.out.println("Wyszukiwanie filmów");
        System.out.println("Wyszukiwanie po: 1 - id, 2 - tytule, 3 - statusie, inne - rezygnacja");
        int odczytanyWybor = Odczyt.odczytInta();
        switch (odczytanyWybor){
            case 1:
                System.out.println("Podaj id szukanego filmu:");
                int odczytanyId = Odczyt.odczytInta();
                for(Film szukanyFilm : listaFilmow){
                    if(szukanyFilm.getIdFilmu()==odczytanyId){
                        zwracanaListaFilmow.add(szukanyFilm);
                    }
                }
                break;
            case 2:
                System.out.println("Podaj fraze z tytułu szukanego filmu:");
                String odczytanaFraza = Odczyt.odczytStringa();
                for(Film szukanyFilm : listaFilmow){
                    if(szukanyFilm.getTytul().contains(odczytanaFraza)){
                        zwracanaListaFilmow.add(szukanyFilm);
                    }
                }
                break;
            case 3:
                System.out.println("Podaj nową dostępność filmu: ");
                System.out.println("1 - DOSTĘPNY; 2 - ZAJĘTY; 3 - NULL");
                int odczytanyWyburStatusu = Odczyt.odczytInta();
                switch (odczytanyWyburStatusu) {
                    case 1:
                        for(Film szukanyFilm : listaFilmow){
                            if(szukanyFilm.getDostepnosc()==Status.DOSTEPNY){
                                zwracanaListaFilmow.add(szukanyFilm);
                            }
                        }
                        break;
                    case 2:
                        for(Film szukanyFilm : listaFilmow){
                            if(szukanyFilm.getDostepnosc()==Status.ZAJETY){
                                zwracanaListaFilmow.add(szukanyFilm);
                            }
                        }
                        break;
                    case 3:
                        for(Film szukanyFilm : listaFilmow){
                            if(szukanyFilm.getDostepnosc()==Status.NULL){
                                zwracanaListaFilmow.add(szukanyFilm);
                            }
                        }
                        break;
                    default:
                        zwracanaListaFilmow=listaFilmow;
                        break;
            }
                break;
            default :
                break;
        }

        return zwracanaListaFilmow;
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
    public static void edytujFilm(Set<Film>listaFilmow) throws IOException{
        System.out.println("Edycja filmu");
        System.out.println("Podaj id filmu do edycji");
        int idFilmuDoModyfikacji=Odczyt.odczytInta();
        for(Film filmZListy : listaFilmow){
            if(filmZListy.getIdFilmu()==idFilmuDoModyfikacji){
                System.out.println("ID modyfikowanego filmu : "+idFilmuDoModyfikacji);
                System.out.println("Obecny tytuł modyfikowanego filmu to : ");
                System.out.println(filmZListy.getTytul());
                System.out.println("Chcesz zmienić tytuł filmu? TAK - t/ NIE - n");
                String odczytanePolecenie = Odczyt.odczytStringa();
                if(odczytanePolecenie.equals("t")){
                    System.out.println("Podaj nowy tytuł filmu: ");
                    filmZListy.setTytul(Odczyt.odczytStringa());
                }
                System.out.println("Obecny status filmu to : "+filmZListy.getDostepnosc().name());
                System.out.println("Chcesz zmienić dostępność filmu? TAK - t/ NIE - n");
                odczytanePolecenie = Odczyt.odczytStringa();
                if(odczytanePolecenie.equals("t")){
                    System.out.println("Podaj nową dostępność filmu: ");
                    System.out.println("1 - DOSTĘPNY; 2 - ZAJĘTY; inne - NULL");
                    switch (Odczyt.odczytInta()){
                        case 1:
                            filmZListy.setDostepnosc(Status.DOSTEPNY);
                            break;
                        case 2:
                            filmZListy.setDostepnosc(Status.ZAJETY);
                            break;
                        default:
                            filmZListy.setDostepnosc(Status.NULL);
                    }
                }
            }
        }
        //zapisuje zmodyfikowana liste do pliku
        List<String> listaStringowTemp = new ArrayList<>();
        listaStringowTemp=tworzeListeStringowZListyFilmow(listaFilmow);
        OperacjeNaPlikach.writeFile(PLIK_Z_LISTA_FILMOW,listaStringowTemp);
        System.out.println("Film zmodyfikowano i dopisano do listy");
    }

    public static void skasujFilm(Set<Film>listaFilmow) throws IOException {
        System.out.println("Kasowanie filmu");
        Film filmDoSkasowania=null;
        System.out.println("Podaj id filmu do skasowania");
        int idFilmuDoModyfikacji = Odczyt.odczytInta();
        String odczytanePolecenie="";
        for(Film filmZListy : listaFilmow) {
            if (filmZListy.getIdFilmu() == idFilmuDoModyfikacji) {
                System.out.println("Czy chcesz skasować film:");
                System.out.println("ID : "+filmZListy.getIdFilmu());
                System.out.println("Tytuł : "+filmZListy.getTytul());
                System.out.println("Status : "+filmZListy.getDostepnosc());
                System.out.println("TAK - t, NIE - n ?");
                odczytanePolecenie = Odczyt.odczytStringa();
                if(odczytanePolecenie.equals("t")){
                    filmDoSkasowania=filmZListy;
                }

            }
        }
        if(odczytanePolecenie.equals("t")){
            listaFilmow.remove(filmDoSkasowania);
            System.out.println("Film usunięto z listy");
        }
        //zapisuje zmodyfikowana liste do pliku
        List<String> listaStringowTemp = new ArrayList<>();
        listaStringowTemp=tworzeListeStringowZListyFilmow(listaFilmow);
        OperacjeNaPlikach.writeFile(PLIK_Z_LISTA_FILMOW,listaStringowTemp);
        System.out.println("Dane zaktualizowano");
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

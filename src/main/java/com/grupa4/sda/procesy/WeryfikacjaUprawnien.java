package com.grupa4.sda.procesy;

import com.grupa4.sda.UzytkownikFunkcja;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WeryfikacjaUprawnien {
    //klasa ma za zadnie zarządzanie uprawnieniami uzytkowników do wykonywania pewnych czynności w aplikacji
    public static Set<Uprawnienie> listaUprawnien = new HashSet<>();
    {
        //UPRAWNIENIA ADMINISTRATORA
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,-1));
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,0));

        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,1));
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,11));
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,12));
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,13));
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,14));
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,15));

        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,2));
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,21));
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,22));
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,23));
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,24));
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,25));
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,26));

        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,3));
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,31));
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,32));

        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,4));
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.ADMINISTRATOR,41));

        //UPRAWNIENIE PRACOWNIKA - DO UZUPEŁNIENIA
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.PRACOWNIK,0));

        //UPRAWNIENIA KLIENTA - DO UZUPEŁNIENIA
        listaUprawnien.add(new Uprawnienie(UzytkownikFunkcja.KLIENT,0));
    }
    public boolean sprawdzUprawnienie(UzytkownikFunkcja uzytkownikFunkcja, int numerMenu){
        Uprawnienie sprawdzaneUprawnienie = new Uprawnienie(uzytkownikFunkcja,numerMenu);
        if(listaUprawnien.contains(sprawdzaneUprawnienie)){
            return true;
        }
        else {
            return false;
        }
    }

    public class Uprawnienie{
        public UzytkownikFunkcja getUzytkownikFunkcja() {
            return uzytkownikFunkcja;
        }

        public void setUzytkownikFunkcja(UzytkownikFunkcja uzytkownikFunkcja) {
            this.uzytkownikFunkcja = uzytkownikFunkcja;
        }

        public int getNumerMenu() {
            return numerMenu;
        }

        public void setNumerMenu(int numerMenu) {
            this.numerMenu = numerMenu;
        }

        private UzytkownikFunkcja uzytkownikFunkcja;
        private int numerMenu;

        public Uprawnienie(UzytkownikFunkcja uzytkownikFunkcja, int numerMenu) {
            this.uzytkownikFunkcja = uzytkownikFunkcja;
            this.numerMenu = numerMenu;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Uprawnienie)) return false;
            Uprawnienie that = (Uprawnienie) o;
            return getNumerMenu() == that.getNumerMenu() &&
                    getUzytkownikFunkcja() == that.getUzytkownikFunkcja();
        }

        @Override
        public int hashCode() {

            return Objects.hash(getUzytkownikFunkcja(), getNumerMenu());
        }
    }

}

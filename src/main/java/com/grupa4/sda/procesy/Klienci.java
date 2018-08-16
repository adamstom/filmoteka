package com.grupa4.sda.procesy;
import com.grupa4.sda.narzedzia.Odczyt;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Klienci extends Odczyt {
    private String imie;
    private String nazwisko;

    public String getImie() { return imie; }
    public void setImie(String imie) { this.imie = imie; }
    public String getNazwisko() { return nazwisko; }
    public void setNazwisko(String nazwisko) { this.nazwisko = nazwisko; }

    public Klienci(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "Klienci{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
        }
}


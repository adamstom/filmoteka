package com.grupa4.sda.procesy.admin;

public class MenuAdmin {
    public void wyswietlMenuAdmin(int numerMenu) {

        switch (numerMenu) {
            case 0:
                System.out.println("Menu Administratora:");
                System.out.println("1 - Klienci");
//                System.out.println("2 - Dodaj film");
//                System.out.println("3 - Lista klientow");
//                System.out.println("4 - Dodaj klienta");
//                System.out.println("0 - exit");
                break;
            case 1:
                System.out.println("Klienci");
                System.out.println("Menu:");
                System.out.println("1 - Lista Klientow");
                System.out.println("2 - Dodaj nowego klienta");
                System.out.println("3 - Edytuj dane klienta");
                System.out.println("4 - Usun klienta");
                System.out.println("0 - Exit");


                break;
            case 2:
                System.out.println("operacje na filmach");
                break;
            default:
                System.out.println("Wyświetlam nieprzewidziane menu!!!");
        }
    }
}

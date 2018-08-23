package com.grupa4.sda.menu;

public class MenuAdmin {

    public void wyswietlMenu(int odczytaneMenu){
        System.out.println("======= Menu Administratora: =======");
        switch (odczytaneMenu) {
            case 0:
                System.out.println("-1. KONIEC PROGRAMU");
                System.out.println("1. FILM");
                System.out.println("2. KLIENT");
                System.out.println("3. WYPOŻYCZENIE ZWROT");
                System.out.println("4. FINANSE");
                break;
            case 1:
                System.out.println("0.  POWRÓT DO GŁÓWNEGO MENU");
                System.out.println("11. LISTA FILMÓW");
                System.out.println("12. WYSZUKANIE FILMU");
                System.out.println("13. DODANIE FILMU");
                System.out.println("14. EDYCJA FILMU");
                System.out.println("15. SKASOWANIE FILMU");
                break;
            case 2:
                System.out.println("0.  POWRÓT DO GŁÓWNEGO MENU");
                System.out.println("21. LISTA KLIENTÓW");
                System.out.println("22. WYSZUKANIE KLIENTÓW");
                System.out.println("23. DODANIE KLIENTA");
                System.out.println("24. EDYCJA KLIENTA");
                System.out.println("25. SKASOWANIE KLIENTA");
                System.out.println("26. LISTA DŁUŻNIKÓW");
                break;
            case 3:
                System.out.println("0.  POWRÓT DO GŁÓWNEGO MENU");
                System.out.println("31. WYPOŻYCZENIE FOLMU");
                System.out.println("32. ZWROT FILMU");
                break;
            case 4:
                System.out.println("0.  POWRÓT DO GŁÓWNEGO MENU");
                System.out.println("41. LISTA PRZYCHODÓW");
                break;
            default:
                System.out.println("-1. KONIEC PROGRAMU");
                System.out.println("1. FILM");
                System.out.println("2. KLIENT");
                System.out.println("3. WYPOŻYCZENIE ZWROT");
                System.out.println("4. FINANSE");
                break;
        }
    }
}


package com.grupa4.sda.menu;
import com.grupa4.sda.narzedzia.Odczyt;

public class MenuAdmin extends MenuPracownik {
    public void wyswietlMenu() {
        System.out.println("Menu Glowne Administratora:");
        System.out.println("1. Lista filmów");
        System.out.println("2. Dodaj film");
        System.out.println("3. Edytuj film");
        System.out.println("4. Usuń film");
        System.out.println("5. Sprawdź dostępność filmu");
        System.out.println("6. Wyszukaj Film");
        System.out.println("7. Lista klientów");
        System.out.println("8. Dodaj klienta");
        System.out.println("9. Edytuj klienta");
        System.out.println("10. Usuń klienta");
        System.out.println("11. Cennik");
        System.out.println("12. Edytuj cennik");
        System.out.println("13. Finanse");
        System.out.println("14. Kary/lista dłużników");
        System.out.println("0. Powrót do poprzedniego menu");

        Odczyt odczyt = new Odczyt() {};
        boolean exit = false;
        switch (odczyt.odczytInta()) {
            case 1:

                break;
            case 2:
                System.out.println("operacje na filmach");
                break;
            case 0:
                System.out.println("Wybrano powrót");
                MenuGlowne menuGlowne =new MenuGlowne();
                menuGlowne.wyswietlMenuLogowania();

                break;
            default:
                System.out.println("Wyświetlam nieprzewidziane menu!!!");
        }
    }
}


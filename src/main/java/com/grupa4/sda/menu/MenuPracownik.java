package com.grupa4.sda.menu;
import com.grupa4.sda.narzedzia.Odczyt;

public class MenuPracownik {
    public void wyswietlMenu() {
        System.out.println("======= Menu Pracownika: ======= ");
        System.out.println("1. Lista filmów");
        System.out.println("2. Sprawdź dostępność filmu");
        System.out.println("3. Wyszukaj Film");
        System.out.println("4. Lista klientów");
        System.out.println("5. Dodaj klienta");
        System.out.println("6. Edytuj klienta");
        System.out.println("7. Cennik");
        System.out.println("8. Kary/lista dłużników");
        System.out.println("0. Powrót do poprzedniego menu");

        Odczyt odczyt = new Odczyt() {
        };
        boolean exit = false;
        switch (odczyt.odczytInta()) {
            case 1:
                System.out.println("==ToDo== 1. Lista filmów");
                break;
            case 2:
                System.out.println("==ToDo== 2. Sprawdź dostępność filmu");
                break;
            case 3:
                System.out.println("==ToDo== 3. Wyszukaj Film");
                break;
            case 4:
                System.out.println("==ToDo== 4. Lista klientów");
                break;
            case 5:
                System.out.println("==ToDo== 5. Dodaj klienta");
                break;
            case 6:
                System.out.println("==ToDo== 6. Edytuj klienta");
                break;
            case 7:
                System.out.println("==ToDo== 7. Cennik");
                break;
            case 8:
                System.out.println("==ToDo== 8. Kary/lista dłużników");
                break;

            case 0:
                System.out.println("======= Wybrano powrót ======= ");
                MenuGlowne menuGlowne = new MenuGlowne();
                menuGlowne.wyswietlMenuLogowania();

                break;
            default:
                System.out.println("Wyświetlam nieprzewidziane zdarzenie! PRACOWNIK");
        }
    }
}
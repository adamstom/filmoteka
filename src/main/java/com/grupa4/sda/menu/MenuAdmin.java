package com.grupa4.sda.menu;
import com.grupa4.sda.narzedzia.Odczyt;
import com.grupa4.sda.procesy.Klienci;
import com.grupa4.sda.procesy.KlientAdd;

public class MenuAdmin {
    private static KlientAdd klientAdd = new KlientAdd();

    MenuGlowne menuGlowne = new MenuGlowne();
    public void wyswietlMenu() {
        System.out.println("======= Menu Administratora: =======");
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

        Odczyt odczyt = new Odczyt() {
        };
        boolean exit = false;
        Klienci klient = new Klienci("","");
        switch (odczyt.odczytInta()) {

            case 1:
                System.out.println("==ToDo== 1. Lista filmów");
                break;
            case 2:
                System.out.println("==ToDo== 2. Dodaj film");
                break;
            case 3:
                System.out.println("==ToDo== 3. Edytuj film");
                break;
            case 4:
                System.out.println("==ToDo== 4. Usuń film");
                break;
            case 5:
                System.out.println("==ToDo== 5. Sprawdź dostępność filmu");
                break;
            case 6:
                System.out.println("==ToDo== 5. Sprawdź dostępność filmu");
                break;
            case 7:
                System.out.println("== Wybrano: 7 == Lista klientów");
                klientAdd.wyswietlListeKlientow(klient);
                break;
            case 8:
                System.out.println("== Wybrano: 8 == Dodaj klienta");
                klientAdd.dodajKlienta(klient);
                wyswietlMenu();
                break;
            case 9:
                System.out.println("==ToDo== 9. Edytuj klienta");
                break;
            case 10:
                System.out.println("==ToDo== 10. Usuń klienta");
                break;
            case 11:
                System.out.println("==ToDo== 11. Cennik");
                break;
            case 12:
                System.out.println("==ToDo== 12. Edytuj cennik");
                break;
            case 13:
                System.out.println("==ToDo== 13. Finanse");
                break;
            case 14:
                System.out.println("==ToDo== 14. Kary/lista dłużników");
                break;
            case 0:
                System.out.println("======= Wybrano powrót ======= ");
               menuGlowne.wyswietlMenuLogowania();

                break;
            default:
                System.out.println("Wyświetlam nieprzewidziane zdarzenie! ADMIN");
        }
    }
}


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Sym {

    //Poniższa metoda zwróci mi tabele Przedmiotów np: Przedmiot przedmiot = new Przedmiot

    public ArrayList<Przedmiot> pobierzDoTabeliZPrzedmiotyZPliku(String plikTxt) {


        ArrayList<Przedmiot> tabelaObiektyPrzedmiotow = new ArrayList<>();

        File p = new File(plikTxt);

        try {

            Scanner sc = new Scanner(p);

            while (sc.hasNextLine()) {

                //******************************
                String linia = sc.nextLine();
                //******************************

                int point0 = linia.indexOf("=");

                String nazwa = linia.substring(0, point0);
                double waga = Double.parseDouble(linia.substring(point0 + 1));
                //ALTERNATYWA ;P
                //double waga1 = Double.valueOf(linia.substring(point0 + 1));

                Przedmiot przedmiot = new Przedmiot(nazwa, waga);

                tabelaObiektyPrzedmiotow.add(przedmiot);
            }

        } catch (Exception ex) {

            System.out.println(ex);
        }

        return tabelaObiektyPrzedmiotow;
    }


    public ArrayList<RakietaM> pobierzDoTabeliRakietyZMaxLadunkiemPrzedmiotow(ArrayList<Przedmiot> tabelaZObiektamiPrzedmiotow) {

        //Tworzę pustą ArrayList o generyku<RakietaM>
        ArrayList<RakietaM> listaRakietZZaladowanymiPrzedmiotami = new ArrayList<>();

        //Pętla while będzie działać dopóki rozmiar przesłanej tabeli z obiektami przedmiotów będzie większy od zera
        //ponieważ .size() wskazuje na rzeczywistą ilość obiektów w tablicy (.size() nie uwzględnia indexowania od zera)
        //
        while (tabelaZObiektamiPrzedmiotow.size() > 0) {

            //Ponizsze informacje dotyczą wszystkich obiektów, które powstaną w skutek działania warunku "if_1"
            //oraz else czyli de facto warunek "if_2"

            //za każdym razem gdy wychodzę z ptli 'for' w którymkolwiek z warunków tworzony jest nowy obiekt typu
            //Rakieta:
            RakirtaU1 rakirtaU1 = new RakirtaU1();

            System.out.println(
                    "\n* * * Rakieta U1: o indexie [" + rakirtaU1.getId() + "] * * * \n"
                            + "\nINFORMACJE DODATKOWE:"
                            + "\nAktualny rozmiar tabeli z obiektami przemiotów wynosi: "
                            + tabelaZObiektamiPrzedmiotow.size() +
                            "\nRakieta będzie zapełniona przedmiotami o łącznej masie nie przekraczajacej: "
                            + rakirtaU1.maxLadownosc() + " kg."
            );

            System.out.println("-------------------------------------");

            //*** warunek if_1 ***
            if(tabelaZObiektamiPrzedmiotow.size() == 1) {

                for(int i = tabelaZObiektamiPrzedmiotow.size() - 1; i >=0; i--) {

                    if(rakirtaU1.czyMoznaJeszczeDodacPrzedmioty(tabelaZObiektamiPrzedmiotow.get(i))) {

                        //po przejści uwalidacji z powyższego if'a to właśnie tu dodaję przedmiot z
                        // pliku textowego przekazanego do tabeliPrzedmiotów do tablicy przedmiotów, która znajduje
                        // się w Klasie RakietaM. Uwaga - dodaniu przedmiotu z danego indexu z tabeli
                        // musze go usunąć poprzez ,remove();

                        rakirtaU1.dodajPrzedmiotDoTablicyPrzedmiotow(tabelaZObiektamiPrzedmiotow.get(i));

                        System.out.println(
                                "\nDo OSTATNIEJ RAKIETY " + rakirtaU1.getId() + " dorzucono "
                                        +"ładunek:" + tabelaZObiektamiPrzedmiotow.get(i).getNazwaP()
                                        + " o wadze: " + tabelaZObiektamiPrzedmiotow.get(i).getWagaP()
                                        + " kg, czym wyczerpano asortyment przeznaczony do załadunku \n"
                                        + "[\nUWAGA! POWYŻSZA INFORMACJA POJAWI SIE JEDYNIE W SYTUACJI, W KTÓREJ DO RAKIETY "
                                        + "JEST ZAŁADOWANY JEDYNIE JEDEN PRZEDMIOT Z ASORTYMENTU]");

                        tabelaZObiektamiPrzedmiotow.remove(i);
                    }
                    //tabelaZObiektamiPrzedmiotow.remove(i); TU BYŁO WCZEŚNIEJ USUWANIE OBIEKTU I TO POWODOWAŁO BŁĄD

                }
                //*** warunek if_2 ***
            } else {

                for(int i = tabelaZObiektamiPrzedmiotow.size() - 1; i >=0; i--) {

                    //tu moja uwaga: za każdym razem, jak będzimny wychodzić z pętli for, i będzimy sprawdzać warunek while,
                    //jeśli while przejdzie walidację to będzie się tworzyć nowy obiekt typu Rakieta oraz powiązane do
                    // niego inkrementowane id.
                    // Jednak by id mogło być poprawnie pobierane to w Klasie matce RakietaM należy stworzyć pole id
                    // oraz getter a w klasach potomnych równiez musi być to id oraz getter.

                    //w pętli for zostanie zapełniona tabela Przedmiotów z Klasy RakietaM, którą będzie należałą do
                    // obiekt typu RakietaU1 (zachodzi dziedziczenie)


                    if(rakirtaU1.czyMoznaJeszczeDodacPrzedmioty(tabelaZObiektamiPrzedmiotow.get(i))) {
                        //przed pierwszą iteracją tabela z przedmiotami przedmiotów z Klasy RakietaM jest pusta,
                        // dopiero poniżej następuje dodanie przedmiotu do tablicy z przedmiotami, która to tablica
                        // znajduje się w Kalsie RakietaM. Co więcej gdy zostanie dodany pierwszy przedmiot w klasie
                        // RakietaM to zaczyna "działać" metoda pomocnicza, którą stworzyłem w klasie RakietaM, która
                        // dokonuje sumy wag wszystkich przedmiotów, które "trafiają" (tak jak poniżej) do tablicy
                        // Przedmiotow

                        rakirtaU1.dodajPrzedmiotDoTablicyPrzedmiotow(tabelaZObiektamiPrzedmiotow.get(i));

                        System.out.println(
                                "Do Rakiety: " + rakirtaU1.getId()
                                        + " dorzucono ładunek: " + tabelaZObiektamiPrzedmiotow.get(i).getNazwaP()
                                        + " o wadze: " + tabelaZObiektamiPrzedmiotow.get(i).getWagaP() + " kg"
                        );

                        tabelaZObiektamiPrzedmiotow.remove(i);
                    }
//    tabelaZObiektamiPrzedmiotow.remove(i); TU BYŁO WCZEŚNIEJ USUWANIE OBIEKTU I TO POWODOWAŁO BŁĄD
                }
            }

//poza elsem dodaj już stworzony Przedmiot RakietaU1 do listy z załadowanymi Rakietami

            //Dodaje do listy Rakiet z załadowanymi przedmiotami, Obiekt typu Rakieta, który juz mają zapełnioną
            // własną liste obiektami typu
            // Przedmiot

            listaRakietZZaladowanymiPrzedmiotami.add(rakirtaU1);
            System.out.println("Totalna waga: " + rakirtaU1.zliczWageWszystkichPrzedmiotwZTablicy());
            System.out.println("");

        }

        //ZA PĘTLĄ WHILE
        return listaRakietZZaladowanymiPrzedmiotami;
    }




    public int OdpalScenariusz(ArrayList<RakietaM> rakietyZPrzedmiotamiTabela) {

        int kosztTotalny = 0;

//Pamiętaj, że .size(); wskazuje na realną ilość elementów w tabeli, więc muszę odjąć jeden, by nie wyskoczył bład
// wyjścia poza tabelę outOfBoundException
        for(int i = rakietyZPrzedmiotamiTabela.size() - 1; i >=0; i--) {

            boolean start;
            boolean ladowanie;

            do {

                //dla każdej RakirtyU1 pobierz koszt i dodaj go do zmiennej łącznej kosztTotalny. Np:
                //w pierwszej iteracji o indexie [i] pobieramy koszt dla Obiektu [i]
                kosztTotalny = kosztTotalny + rakietyZPrzedmiotamiTabela.get(i).getKoszt();


                start = rakietyZPrzedmiotamiTabela.get(i).startRakiety();
                ladowanie = rakietyZPrzedmiotamiTabela.get(i).ladowanieRakiety();

                if(!start) {

                    System.out.println("Rakieta " + rakietyZPrzedmiotamiTabela.get(i).getId() + " explodowała podczas" +
                            " startu!");
                }

                else {

                    System.out.println("Rakieta " + rakietyZPrzedmiotamiTabela.get(i).getId() + " wystartowała z " +
                            "sukcesem,");

                    if(!ladowanie) {

                        System.out.println("niestety explodowała w trakcie lądowania.\n");

                    } else {

                        System.out.println("oraz wylądowała pomyslnie.\n");

                    }

                }

            } while (!start || !ladowanie);

            rakietyZPrzedmiotamiTabela.remove(i);
        }


        return kosztTotalny;
    }


//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
// *** U2
// ----------------------


    public ArrayList<RakietaM> pobierzDoTabeliRakietyZMaxLadunkiemPrzedmiotowU2(ArrayList<Przedmiot>
                                                                                        tabelaZObiektamiPrzedmiotow) {

        //Tworzę pustą ArrayList o generyku<RakietaM>
        ArrayList<RakietaM> listaRakietZZaladowanymiPrzedmiotami = new ArrayList<>();

        //Pętla while będzie działać dopóki rozmiar przesłanej tabeli z obiektami przedmiotów będzie większy od zera
        //ponieważ .size() wskazuje na rzeczywistą ilość obiektów w tablicy (.size() nie uwzględnia indexowania od zera)
        //
        while (tabelaZObiektamiPrzedmiotow.size() > 0) {

            //Ponizsze informacje dotyczą wszystkich obiektów, które powstaną w skutek działania warunku "if_1"
            //oraz else czyli de facto warunek "if_2"

            //za każdym razem gdy wychodzę z ptli 'for' w którymkolwiek z warunków tworzony jest nowy obiekt typu
            //Rakieta:
            RakirtaU2 rakirtaU2 = new RakirtaU2();

            System.out.println(
                    "\n* * * Rakieta U2: o indexie [" + rakirtaU2.getId() + "] * * * \n"
                            + "\nINFORMACJE DODATKOWE:"
                            + "\nAktualny rozmiar tabeli z obiektami przemiotów wynosi: "
                            + tabelaZObiektamiPrzedmiotow.size() +
                            "\nRakieta będzie zapełniona przedmiotami o łącznej masie nie przekraczajacej: "
                            + rakirtaU2.maxLadownosc() + " kg."
            );

            System.out.println("-------------------------------------");

            //*** warunek if_1 ***
            if(tabelaZObiektamiPrzedmiotow.size() == 1) {

                for(int i = tabelaZObiektamiPrzedmiotow.size() - 1; i >=0; i--) {

                    if(rakirtaU2.czyMoznaJeszczeDodacPrzedmioty(tabelaZObiektamiPrzedmiotow.get(i))) {

                        //po przejści uwalidacji z powyższego if'a to właśnie tu dodaję przedmiot z
                        // pliku textowego przekazanego do tabeliPrzedmiotów do tablicy przedmiotów, która znajduje
                        // się w Klasie RakietaM. Uwaga - dodaniu przedmiotu z danego indexu z tabeli
                        // musze go usunąć poprzez ,remove();

                        rakirtaU2.dodajPrzedmiotDoTablicyPrzedmiotow(tabelaZObiektamiPrzedmiotow.get(i));

                        System.out.println(
                                "\nDo OSTATNIEJ RAKIETY " + rakirtaU2.getId() + " dorzucono "
                                        +"ładunek:" + tabelaZObiektamiPrzedmiotow.get(i).getNazwaP()
                                        + " o wadze: " + tabelaZObiektamiPrzedmiotow.get(i).getWagaP()
                                        + " kg, czym wyczerpano asortyment przeznaczony do załadunku \n"
                                        + "[\nUWAGA! POWYŻSZA INFORMACJA POJAWI SIE JEDYNIE W SYTUACJI, W KTÓREJ DO RAKIETY "
                                        + "JEST ZAŁADOWANY JEDYNIE JEDEN PRZEDMIOT Z ASORTYMENTU]");

                        tabelaZObiektamiPrzedmiotow.remove(i);
                    }
                    //tabelaZObiektamiPrzedmiotow.remove(i); TU BYŁO WCZEŚNIEJ USUWANIE OBIEKTU I TO POWODOWAŁO BŁĄD

                }
                //*** warunek if_2 ***
            } else {

                for(int i = tabelaZObiektamiPrzedmiotow.size() - 1; i >=0; i--) {

                    //tu moja uwaga: za każdym razem, jak będzimny wychodzić z pętli for, i będzimy sprawdzać warunek while,
                    //jeśli while przejdzie walidację to będzie się tworzyć nowy obiekt typu Rakieta oraz powiązane do
                    // niego inkrementowane id.
                    // Jednak by id mogło być poprawnie pobierane to w Klasie matce RakietaM należy stworzyć pole id
                    // oraz getter a w klasach potomnych równiez musi być to id oraz getter.

                    //w pętli for zostanie zapełniona tabela Przedmiotów z Klasy RakietaM, którą będzie należałą do
                    // obiekt typu RakietaU1 (zachodzi dziedziczenie)


                    if(rakirtaU2.czyMoznaJeszczeDodacPrzedmioty(tabelaZObiektamiPrzedmiotow.get(i))) {
                        //przed pierwszą iteracją tabela z przedmiotami przedmiotów z Klasy RakietaM jest pusta,
                        // dopiero poniżej następuje dodanie przedmiotu do tablicy z przedmiotami, która to tablica
                        // znajduje się w Kalsie RakietaM. Co więcej gdy zostanie dodany pierwszy przedmiot w klasie
                        // RakietaM to zaczyna "działać" metoda pomocnicza, którą stworzyłem w klasie RakietaM, która
                        // dokonuje sumy wag wszystkich przedmiotów, które "trafiają" (tak jak poniżej) do tablicy
                        // Przedmiotow

                        rakirtaU2.dodajPrzedmiotDoTablicyPrzedmiotow(tabelaZObiektamiPrzedmiotow.get(i));

                        System.out.println(
                                "Do Rakiety: " + rakirtaU2.getId()
                                        + " dorzucono ładunek: " + tabelaZObiektamiPrzedmiotow.get(i).getNazwaP()
                                        + " o wadze: " + tabelaZObiektamiPrzedmiotow.get(i).getWagaP() + " kg"
                        );

                        tabelaZObiektamiPrzedmiotow.remove(i);
                    }
//    tabelaZObiektamiPrzedmiotow.remove(i); TU BYŁO WCZEŚNIEJ USUWANIE OBIEKTU I TO POWODOWAŁO BŁĄD
                }
            }

//poza elsem dodaj już stworzony Przedmiot RakietaU1 do listy z załadowanymi Rakietami

            //Dodaje do listy Rakiet z załadowanymi przedmiotami, Obiekt typu Rakieta, który juz mają zapełnioną
            // własną liste obiektami typu
            // Przedmiot

            listaRakietZZaladowanymiPrzedmiotami.add(rakirtaU2);
            System.out.println("Totalna waga: " + rakirtaU2.zliczWageWszystkichPrzedmiotwZTablicy());
            System.out.println("");

        }

        //ZA PĘTLĄ WHILE
        return listaRakietZZaladowanymiPrzedmiotami;
    }
}

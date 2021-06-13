import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static String pokazDate() {

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String data = simpleDateFormat.format(date);

        return data;

    }

    public static String pokazCzas() {

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String czas = simpleDateFormat.format(date);

        return czas;

    }


    public static void main(String[] args) {


        Sym sym = new Sym();


        //PRZEDMIOTY:
        ArrayList<Przedmiot> przedmiots = sym.pobierzDoTabeliZPrzedmiotyZPliku("phase-1.txt");
        ArrayList<Przedmiot> przedmiots2 = sym.pobierzDoTabeliZPrzedmiotyZPliku("phase-2.txt");

//        //RAKIETA U1
//        ArrayList<RakietaM> rakietaM = sym.pobierzDoTabeliRakietyZMaxLadunkiemPrzedmiotow(przedmiots);
//        int wynikFinansowyRakietaU1 = sym.OdpalScenariusz(rakietaM);
//
//
//        ArrayList<RakietaM> rakietaM2 = sym.pobierzDoTabeliRakietyZMaxLadunkiemPrzedmiotow(przedmiots2);
//        int wynikFinansowyRakietaU2 = sym.OdpalScenariusz(rakietaM2);


        // RAKIETA U2

        ArrayList<RakietaM> rakietaMU2 = sym.pobierzDoTabeliRakietyZMaxLadunkiemPrzedmiotowU2(przedmiots);
        int wynikFinansowyRakietaRU2 = sym.OdpalScenariusz(rakietaMU2);


        ArrayList<RakietaM> rakietaMUU2 = sym.pobierzDoTabeliRakietyZMaxLadunkiemPrzedmiotowU2(przedmiots2);
        int wynikFinansowyRakietaRUU2 = sym.OdpalScenariusz(rakietaMUU2);


        //SYMULACJA RAKIETA U1

//        System.out.println("\nKoszt przedsięwzięcia wysłania rakiety na planetę Mars w Fazie nr 1 wysniósł: " +
//                wynikFinansowyRakietaU1 + " milionów" +
//                " dolarów." +
//                "\nKoszt przedsięwzięcia wysłania rakiety na planetę  Mars w Fazie nr 2 wysniósł: " +
//                wynikFinansowyRakietaU2 + " milionów dolarów.");
//
//        System.out.println("\nData wykonania symulacji: " + pokazDate() + " o godzinie: " + pokazCzas());
//

        //**************************************************************************************************************


        System.out.println("\n\nSYMULACJA RAKIETA U2");


        //**************************************************************************************************************

        //SYMULACJA RAKIETA U2
        System.out.println("\nKoszt przedsięwzięcia wysłania rakiety na planetę Mars w Fazie nr 1 wysniósł: " +
                wynikFinansowyRakietaRU2 + " milionów" +
                " dolarów." +
                "\nKoszt przedsięwzięcia wysłania rakiety na planetę  Mars w Fazie nr 2 wysniósł: " +
                wynikFinansowyRakietaRUU2 + " milionów dolarów.");

        System.out.println("\nData wykonania symulacji: " + pokazDate() + " o godzinie: " + pokazCzas());

    }

    }


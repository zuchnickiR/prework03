import java.util.ArrayList;

public class RakietaM implements InterfaceStatekKosmiczny{

     /*
    Dlaczego powstała Klasa "Matka" dla U1 oraz U2? --> Dostrzegam, że w obu Klasach U1 oraz U2 powtarzają się zmienne,
    więc postanawiam utworzyć Klasę nadrzędną jaką dla tych obu Klas: Klasa RakietaM
    */

    int koszt;
    private double waga;
    private double maxObciazenieRakiety;
    private double wagaRakiety;

    private int id;
    private int idObiektu;


    ArrayList<Przedmiot> tabPrzedmioty = new ArrayList<>();

    public RakietaM(int koszt, double waga, double maxObciazenieRakiety) {
        this.koszt = koszt;
        this.waga = waga;
        this.maxObciazenieRakiety = maxObciazenieRakiety;
//        idObiektu++;
//        this.idObiektu = id;


    }


    public int getKoszt() {
        return koszt;
    }

    public double getWaga() {
        return waga;
    }

    public double getMaxObciazenieRakiety() {
        return maxObciazenieRakiety;
    }

    public double getWagaRakiety() {
        return wagaRakiety;
    }

    public int getId() {
        return id;
    }


    //**************************Interface*****************************


    @Override
    public boolean startRakiety() {
        return true;
    }

    @Override
    public boolean ladowanieRakiety() {
        return true;
    }

    @Override
    public void dodajPrzedmiotDoTablicyPrzedmiotow(Przedmiot przedmiot) {
        //na potrzeby tej metody tworze pustą tablice ArrayList<Przedmioty>: tabPrzedmioty
        tabPrzedmioty.add(przedmiot);

        //Pierwszy przedmiot do tablicy Przedmiotów bedzie dodany w Klasie Symulacja w pętli while w ifie (a
        // konkretnie w else)
    }

    /*
    Do tej metody potrzebuję sumy wag wszystkich Przedmiotów, które są w tablicy tablicaPrzedmiotow, dlatego
    potrzebuję metody pomocnicznej: zliczWageWszystkichPrzedmiotwZTablicy(); (metoda pomocnicza nr 1)
    */
    //METODA WALIDACYJNA
    @Override
    public boolean czyMoznaJeszczeDodacPrzedmioty(Przedmiot przedmiot) {

        return przedmiot.getWagaP() + zliczWageWszystkichPrzedmiotwZTablicy() <= maxObciazenieRakiety;

    }

    /*
    metoda pomocnicza nr 1. Iteruje po tablicy z obiektami typu Przedmit i z kazdego przedmiotu wygiąga wagę, po czym
    sumuje tę wagę i zwraca sumę w postaci double.
    */


    // Ponizsza metoda jest składową metody o nazwie: 'czyMoznaJeszczeDodacPrzedmioty'(metoda docelowo uzywana w
    // Klasie Symulacja) - dzięki temu, że metoda będzie dodawała do siebie wagi każdego z przedmiotów po każdej iteracji
    // w pętli for, która znajduje się w ciele pętli while, która jest osiową logiką metody 'czyMoznaJeszczeDodacPrzedmioty'
    // z Klasy Symulacja.

    public double zliczWageWszystkichPrzedmiotwZTablicy(){
        // Defaultowo tablica (tabPrzedmiotow) przedmiotów jest pusta.
        // Pierwszy przedmiot bedzie dodany do tablicy Przedmiotów (która jest polem tej Klasy, Klasy RakietaM), w
        // Klasie Symulacja za pomoca metody "pobierzDoTabeliRakietyZMaxLadunkiemPrzedmiotow". W pętli while,
        // zostanie utworzony nowy obiekt RakirtaU1 oraz output do każdego nowo utworzonego obiektu RakietaU1 [informacje/dane].
        // Następnie program "napotka" na pętlę for i podczas  iteracji  po tej pętli a konkretnie po tabeli
        // Przedmiotów (tabeli z tej Klasy), gdy program napotka "pierwszy raz" if'a, znajdującego się juz w ciele pętli
        // for to "na sto procent" ten if przejdzie walidację dotyczacą tego, czy mozna jeszcze dodac przedmiot do tablicy
        // (ponieważ do tablicy Przedmiotow nie został dodany jaszcze ani jeden przedmiot)- Przedmiot dopiero
        // będzie dodany do tabPrzedmioty po przejściu w/w walidacji w if'ie - więc warunek if'a zostanie spełniony i wówcas
        // w ciele if'a na referencjo do nowo utworzonego Obiektu RakietaU1 zostanie wywołana metoda z Klasy RakietaU1 o nazwie:
        // 'dodajPrzedmiotDoTablicyPrzedmiotow' (I WŁAŚNIE W TYM MOMENCIE NASZA TABLICA 'tabPrzedmioty' ZOSTAŁA
        // ZAPISANA NA INDEXIE[0] PIERWSZYM PRZEDMIOTEM Z DOSTARCZONEJ DO METODY O NAZWIE: pobierzDoTabeliRakietyZMaxLadunkiemPrzedmiotow
        // TABLICY Z PRZEDMIOTAMI)

        // Po pierwszej iteracji zmienna o typie double wagaSuam z metody zliczajacejWszystkieWagi
        // bedzie juz zainicializowana pierwsza wartoscia, więc w kolejnej iteracji pętli, gdy program napotka if'a
        // będzie już brał "pod uwagę" wagę przedmiotu z tablicy 'tabPrzedmioty' oraz sumę wag, która już nie będzie
        // miała wartości zero, tylko będzie posiadała wartość: (startowe zero) 0 + waga przedmiotu po pierwszej iteracji w pętli
        // for, która znajduje się w pętli while.

        double wagaSuam = 0;

        for(Przedmiot aaa: tabPrzedmioty) {

            wagaSuam += aaa.getWagaP();
        }
        return wagaSuam;
    }

    // metoda pomocnicza nr 2

    public double maxLadownosc() {

        return maxObciazenieRakiety - wagaRakiety;

    }

}

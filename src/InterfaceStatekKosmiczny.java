public interface InterfaceStatekKosmiczny {

    //nadpisane w RakietaU1 oraz RakietaU2 - @override
    boolean startRakiety();
    boolean ladowanieRakiety();

    //zaimplementowane w Kalsie RakietaM
    void dodajPrzedmiotDoTablicyPrzedmiotow(Przedmiot przedmiot);
    boolean czyMoznaJeszczeDodacPrzedmioty(Przedmiot przedmiot);
}

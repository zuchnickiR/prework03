public class RakirtaU1 extends RakietaM{

    private static int count = 0;

    int id;


    public RakirtaU1() {
        super(100, 10000, 10000);

        this.id = count;
        count++;
    }

//    public int getIdObiekt() {
//
//        return id;
//
//    }

    //*** nadpisane

    @Override
    public boolean startRakiety() {
        int liczbaPrzypadkowa = (int) ((Math.random() * 100) + 1);
        return liczbaPrzypadkowa > (5.0 * zliczWageWszystkichPrzedmiotwZTablicy() / maxLadownosc()) /100;

    }


    @Override
    public boolean ladowanieRakiety() {

        int liczbaPrzypadkowa = (int) ((Math.random() * 100) + 1);
        return liczbaPrzypadkowa > (1.0 * zliczWageWszystkichPrzedmiotwZTablicy() / maxLadownosc()) /100;
    }

    @Override
    public int getId() {
        return id;
    }

}

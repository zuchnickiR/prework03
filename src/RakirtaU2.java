public class RakirtaU2 extends RakietaM{

    private static int count = 0;
    int id;



    public RakirtaU2() {
        super(120, 18000, 29000);

        this.id = count;
        count++;
    }

    @Override
    public boolean startRakiety() {
        int liczbaPrzypadkowa = (int) ((Math.random() * 100) + 1);
        return liczbaPrzypadkowa > (4.0 * zliczWageWszystkichPrzedmiotwZTablicy() / maxLadownosc()) /100;
    }

    @Override
    public boolean ladowanieRakiety() {
        int liczbaPrzypadkowa = (int) ((Math.random() * 100) + 1);
        return liczbaPrzypadkowa > (8.0 * zliczWageWszystkichPrzedmiotwZTablicy() / maxLadownosc()) /100;
    }

    @Override
    public int getId() {
        return id;
    }


}

class GorillaTest {
    public static void main(String args[]) {
        Gorilla g = new Gorilla();
        g.throwSomething();
        g.displayEnergy();
        g.throwSomething();
        g.displayEnergy();
        g.throwSomething();
        g.displayEnergy();
        g.eatBananas();
        g.displayEnergy();
        g.eatBananas();
        g.displayEnergy();
        g.climb();
        g.displayEnergy();

        Dragon d = new Dragon();
        d.attackTown();
        d.displayEnergy();
        d.attackTown();
        d.displayEnergy();
        d.attackTown();
        d.displayEnergy();
        d.eatHumans();
        d.displayEnergy();
        d.eatHumans();
        d.displayEnergy();
        d.fly();
        d.displayEnergy();
        d.fly();
        d.displayEnergy();
    }
}

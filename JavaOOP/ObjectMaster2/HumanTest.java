class HumanTest {
    public static void main(String args[]) {
        Human human1 = new Human();
        Human human2 = new Human();
        Human human3 = new Human();
        Wizard wizard1 = new Wizard();
        Ninja ninja1 = new Ninja();
        Samurai samurai1 = new Samurai();
        Samurai samurai2 = new Samurai();
        Samurai samurai3 = new Samurai();

        System.out.println(human1.getHealth());
        System.out.println(human2.getHealth());
        human1.attack(human2);
        System.out.println(human1.getHealth());
        System.out.println(human2.getHealth());

        System.out.println("Wizard");

        System.out.println(wizard1.getHealth());
        System.out.println(wizard1.getIntelligence());
        System.out.println(wizard1.getStrength());

        System.out.println("Ninja");

        ninja1.steal(human2);
        System.out.println(ninja1.getHealth());
        ninja1.runAway();
        System.out.println(ninja1.getHealth());

        System.out.println("Samurai");

        samurai1.deathBlow(human3);
        System.out.println(samurai1.getHealth());
        samurai1.meditate();
        System.out.println(samurai1.getHealth());
        samurai1.howMany();

        
    }
}

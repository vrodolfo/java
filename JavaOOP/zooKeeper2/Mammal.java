class Mammal{
    private int energyLevel;
    public Mammal() {
        energyLevel = 100;
    }
    public int displayEnergy() {
        System.out.println("Energy: " + energyLevel);
        return energyLevel;
    }
    public void setEnergyLevel(int energy){
        energyLevel = energy;
    }

    public void decreaseEnergyLevel(int energy){
        energyLevel = energyLevel - energy;
    }
}

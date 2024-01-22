public class Component {
    
    String name;
    int timeSpent;
    double[] range;

    /**
     * Constructor
     * 
     * @param name
     * @param timeSpent
     * @param range
     */
    public Component(String name, int  timeSpent, double[] range){

        this.name = name;
        this.timeSpent = timeSpent;
        this.range = range;
    }

    /**
     * Calculate the energyconsumed by a component
     * 
     * @return array containing lower and upper values
     */
    public double[] calculateEnergy(){
        double lower_energy = new CodingCalculator(this.timeSpent, this.range[0]).energyConsumption();
        double upper_energy = new CodingCalculator(this.timeSpent, this.range[1]).energyConsumption();

        double[] store = {lower_energy, upper_energy};

        return store;
    }
}

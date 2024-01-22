public class CodingCalculator {

    int computerTime;
    double power;

    /**
     * Constructor
     */
    public CodingCalculator(int duration,double power){
        this.computerTime = duration;
        this.power = power / 1000.0;
    }

    /**
     * calculate energy consumption
     * @return energy consumed by component
     */
    public double energyConsumption(){
        return this.computerTime * this.power;
    }

}
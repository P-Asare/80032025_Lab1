public class App {

    public static void main(String[] args) {

        int computerTime = 17;
        int gpu_time = 13;

        // Power consumption ranges for components
        double[] cpuPowerRange = {73, 95};
        double[] ramPowerRange = {1.2, 1.6};
        double[] boardPowerRange = {25, 40};
        double[] storagePowerRange = {0.6, 2.8};
        double[] loadPowerRange = {110, 164};
        double[] idlePowerRange = {8, 13};

        Component cpu = new Component("cpu", computerTime, cpuPowerRange);
        Component ram = new Component("ram", computerTime, ramPowerRange);
        Component board = new Component("board", computerTime, boardPowerRange);
        Component ssd = new Component("ssd", computerTime, storagePowerRange);

        Component loadGpu = new Component("gpu", gpu_time, loadPowerRange);
        Component idleGpu = new Component("gpu", gpu_time, idlePowerRange);

        System.out.println();

        // Question 2

        Component[] components = {cpu, ram, board, ssd};
        for (Component comp:components){
            
            double lowerEnergy = comp.calculateEnergy()[0];
            double upperEnergy = comp.calculateEnergy()[1];

            System.out.println(comp.name + " energy consumption " + lowerEnergy + "kWh to " + upperEnergy + "kWh");
        }
        System.out.println();

        // Question 4

        System.out.println("Load Power Mode: " + loadGpu.calculateEnergy()[0] + " kWh to " + loadGpu.calculateEnergy()[1] + " kWh");
        System.out.println("Idle Power Mode: " + idleGpu.calculateEnergy()[0] + " kWh to " + idleGpu.calculateEnergy()[0] + "kWh");
        System.out.println();

        // Question 5

        double loadMintotalEnergy = loadGpu.calculateEnergy()[0];
        double loadMaxtotalEnergy = loadGpu.calculateEnergy()[1];

        double idleMinTotalEnergy = idleGpu.calculateEnergy()[0];
        double idleMaxTotalEnergy = idleGpu.calculateEnergy()[1];

        for (Component comp:components){
            
            double lowerEnergy = comp.calculateEnergy()[0];
            double upperEnergy = comp.calculateEnergy()[1];

            loadMintotalEnergy += lowerEnergy;
            loadMaxtotalEnergy += upperEnergy;

            idleMinTotalEnergy += lowerEnergy;
            idleMaxTotalEnergy += upperEnergy;
        }

        System.out.println("Minimum total energy for load power mode" + loadMintotalEnergy + "kWh");
        System.out.println("Maximum total energy for load power mode" + loadMaxtotalEnergy + "kWh");

        System.out.println("Minimum total energy for idle power mode" + idleMinTotalEnergy + "kWh");
        System.out.println("Maximum total energy for idle power mode" + idleMaxTotalEnergy + "kWh");

        System.out.println();

        // Total power consumed by computer falls between 0 - 50kWh
        // There are 31 days in January

        double loadPowerBill = loadMaxtotalEnergy * 0.34;
        double januaryPowerBill = loadPowerBill * 31;

        double idlePowerBill = idleMaxTotalEnergy * 0.34;
        double januaryIdleBill = idlePowerBill * 31;

        // With the bills I focused only on the maximum values and not the minimum

        System.out.println("January Load Bill: GHC " + januaryPowerBill);
        System.out.println("January Idle Bill: GHC " + januaryIdleBill);
    }
}

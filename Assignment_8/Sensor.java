package class10.Assignment_8;

class Sensor extends Thread {
    private final Device device;
    private double value;

    public Sensor(Device device) {
        this.device = device;
    }

    public double getValue() {
        return value;
    }

    public void updateValue() {
        this.value += 0.001;

    }

    public void run() {
        while(true) {
            try {
                synchronized (device) {
                    updateValue();
                    device.notify();//notify controller value is updated
                }
            }catch (Exception e){

            }
        }
    }
}

package class10.Assignment_8;

public class Controller extends Thread{
    Device device ;
    Sensor heat;
    Sensor pressure;
    public Controller(Device d,Sensor h, Sensor p){
        this.device = d;
        this.heat = h;
        this.pressure = p;



    }

    public void run() {
        device.startup();
        synchronized (device) {
          while(heat.getValue() <= 70 && pressure.getValue() <= 100){
              System.out.printf("heat: %.2f pressure: %.2f  \n", heat.getValue(),pressure.getValue());
              try{
                  device.wait();//waiting for sensor update value
              }catch (Exception e){

              }
          }
            System.out.printf("heat: %.2f pressure: %.2f  \n", heat.getValue(),pressure.getValue());
            device.shutdown();


        }

    }

}

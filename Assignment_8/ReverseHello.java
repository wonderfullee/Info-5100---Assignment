package class10.Assignment_8;

public class ReverseHello extends Thread {
    private int counter;
    public ReverseHello(int i){
        counter = i;
        run();
    }
    public void run(){
        if(counter < 51){
            makeThread(counter+1);
        }

    }
    public void makeThread(int i){
        ReverseHello rh = new ReverseHello(i);
        rh.start();
        try {
            rh.join();
            System.out.println("Hello from Thread " + counter);
        }catch (Exception e){

        }
    }
    public static void main(String[] args)throws Exception{
        ReverseHello rh = new ReverseHello(1);
        rh.start();
    }
}

package Session06;

public class Main {
    public static void main(String[] args){
        TrainStation station = new TrainStation(10);

        BoxOffice box1 = new BoxOffice("Quầy 1", station);
        BoxOffice box2 = new BoxOffice("Quầy 2", station);
        BoxOffice box3 = new BoxOffice("Quầy 3", station);

        Thread t1 = new Thread(box1);
        Thread t2 = new Thread(box2);
        Thread t3 = new Thread(box3);

        t1.start();
        t2.start();
        t3.start();
    }
}
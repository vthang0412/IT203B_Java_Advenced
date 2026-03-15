package Session06;

public class BoxOffice implements Runnable{
    private String boxName;
    private TrainStation trainStation;

    public BoxOffice(){}

    public BoxOffice(String boxName, TrainStation trainStation){
        this.boxName = boxName;
        this.trainStation = trainStation;
    }

    public String getBoxName(){
        return boxName;
    }

    public void setBoxName(String boxName){
        this.boxName = boxName;
    }

    public TrainStation getTrainStation(){
        return trainStation;
    }

    public void setTrainStation(TrainStation trainStation){
        this.trainStation = trainStation;
    }

    @Override
    public synchronized void run(){
        while(trainStation.getQuantity() > 0){
            trainStation.sellTicket(boxName);
        }
    }
}
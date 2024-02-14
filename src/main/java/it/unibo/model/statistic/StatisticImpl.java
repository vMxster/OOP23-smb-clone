package it.unibo.model.statistic;

public class StatisticImpl implements Statistic{
    private int deaths;
    private int recordTime; 
    
    public StatisticImpl() {
        this.deaths = 0;
        this.recordTime = Integer.MAX_VALUE;
    }

    @Override
    public void addDeaths() {
        this.deaths++;
    }

    @Override
    public void updateRecord(int time) {
        if (time < this.recordTime) {
            this.recordTime = time;
        }
    }

    @Override
    public int getDeaths() {
        return this.deaths;
    }

    @Override
    public int getRecordTime() {
        return this.recordTime;
    }

}

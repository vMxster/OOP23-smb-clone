package it.unibo.model.statistic;

public class StatisticImpl implements Statistic{
    private int deaths;
    //timer  
    
    public StatisticImpl() {
        this.deaths = 0;
    }

    @Override
    public void addDeaths() {
        deaths++;
    }

    @Override
    public void updateRecord() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRecord'");
    }

    @Override
    public int getDeaths() {
        return deaths;
    }

}

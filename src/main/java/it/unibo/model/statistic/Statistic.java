package it.unibo.model.statistic;

public interface Statistic {

    void addDeaths();

    void updateRecord(int time);

    int getDeaths();

    int getRecordTime();
}

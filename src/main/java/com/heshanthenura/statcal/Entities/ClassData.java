package com.heshanthenura.statcal.Entities;

public class ClassData {
    double lowerLimit;
    double upperLimit;
    double frequency;
    double mean;
    double deviation;
    double cumulativeFrequency;
    double u;
    double uu;
    double fu;
    double fuu;

    public ClassData(double lowerLimit, double upperLimit, double frequency, double mean, double deviation, double cumulativeFrequency, double u, double uu, double fu, double fuu) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.frequency = frequency;
        this.mean = mean;
        this.deviation = deviation;
        this.cumulativeFrequency = cumulativeFrequency;
        this.u = u;
        this.uu = uu;
        this.fu = fu;
        this.fuu = fuu;
    }

    public double getU() {
        return u;
    }

    public void setU(double u) {
        this.u = u;
    }

    public double getUu() {
        return uu;
    }

    public void setUu(double uu) {
        this.uu = uu;
    }

    public double getFu() {
        return fu;
    }

    public void setFu(double fu) {
        this.fu = fu;
    }

    public double getFuu() {
        return fuu;
    }

    public void setFuu(double fuu) {
        this.fuu = fuu;
    }

    public double getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public double getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(double upperLimit) {
        this.upperLimit = upperLimit;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getDeviation() {
        return deviation;
    }

    public void setDeviation(double deviation) {
        this.deviation = deviation;
    }

    public double getCumulativeFrequency() {
        return cumulativeFrequency;
    }

    public void setCumulativeFrequency(double cumulativeFrequency) {
        this.cumulativeFrequency = cumulativeFrequency;
    }

    @Override
    public String toString() {
        return "ClassData{" +
                "lowerLimit=" + lowerLimit +
                ", upperLimit=" + upperLimit +
                ", frequency=" + frequency +
                ", mean=" + mean +
                ", deviation=" + deviation +
                ", cumulativeFrequency=" + cumulativeFrequency +
                '}';
    }
}

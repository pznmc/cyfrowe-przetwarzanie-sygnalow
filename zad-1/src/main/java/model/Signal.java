package model;

import java.util.TreeMap;

public abstract class Signal {
    protected String signalType;
    protected String name;
    protected Double amplitude;
    protected Integer startTime;
    protected Integer duration;
    protected Double frequencySampling;

    protected TreeMap<Integer, Double> signal = new TreeMap<>();

    protected Double avg;               // średnia
    protected Double absoluteAvg;       // średnia bezwzględna
    protected Double avgSignalPower;    // moc średnia sygnału
    protected Double variance;          // wariancja
    protected Double rms;               // wartość skuteczna

    public Signal() {}

    @Override
    public String toString() {
        return name;
    }

    public TreeMap<Integer, Double> getData() {
        return signal;
    }

    protected void calcStats() {
        System.out.println(signal.values());
        avg = signal.values().stream().mapToDouble(Double::doubleValue).sum() / (double) signal.size();
        absoluteAvg = signal.values().stream().mapToDouble(Double::doubleValue).map(Math::abs).sum() / (double) signal.size();
        avgSignalPower = signal.values().stream().mapToDouble(Double::doubleValue).map(i -> Math.pow(i, 2)).sum() / (double) signal.size();
        variance = signal.values().stream().mapToDouble(Double::doubleValue).map(i -> Math.pow(i - avg, 2)).sum() / (double) signal.size();
        rms = Math.sqrt(avgSignalPower);
    }

    protected abstract void generateSignal();

    public String getName() { return name; }
    public Double getAvg() {
        return avg;
    }
    public Double getAbsoluteAvg() {
        return absoluteAvg;
    }
    public Double getAvgSignalPower() {
        return avgSignalPower;
    }
    public Double getVariance() {
        return variance;
    }
    public Double getRms() {
        return rms;
    }

    public int getMinValue() {
        return (int) signal.values().stream().mapToDouble(Double::doubleValue).min().getAsDouble();
    }

    public int getMaxValue() {
        return (int) signal.values().stream().mapToDouble(Double::doubleValue).max().getAsDouble();
    }

    public Integer getStartTime() {
        return startTime;
    }

    public Double getFrequencySampling() {
        return frequencySampling;
    }

    public Integer getDuration() {
        return duration;
    }

    public Double getAmplitude() {
        return amplitude;
    }

    public Integer getBaseInterval() {
        return null;
    }

    public Integer getFillFactor() {
        return null;
    }

    public Integer getJumpNum() {
        return null;
    }

    public Integer getJumpTime() {
        return null;
    }

    public Double getAmplitudeProbability() {
        return null;
    }

    public String getSignalType() {
        return signalType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public void setFrequencySampling(Double frequencySampling) {
        this.frequencySampling = frequencySampling;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setAmplitude(Double amplitude) {
        this.amplitude = amplitude;
    }

//    public void setBaseInterval(Integer baseInterval) {
//        this.baseInterval = baseInterval;
//    }
//
//    public void setFillFactor(Integer fillFactor) {
//        this.fillFactor = fillFactor;
//    }
//
//    public void setJumpNum(Integer jumpNum) {
//        this.jumpNum = jumpNum;
//    }
//
//    public void setJumpTime(Integer jumpTime) {
//        this.jumpTime = jumpTime;
//    }
//
//    public void setAmplitudeProbability(Double amplitudeProbability) {
//        this.amplitudeProbability = amplitudeProbability;
//    }

    public void setSignalType(String signalType) {
        this.signalType = signalType;
    }
}
package com.aghairsalon.resourceserver.services;

public class QualityMetricsService {

    public int calculatePercentage(int value, int total) {
        if (total <= 0 || value <= 0) {
            return 0;
        }

        float percentage = (value * 100.0f) / total;
        return Math.round(percentage);
    }

    public boolean isCoverageAcceptable(int currentCoverage, int minimumCoverage) {
        return currentCoverage >= minimumCoverage;
    }

 
    public int calculateDefectReductionPercentage(int previousDefects, int currentDefects) {
        if (previousDefects <= 0) {
            return 0;
        }

        if (currentDefects < 0) {
            throw new IllegalArgumentException("Current defects cannot be negative");
        }

        int reducedDefects = Math.max(0, previousDefects - currentDefects);
        return calculatePercentage(reducedDefects, previousDefects);
    }

    public boolean hasDefectCountImproved(int previousDefects, int currentDefects) {
        if (previousDefects < 0 || currentDefects < 0) {
            throw new IllegalArgumentException("Defect counts cannot be negative");
        }

        return currentDefects <= previousDefects;
    }
}

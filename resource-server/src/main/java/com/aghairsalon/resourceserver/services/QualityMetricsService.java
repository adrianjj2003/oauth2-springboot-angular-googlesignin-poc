package com.aghairsalon.resourceserver.services;


public class QualityMetricsService {

    public int calculatePercentage(int coveredLines, int totalLines) {
        if (totalLines <= 0) {
            return 0;
        }
        double ratio = (coveredLines * 100.0) / totalLines;
        return (int) Math.round(ratio);
    }


    public boolean isCoverageAcceptable(int coverage, int minimumThreshold) {
        return coverage >= minimumThreshold;
    }
}

package com.aghairsalon.resourceserver.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QualityMetricsServiceTest {

    private final QualityMetricsService service = new QualityMetricsService();

    @Test
    void calculatePercentageReturnsZeroWhenTotalIsZero() {
        int result = service.calculatePercentage(10, 0);
        assertEquals(0, result);
    }

    @Test
    void calculatePercentageRoundsCorrectly() {
        assertEquals(50, service.calculatePercentage(1, 2));
        assertEquals(33, service.calculatePercentage(1, 3));
    }

    @Test
    void isCoverageAcceptableReturnsTrueWhenCoverageAboveThreshold() {
        assertTrue(service.isCoverageAcceptable(80, 70));
    }

    @Test
    void isCoverageAcceptableReturnsFalseWhenCoverageBelowThreshold() {
        assertFalse(service.isCoverageAcceptable(60, 70));
    }
        @Test
    void defectReductionIsZeroWhenNoPreviousDefects() {
        int result = service.calculateDefectReductionPercentage(0, 5);

        assertEquals(0, result);
    }

    @Test
    void defectReductionIsPositiveWhenDefectsDecrease() {
        int result = service.calculateDefectReductionPercentage(10, 5);

        assertEquals(50, result);
    }

    @Test
    void defectReductionIsZeroWhenDefectsIncrease() {
        int result = service.calculateDefectReductionPercentage(5, 8);

        assertEquals(0, result);
    }

    @Test
    void defectCountImprovedReturnsTrueWhenDefectsDecrease() {
        boolean improved = service.hasDefectCountImproved(10, 3);

        assertTrue(improved);
    }

    @Test
    void defectCountImprovedReturnsFalseWhenDefectsIncrease() {
        boolean improved = service.hasDefectCountImproved(3, 5);

        assertFalse(improved);
    }

    @Test
    void metricsThrowExceptionForNegativeDefectCounts() {
        assertThrows(IllegalArgumentException.class,
                () -> service.calculateDefectReductionPercentage(5, -1));

        assertThrows(IllegalArgumentException.class,
                () -> service.hasDefectCountImproved(-1, 0));
    }

}

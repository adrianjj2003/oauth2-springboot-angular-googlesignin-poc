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
}

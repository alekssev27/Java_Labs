
package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataSampleTest {

    @Test
    void shouldCreateValidSample() {
        double[] features = {2.0, 4.0, 6.0};

        DataSample sample = new DataSample(
                "sample-1",
                "cat",
                SampleStatus.PENDING,
                features
        );

        assertEquals("sample-1", sample.getId());
        assertEquals("cat", sample.getLabel());
        assertEquals(SampleStatus.PENDING, sample.getStatus());
        assertArrayEquals(features, sample.getFeatures());
    }

    @Test
    void shouldChangeStatus() {
        DataSample sample = new DataSample(
                "sample-1",
                "cat",
                SampleStatus.PENDING,
                new double[]{2.0, 4.0}
        );

        sample.changeStatus(SampleStatus.READY);

        assertEquals(SampleStatus.READY, sample.getStatus());
        assertTrue(sample.isReady());
    }

    @Test
    void shouldCalculateAverageFeatures() {
        DataSample sample = new DataSample(
                "sample-1",
                "cat",
                SampleStatus.PENDING,
                new double[]{3.0, 6.0, 9.0}
        );

        assertEquals(6.0, sample.averageFeatures(), 0.0001);
    }

    @Test
    void shouldRejectNullId() {
        assertThrows(IllegalArgumentException.class, () ->
                new DataSample(
                        null,
                        "cat",
                        SampleStatus.PENDING,
                        new double[]{1.0}
                )
        );
    }

    @Test
    void shouldRejectEmptyId() {
        assertThrows(IllegalArgumentException.class, () ->
                new DataSample(
                        "", "cat", SampleStatus.PENDING,
                        new double[]{1.0}
                )
        );
    }

    @Test
    void shouldRejectNullLabel() {
        assertThrows(IllegalArgumentException.class, () ->
                new DataSample(
                        "sample-1", null, SampleStatus.PENDING,
                        new double[]{1.0}
                )
        );
    }

    @Test
    void shouldRejectEmptyLabel() {
        assertThrows(IllegalArgumentException.class, () ->
                new DataSample(
                        "sample-1", "", SampleStatus.PENDING,
                        new double[]{1.0}
                )
        );
    }

    @Test
    void shouldRejectNullStatus() {
        assertThrows(IllegalArgumentException.class, () ->
                new DataSample(
                        "sample-1", "cat", null,
                        new double[]{1.0}
                )
        );
    }

    @Test
    void shouldRejectNullFeatures() {
        assertThrows(IllegalArgumentException.class, () ->
                new DataSample(
                        "sample-1", "cat", SampleStatus.PENDING,
                        null
                )
        );
    }

    @Test
    void shouldRejectEmptyFeatures() {
        assertThrows(IllegalArgumentException.class, () ->
                new DataSample(
                        "sample-1", "cat", SampleStatus.PENDING,
                        new double[]{}
                )
        );
    }

    @Test
    void shouldProtectFeaturesFromExternalChanges() {
        double[] features = {1.0, 2.0};

        DataSample sample = new DataSample(
                "sample-1", "cat", SampleStatus.PENDING, features
        );

        features[0] = 999.0;

        assertArrayEquals(new double[]{1.0, 2.0}, sample.getFeatures());

        double[] returnedFeatures = sample.getFeatures();
        returnedFeatures[0] = 888.0;

        assertArrayEquals(new double[]{1.0, 2.0}, sample.getFeatures());
    }

    @Test
    void shouldRejectNullStatusChange() {
        DataSample sample = new DataSample(
                "sample-1", "cat", SampleStatus.PENDING,
                new double[]{1.0}
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> sample.changeStatus(null)
        );

        assertEquals(SampleStatus.PENDING, sample.getStatus());
    }
}


package io.github.gabbloquet.tddtraining.Thermometer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ThermometerTest {

    @Test
    public void shouldReturnZeroWhenNoTemperatures() {
        //Given
        var temperatures = new int[]{};

        //When
        var result = new Thermometer(temperatures).getClosestTemperatureToZero();

        //Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldThrowExceptionWhenTemperatesSizeExceedsThreshold() {
        //Given
        var temperatures = new int[10001];

        //When /Then
        assertThatThrownBy(() -> new Thermometer(temperatures).getClosestTemperatureToZero())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void shouldReturnClosestTemperatureToZeroWithOneTemperature() {
        //Given
        var temperatures = new int[]{2};

        //When
        var result = new Thermometer(temperatures).getClosestTemperatureToZero();

        //Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void shouldReturnClosestTemperatureToZeroWithPositiveTemperatures() {
        //Given
        var temperatures = new int[]{2, 9, 1};

        //When
        var result = new Thermometer(temperatures).getClosestTemperatureToZero();

        //Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldReturnClosestTemperatureToZeroWithOneNegativeTemperature() {
        //Given
        var temperatures = new int[]{2, 9, -1};

        //When
        var result = new Thermometer(temperatures).getClosestTemperatureToZero();

        //Then
        assertThat(result).isEqualTo(-1);
    }


    @Test
    public void shouldReturnClosestTemperatureToZeroWithNegativeTemperatures() {
        //Given
        var temperatures = new int[]{1, 9, -2, -3};

        //When
        var result = new Thermometer(temperatures).getClosestTemperatureToZero();

        //Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldPreferPositiveTemperatureClosestToZero() {
        //Given
        var temperatures = new int[]{2, 9, -2, -3};

        //When
        var result = new Thermometer(temperatures).getClosestTemperatureToZero();

        //Then
        assertThat(result).isEqualTo(2);
    }
}


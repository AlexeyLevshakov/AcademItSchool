package ru.academits.levshakov.temperatureconverter.model;

public class TemperatureConverterModel {
    private double conversionResult;

    public double getConversionResult() {
        return conversionResult;
    }

    public void convertTemperature(double initialTemperature, String initialScale, String finalScale) {
        switch (initialScale) {
            case "Цельсий":
                if (initialTemperature < -273.15) {
                    throw new IllegalArgumentException("Температура по шкале цельсия не может быть ниже -273.15 градусов");
                }

                if (finalScale.equals("Кельвин")) {
                    conversionResult = initialTemperature + 273.15;
                } else if (finalScale.equals("Фаренгейт")) {
                    conversionResult = initialTemperature * 9 / 5 + 32;
                }
                break;
            case "Кельвин":
                if (initialTemperature < 0) {
                    throw new IllegalArgumentException("Температура по шкале кельвина не может быть ниже нуля");
                }

                if (finalScale.equals("Цельсий")) {
                    conversionResult = initialTemperature - 273.15;
                } else if (finalScale.equals("Фаренгейт")) {
                    conversionResult = (initialTemperature - 273.15) * 9 / 5 + 32;
                }
                break;
            case "Фаренгейт":
                if (initialTemperature < -459.67) {
                    throw new IllegalArgumentException("Температура по шкале цельсия не может быть ниже -459.67");
                }

                if (finalScale.equals("Цельсий")) {
                    conversionResult = (initialTemperature - 32) * 5 / 9;
                } else if (finalScale.equals("Кельвин")) {
                    conversionResult = (initialTemperature - 32) * 5 / 9 + 273.15;
                }
                break;
        }

        if (initialScale.equals(finalScale)) {
            conversionResult = initialTemperature;
        }
    }
}

package ru.academits.levshakov.temperatureconverter.main;

import ru.academits.levshakov.temperatureconverter.controller.TemperatureConverterController;
import ru.academits.levshakov.temperatureconverter.model.TemperatureConverterModel;
import ru.academits.levshakov.temperatureconverter.view.TemperatureConverterView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TemperatureConverterView theView = new TemperatureConverterView();
            TemperatureConverterModel theModel = new TemperatureConverterModel();
            TemperatureConverterController theController = new TemperatureConverterController(theView, theModel);
        });
    }
}

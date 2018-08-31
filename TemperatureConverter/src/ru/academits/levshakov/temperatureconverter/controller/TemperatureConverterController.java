package ru.academits.levshakov.temperatureconverter.controller;

import ru.academits.levshakov.temperatureconverter.model.TemperatureConverterModel;
import ru.academits.levshakov.temperatureconverter.view.TemperatureConverterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterController {
    private TemperatureConverterView theView;
    private TemperatureConverterModel theModel;

    public TemperatureConverterController(TemperatureConverterView theView, TemperatureConverterModel theModel) {
        this.theModel = theModel;
        this.theView = theView;

        this.theView.addConversionButtonActionListener(new ButtonListener());
    }

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double initialTemperature = theView.getInitialTemperature();
                String initialScale = theView.getInitialScale();
                String finalScale = theView.getFinalScale();

                theModel.convertTemperature(initialTemperature, initialScale, finalScale);

                theView.setFinalTemperature(theModel.getConversionResult());
            } catch (NumberFormatException exception) {
                theView.displayErrorMessage("Нужно ввести число");
            } catch (IllegalArgumentException exception) {
                theView.displayErrorMessage("Такой низкой температуры не бывает");
            }
        }
    }
}

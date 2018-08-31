package ru.academits.levshakov.temperatureconverter.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TemperatureConverterView extends JFrame {
    private JTextField inputTemperatureField = new JTextField("Ввод");

    private JTextField outputTemperatureField = new JTextField("Вывод");

    private String[] temperatureScalesList = {"Цельсий", "Фаренгейт", "Кельвин"};

    private JComboBox<String> initialScaleChoice = new JComboBox<>(temperatureScalesList);

    private JComboBox<String> finalScaleChoice = new JComboBox<>(temperatureScalesList);

    private JButton conversionButton = new JButton("Перевести");

    public TemperatureConverterView() {
        this.setTitle("Конвертер температуры");

        ImageIcon icon = new ImageIcon("TemperatureConverter\\icon.jpg");
        this.setIconImage(icon.getImage());

        this.setSize(500, 100);
        Dimension minimumSize = new Dimension(500, 100);
        this.setMinimumSize(minimumSize);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());

        GridBagConstraints inputTemperatureFieldConstraints = new GridBagConstraints();
        inputTemperatureFieldConstraints.gridx = 0;
        inputTemperatureFieldConstraints.gridy = 0;
        inputTemperatureFieldConstraints.weightx = 0.33;
        inputTemperatureFieldConstraints.weighty = 0.5;
        inputTemperatureFieldConstraints.fill = GridBagConstraints.BOTH;
        this.add(inputTemperatureField, inputTemperatureFieldConstraints);

        outputTemperatureField.setEditable(false);
        GridBagConstraints outputTemperatureFieldConstraints = new GridBagConstraints();
        outputTemperatureFieldConstraints.gridx = 2;
        outputTemperatureFieldConstraints.gridy = 0;
        outputTemperatureFieldConstraints.weightx = 0.33;
        outputTemperatureFieldConstraints.weighty = 0.5;
        outputTemperatureFieldConstraints.fill = GridBagConstraints.BOTH;
        this.add(outputTemperatureField, outputTemperatureFieldConstraints);

        GridBagConstraints initialScaleChoiceConstraints = new GridBagConstraints();
        initialScaleChoiceConstraints.gridx = 0;
        initialScaleChoiceConstraints.gridy = 1;
        initialScaleChoiceConstraints.weightx = 0.33;
        initialScaleChoiceConstraints.weighty = 0.5;
        initialScaleChoiceConstraints.fill = GridBagConstraints.BOTH;
        this.add(initialScaleChoice, initialScaleChoiceConstraints);

        GridBagConstraints finalScaleChoiceConstraints = new GridBagConstraints();
        finalScaleChoiceConstraints.gridx = 2;
        finalScaleChoiceConstraints.gridy = 1;
        finalScaleChoiceConstraints.weightx = 0.33;
        finalScaleChoiceConstraints.weighty = 0.5;
        finalScaleChoiceConstraints.fill = GridBagConstraints.BOTH;
        this.add(finalScaleChoice, finalScaleChoiceConstraints);

        GridBagConstraints conversionButtonConstraints = new GridBagConstraints();
        conversionButtonConstraints.gridx = 1;
        conversionButtonConstraints.gridy = 0;
        conversionButtonConstraints.gridheight = 2;
        conversionButtonConstraints.weightx = 0.33;
        conversionButtonConstraints.weighty = 1;
        conversionButtonConstraints.fill = GridBagConstraints.BOTH;
        this.add(conversionButton, conversionButtonConstraints);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public double getInitialTemperature() {
        return Double.parseDouble(inputTemperatureField.getText());
    }

    public void setFinalTemperature(double finalTemperature) {
        outputTemperatureField.setText(Double.toString(finalTemperature));
    }

    public String getInitialScale() {
        return (String) initialScaleChoice.getSelectedItem();
    }

    public String getFinalScale() {
        return (String) finalScaleChoice.getSelectedItem();
    }

    public void addConversionButtonActionListener(ActionListener listenForConversionButton) {
        conversionButton.addActionListener(listenForConversionButton);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}


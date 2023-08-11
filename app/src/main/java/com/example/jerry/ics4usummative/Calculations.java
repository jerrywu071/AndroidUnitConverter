package com.example.jerry.ics4usummative;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/*
* Name :: Jerry Wu
* Due :: May 29 2019
* Desc :: This class calculates and displays the conversions of the different units to the user
* DISCLAIMER :: Negative values are allowed, and will not yield errors.
* */
public class Calculations
{
   /*
    * This method converts and displays a mass based on what item in a spinner is selected
    */
    public static void calculateAndDisplayMass(TextView t, Spinner s, EditText e)
    {
        String item = (String)s.getSelectedItem();

        //check which item in the spinner is selected and calculate accordingly
        switch(item)
        {
            case "Kilograms to Pounds":
                t.setText(String.format("%.2f kilograms = %.2f pounds", Double.parseDouble(e.getText().toString()), Formulas.kilogramsToPounds(Double.parseDouble(e.getText().toString()))));
                break;

            case "Pounds to Kilograms":
                t.setText(String.format("%.2f pounds = %.2f kilograms", Double.parseDouble(e.getText().toString()), Formulas.poundsToKilograms(Double.parseDouble(e.getText().toString()))));
                break;

            case "Kilograms to Ounces":
                t.setText(String.format("%.2f kilograms = %.2f pounds", Double.parseDouble(e.getText().toString()), Formulas.kilogramsToOunces(Double.parseDouble(e.getText().toString()))));
                break;

            case "Ounces to Kilograms":
                t.setText(String.format("%.2f ounces = %.2f pounds", Double.parseDouble(e.getText().toString()), Formulas.ouncesToKilograms(Double.parseDouble(e.getText().toString()))));
                break;

            case "Pounds to Ounces":
                t.setText(String.format("%.2f pounds = %.2f ounces", Double.parseDouble(e.getText().toString()), Formulas.poundsToOunces(Double.parseDouble(e.getText().toString()))));
                break;

            case "Ounces to Pounds":
                t.setText(String.format("%.2f ounces = %.2f pounds", Double.parseDouble(e.getText().toString()), Formulas.ouncesToPounds(Double.parseDouble(e.getText().toString()))));
                break;

            default:
                t.setText("Nothing yet...");
                break;
        }
    }

    /*
     * This method converts and displays a distance measure based on what item in a spinner is selected
     */
    public static void calculateAndDisplayDistance(TextView t, Spinner s, EditText e)
    {
        String item = (String)s.getSelectedItem();

        //check which item in the spinner is selected and calculate accordingly
        switch(item)
        {
            case "Kilometers to Miles":
                t.setText(String.format("%.2f kilometers = %.2f miles", Double.parseDouble(e.getText().toString()), Formulas.kilometersToMiles(Double.parseDouble(e.getText().toString()))));
                break;

            case "Miles to Kilometers":
                t.setText(String.format("%.2f miles = %.2f kilometers", Double.parseDouble(e.getText().toString()), Formulas.milesToKilometer(Double.parseDouble(e.getText().toString()))));
                break;

            case "Kilometers to Meters":
                t.setText(String.format("%.2f kilometers = %.2f meters", Double.parseDouble(e.getText().toString()), Formulas.kilometersToMeters(Double.parseDouble(e.getText().toString()))));
                break;

            case "Meters to Kilometers":
                t.setText(String.format("%.2f meters = %.2f kilometers", Double.parseDouble(e.getText().toString()), Formulas.metersToKilometers(Double.parseDouble(e.getText().toString()))));
                break;

            case "Miles to Feet":
                t.setText(String.format("%.2f miles = %.2f feet", Double.parseDouble(e.getText().toString()), Formulas.milesToFeet(Double.parseDouble(e.getText().toString()))));
                break;

            case "Feet to Miles":
                t.setText(String.format("%.2f feet = %.2f miles", Double.parseDouble(e.getText().toString()), Formulas.feetToMiles(Double.parseDouble(e.getText().toString()))));
                break;

            case "Meters to Feet":
                t.setText(String.format("%.2f meters = %.2f feet", Double.parseDouble(e.getText().toString()), Formulas.metersToFeet(Double.parseDouble(e.getText().toString()))));
                break;

            case "Feet to Meters":
                t.setText(String.format("%.2f feet = %.2f meters", Double.parseDouble(e.getText().toString()), Formulas.feetToMeters(Double.parseDouble(e.getText().toString()))));
                break;

            default:
                t.setText("Nothing yet...");
                break;
        }
    }

    /*
     * This method converts and displays a speed measure based on what item in a spinner is selected
     */
    public static void calculateAndDisplaySpeed(TextView t, Spinner s, EditText e)
    {
        String item = (String)s.getSelectedItem();

        //check which item in the spinner is selected and calculate accordingly
        switch(item)
        {
            case "Km/h to Mph":
                t.setText(String.format("%.2f km/h = %.2f mph", Double.parseDouble(e.getText().toString()), Formulas.kmhToMph(Double.parseDouble(e.getText().toString()))));
                System.out.println("hi");
                break;

            case "Mph to Km/h":
                t.setText(String.format("%.2f mph = %.2f km/h", Double.parseDouble(e.getText().toString()), Formulas.mphToKmh(Double.parseDouble(e.getText().toString()))));
                break;

            case "Km/h to m/s":
                t.setText(String.format("%.2f km/h = %.2f m/s", Double.parseDouble(e.getText().toString()), Formulas.kmhToMs(Double.parseDouble(e.getText().toString()))));
                break;

            case "m/s to Km/h":
                t.setText(String.format("%.2f m/s = %.2f km/h", Double.parseDouble(e.getText().toString()), Formulas.msToKmh(Double.parseDouble(e.getText().toString()))));
                break;

            case "Mph to Fps":
                t.setText(String.format("%.2f mph = %.2f fps", Double.parseDouble(e.getText().toString()), Formulas.mphToFps(Double.parseDouble(e.getText().toString()))));
                break;

            case "Fps to Mph":
                t.setText(String.format("%.2f fps = %.2f mph", Double.parseDouble(e.getText().toString()), Formulas.fpsToMph(Double.parseDouble(e.getText().toString()))));
                break;

            case "m/s to Fps":
                t.setText(String.format("%.2f m/s = %.2f fps", Double.parseDouble(e.getText().toString()), Formulas.msToFps(Double.parseDouble(e.getText().toString()))));
                break;

            case "Fps to m/s":
                t.setText(String.format("%.2f fps = %.2f m/s", Double.parseDouble(e.getText().toString()), Formulas.fpsToMs(Double.parseDouble(e.getText().toString()))));
                break;

            default:
                t.setText("Nothing yet...");
                break;
        }
    }

    /*
     * This method converts and displays a temperature measure based on what item in a spinner is selected
     */
    public static void calculateAndDisplayTemperature(TextView t, Spinner s, EditText e)
    {
        String item = (String)s.getSelectedItem();

        //check which item in the spinner is selected and calculate accordingly
        switch(item)
        {
            case "Celsius to Fahrenheit":
                t.setText(String.format("%.2f celsius = %.2f fahrenheit", Double.parseDouble(e.getText().toString()), Formulas.celsiusToFahrenheit(Double.parseDouble(e.getText().toString()))));
                break;

            case "Fahrenheit to Celsius":
                t.setText(String.format("%.2f fahrenheit = %.2f celsius", Double.parseDouble(e.getText().toString()), Formulas.fahrenheitToCelsius(Double.parseDouble(e.getText().toString()))));
                break;

            case "Celsius to Kelvin":
                t.setText(String.format("%.2f celsius = %.2f kelvin", Double.parseDouble(e.getText().toString()), Formulas.celsiusToKelvin(Double.parseDouble(e.getText().toString()))));
                break;

            case "Kelvin to Celsius":
                t.setText(String.format("%.2f kelvin = %.2f celsius", Double.parseDouble(e.getText().toString()), Formulas.kelvinToCelsius(Double.parseDouble(e.getText().toString()))));
                break;

            case "Fahrenheit to Kelvin":
                t.setText(String.format("%.2f fahrenheit = %.2f kelvin", Double.parseDouble(e.getText().toString()), Formulas.fahrenheitToKelvin(Double.parseDouble(e.getText().toString()))));
                break;

            case "Kelvin to Fahrenheit":
                t.setText(String.format("%.2f kelvin = %.2f fahrenheit", Double.parseDouble(e.getText().toString()), Formulas.kelvinToFahrenheit(Double.parseDouble(e.getText().toString()))));
                break;

            default:
                t.setText("Nothing yet...");
                break;
        }
    }

    /*
     * This method converts and displays an angle measure based on what item in a spinner is selected
     */
    public static void calculateAndDisplayTrig(TextView t, Spinner s, EditText e)
    {
        String item = (String)s.getSelectedItem();

        //check which item in the spinner is selected and calculate accordingly
        switch(item)
        {
            case "Degrees to Radians":
                t.setText(String.format("%.2f degrees = %.2f radians", Double.parseDouble(e.getText().toString()), Formulas.degToRad(Double.parseDouble(e.getText().toString()))));
                break;

            case "Radians to Degrees":
                t.setText(String.format("%.2f radians = %.2f degrees", Double.parseDouble(e.getText().toString()), Formulas.radToDeg(Double.parseDouble(e.getText().toString()))));
                break;

            case "Degrees to Gradians":
                t.setText(String.format("%.2f degrees = %.2f gradians", Double.parseDouble(e.getText().toString()), Formulas.degToGrad(Double.parseDouble(e.getText().toString()))));
                break;

            case "Gradians to Degrees":
                t.setText(String.format("%.2f gradians = %.2f degrees", Double.parseDouble(e.getText().toString()), Formulas.gradToDeg(Double.parseDouble(e.getText().toString()))));
                break;

            case "Radians to Gradians":
                t.setText(String.format("%.2f radians = %.2f gradians", Double.parseDouble(e.getText().toString()), Formulas.radToGrad(Double.parseDouble(e.getText().toString()))));
                break;

            case "Gradians to Radians":
                t.setText(String.format("%.2f gradians = %.2f radians", Double.parseDouble(e.getText().toString()), Formulas.gradToRad(Double.parseDouble(e.getText().toString()))));
                break;

            default:
                t.setText("Nothing yet...");
                break;
        }
    }
}

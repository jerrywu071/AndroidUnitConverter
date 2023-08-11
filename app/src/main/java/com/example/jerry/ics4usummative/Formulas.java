package com.example.jerry.ics4usummative;

/*
* Name :: Jerry Wu
* Due :: May 29 2019
* Desc :: This class houses static methods to make calculations for the unit converter
* DISCLAIMER :: The formulas in this library allow negative numbers to be inputted.
* */
public class Formulas
{
    /* MASS */

    //this method converts kilograms to pounds
    public static double kilogramsToPounds(double kilograms)
    {
        return kilograms*2.20462;
    }

    //this method converts pounds to kilograms
    public static double poundsToKilograms(double pounds)
    {
        return pounds/2.20462;
    }

    //this method converts kilograms to ounces
    public static double kilogramsToOunces(double kilograms)
    {
        return kilograms*35.274;
    }

    //this method converts ounces to kilograms
    public static double ouncesToKilograms(double ounces)
    {
        return ounces/35.274;
    }

    //this method converts pounds to ounces
    public static double poundsToOunces(double pounds)
    {
        return pounds*16.0;
    }

    //this method converts ounces to pounds
    public static double ouncesToPounds(double ounces)
    {
        return ounces/16.0;
    }

    /* DISTANCE */

    //this method converts kilometers to miles
    public static double kilometersToMiles(double kilometers)
    {
        return kilometers*0.62137;
    }

    //this method converts miles to kilometers
    public static double milesToKilometer(double miles)
    {
        return miles/0.62137;
    }

    //this method converts kilometers to meters
    public static double kilometersToMeters(double kilometers)
    {
        return kilometers*1000.0;
    }

    //this method converts meters to kilometers
    public static double metersToKilometers(double meters)
    {
        return meters/1000.0;
    }

    //this method converts miles to feet
    public static double milesToFeet(double miles)
    {
        return miles*5280.0;
    }

    //this method converts feet to miles
    public static double feetToMiles(double feet)
    {
        return feet/5280.0;
    }

    //this method converts meters to feet
    public static double metersToFeet(double meters)
    {
        return meters/0.3048;
    }

    //this method converts feet to meters
    public static double feetToMeters(double feet)
    {
        return feet*0.3048;
    }

    /* SPEED */

    //this method converts km/h to mph
    public static double kmhToMph(double kmh)
    {
        return kmh*0.62137;
    }

    //this method converts mph to km/h
    public static double mphToKmh(double mph)
    {
        return mph/0.62137;
    }

    //this method converts km/h to m/s
    public static double kmhToMs(double kmh)
    {
        return kmh*(5/18.0);
    }

    //this method converts m/s to km/h
    public static double msToKmh(double ms)
    {
        return ms*(18/5.0);
    }

    //this method converts mph to fps
    public static double mphToFps(double mph)
    {
        return mph*1.467;
    }

    //this method converts fps to mph
    public static double fpsToMph(double fps)
    {
        return fps/1.467;
    }

    //this method converts m/s to fps
    public static double msToFps(double ms)
    {
        return ms*3.281;
    }

    //this method converts fps to m/s
    public static double fpsToMs(double fps)
    {
        return fps/3.281;
    }

    /* TEMPERATURE */

    //this method converts celsius to fahrenheit
    public static double celsiusToFahrenheit(double celsius)
    {
        return (celsius*(9/5.0)) + 32;
    }

    //this method converts fahrenheit to celsius
    public static double fahrenheitToCelsius(double fahrenheit)
    {
        return (fahrenheit - 32)*(5/9.0);
    }

    //this method converts celsius to kelvin
    public static double celsiusToKelvin(double celsius)
    {
        return celsius + 273.15;
    }

    //this method converts kelvin to celsius
    public static double kelvinToCelsius(double kelvin)
    {
        return kelvin - 273.15;
    }

    //this method converts fahrenheit to kelvin
    public static  double fahrenheitToKelvin(double fahrenheit)
    {
        return (fahrenheit + 459.67)*(5/9.0);
    }

    //this method converts kelvin to fahrenheit
    public static double kelvinToFahrenheit(double kelvin)
    {
        return kelvin*(9/5.0) - 459.67;
    }

    /* TRIGONOMETRY */

    //this method converts degrees to radians
    public static double degToRad(double deg)
    {
        return  deg*(Math.PI/180.0);
    }

    //this method converts radians to degrees
    public static double radToDeg(double rad)
    {
        return  rad*(180.0/Math.PI);
    }

    //this method converts degrees to gradians
    public static double degToGrad(double deg)
    {
        return  deg*(10/9.0);
    }

    //this method converts gradians to degrees
    public static double gradToDeg(double grad)
    {
        return  grad*(9/10.0);
    }

    //this method converts radians to gradians
    public static double radToGrad(double rad)
    {
        return  rad*(200.0/Math.PI);
    }

    //this method converts gradians to radians
    public static double gradToRad(double grad)
    {
        return  grad*(Math.PI/200.0);
    }
}

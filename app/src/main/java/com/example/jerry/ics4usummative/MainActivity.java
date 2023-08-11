package com.example.jerry.ics4usummative;

//import android system classes to build the app
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

//import widget classes and their respective event handlers
import android.widget.AdapterView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;

//import classes for activity lifecycle and toast
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

/*
* Name :: Jerry Wu
* Due :: May 29 2019
* Desc :: This app is a basic unit converter that converts all elementary unit types such as mass, distance, speed, temperature, and angle measures.
* DISCLAIMER :: Negative values are allowed, and will not yield errors.
* */
public class MainActivity extends Activity
{
    //declare instance variables for all widgets
    private LinearLayout background;
    private Switch darkModeSwitch, rainbowTextSwitch;
    private Spinner massSelectionSpinner, distanceSelectionSpinner, speedSelectionSpinner, tempSelectionSpinner, trigSelectionSpinner;
    private EditText massAmountEditText, distanceAmountEditText, speedAmountEditText, tempAmountEditText, trigAmountEditText;
    private Button massCalcButton, distanceCalcButton, speedCalcButton, tempCalcButton, trigCalcButton;
    private TextView massConvertedTextView, distanceConvertedTextView, speedConvertedTextView, tempConvertedTextView, trigConvertedTextView;
    // Declare reference for a SharedPreferences object
    private SharedPreferences savedPrefs;

    /*This is onCreate, its where the good stuff happens. Called when app is opened for the first time*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        background = findViewById(R.id.container);

        //instantiate switches
        darkModeSwitch = findViewById(R.id.darkModeSwitch);
        darkModeSwitch.setOnCheckedChangeListener(new DarkModeListener());
        rainbowTextSwitch = findViewById(R.id.rainbowTextSwitch);
        rainbowTextSwitch.setOnCheckedChangeListener(new RainbowTextListener());
        rainbowTextSwitch.setEnabled(false);
        rainbowTextSwitch.setTextColor(Color.BLACK);

        //instantiate spinner objects for dropdown menus
        massSelectionSpinner = findViewById(R.id.massSelectionSpinner);
        distanceSelectionSpinner = findViewById(R.id.distanceSelectionSpinner);
        speedSelectionSpinner = findViewById(R.id.speedSelectionSpinner);
        tempSelectionSpinner = findViewById(R.id.tempSelectionSpinner);
        trigSelectionSpinner = findViewById(R.id.trigSelectionSpinner);

        //create ArrayAdapter objects for the spinners to use
        ArrayAdapter<CharSequence> massSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.mass_spinner_options, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> distanceSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.distance_spinner_options, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> speedSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.speed_spinner_options, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> tempSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.temp_spinner_options, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> trigSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.trig_spinner_options, android.R.layout.simple_spinner_item);

        //set dropdown view resources for the ArrayAdapter objects
        massSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distanceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speedSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tempSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        trigSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //set the adapter for the spinners
        massSelectionSpinner.setAdapter(massSpinnerAdapter);
        distanceSelectionSpinner.setAdapter(distanceSpinnerAdapter);
        speedSelectionSpinner.setAdapter(speedSpinnerAdapter);
        tempSelectionSpinner.setAdapter(tempSpinnerAdapter);
        trigSelectionSpinner.setAdapter(trigSpinnerAdapter);

        //set event handler for spinners
        massSelectionSpinner.setOnItemSelectedListener(new SpinnerListener());
        distanceSelectionSpinner.setOnItemSelectedListener(new SpinnerListener());
        speedSelectionSpinner.setOnItemSelectedListener(new SpinnerListener());
        tempSelectionSpinner.setOnItemSelectedListener(new SpinnerListener());
        trigSelectionSpinner.setOnItemSelectedListener(new SpinnerListener());

        //instantiate EditText objects to enter values for calculations
        massAmountEditText = findViewById(R.id.massAmountEditText);
        distanceAmountEditText = findViewById(R.id.distanceAmountEditText);
        speedAmountEditText = findViewById(R.id.speedAmountEditText);
        tempAmountEditText = findViewById(R.id.tempAmountEditText);
        trigAmountEditText = findViewById(R.id.trigAmountEditText);

        //change the background colour of the EditTexts
        massAmountEditText.setBackgroundColor(0xFFC8C8C8);
        distanceAmountEditText.setBackgroundColor(0xFFC8C8C8);
        speedAmountEditText.setBackgroundColor(0xFFC8C8C8);
        tempAmountEditText.setBackgroundColor(0xFFC8C8C8);
        trigAmountEditText.setBackgroundColor(0xFFC8C8C8);

        //instantiate Button objects to make calculations
        massCalcButton = findViewById(R.id.massCalcButton);
        distanceCalcButton = findViewById(R.id.distanceCalcButton);
        speedCalcButton = findViewById(R.id.speedCalcButton);
        tempCalcButton = findViewById(R.id.tempCalcButton);
        trigCalcButton = findViewById(R.id.trigCalcButton);

        //add event handling to buttons
        massCalcButton.setOnClickListener(new ButtonListener());
        distanceCalcButton.setOnClickListener(new ButtonListener());
        speedCalcButton.setOnClickListener(new ButtonListener());
        tempCalcButton.setOnClickListener(new ButtonListener());
        trigCalcButton.setOnClickListener(new ButtonListener());

        //instantiate TextView objects to display conversion info to the user
        massConvertedTextView = findViewById(R.id.massConvertedTextView);
        distanceConvertedTextView = findViewById(R.id.distanceConvertedTextView);
        speedConvertedTextView = findViewById(R.id.speedConvertedTextView);
        tempConvertedTextView = findViewById(R.id.tempConvertedTextView);
        trigConvertedTextView = findViewById(R.id.trigConvertedTextView);

        // get SharedPreferences object
        savedPrefs = getSharedPreferences( "ChangeCalculatorPrefs", MODE_PRIVATE );
    }

    /*Called when app is exited*/
    @Override
    public void onPause()
    {
        Editor prefsEditor = savedPrefs.edit();

        //get values entered in EditTexts
        String savedMass = massAmountEditText.getText().toString();
        String savedDistance = distanceAmountEditText.getText().toString();
        String savedSpeed = distanceAmountEditText.getText().toString();
        String savedTemp = tempAmountEditText.getText().toString();
        String savedTrig = trigAmountEditText.getText().toString();

        //get values selected in the spinners
        String savedMassSelection = (String) massSelectionSpinner.getSelectedItem();
        String savedDistanceSelection = (String) distanceSelectionSpinner.getSelectedItem();
        String savedSpeedSelection = (String) speedSelectionSpinner.getSelectedItem();
        String savedTempSelection = (String) tempSelectionSpinner.getSelectedItem();
        String savedTrigSelection = (String) trigSelectionSpinner.getSelectedItem();

        //save EditText values
        prefsEditor.putString("savedMass", savedMass);
        prefsEditor.putString("savedDistance", savedDistance);
        prefsEditor.putString("savedSpeed", savedSpeed);
        prefsEditor.putString("savedTemp", savedTemp);
        prefsEditor.putString("savedTrig", savedTrig);

        //save selected spinner values
        prefsEditor.putString("savedMassSelection", savedMassSelection);
        prefsEditor.putString("savedDistanceSelection", savedDistanceSelection);
        prefsEditor.putString("savedSpeedSelection", savedSpeedSelection);
        prefsEditor.putString("savedTempSelection", savedTempSelection);
        prefsEditor.putString("savedTrigSelection", savedTrigSelection);

        prefsEditor.apply();

        // Calling the parent onPause() must be done LAST
        super.onPause();
    }

    /*Called when app resumes*/
    @Override
    public void onResume()
    {
        super.onResume();

        //load values that were entered in the EditTexts
        String savedMass = savedPrefs.getString("savedMass", "0");
        String savedDistance = savedPrefs.getString("savedDistance", "0");
        String savedSpeed = savedPrefs.getString("savedSpeed", "0");
        String savedTemp = savedPrefs.getString("savedTemp", "0");
        String savedTrig = savedPrefs.getString("savedTrig", "0");

        //load the value that was selected on the spinners
        String savedMassSelection = savedPrefs.getString("savedMassSelection", "Kilograms to Pounds");
        String savedDistanceSelection = savedPrefs.getString("savedDistanceSelection", "Kilometers to Miles");
        String savedSpeedSelection = savedPrefs.getString("savedSpeedSelection", "Km/h to Mph");
        String savedTempSelection = savedPrefs.getString("savedTempSelection", "Celsius to Fahrenheit");
        String savedTrigSelection = savedPrefs.getString("savedTrigSelection", "Degrees to Radians");

        //set the saved string value on each EditText
        massAmountEditText.setText(savedMass);
        distanceAmountEditText.setText(savedDistance);
        speedAmountEditText.setText(savedSpeed);
        tempAmountEditText.setText(savedTemp);
        trigAmountEditText.setText(savedTrig);

        //set all spinners to their saved item selections
        setSavedMassSelection(massSelectionSpinner, savedMassSelection);
        setSavedDistanceSelection(distanceSelectionSpinner, savedDistanceSelection);
        setSavedSpeedSelection(speedSelectionSpinner, savedSpeedSelection);
        setSavedTempSelection(tempSelectionSpinner, savedTempSelection);
        setSavedTrigSelection(trigSelectionSpinner, savedTrigSelection);

        //calculate and display for all text views
        Calculations.calculateAndDisplayMass(massConvertedTextView, massSelectionSpinner, massAmountEditText);
        Calculations.calculateAndDisplayDistance(distanceConvertedTextView, distanceSelectionSpinner, distanceAmountEditText);
        Calculations.calculateAndDisplaySpeed(speedConvertedTextView, speedSelectionSpinner, speedAmountEditText);
        Calculations.calculateAndDisplayTemperature(tempConvertedTextView, tempSelectionSpinner, tempAmountEditText);
        Calculations.calculateAndDisplayTrig(trigConvertedTextView, trigSelectionSpinner, trigAmountEditText);


        Toast.makeText( this, "Welcome back!", Toast.LENGTH_LONG).show();
    }

    /*This helper method sets the text colour of the entire app*/
    private void setComponentTextColor(int color)
    {
        //get the selected view of the spinner
        View massView = massSelectionSpinner.getSelectedView();
        View distanceView = distanceSelectionSpinner.getSelectedView();
        View speedView = speedSelectionSpinner.getSelectedView();
        View tempView = tempSelectionSpinner.getSelectedView();
        View trigView = trigSelectionSpinner.getSelectedView();

        //set button text colour
        massCalcButton.setTextColor(color);
        distanceCalcButton.setTextColor(color);
        speedCalcButton.setTextColor(color);
        tempCalcButton.setTextColor(color);
        trigCalcButton.setTextColor(color);

        //set the text color to WHITE for all EditText widgets
        massAmountEditText.setTextColor(color);
        distanceAmountEditText.setTextColor(color);
        speedAmountEditText.setTextColor(color);
        tempAmountEditText.setTextColor(color);
        trigAmountEditText.setTextColor(color);

        //set the text color to WHITE for all TextView widgets
        massConvertedTextView.setTextColor(color);
        distanceConvertedTextView.setTextColor(color);
        speedConvertedTextView.setTextColor(color);
        tempConvertedTextView.setTextColor(color);
        trigConvertedTextView.setTextColor(color);

        //set switch text color to black
        darkModeSwitch.setTextColor(color);
        rainbowTextSwitch.setTextColor(color);

        //set spinner text colour to WHITE
        ((TextView) massView).setTextColor(color);
        ((TextView) distanceView).setTextColor(color);
        ((TextView) speedView).setTextColor(color);
        ((TextView) tempView).setTextColor(color);
        ((TextView) trigView).setTextColor(color);
    }

    /*This helper method is used to set the spinner option that was saved for the mass spinner*/
    private void setSavedMassSelection(Spinner massSelectionSpinner, String savedMassSelection)
    {
        //check what item was saved for mass and set it to that item
        switch(savedMassSelection)
        {
            case "Kilograms to Pounds":
                massSelectionSpinner.setSelection(0);
                break;

            case "Pounds to Kilograms":
                massSelectionSpinner.setSelection(1);
                break;

            case "Kilograms to Ounces":
                massSelectionSpinner.setSelection(2);
                break;

            case "Ounces to Kilograms":
                massSelectionSpinner.setSelection(3);
                break;

            case "Pounds to Ounces":
                massSelectionSpinner.setSelection(4);
                break;

            case "Ounces to Pounds":
                massSelectionSpinner.setSelection(5);
                break;

            default:
                massSelectionSpinner.setSelection(0);
                break;
        }
    }

    /*This helper method is used to set the spinner option that was saved for the distance spinner*/
    private void setSavedDistanceSelection(Spinner distanceSelectionSpinner, String savedDistanceSelection)
    {
        //check what item was saved for distance and set it to that item
        switch(savedDistanceSelection)
        {
            case "Kilometers to Miles":
                distanceSelectionSpinner.setSelection(0);
                break;

            case "Miles to Kilometers":
                distanceSelectionSpinner.setSelection(1);
                break;

            case "Kilometers to Meters":
                distanceSelectionSpinner.setSelection(2);
                break;

            case "Meters to Kilometers":
                distanceSelectionSpinner.setSelection(3);
                break;

            case "Miles to Feet":
                distanceSelectionSpinner.setSelection(4);
                break;

            case "Feet to Miles":
                distanceSelectionSpinner.setSelection(5);
                break;

            case "Meters to Feet":
                distanceSelectionSpinner.setSelection(6);
                break;

            case "Feet to Meters":
                distanceSelectionSpinner.setSelection(7);
                break;

            default:
                distanceSelectionSpinner.setSelection(0);
                break;
        }
    }

    /*This helper method is used to set the spinner option that was saved for the speed spinner*/
    private void setSavedSpeedSelection(Spinner speedSelectionSpinner, String savedSpeedSelection)
    {
        //check what item was saved for speed and set it to that item
        switch(savedSpeedSelection)
        {
            case "Km/h to Mph":
                speedSelectionSpinner.setSelection(0);
                break;

            case "Mph to Km/h":
                speedSelectionSpinner.setSelection(1);
                break;

            case "Km/h to m/s":
                speedSelectionSpinner.setSelection(2);
                break;

            case "m/s to Km/h":
                speedSelectionSpinner.setSelection(3);
                break;

            case "Mph to Fps":
                speedSelectionSpinner.setSelection(4);
                break;

            case "Fps to Mph":
                speedSelectionSpinner.setSelection(5);
                break;

            case "m/s to Fps":
                speedSelectionSpinner.setSelection(6);
                break;

            case "Fps to m/s":
                speedSelectionSpinner.setSelection(7);
                break;

            default:
                speedSelectionSpinner.setSelection(0);
                break;
        }
    }

    /*This helper method is used to set the spinner option that was saved for the temperature spinner*/
    private void setSavedTempSelection(Spinner tempSelectionSpinner, String savedTempSelection)
    {
        //check what item was saved for temperature and set it to that item
        switch(savedTempSelection)
        {
            case "Celsius to Fahrenheit":
                tempSelectionSpinner.setSelection(0);
                break;

            case "Fahrenheit to Celsius":
                tempSelectionSpinner.setSelection(1);
                break;

            case "Celsius to Kelvin":
                tempSelectionSpinner.setSelection(2);
                break;

            case "Kelvin to Celsius":
                tempSelectionSpinner.setSelection(3);
                break;

            case "Fahrenheit to Kelvin":
                tempSelectionSpinner.setSelection(4);
                break;

            case "Kelvin to Fahrenheit":
                tempSelectionSpinner.setSelection(5);
                break;

            default:
                tempSelectionSpinner.setSelection(0);
                break;
        }
    }

    /*This helper method is used to set the spinner option that was saved for the trigonometry spinner*/
    private void setSavedTrigSelection(Spinner trigSelectionSpinner, String savedTrigSelection)
    {
        //check what item was saved for angles and set it to that item
        switch(savedTrigSelection)
        {
            case "Degrees to Radians":
                trigSelectionSpinner.setSelection(0);
                break;

            case "Radians to Degrees":
                trigSelectionSpinner.setSelection(1);
                break;

            case "Degrees to Gradians":
                trigSelectionSpinner.setSelection(2);
                break;

            case "Gradians to Degrees":
                trigSelectionSpinner.setSelection(3);
                break;

            case "Radians to Gradians":
                trigSelectionSpinner.setSelection(4);
                break;

            case "Gradians to Radians":
                trigSelectionSpinner.setSelection(5);
                break;

            default:
                trigSelectionSpinner.setSelection(0);
                break;
        }
    }

    /*This class is used to handle events relating to the dark mode switch*/
    class DarkModeListener implements OnCheckedChangeListener
    {
        /*This method checks if the switch is on or off*/
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        {
            if(isChecked)
            {
                //set background colour to black
                background.setBackgroundColor(Color.BLACK);

                //change the background colour of the EditTexts
                massAmountEditText.setBackgroundColor(0xFF363636);
                distanceAmountEditText.setBackgroundColor(0xFF363636);
                speedAmountEditText.setBackgroundColor(0xFF363636);
                tempAmountEditText.setBackgroundColor(0xFF363636);
                trigAmountEditText.setBackgroundColor(0xFF363636);

                //turn on rainbow text functionality
                rainbowTextSwitch.setEnabled(true);

                //set all text to WHITE
                setComponentTextColor(Color.WHITE);
            }

            else
            {
                //set background colour to white
                background.setBackgroundColor(Color.WHITE);

                //change the background colour of the EditTexts
                massAmountEditText.setBackgroundColor(0xFFC8C8C8);
                distanceAmountEditText.setBackgroundColor(0xFFC8C8C8);
                speedAmountEditText.setBackgroundColor(0xFFC8C8C8);
                tempAmountEditText.setBackgroundColor(0xFFC8C8C8);
                trigAmountEditText.setBackgroundColor(0xFFC8C8C8);

                //turn off rainbow text functionality
                rainbowTextSwitch.setChecked(false);
                rainbowTextSwitch.setEnabled(false);

                //set all text color to BLACK
                setComponentTextColor(Color.BLACK);
            }
        }
    }

    /*This class is used to handle events relating to the colourful text switch*/
    class RainbowTextListener implements OnCheckedChangeListener
    {
        /*This method checks if the switch is on or off*/
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        {
            //get the selected view of the spinner
            View massView = massSelectionSpinner.getSelectedView();
            View distanceView = distanceSelectionSpinner.getSelectedView();
            View speedView = speedSelectionSpinner.getSelectedView();
            View tempView = tempSelectionSpinner.getSelectedView();
            View trigView = trigSelectionSpinner.getSelectedView();

            if(isChecked)
            {
                //set button text colour
                massCalcButton.setTextColor(Color.RED);
                distanceCalcButton.setTextColor(Color.GREEN);
                speedCalcButton.setTextColor(Color.BLUE);
                tempCalcButton.setTextColor(Color.YELLOW);
                trigCalcButton.setTextColor(Color.CYAN);

                //set the text color to white for all EditText widgets
                massAmountEditText.setTextColor(Color.RED);
                distanceAmountEditText.setTextColor(Color.GREEN);
                speedAmountEditText.setTextColor(Color.BLUE);
                tempAmountEditText.setTextColor(Color.YELLOW);
                trigAmountEditText.setTextColor(Color.CYAN);

                //set the text color to white for all TextView widgets
                massConvertedTextView.setTextColor(Color.RED);
                distanceConvertedTextView.setTextColor(Color.GREEN);
                speedConvertedTextView.setTextColor(Color.BLUE);
                tempConvertedTextView.setTextColor(Color.YELLOW);
                trigConvertedTextView.setTextColor(Color.CYAN);

                //set switch text color
                darkModeSwitch.setTextColor(Color.RED);
                rainbowTextSwitch.setTextColor(Color.BLUE);

                //set the spinner text colour to white
                ((TextView) massView).setTextColor(Color.RED);
                ((TextView) distanceView).setTextColor(Color.GREEN);
                ((TextView) speedView).setTextColor(Color.BLUE);
                ((TextView) tempView).setTextColor(Color.YELLOW);
                ((TextView) trigView).setTextColor(Color.CYAN);
            }

            else if(darkModeSwitch.isChecked())
            {
                //set all text to white
                setComponentTextColor(Color.WHITE);
            }

            else
            {
                //change the background colour of the EditTexts
                massAmountEditText.setBackgroundColor(0xFFC8C8C8);
                distanceAmountEditText.setBackgroundColor(0xFFC8C8C8);
                speedAmountEditText.setBackgroundColor(0xFFC8C8C8);
                tempAmountEditText.setBackgroundColor(0xFFC8C8C8);
                trigAmountEditText.setBackgroundColor(0xFFC8C8C8);

                //turn off rainbow text functionality
                rainbowTextSwitch.setChecked(false);
                rainbowTextSwitch.setEnabled(false);

                //set all text color to BLACK
                setComponentTextColor(Color.BLACK);
            }
        }
    }

    /*This class is used to handle events relating to the dropdown menus*/
    class SpinnerListener implements OnItemSelectedListener
    {
        /*This method checks which item in the spinners is selected*/
        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
        {
            //get the selected view of the spinner
            View massView = massSelectionSpinner.getSelectedView();
            View distanceView = distanceSelectionSpinner.getSelectedView();
            View speedView = speedSelectionSpinner.getSelectedView();
            View tempView = tempSelectionSpinner.getSelectedView();
            View trigView = trigSelectionSpinner.getSelectedView();

            if(darkModeSwitch.isChecked() && !rainbowTextSwitch.isChecked())
            {
                //set the spinner text colour to white to avoid it being reset
                ((TextView) massView).setTextColor(Color.WHITE);
                ((TextView) distanceView).setTextColor(Color.WHITE);
                ((TextView) speedView).setTextColor(Color.WHITE);
                ((TextView) tempView).setTextColor(Color.WHITE);
                ((TextView) trigView).setTextColor(Color.WHITE);
            }

            if(rainbowTextSwitch.isChecked())
            {
                //set the spinner text colour to rainbow colours
                ((TextView) massView).setTextColor(Color.RED);
                ((TextView) distanceView).setTextColor(Color.GREEN);
                ((TextView) speedView).setTextColor(Color.BLUE);
                ((TextView) tempView).setTextColor(Color.YELLOW);
                ((TextView) trigView).setTextColor(Color.CYAN);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parentView)
        {
            //doNothing(void)
        }
    }

    /*This class handles button events*/
    class ButtonListener implements OnClickListener
    {
        /*This method checks if a button has been pressed*/
        @Override
        public void onClick( View v )
        {
            int id = v.getId();
            try
            {
                //check which button is pressed and calculate accordingly
                switch(id)
                {
                    case(R.id.massCalcButton):
                        //calculate for mass
                        Calculations.calculateAndDisplayMass(massConvertedTextView, massSelectionSpinner, massAmountEditText);
                        break;

                    case(R.id.distanceCalcButton):
                        //calculate for distance
                        Calculations.calculateAndDisplayDistance(distanceConvertedTextView, distanceSelectionSpinner, distanceAmountEditText);
                        break;

                    case(R.id.speedCalcButton):
                        //calculate for speed
                        Calculations.calculateAndDisplaySpeed(speedConvertedTextView, speedSelectionSpinner, speedAmountEditText);
                        break;

                    case(R.id.tempCalcButton):
                        //calculate for temperature
                        Calculations.calculateAndDisplayTemperature(tempConvertedTextView, tempSelectionSpinner, tempAmountEditText);
                        break;

                    case(R.id.trigCalcButton):
                        //calculate for trig
                        Calculations.calculateAndDisplayTrig(trigConvertedTextView, trigSelectionSpinner, trigAmountEditText);
                        break;

                    default:
                        break;
                }
            }

            //make sure a string was not entered (a decimal point by itself counts as a string)
            catch(NumberFormatException e)
            {
                System.err.println("Enter numbers only!");
            }
        }
    }
}
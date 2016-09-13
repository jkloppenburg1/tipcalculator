package edu.orangecoastcollege.cs273.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


    private static NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static NumberFormat percent = NumberFormat.getPercentInstance();


    // Associate the controller with the needed views
    private EditText amountEditText;
    private TextView amountTextView;
    private TextView percentTextView;
   // private TextView tipTextView;
    private TextView tipAmountTextView;
    //private TextView totalTextView;
    private TextView totalAmountTextView;
    private SeekBar percentSeekBar;

    private RestaurantBill currentBill = new RestaurantBill();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect the controller with the widgets in our app
        amountEditText = (EditText) findViewById(R.id.amountEditText);
        amountTextView = (TextView) findViewById(R.id.amountTextView);
        percentTextView = (TextView) findViewById(R.id.percentTextView);
        //tipTextView = (TextView) findViewById(R.id.tipTextView);
        tipAmountTextView = (TextView) findViewById(R.id.tipAmountTextView);
        //totalTextView = (TextView) findViewById(R.id.totalTextView);
        totalAmountTextView = (TextView) findViewById(R.id.totalAmountTextView);
        percentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);

        //Define a listener for the amountEditText (onTextChanged)
        amountEditText.addTextChangedListener(amountTextChangedListener);

        // Define a listener for our percentSeekBar (onProgressChanged);
        percentSeekBar.setOnSeekBarChangeListener(percentChangedListener);
    }

    private TextWatcher amountTextChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //Try to get the amount from amountEditText
            try
            {
                if (charSequence.length() > 0) {
                    double amount = Double.parseDouble(charSequence.toString()) / 100.0;
                    currentBill.setAmount(amount);
                }
                else
                {
                    double amount = 0.0;
                    currentBill.setAmount(amount);
                }

            }
            catch (NumberFormatException e)
            {
                amountEditText.setText("");
            }

            //No exception, input is valid:

            updateViews();
        }

        @Override
        public void afterTextChanged(Editable editable)
        {


        }
    };

    private SeekBar.OnSeekBarChangeListener percentChangedListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            //Update the model with the new tip amount
            currentBill.setTipPercent(i / 100.0);

            // Update the percentTextView
            percentTextView.setText(percent.format(currentBill.getTipPercent()));

            //Update the views
            updateViews();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void updateViews()
    {
        // 1) Set the bill amount
        amountTextView.setText(currency.format(currentBill.getAmount()));

        // 2) Set the tip amount (tipTextView)
        tipAmountTextView.setText(currency.format(currentBill.getTipAmount()));

        //3
        totalAmountTextView.setText(currency.format(currentBill.getTotalAmount()));
    }
}

package edu.orangecoastcollege.cs273.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Associate the controller with the needed views
    private EditText amountEditText;
    private TextView amountTextView;
    private TextView percentTextView;
    private TextView tipTextView;
    private TextView tipAmountTextView;
    private TextView totalTextView;
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
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        tipAmountTextView = (TextView) findViewById(R.id.tipAmountTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        totalAmountTextView = (TextView) findViewById(R.id.totalAmountTextView);
        percentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);

        //Define a listener for the amountEditText (onTextChanged)
        amountEditText.addTextChangedListener(amountTextChangedListener);
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
                double amount = Double.parseDouble(charSequence.toString()) / 100;
                currentBill.setAmount(amount);
            }
            catch (NumberFormatException e)
            {
                amountEditText.setText("");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}

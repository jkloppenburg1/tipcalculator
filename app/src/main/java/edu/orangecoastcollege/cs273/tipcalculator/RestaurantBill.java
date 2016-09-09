package edu.orangecoastcollege.cs273.tipcalculator;

/**
 * Created by jkloppenburg1 on 9/8/2016.
 */
public class RestaurantBill
{
    private double mAmount;
    private double mTipPercent;
    private double mTipAmount;
    private double mTotalAmount;

    public RestaurantBill() {
        mTipAmount = 0.0;
        mTipPercent = 0.0;
        mTipAmount = 0.0;
        mTotalAmount = 0.0;
    }

    public RestaurantBill(double mAmount, double mTipPercent)
    {
        this.mAmount = mAmount;
        this.mTipPercent = mTipPercent;
        recalculateAmounts();
    }

    public double getAmount() {
        return mAmount;
    }

    public void setAmount(double mAmount) {
        this.mAmount = mAmount;
        recalculateAmounts();
    }

    public double getTipPercent() {
        return mTipPercent;
    }

    public void setTipPercent(double mTipPercent) {
        this.mTipPercent = mTipPercent;
        recalculateAmounts();
    }

    public double getTipAmount() {
        return mTipAmount;
    }

    public double getTotalAmount() {
        return mTotalAmount;
    }

    private void recalculateAmounts()
    {
        mTipAmount = mAmount * mTipPercent;
        mTotalAmount = mAmount + mTipAmount;
    }

}

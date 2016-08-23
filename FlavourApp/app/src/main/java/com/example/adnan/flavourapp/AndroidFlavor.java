

package com.example.adnan.flavourapp;



public class AndroidFlavor {


    private String mVersionName;


    private String mVersionNumber;

    // Drawable resource ID
    private int mImageResourceId;


    public AndroidFlavor(String vName, String vNumber, int imageResourceId)
    {
        mVersionName = vName;
        mVersionNumber = vNumber;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the Android version
     */
    public String getVersionName() {
        return mVersionName;
    }

    /**
     * Get the Android version number
     */
    public String getVersionNumber() {
        return mVersionNumber;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }


}

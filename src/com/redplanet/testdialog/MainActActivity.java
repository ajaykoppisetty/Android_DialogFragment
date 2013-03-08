package com.redplanet.testdialog;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_act, menu);
        return true;
    }

}

package com.redplanet.testdialog.ui;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import com.redplanet.testdialog.R;

public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_act, menu);
        return true;
    }

}

package com.murrayc.galaxyzoo.app;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class ExampleViewerActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_viewer);

        final Intent intent = getIntent();
        final String uriStr = intent.getStringExtra(ExampleViewerFragment.ARG_EXAMPLE_URL);

        final Bundle arguments = new Bundle();
        arguments.putString(ExampleViewerFragment.ARG_EXAMPLE_URL, uriStr);

        if (savedInstanceState == null) {
            final ExampleViewerFragment fragment = new ExampleViewerFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }

        // Show the Up button in the action bar.
        final ActionBar actionBar = getActionBar();
        if (actionBar == null)
            return;

        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}

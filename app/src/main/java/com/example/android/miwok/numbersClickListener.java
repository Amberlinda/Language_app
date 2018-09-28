package com.example.android.miwok;

import android.view.View;
import android.widget.Toast;

/**
 * Created by AUL on 9/11/2018.
 */

public class numbersClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "Opening...", Toast.LENGTH_SHORT).show();
    }
}

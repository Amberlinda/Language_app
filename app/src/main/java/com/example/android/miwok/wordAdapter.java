package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class wordAdapter extends ArrayAdapter<Word> {


    private static final String LOG_TAG = wordAdapter.class.getSimpleName();
    private int colorResourceId;

    public wordAdapter(Activity context, ArrayList<Word> words, int mcolorResourceId) {

        super(context, 0, words);
        colorResourceId = mcolorResourceId;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View list = convertView;
        if (list == null) {
            list = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);

        TextView defaultText = (TextView) list.findViewById(R.id.version_name);
        defaultText.setText(currentWord.getDefaultTranslation());

        TextView miwokText = (TextView) list.findViewById(R.id.version_number);
        miwokText.setText(currentWord.getMiwokTranslation());

        ImageView miwokimage = (ImageView) list.findViewById(R.id.miwok_image);
        if (currentWord.hasImage()) {
            miwokimage.setImageResource(currentWord.getmMiwokImage());
            miwokimage.setVisibility(View.VISIBLE);
        } else {
            miwokimage.setVisibility(View.GONE);
        }

        View textContainer = list.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), colorResourceId);
        textContainer.setBackgroundColor(color);


        return list;
    }
}

package com.example.myfirsttask.ui.main;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.myfirsttask.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    public int num;
    MediaPlayer mediaPlayer;
    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        num = index;
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);

        final TextView textView = root.findViewById(R.id.section_label);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        final ImageView imageView = root.findViewById(R.id.section_labe2);
        pageViewModel.getImage().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer number) {
                if(number == 1){
                    imageView.setImageResource(R.drawable.apple);
                }
                else if (number == 2){
                    imageView.setImageResource(R.drawable.orange);
                }
                else if(number == 3){
                    imageView.setImageResource(R.drawable.mango);
                }
                else{
                    imageView.setImageResource(R.drawable.lemon);
                }
            }
        });

        final Button learnmore = root.findViewById(R.id.learn_more);
        learnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num == 1){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://en.wikipedia.org/wiki/Apple"));
                    startActivity(intent);
                }
                else if (num == 2){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://en.wikipedia.org/wiki/Orange_(fruit)"));
                    startActivity(intent);
                }
                else if(num == 3){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://en.wikipedia.org/wiki/Mango"));
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://en.wikipedia.org/wiki/Lemon"));
                    startActivity(intent);
                }
            }
        });

        final FloatingActionButton fab = root.findViewById(R.id.pronunciation);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num == 1){
                    MediaPlayer.create(this, R.raw.apple).start();
                }
                else if (num == 2){
                    MediaPlayer.create(this, R.raw.orange).start();
                }
                else if(num == 3){
                    MediaPlayer.create(this, R.raw.mango).start();
                }
                else if(num == 4){
                    MediaPlayer.create(this, R.raw.lemon).start();
                }
            }
        });
        return root;
    }
}
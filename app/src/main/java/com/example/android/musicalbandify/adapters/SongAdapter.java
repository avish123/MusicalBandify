package com.example.android.musicalbandify.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.musicalbandify.R;
import com.example.android.musicalbandify.data_objects.Song;

import java.util.List;

/**
 * Created by avishai on 3/15/2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(@NonNull Context context, @NonNull List<Song> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        TextView songName = listItemView.findViewById(R.id.name);
        songName.setText(currentSong.getName());

        TextView singer = listItemView.findViewById(R.id.singer);
        singer.setText(currentSong.getSinger());

        TextView length = listItemView.findViewById(R.id.length);
        length.setText(currentSong.getLength());

        TextView stems = listItemView.findViewById(R.id.available_stems);
        stems.setText(currentSong.getStemsAsString());

        return listItemView;
    }
}

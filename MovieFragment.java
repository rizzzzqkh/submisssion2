package com.ziqo.picodiploma.gowatch.ui.movie;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ziqo.picodiploma.gowatch.R;

import java.util.ArrayList;

public class MovieFragment extends Fragment {

    private RecyclerView rvMovie;
    private ArrayList<Movie> list = new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvMovie = getActivity().findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);

        list.addAll(getListData());
        showRecyclerList();

    }

    private ArrayList<Movie> getListData() {
        String[] dataTitle = getResources().getStringArray(R.array.data_name_movie);
        String[] dataDescription = getResources().getStringArray(R.array.data_detail_movie);
        TypedArray dataPoster = getResources().obtainTypedArray(R.array.data_photo_movie);

        ArrayList<Movie> listMovie = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(dataTitle[i]);
            movie.setDescription(dataDescription[i]);
            movie.setPoster(dataPoster.getResourceId(i, -1));

            listMovie.add(movie);
        }
        return listMovie;
    }

    private void showRecyclerList() {
        rvMovie.setLayoutManager(new LinearLayoutManager(this.getContext()));
        MovieAdapter movieAdapter = new MovieAdapter(list);
        rvMovie.setAdapter(movieAdapter);

    }

}
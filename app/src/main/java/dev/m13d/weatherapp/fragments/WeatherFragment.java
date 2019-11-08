package dev.m13d.weatherapp.fragments;

import android.content.res.TypedArray;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import dev.m13d.weatherapp.R;

public class WeatherFragment extends Fragment {
    public static WeatherFragment create(int index) {
        WeatherFragment f = new WeatherFragment();    // создание

        // Передача параметра
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    // Получить индекс из списка (фактически из параметра)
    public int getIndex() {
        int index = getArguments().getInt("index", 0);
        return index;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Определить какой герб надо показать, и показать его
        ImageView coatOfArms = new ImageView(getActivity());

        // Получить из ресурсов массив указателей на изображения гербов
        TypedArray imgs = getResources().obtainTypedArray(R.array.coatofarms_imgs);
        // Выбрать по индексу подходящий
        coatOfArms.setImageResource(imgs.getResourceId(getIndex(), -1));
        return coatOfArms;     // Вместо макета используем сразу картинку
    }

}

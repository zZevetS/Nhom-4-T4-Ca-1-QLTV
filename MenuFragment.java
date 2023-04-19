package com.example.camnangmonan.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.camnangmonan.CategoryActivity;
import com.example.camnangmonan.ItemCallBack;
import com.example.camnangmonan.R;
import com.example.camnangmonan.menu.Menu;
import com.example.camnangmonan.menu.MenuAdapter;
import com.example.camnangmonan.menu.MenuDB;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment implements ItemCallBack {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }
    RecyclerView rcvMenu;
    MenuAdapter menuAdapter;
    ArrayList<Menu> listMenu;
    MenuDB menuDB;
    @Override
    public void onItemClick(String id){
        String[] fixInput = id.split(":");
        Intent i = new Intent(getActivity(), CategoryActivity.class);
        i.putExtra("id",fixInput[1]);
        startActivity(i);

    }

    @Override
    public boolean onCreateOptionMenu(Menu menu) {
        return false;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        Activity activity =getActivity();
        menuDB = new MenuDB(activity);
        listMenu = menuDB.getlistMenu();
        menuAdapter = new MenuAdapter(listMenu,getActivity(), this);
        rcvMenu = view.findViewById(R.id.rcmenu);
        rcvMenu.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        rcvMenu.setAdapter(menuAdapter);


    }
}
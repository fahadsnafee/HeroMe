package com.fahad.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fahad.herome.Activities.MainActivity;
import com.fahad.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.PickPowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements  View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button turtleBtn;
    private Button lightningBtn;
    private Button flightBtn;
    private Button webBtn;
    private Button laserBtn;
    private Button superBtn;
    private Button showBtn;

    private PickPowerInteractionListener mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
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
        View view = inflater.inflate(R.layout.fragment_pick_power, container, false);

        turtleBtn = view.findViewById(R.id.turtleBtn);
        lightningBtn = view.findViewById(R.id.lightningBtn);
        flightBtn = view.findViewById(R.id.flightBtn);
        webBtn = view.findViewById(R.id.webBtn);
        laserBtn = view.findViewById(R.id.laserBtn);
        superBtn = view.findViewById(R.id.superBtn);
        showBtn = view.findViewById(R.id.showBtn);

        turtleBtn.setOnClickListener(this);
        lightningBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        webBtn.setOnClickListener(this);
        laserBtn.setOnClickListener(this);
        superBtn.setOnClickListener(this);


        showBtn.setEnabled(false);
        showBtn.getBackground().setAlpha(128);

        // Inflate the layout for this fragment

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadStory();
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPickPowerFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        showBtn.setEnabled(true);
        showBtn.getBackground().setAlpha(255);

        turtleBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power,0,0,0);
        lightningBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thors_hammer, 0,0,0);
        flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.superman_crest, 0,0,0);
        webBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spiderweb, 0,0,0);
        laserBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision,0,0,0);
        superBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_strength,0,0,0);


        Button btn = (Button) v;

        MainActivity mainActivity = (MainActivity) getActivity();

        int leftDrawable = 0;

        if (btn == turtleBtn) {
            leftDrawable = R.drawable.turtle_power;
            mainActivity.HERO_NAME = "Michaelangelo";
            mainActivity.HERO_IMG = R.drawable.turtle_power;
            mainActivity.POWER_ACTUAL = "Smart";
            mainActivity.POWER_PICKED = "Turtle Power";
            mainActivity.POWER_SRC = R.drawable.turtle_power;
            mainActivity.POWER_SRC_SECONDARY = R.drawable.super_strength;
            mainActivity.HERO_STORY = R.string.turtle;
        } else if (btn == lightningBtn) {
            leftDrawable = R.drawable.thors_hammer;
            mainActivity.HERO_NAME = "Thor";
            mainActivity.HERO_IMG = R.drawable.thors_hammer;
            mainActivity.POWER_ACTUAL = "Lightning";
            mainActivity.POWER_PICKED = "Super Strength";
            mainActivity.POWER_SRC = R.drawable.lightning;
            mainActivity.POWER_SRC_SECONDARY = R.drawable.super_strength;
            mainActivity.HERO_STORY = R.string.thor;
        } else if (btn == flightBtn) {
            leftDrawable = R.drawable.superman_crest;
            mainActivity.HERO_NAME = "Superman";
            mainActivity.HERO_IMG = R.drawable.super_man_crest;
            mainActivity.POWER_ACTUAL = "Flight";
            mainActivity.POWER_PICKED = "Super Strength";
            mainActivity.POWER_SRC = R.drawable.super_man_crest;
            mainActivity.POWER_SRC_SECONDARY = R.drawable.superman_crest;
            mainActivity.HERO_STORY = R.string.superman_story;
        } else if (btn == webBtn) {
            leftDrawable = R.drawable.spiderweb;
            mainActivity.HERO_NAME = "Spiderman";
            mainActivity.HERO_IMG = R.drawable.spider_web;
            mainActivity.POWER_ACTUAL = "Spider webs";
            mainActivity.POWER_PICKED = "Super senses";
            mainActivity.POWER_SRC = R.drawable.spider_web;
            mainActivity.POWER_SRC_SECONDARY = R.drawable.spiderweb;
            mainActivity.HERO_STORY = R.string.spiderman;
        } else if (btn == laserBtn) {
            leftDrawable = R.drawable.laser_vision;
            mainActivity.HERO_NAME = "Cyclops";
            mainActivity.HERO_IMG = R.drawable.laser_vision;
            mainActivity.POWER_ACTUAL = "Laser";
            mainActivity.POWER_PICKED = "Laser Vision";
            mainActivity.POWER_SRC = R.drawable.laser_vision;
            mainActivity.POWER_SRC_SECONDARY = R.drawable.laser_vision;
            mainActivity.HERO_STORY = R.string.cyclops;
        } else if (btn == superBtn ){
            leftDrawable = R.drawable.super_strength;
            mainActivity.HERO_NAME = "Hulk";
            mainActivity.HERO_IMG = R.drawable.super_strength;
            mainActivity.POWER_ACTUAL = "Destruction Power";
            mainActivity.POWER_PICKED = "Super Strength";
            mainActivity.POWER_SRC = R.drawable.super_strength;
            mainActivity.POWER_SRC_SECONDARY = R.drawable.super_strength;
            mainActivity.HERO_STORY = R.string.hulk;
        }

        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, 0, R.drawable.item_selected, 0);

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PickPowerInteractionListener {
        // TODO: Update argument type and name
        void onPickPowerFragmentInteraction(Uri uri);
    }
}

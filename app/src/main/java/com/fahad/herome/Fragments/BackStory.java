package com.fahad.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fahad.herome.Activities.MainActivity;
import com.fahad.herome.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BackStory.BackStoryFragmentListener} interface
 * to handle interaction events.
 * Use the {@link BackStory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BackStory extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button startBtn;

    private BackStoryFragmentListener mListener;

    public BackStory() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BackStory.
     */
    // TODO: Rename and change types and number of parameters
    public static BackStory newInstance(String param1, String param2) {
        BackStory fragment = new BackStory();
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
        View view = inflater.inflate(R.layout.fragment_back_story, container, false);
        final MainActivity mainActivity = (MainActivity) getActivity();

        String powerPicked = mainActivity.POWER_PICKED;
        String powerHow = mainActivity.POWER_HOW;
        String powerActual = mainActivity.POWER_ACTUAL;
        String powerSecondary = mainActivity.POWER_SECONDARY;
        String heroName = mainActivity.HERO_NAME;
        int heroStory = mainActivity.HERO_STORY;
        int heroImg = mainActivity.HERO_IMG;
        int primarySRC = mainActivity.POWER_SRC;
        int secondarySRC = mainActivity.POWER_SRC_SECONDARY;

        Button PrimaryBtn = view.findViewById(R.id.primBtn);
        Button SecondaryBtn = view.findViewById(R.id.primBtn2);
        ImageView heroImage = view.findViewById(R.id.heroImg);
        TextView story = view.findViewById(R.id.storyText);
        TextView heroBigText = view.findViewById(R.id.heroText);
        TextView backStText = view.findViewById(R.id.backText);

        heroBigText.setText(heroName);
        heroImage.setImageResource(heroImg);
        PrimaryBtn.setCompoundDrawablesWithIntrinsicBounds(primarySRC,0,0,0);
        SecondaryBtn.setCompoundDrawablesWithIntrinsicBounds(secondarySRC,0,0,0);
        backStText.setText( "This is how you got your powers " + powerHow);
        story.setText(heroStory);
        PrimaryBtn.setText(powerActual);
        SecondaryBtn.setText(powerPicked);


        startBtn = view.findViewById(R.id.startBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.loadMainScreen();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onBackStoryFragment(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BackStoryFragmentListener) {
            mListener = (BackStoryFragmentListener) context;
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
    public interface BackStoryFragmentListener {
        // TODO: Update argument type and name
        void onBackStoryFragment(Uri uri);
    }
}

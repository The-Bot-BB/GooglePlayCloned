package com.pushpal.googleplayclone.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pushpal.googleplayclone.R;
import com.pushpal.googleplayclone.adapters.ViewPagerAdapter;
import com.pushpal.googleplayclone.viewPager.CustomViewPager;

import java.util.Objects;

public class HomeFragment extends Fragment {

    View view;
    private TabLayout subTabLayout;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        CustomViewPager viewPager = view.findViewById(R.id.homeViewPager);
        setupViewPager(viewPager);

        subTabLayout = view.findViewById(R.id.sub_tabs);
        subTabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(Objects.requireNonNull(getActivity()).getSupportFragmentManager());
        adapter.addFragment(new HomeForYouFragment(), "For You");
        adapter.addFragment(new HomeTopSellFragment(), "Top Selling");
        adapter.addFragment(new HomeNewReleaseFragment(), "New Releases");
        adapter.addFragment(new HomeGenresFragment(), "Genres");
        adapter.addFragment(new HomeEditorChoiceFragment(), "Editor's Choice");
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_sub_tab, null);
        tabOne.setText(R.string.tab_one);
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_explore_black_18dp, 0, 0);
        Objects.requireNonNull(subTabLayout.getTabAt(0)).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_sub_tab, null);
        tabTwo.setText(R.string.tab_two);
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_star_black_18dp, 0, 0);
        Objects.requireNonNull(subTabLayout.getTabAt(1)).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_sub_tab, null);
        tabThree.setText(R.string.tab_three);
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_movie_filter_black_18dp, 0, 0);
        Objects.requireNonNull(subTabLayout.getTabAt(2)).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_sub_tab, null);
        tabFour.setText(R.string.tab_four);
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_assistant_black_18dp, 0, 0);
        Objects.requireNonNull(subTabLayout.getTabAt(3)).setCustomView(tabFour);

        TextView tabFive = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_sub_tab, null);
        tabFive.setText(R.string.tab_five);
        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_group_work_black_18dp, 0, 0);
        Objects.requireNonNull(subTabLayout.getTabAt(4)).setCustomView(tabFive);
    }
}

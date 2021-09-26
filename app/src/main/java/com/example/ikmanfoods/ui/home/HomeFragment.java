package com.example.ikmanfoods.ui.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;

import com.example.ikmanfoods.CategoryFragment;
import com.example.ikmanfoods.R;
import com.example.ikmanfoods.SelectListFragment;
import com.example.ikmanfoods.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private ViewPager _pages;
    private TabLayout _tabs;
    private PagerAdapter _adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        _tabs = root.findViewById(R.id.menutabs);
        _pages = root.findViewById(R.id.pagetabs);
        _tabs.addTab(_tabs.newTab().setIcon(R.drawable.ic_menu_camera).setText("Category"));
        _tabs.addTab(_tabs.newTab().setIcon(R.drawable.ic_menu_camera).setText("Select List"));

        _adapter = new PagerAdapter(getActivity().getSupportFragmentManager(),_tabs.getTabCount());
        _pages.setAdapter(_adapter);
        _pages.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(_tabs));
        _tabs.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                _pages.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return root;
    }
    public class PagerAdapter extends FragmentPagerAdapter{
        int _numerodetabs;

        public PagerAdapter(FragmentManager fm, int _numerodetabs) {
            super(fm);
            this._numerodetabs = _numerodetabs;
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            switch(i){
                case 0:fragment  = new CategoryFragment(); break;
                case 1:fragment =  new SelectListFragment(); break;
                case 2:fragment =  new AddCartFragment(); break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return _numerodetabs;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
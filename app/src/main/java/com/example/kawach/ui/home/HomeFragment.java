package com.example.kawach.ui.home;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kawach.R;
import com.example.kawach.data.applistdata;
import com.example.kawach.databinding.FragmentHomeBinding;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        final PackageManager pm= getActivity().getPackageManager();
        List<ApplicationInfo> app_list=pm.getInstalledApplications(PackageManager.GET_META_DATA);
        recyclerView=root.findViewById(R.id.app_recyclerview);
        applistdata[] applists = new applistdata[0];
        int i=0;
        for (ApplicationInfo apps: app_list){
            applists[i].setDescription(apps.packageName);
            applists[i].setImgId(apps.loadLogo(getActivity().getPackageManager()));
            i++;
        }
        applist_recyclerview adapter = new applist_recyclerview(applists);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
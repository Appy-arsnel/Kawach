package com.example.kawach.ui.home;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kawach.R;
import com.example.kawach.data.applistdata;
import com.example.kawach.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    private static final String TAG = "MyActivity";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        final PackageManager pm= getActivity().getPackageManager();
        List<ApplicationInfo> app_list=pm.getInstalledApplications(PackageManager.GET_META_DATA);
        recyclerView=root.findViewById(R.id.app_recyclerview);
        try{
        Log.e(TAG,"Error");
         List<applistdata> applists=new ArrayList<>();
            for (ApplicationInfo apps: app_list){
                try {
                    PackageInfo packageInfo = pm.getPackageInfo(apps.packageName, PackageManager.GET_PERMISSIONS);

                    //Get Permissions
                    String[] requestedPermissions = packageInfo.requestedPermissions;

                    if(requestedPermissions != null) {
                        for (int i = 0; i < requestedPermissions.length; i++) {
                            Log.d("test", requestedPermissions[i]);
                        }
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(getContext(),"Error: "+e.toString(),Toast.LENGTH_LONG).show();

                }
             applistdata a=new applistdata();
                a.setDescription(apps.loadLabel(getContext().getPackageManager()).toString());
                Log.e(TAG,"Error");

                a.setImgId(apps.loadIcon(getContext().getPackageManager()));
                applists.add(a);

            }
            applist_recyclerview adapter = new applist_recyclerview(applists);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
            recyclerView.setAdapter(adapter);

        }
        catch (Exception e){
            Toast.makeText(getContext(),"Error: "+e.toString(),Toast.LENGTH_LONG).show();
         }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
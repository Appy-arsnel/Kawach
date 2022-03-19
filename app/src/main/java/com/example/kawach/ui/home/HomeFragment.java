package com.example.kawach.ui.home;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kawach.R;
import com.example.kawach.data.applistdata;
import com.example.kawach.databinding.FragmentHomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    private static final String TAG = "MyActivity";
    private EditText searchview;
    private applist_recyclerview adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        searchview=root.findViewById(R.id.searchedit);
        searchview.setVisibility(View.GONE);

        try {
    FloatingActionButton fab = root.findViewById(R.id.fab);
    binding.fab.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if((keyEvent.getAction()==KeyEvent.KEYCODE_BACK) ||(i == KeyEvent.KEYCODE_ENTER)){
               fab.setVisibility(View.GONE);
                return true;

            }
            fab.setVisibility(View.VISIBLE);


            return false;
        }
    });
    binding.fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            fab.setVisibility(View.GONE);

            searchview.setVisibility(View.VISIBLE);
            searchview.setImeActionLabel("Custom text", KeyEvent.KEYCODE_ENTER);

        }
    });
}
catch (Exception e){
    Toast.makeText(getContext(),"Error: "+e,Toast.LENGTH_LONG).show();
}


        final PackageManager pm= getActivity().getPackageManager();
        List<ApplicationInfo> app_list=pm.getInstalledApplications(PackageManager.GET_META_DATA);
        recyclerView=root.findViewById(R.id.app_recyclerview);

        List<applistdata> applists=new ArrayList<>();
        searchview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString(),app_list);
            }
        });

        try{
        Log.e(TAG,"Error");

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


        }
        catch (Exception e){
            Toast.makeText(getContext(),"Error: "+e.toString(),Toast.LENGTH_LONG).show();
         }



        adapter = new applist_recyclerview(applists);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(adapter);
        return root;
    }

    private void filter(String text, List<ApplicationInfo> app_list) {
        ArrayList<applistdata> filteredList = new ArrayList<>();
        for (ApplicationInfo item : app_list) {

                applistdata a=new applistdata();
                if(item.loadLabel(getContext().getPackageManager()).toString().toLowerCase().contains(text.toLowerCase())){
                    a.setDescription(item.loadLabel(getContext().getPackageManager()).toString());


                    a.setImgId(item.loadIcon(getContext().getPackageManager()));
                    filteredList.add(a);

                }


            }
                adapter.filterList(filteredList);

        }





    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.moncefadj.medcare.HelperClasses;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moncefadj.medcare.Doctor.DoctorLoginFragment;
import com.moncefadj.medcare.Patient.PatientLoginFragment;

public class LoginFragmentAdapter extends FragmentPagerAdapter {

    private Context context;
    private int tabsNumber;

    public LoginFragmentAdapter(FragmentManager fm, Context context, int tabsNUmber) {
        super(fm);
        this.context = context;
        this.tabsNumber = tabsNUmber;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                PatientLoginFragment patientLoginFragment = new PatientLoginFragment();
                return patientLoginFragment;
            case 1:
                DoctorLoginFragment doctorLoginFragment = new DoctorLoginFragment();
                return doctorLoginFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}

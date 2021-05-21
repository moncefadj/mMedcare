package com.moncefadj.medcare.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.moncefadj.medcare.Doctor.DoctorSignUp;
import com.moncefadj.medcare.HelperClasses.LoginFragmentAdapter;
import com.moncefadj.medcare.Patient.PatientSignUp;
import com.moncefadj.medcare.R;

public class LoginActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    public Button loginBtn;  // To access it from PatientLoginFragment and DoctorLoginFragment
    Button signUpBtn;
    LinearLayout signBtnsLayout;
    Dialog dialog;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        loginBtn = findViewById(R.id.connexion);
        signUpBtn = findViewById(R.id.creer_compte);
        signBtnsLayout = findViewById(R.id.sign_btns_layout);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.patient));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.doctor));

        // we have add this to switch to other tab when we just click on the tabs
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {  }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {  }
        });

        final LoginFragmentAdapter loginFragmentAdapter = new LoginFragmentAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
        viewPager.setAdapter(loginFragmentAdapter);

        viewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // animation for button and tabLayout
        loginBtn.setTranslationX(300);
        signUpBtn.setTranslationX(300);
        signBtnsLayout.setTranslationX(300);
        tabLayout.setTranslationX(300);

        loginBtn.setAlpha(0);
        signUpBtn.setAlpha(0);
        signBtnsLayout.setAlpha(0);
        tabLayout.setAlpha(0);

        loginBtn.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400);
        signUpBtn.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400);
        signBtnsLayout.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400);
        tabLayout.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400);

        // ** Dialog ** to ask user if he is a doctor or patient when he want to signUp
        dialog = new Dialog(LoginActivity.this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.rounded_corner_white));
        }
        dialog.setCancelable(false);
        // we can make animation for Dialog by mentioned it in Style
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        Button patientBtn = dialog.findViewById(R.id.check_user_btn_patient);
        Button doctorBtn = dialog.findViewById(R.id.check_user_btn_doctor);
        ImageView cancelDialogBtn = dialog.findViewById(R.id.cancel_dialog_btn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation fadeIn = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fade_in);
                dialog.show();
            }
        });
        patientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, PatientSignUp.class);
                startActivity(intent);
                finish();
            }
        });
        doctorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, DoctorSignUp.class);
                startActivity(intent);
                finish();
            }
        });
        cancelDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dialog.dismiss();
            }
        });

    }
}

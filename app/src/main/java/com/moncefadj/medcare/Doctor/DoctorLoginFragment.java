package com.moncefadj.medcare.Doctor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.moncefadj.medcare.Common.LoginActivity;
import com.moncefadj.medcare.R;

import java.awt.font.TextAttribute;

public class DoctorLoginFragment extends Fragment {

    TextInputLayout emailInput,passInput,keyInput;
    String emailTxt,passTxt,keyTxt;
    FirebaseAuth fAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.doctor_login_fragment, container, false);

        emailInput = view.findViewById(R.id.email);
        passInput = view.findViewById(R.id.password);
        keyInput = view.findViewById(R.id.key);

        ((LoginActivity)getActivity()).loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInDoctor();
            }
        });




        return view;


    }

    private void signInDoctor() {

        getEditTexts();

        clearErrors();

        //check those Inputs if are empty ...
        if (emailTxt.isEmpty()) {
            emailInput.setError("Email obligatoire");
            return;
        }
        if (passTxt.isEmpty()) {
            passInput.setError("Mot de pass obligatoire");
            return;
        }
        if (keyTxt.isEmpty()) {
            keyInput.setError("Clé obligatoire");
            return;
        }

        fAuth = FirebaseAuth.getInstance();
        fAuth.signInWithEmailAndPassword(emailTxt, passTxt).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(getContext(), "Connexion réussie", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void clearErrors() {

        emailInput.setError(null);
        passInput.setError(null);
        keyInput.setError(null);

    }

    private void getEditTexts() {
        emailTxt = emailInput.getEditText().getText().toString();
        passTxt = passInput.getEditText().getText().toString();
        keyTxt = keyInput.getEditText().getText().toString();
    }
}

package com.moncefadj.medcare.Patient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class PatientLoginFragment extends Fragment {

    TextInputLayout email,password;
    String emailTxt,passwordTxt;
    Button forgetPassword;
    FirebaseAuth fAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.patient_login_fragment, container, false);

        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.pass_word);
        forgetPassword = view.findViewById(R.id.forget_password);

        email.setTranslationX(300);
        password.setTranslationX(300);
        forgetPassword.setTranslationX(300);

        email.setAlpha(0);
        password.setAlpha(0);

        forgetPassword.setAlpha(0);

        email.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400);
        password.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400);

        forgetPassword.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400);



        ((LoginActivity)getActivity()).loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInUser();
            }
        });


        return view;
    }

    private void signInUser() {

        emailTxt = email.getEditText().getText().toString();
        passwordTxt = password.getEditText().getText().toString();

        clearErrors();   // this fun will clear the SetError (if it was appearing before) of all EditTexts

        if (emailTxt.isEmpty()) {
            email.setError("l'Email est Obligatoire");
            return;  // we will leave the onClick fun
        }
        if (passwordTxt.isEmpty()) {
            password.setError("Mot de passe Obligatoire");
            return;
        }

        fAuth = FirebaseAuth.getInstance();
        fAuth.signInWithEmailAndPassword(emailTxt, passwordTxt).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
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
        email.setError(null);
        password.setError(null);
    }


}

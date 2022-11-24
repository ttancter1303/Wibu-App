package com.example.comicapp.Login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.comicapp.R;
import com.example.comicapp.databinding.FragmentRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterFragment extends Fragment {
    FirebaseAuth firebaseAuth;
    private String mEmail;
    private String mPassword;
    FragmentRegisterBinding binding;
    EditText mEdtRegisterName;
    EditText mEdtRegisterEmail;
    EditText mEdtRegisterPassword;
    EditText mEdtRegisterPasswordAgain;
    Button mBtnRegisterAccept;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
        mEdtRegisterEmail = binding.edtRegisterEmail;
        mEdtRegisterName = binding.edtRegisterName;
        mEdtRegisterPassword = binding.edtRegisterPassword;
        mEdtRegisterPasswordAgain = binding.edtRegisterPasswordAgain;
        mBtnRegisterAccept = binding.btnRegisterAccept;


        mEdtRegisterName.setOnClickListener(v->{

        });

        mEdtRegisterEmail.setOnClickListener(v->{

        });

        mEdtRegisterPassword.setOnClickListener(v->{

        });

        mEdtRegisterPasswordAgain.setOnClickListener(v->{

        });

        mBtnRegisterAccept.setOnClickListener(v->{
            Navigation.findNavController(requireActivity(),R.id.fragmentContainerView3).navigate(R.id.action_registerFragment_to_loginFragment);
        });

    }


}
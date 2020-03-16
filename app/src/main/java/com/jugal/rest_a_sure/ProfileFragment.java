package com.jugal.rest_a_sure;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {
    TextView chgpass,uname,email;
    ImageView profile;
    FirebaseUser user;
    FirebaseAuth fauth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile,container,false);




        chgpass = view.findViewById(R.id.textView5);
        chgpass.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email = user.getEmail();
            fauth = FirebaseAuth.getInstance();
            fauth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(getActivity(),"Reset Email Sent",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getActivity(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    });

        uname = view.findViewById(R.id.uname);
        user = fauth.getInstance().getCurrentUser();
        uname.setText(user.getDisplayName());
        email = view.findViewById(R.id.uname2);
        email.setText(user.getEmail());
        profile = view.findViewById(R.id.imageView3);
        profile.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_black_24dp));
        String provider = user.getProviderData().get(0).toString();
        //Toast.makeText(getActivity(), ""+provider, Toast.LENGTH_SHORT).show();
        if (provider.contains("google"))
        {
            Uri photoUrl = user.getPhotoUrl();
            if (photoUrl == null) {
                Toast.makeText(getActivity(), "no image found", Toast.LENGTH_LONG).show();
            } else {
                String photo = photoUrl.toString();
                Glide.with(getActivity()).load(photo).into(profile);
            }
        }
        return view;
    }



}

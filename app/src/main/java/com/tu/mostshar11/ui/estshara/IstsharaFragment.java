package com.tu.mostshar11.ui.estshara;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.tu.mostshar11.R;

public class IstsharaFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_istshara, container, false);

        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
             //   textView.setText(s);
            }
        });
       /* final EditText editText=root.findViewById(R.id.editText3) ;
        final Button button=root.findViewById(R.id.button4);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Istshara istshara = new Istshara();
        String email ="omar"; /*user.getEmail();*/

       //button.setOnClickListener(new View.OnClickListener() {
          //  @Override
         //   public void onClick(View view) {
               // GalleryViewModel obj = new GalleryViewModel(editText.getText().toString(),email);
                     /* istshara.add(obj).addOnSuccessListener(suc->
                      {
                          Toast.makeText(this,"تم الارسال بنجاح",Toast.LENGTH_SHORT).show();
                      });*/
           // }
      //  });
        return root;

    }
}

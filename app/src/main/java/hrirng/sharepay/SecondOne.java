package hrirng.sharepay;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SecondOne extends AppCompatActivity {

    Button logout;
    FirebaseAuth FAuth;
    FirebaseAuth.AuthStateListener FAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_one);

        logout = findViewById(R.id.logout);
        FAuth = FirebaseAuth.getInstance();
        FAuthListener =  new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null)
                {
                    startActivity(new Intent(SecondOne.this , MainActivity.class));
                }
            }
        };
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FAuth.signOut();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FAuth.addAuthStateListener(FAuthListener);
    }

}

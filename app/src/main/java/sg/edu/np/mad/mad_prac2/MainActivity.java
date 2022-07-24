package sg.edu.np.mad.mad_prac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String TAG="Main Activity";
    Button myFollow;
    User user=new User();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFollow=findViewById(R.id.followed);
        myFollow.setText("Followed");
        TextView myName=findViewById(R.id.name);
        TextView myDesc=findViewById(R.id.description);
        Intent receivingEnd=getIntent();
        String Name=receivingEnd.getStringExtra("Name");
        String Desc=receivingEnd.getStringExtra("Desc");
        String pic=receivingEnd.getStringExtra("Pic");
        Boolean followed=receivingEnd.getBooleanExtra("Followed",false);
        User user=receivingEnd.getParcelableExtra("User");

        if(user.isFollowed()==true){
            myFollow.setText("UNFOLLOW");
        }
        else{myFollow.setText("FOLLOW");}
        myName.setText(Name);
        myDesc.setText(Desc);
        myFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.isFollowed()==true){
                    user.setFollowed(false);
                    myFollow.setText("FOLLOW");
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();

                }
                else{user.setFollowed(true);
                    myFollow.setText("UNFOLLOW");

                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();}


            }
        });





    }
}
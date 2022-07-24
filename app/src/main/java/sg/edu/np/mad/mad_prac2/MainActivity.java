package sg.edu.np.mad.mad_prac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String TAG="Main Activity";
    Button myFollow;
    User user=new User();
    ArrayList<User> users = ListActivity.userList;
    int position;
    DBHandler dbHandler = new DBHandler(this, null, null, 1);


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
        position = receivingEnd.getIntExtra("position", 0);

        if(user.isFollowed()==true){
            myFollow.setText("UNFOLLOW");
        }
        else{myFollow.setText("FOLLOW");}
        myName.setText(Name);
        myDesc.setText(Desc);
        myFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(users.get(position).isFollowed()==true){
                    users.get(position).setFollowed(false);
                    myFollow.setText("FOLLOW");
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();

                }
                else{users.get(position).setFollowed(true);
                    myFollow.setText("UNFOLLOW");

                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();}
                dbHandler.updateUsers(users.get(position));


            }

        });





    }
}
package sg.edu.np.mad.mad_prac2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity implements RecyclerAdapter.OnImageListener{
    public static ArrayList<User>userList= new ArrayList<User>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        DBHandler dbHandler = new DBHandler(this, null, null, 1);
        userList = new ArrayList<>();
        userList = dbHandler.getUsers();
        User user1=new User();
        user1.setName("User1");
        user1.setDescription("Hello1");
        user1.setId(1);
        user1.setFollowed(true);
        user1.setUri("android.resource://"+getPackageName()+"/"+R.drawable.profilepic);
        userList.add(user1);

        User user2=new User();
        user2.setName("User2");
        user2.setDescription("Hello2");
        user2.setId(2);
        user2.setFollowed(true);
        user2.setUri("android.resource://"+getPackageName()+"/"+R.drawable.profilepic);
        userList.add(user2);

        User user3=new User();
        user3.setName("User3");
        user3.setDescription("Hello3");
        user3.setId(3);
        user3.setFollowed(true);
        user3.setUri("android.resource://"+getPackageName()+"/"+R.drawable.profilepic);
        userList.add(user3);

        User user4=new User();
        user4.setName("User4");
        user4.setDescription("Hello4");
        user4.setId(4);
        user4.setFollowed(true);
        user4.setUri("android.resource://"+getPackageName()+"/"+R.drawable.profilepic);
        userList.add(user4);

        User user5=new User();
        user5.setName("User5");
        user5.setDescription("Hello5");
        user5.setId(5);
        user5.setFollowed(true);
        user5.setUri("android.resource://"+getPackageName()+"/"+R.drawable.profilepic);
        userList.add(user5);

        User user6=new User();
        user6.setName("User6");
        user6.setDescription("Hello6");
        user6.setId(6);
        user6.setFollowed(false);
        user6.setUri("android.resource://"+getPackageName()+"/"+R.drawable.profilepic);
        userList.add(user6);

        User user7=new User();
        user7.setName("User7");
        user7.setDescription("Hello7");
        user7.setId(7);
        user7.setFollowed(false);
        user7.setUri("android.resource://"+getPackageName()+"/"+R.drawable.profilepic);
        userList.add(user7);

        User user8=new User();
        user8.setName("User8");
        user8.setDescription("Hello8");
        user8.setId(8);
        user8.setFollowed(false);
        user8.setUri("android.resource://"+getPackageName()+"/"+R.drawable.profilepic);
        userList.add(user8);

        User user9=new User();
        user9.setName("User9");
        user9.setDescription("Hello9");
        user9.setId(9);
        user9.setFollowed(false);
        user9.setUri("android.resource://"+getPackageName()+"/"+R.drawable.profilepic);
        userList.add(user9);

        User user10=new User();
        user10.setName("User10");
        user10.setDescription("Hello10");
        user10.setId(10);
        user10.setFollowed(false);
        user10.setUri("android.resource://"+getPackageName()+"/"+R.drawable.profilepic);
        userList.add(user10);

        recyclerView = findViewById(R.id.recyclerView);
        userList = new ArrayList<>();
        userList = dbHandler.getUsers();
        setAdapter();



    }
    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(userList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void MADness(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("MADness").setCancelable(false);
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent myIntent=new Intent(ListActivity.this,MainActivity.class);
                Random ran = new Random();   //calling random class assigning to a variable random
                int value = ran.nextInt(999999);
                Bundle extras=new Bundle();
                extras.putInt("Random",value);
                myIntent.putExtras(extras);
                startActivity(myIntent);

            }
        });
        AlertDialog alert=builder.create();
        alert.setTitle("Profile");
        alert.show();
    }


    @Override
    public void onImageClick(int position) {
        User chosen_user;
        chosen_user=userList.get(position);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage(chosen_user.getName()).setCancelable(false);
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent myIntent=new Intent(ListActivity.this,MainActivity.class);
                Random ran = new Random();   //calling random class assigning to a variable random
                int value = ran.nextInt(999999);
                Bundle extras=new Bundle();
                extras.putString("Name",chosen_user.getName());
                extras.putString("Desc",chosen_user.getDescription());
                extras.putString("Pic",chosen_user.getUri());
                extras.putBoolean("Followed", chosen_user.isFollowed());
                extras.putInt("position", position);
                myIntent.putExtra("User",chosen_user);

                myIntent.putExtras(extras);
                startActivity(myIntent);

            }
        });
        AlertDialog alert=builder.create();
        alert.setTitle("Profile");
        alert.show();

    }
}



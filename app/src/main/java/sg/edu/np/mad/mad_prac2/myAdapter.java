package sg.edu.np.mad.mad_prac2;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter {
    ArrayList<User> data;
    private OnClickInterface OnClickInterface;

    public myAdapter(ArrayList<User> input, OnClickInterface OnClickInterface) {

        data = input;
        this.OnClickInterface = OnClickInterface;
    }
    @Override
    public int getItemViewType(int position) {
        String name = (data.get(position).getName());
        if (name.endsWith("7")) {
            return 0;
        }
        return 1;


    }

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item;
        if (ViewType == 0) {
            item = layoutInflater.inflate(R.layout.layout2, parent, false);
            return new ViewHolder2(item, OnClickInterface);

        }
        item = layoutInflater.inflate(R.layout.layout, parent, false);
        return new ViewHolder1(item, OnClickInterface);


    }


    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String name = (data.get(position).getName());
        if (name.endsWith("7")) {

            User user = data.get(position);
            ((ViewHolder2) holder).name.setText(user.getName());
            ((ViewHolder2) holder).desc.setText(user.getDescription());
            ((ViewHolder2) holder).img.setImageURI(Uri.parse(user.getUri()));
            ((ViewHolder2) holder).img2.setImageURI(Uri.parse(user.getUri()));
        }
        else{

            User user=data.get(position);
            ((ViewHolder1) holder).name.setText(user.getName());
            ((ViewHolder1) holder).desc.setText(user.getDescription());
            ((ViewHolder1) holder).img.setImageURI(Uri.parse(user.getUri()));

        }


    }



    public int getItemCount() {
        return data.size();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView desc;
        ImageView img;
        OnClickInterface OnClickInterface;

        public ViewHolder1(View itemView, OnClickInterface OnClickInterface) {
            super(itemView);
            name = itemView.findViewById(R.id.userName);
            desc = itemView.findViewById(R.id.userDesc);
            img = itemView.findViewById(R.id.userPic);
            this.OnClickInterface = OnClickInterface;
            img.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            OnClickInterface.onClick(getAdapterPosition());

        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView desc;
        ImageView img;
        ImageView img2;
        OnClickInterface OnClickInterface;

        public ViewHolder2(View itemView, OnClickInterface OnClickInterface) {
            super(itemView);
            name = itemView.findViewById(R.id.userName2);
            desc = itemView.findViewById(R.id.userDesc2);
            img = itemView.findViewById(R.id.userpic2);
            img2 = itemView.findViewById(R.id.biguser);
            this.OnClickInterface = OnClickInterface;
            img.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            OnClickInterface.onClick(getAdapterPosition());

        }
    }
}




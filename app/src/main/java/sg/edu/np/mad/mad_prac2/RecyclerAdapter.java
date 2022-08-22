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

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<User> usersList;
    private OnImageListener monImageListener;
    public RecyclerAdapter(ArrayList<User> usersList, OnImageListener onImageListener){
        this.usersList = usersList;
        this.monImageListener = onImageListener;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nameTxt;
        private TextView descTxt;
        private ImageView pfp;
        OnImageListener onImageListener;
        public MyViewHolder(final View view, OnImageListener onImageListener){
            super(view);
            nameTxt = view.findViewById(R.id.userName);
            descTxt = view.findViewById(R.id.userDesc);
            pfp = view.findViewById(R.id.userPic);
            this.onImageListener = onImageListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onImageListener.onImageClick(getAdapterPosition());
        }
    }
    public class MyViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nameTxt2;
        private TextView descTxt2;
        private ImageView pfp2;
        private ImageView pic2;
        OnImageListener onImageListener;
        public MyViewHolder2(final View view, OnImageListener onImageListener){
            super(view);
            nameTxt2 = view.findViewById(R.id.userName2);
            descTxt2 = view.findViewById(R.id.userDesc2);
            pfp2 = view.findViewById(R.id.userpic2);
            pic2 = view.findViewById(R.id.biguser);
            this.onImageListener = onImageListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onImageListener.onImageClick(getAdapterPosition());
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemview;
        if (viewType == 0){
            itemview = inflater.inflate(R.layout.layout2, parent, false);
            return new MyViewHolder2(itemview, monImageListener);
        }
        itemview = inflater.inflate(R.layout.layout, parent, false);
        return new MyViewHolder(itemview, monImageListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String name = usersList.get(position).getName();
        User user = usersList.get(position);
        if (name.endsWith("7")){
            ((MyViewHolder2) holder).nameTxt2.setText(user.getName());
            ((MyViewHolder2) holder).descTxt2.setText(user.getDescription());
            //((myViewHolder2) holder).img.setImageURI(Uri.parse(user.getUri()));
            //((myViewHolder2) holder).img2.setImageURI(Uri.parse(user.getUri()));
        }
        else{
            ((MyViewHolder) holder).nameTxt.setText((user.getName()));
            ((MyViewHolder) holder).descTxt.setText(user.getDescription());
            //((myViewHolder) holder).img.setImageURI(Uri.parse(user.getUri()));
        }
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
    public interface OnImageListener{
        void onImageClick(int position);
    }

    @Override
    public int getItemViewType(int position){
        String name = usersList.get(position).getName();
        if (name.endsWith("7")){
            return 0;
        }
        return 1;
    }
}

package sg.edu.np.mad.mad_prac2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView name;
    TextView desc;
    ImageView img;
    OnClickInterface OnClickInterface;

    public myViewHolder(View itemView, OnClickInterface OnClickInterface){
        super(itemView);
        name=itemView.findViewById(R.id.userName);
        desc=itemView.findViewById(R.id.userDesc);
        img=itemView.findViewById(R.id.userPic);
        this.OnClickInterface=OnClickInterface;
        img.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        OnClickInterface.onClick(getAdapterPosition());

    }
}

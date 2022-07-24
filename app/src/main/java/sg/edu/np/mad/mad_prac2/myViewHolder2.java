package sg.edu.np.mad.mad_prac2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class myViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView name;
    TextView desc;
    ImageView img;
    ImageView img2;
    OnClickInterface OnClickInterface;

    public myViewHolder2(View itemView, OnClickInterface OnClickInterface){
        super(itemView);
        name=itemView.findViewById(R.id.userName2);
        desc=itemView.findViewById(R.id.userDesc2);
        img=itemView.findViewById(R.id.userpic2);
        img2=itemView.findViewById(R.id.biguser);
        this.OnClickInterface=OnClickInterface;
        img.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        OnClickInterface.onClick(getAdapterPosition());

    }
}

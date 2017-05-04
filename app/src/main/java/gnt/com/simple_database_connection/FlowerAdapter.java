package gnt.com.simple_database_connection;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by PC-05 on 5/3/2017.
 */

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.ViewHolder> {

    Context context;
    private List<Flower>mflowerList;
    private ItemClickListener clickListener;


    public FlowerAdapter(Context context,List<Flower>mflowerList){
        this.mflowerList = mflowerList;
        this.context = context;
    }

    public void add(int position,Flower item){
        mflowerList.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(Flower item){
        int position = mflowerList.indexOf(item);
        mflowerList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flower_view,parent,false);

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Flower flower = mflowerList.get(position);
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                //Toast.makeText(context,"You clicked"+mflowerList.get(position),Toast.LENGTH_LONG).show();
                //Intent i = new Intent(context,DescriptionActivity.class);
                context.startActivity(new Intent(context,DescriptionActivity.class));
            }
        });
        holder.name.setText(flower.getName());
        holder.price.setText( flower.getPrice());

    }

    @Override
    public int getItemCount() {
        return mflowerList.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView name;
        public TextView price;

        private ItemClickListener itemClickListener;


        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.tv_name);

            price = (TextView)itemView.findViewById(R.id.tv_price);


            itemView.setOnClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {

            itemClickListener.onClick(view,getAdapterPosition());

        }
    }
}

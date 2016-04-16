package nx.kernnel.dash.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import nx.kernnel.dash.Entity.Local;
import nx.kernnel.dash.R;

/**
 * Created by Rodrigo Figueiredo on 16/04/16.
 */
public class LocalAdapter extends RecyclerView.Adapter<LocalAdapter.ViewHolder> implements View.OnClickListener {

    private List<Local> mData;
    private View.OnClickListener listener;

    public LocalAdapter(List<Local> myData) {
        mData = myData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivPicture;
        public TextView tvName;
        public TextView tvAddress;
        public RatingBar ratingBar;

        public ViewHolder(View v) {
            super(v);
            ivPicture = (ImageView) v.findViewById(R.id.iv_picture);
            tvName = (TextView) v.findViewById(R.id.tv_name);
            tvAddress = (TextView) v.findViewById(R.id.tv_address);
            ratingBar = (RatingBar) v.findViewById(R.id.ratingBar);
        }
    }

    @Override
    public LocalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_local, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.ivPicture.setImageResource(mData.get(position).getTipo().getImagem());
        holder.tvName.setText(mData.get(position).getNome());
        holder.tvAddress.setText("Tipo: " + mData.get(position).getTipo().getNome());
        holder.ratingBar.setRating(mData.get(position).getNota());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }
}

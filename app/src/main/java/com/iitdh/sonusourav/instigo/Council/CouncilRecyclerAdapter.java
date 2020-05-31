package com.iitdh.sonusourav.instigo.Council;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iitdh.sonusourav.instigo.R;

import java.util.ArrayList;

public class CouncilRecyclerAdapter extends RecyclerView.Adapter<CouncilRecyclerAdapter.ItemViewHolder> {

    private ArrayList<String> mCouncilName;
    private ArrayList<Integer> mCouncilImage;

    public CouncilRecyclerAdapter(ArrayList<String> mCouncilName, ArrayList<Integer> mCouncilImage) {
        this.mCouncilName = mCouncilName;
        this.mCouncilImage = mCouncilImage;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.council_single_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.councilTextView.setText(mCouncilName.get(position));
        holder.councilImageView.setImageResource(mCouncilImage.get(position));
    }

    @Override
    public int getItemCount() {
        if (mCouncilName == null ) return 0;
        return mCouncilName.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView councilTextView;
        private ImageView councilImageView;
        private Context context;

        ItemViewHolder(View itemView) {
            super(itemView);

            councilTextView = itemView.findViewById(R.id.council_name);
            councilImageView = itemView.findViewById(R.id.council_picture);
            context = itemView.getContext();

            councilImageView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (getAdapterPosition()){
                case 0:
                    intent = new Intent(context, CouncilWarden.class);
                    break;
                case 1:
                    intent = new Intent(context, CouncilGenSecy.class);
                    break;
                case 2:
                    intent = new Intent(context, CouncilSportsSecy.class);
                    break;
                case 3:
                    intent = new Intent(context, CouncilFHosMainSecy.class);
                    break;
                case 4:
                    intent = new Intent(context, CouncilFMessSecy.class);
                    break;
                case 5:
                    intent = new Intent(context, CouncilFHostelSecy.class);
                    break;
                case 6:
                    intent = new Intent(context, CouncilFSportsSecy.class);
                    break;
                case 7:
                    intent = new Intent(context, CouncilCulturalSecy.class);
                    break;
                case 8:
                    intent = new Intent(context, CouncilEmergency.class);
                    break;
                default:
                    intent = new Intent(context, CouncilWarden.class);
                    break;
            }
            context.startActivity(intent);
        }
    }
}

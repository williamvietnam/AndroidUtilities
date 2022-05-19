package com.rikkeisoft.project_training.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rikkeisoft.project_training.databinding.SubItemTwoBinding;
import com.rikkeisoft.project_training.models.SubItem;

import java.util.List;

public class SubItemTwoAdapter extends RecyclerView.Adapter<SubItemTwoAdapter.ViewHolder> {

    private final List<SubItem> listItem;

    public SubItemTwoAdapter(List<SubItem> listItem) {
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(SubItemTwoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(listItem.get(position));
        holder.binding.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItem.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        private final SubItemTwoBinding binding;

        public ViewHolder(SubItemTwoBinding itemTwoBinding) {
            super(itemTwoBinding.getRoot());
            this.binding = itemTwoBinding;
        }

        void setData(SubItem item) {
            binding.imageView.setImageResource(item.getImageRes());
            binding.tvContent.setText(item.getContent());
        }
    }
}

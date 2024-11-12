package com.example.uts9;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>{
    Context ctx;
    ArrayList<Book> listBook;

    public  BookAdapter(Context ctx,ArrayList<Book> listBook){
        this.ctx = ctx;
        this.listBook = listBook;
    }
    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.listitem,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder, int position) {
        Book book = listBook.get(position);
        holder.image.setImageResource(book.image);
        holder.title.setText(book.title);
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            Book book = listBook.get(pos);
            Intent openDetailActivity = new Intent(v.getContext(), MainActivity2.class);
            openDetailActivity.putExtra("dataBook",book);
            v.getContext().startActivity(openDetailActivity);
        }
    }
    @Override
    public int getItemCount() {
        return listBook.size();
    }
}

package com.example.letschat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MessageViewHolder> {
    Context context;
    ArrayList<String> messages;
    ChatAdapter(ArrayList<String> messages,Context context)
    {
        this.messages=messages;
        this.context=context;
    }
    @NonNull
    @Override
    public ChatAdapter.MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MessageViewHolder(((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.messagelayout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.MessageViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.sendername.setText(messages.get(position).split(":")[0]);
        holder.sendermessage.setText(messages.get(position).split(":")[1]);

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        TextView sendername;
        TextView sendermessage;
        FrameLayout card;


        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
          sendername=itemView.findViewById(R.id.sendername);
          sendermessage=itemView.findViewById(R.id.sendermessage);
          card=itemView.findViewById(R.id.card);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (listener != null) {
//                        listener.onRowClicked(getAdapterPosition());
//                    }
//                }
//            });
        }
    }
}


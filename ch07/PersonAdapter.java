package com.koreait.first.ch07;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.koreait.first.R;

import java.util.LinkedList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder> {

    private List<Person> items = new LinkedList<>();

    public void addItem(Person item){ items.add(item); }

    @NonNull
    @Override
    public  MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.person_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Person item = items.get(position);
        holder.setItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvAge;

        public MyViewHolder(View v){
            super(v);

            tvName = v.findViewById(R.id.tvName);
            tvAge = v.findViewById(R.id.tvAge);
        }
        public void setItem(Person item){
            tvName.setText(item.getName());
            tvAge.setText(item.getAge() + "살"); // setText()는 R에서 관리하고 있는 정수값만 인풋가능. 임의로 설정 불가능
            // tvAge.setText(R.String.tv_01); // 이렇게 strings.xml에서 관리하고 있는 문자열을 입력할 때 정수값 사용 가능
        }


    }


}

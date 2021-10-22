package com.koreait.first.ch07;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
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
        View itemView = inflater.inflate(R.layout.item_person, parent, false);

        return new MyViewHolder(itemView); //new 객체화(Linear layout 객체 값을 전달)
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
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 클로저(Closure), 지역변수가 매소드가 끝난 후에도 안죽고 살아있는 현상
                    String name = tvName.getText().toString();
                    String age = tvAge.getText().toString();
                    Snackbar.make(view, name + ", "+ age, Snackbar.LENGTH_SHORT).show();
                }
            });
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

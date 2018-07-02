package com.example.az.database;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    Context context;
    Student vse;

    public class PersonViewHolder extends RecyclerView.ViewHolder {

        TextView text_name;
        TextView text_course;


        PersonViewHolder(View itemView) {
            super(itemView);

            text_name = itemView.findViewById(R.id.name);
            text_course = itemView.findViewById(R.id.course);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    vse = new Student();
//                    int id = getAdapterPosition();
//                    vse = listVse.get(id);
//                  ((ExpenesActivity) context).mainCategoryDetail(vse.getId(), vse.getName());

                }
            });

        }


    }

    List<Student> listVse;

    public RVAdapter(Context context, List<Student> listVse) {
        this.listVse = listVse;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final PersonViewHolder personViewHolder, int i) {
        vse = new Student();
        vse = listVse.get(i);
        personViewHolder.text_name.setText(vse.getName());
        personViewHolder.text_course.setText(vse.getCourse()+"");

    }

    @Override
    public int getItemCount() {
        return listVse.size();
    }

}
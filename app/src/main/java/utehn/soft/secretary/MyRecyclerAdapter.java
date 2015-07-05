package utehn.soft.secretary;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.PersonViewHolder> {


    List<Person> persons;

    MyRecyclerAdapter(List<Person> persons) {

        this.persons = persons;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(persons.get(i).name);
        personViewHolder.personAge.setText(persons.get(i).age);
        personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
        if (persons.get(i).bgcolor != 0) {
            personViewHolder.card.setCardBackgroundColor(persons.get(i).bgcolor);
        } else {
            personViewHolder.card.setCardBackgroundColor(Color.parseColor("#fff"));
        }

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }


    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView card;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        private String mItem;
       // private TextView mTextView;

        PersonViewHolder(View itemView) {
            super(itemView);
            card = (CardView) itemView.findViewById(R.id.card);
            personName = (TextView) itemView.findViewById(R.id.person_name);
            personAge = (TextView) itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView) itemView.findViewById(R.id.person_photo);
            itemView.setOnClickListener(this);
            //mTextView = (TextView) itemView;
        }

        public void setItem(String item) {
            mItem = item;
            //mTextView.setText(item);
        }

        @Override
        public void onClick(View v) {
            Log.d("TAG", "onClick " + getPosition() + " " + mItem);
        }
    }


}
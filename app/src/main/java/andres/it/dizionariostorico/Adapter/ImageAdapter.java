package andres.it.dizionariostorico.Adapter;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import andres.it.dizionariostorico.ListItems.AgeNames;
import andres.it.dizionario.storico.R;

/**
 * Created by ryder on 01/12/14.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private ArrayList<String> ages = new ArrayList<String>() ;

    public ImageAdapter(){
        for(int i =0; i < AgeNames.AGES.length; ++i)
            ages.add(AgeNames.AGES[i]);
    }
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        final View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        ImageViewHolder ivh = new ImageViewHolder(itemView);


        return ivh;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder imageViewHolder, int i) {
        String age = ages.get(i);
        imageViewHolder.vName.setText(age);


    }

    @Override
    public int getItemCount() {
        return ages.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {

        protected  TextView vName;

        public ImageViewHolder(final View itemView) {
            super(itemView);
            vName = (TextView) itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //switch + case
                }
            });
        }


    }
}

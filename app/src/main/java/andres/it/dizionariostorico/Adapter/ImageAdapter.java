package andres.it.dizionariostorico.Adapter;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import andres.it.dizionariostorico.Activities.DescriptionActivity;
import andres.it.dizionariostorico.ListItems.AgeNames;
import andres.it.dizionario.storico.R;
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private ArrayList<String> ages = new ArrayList<String>() ;
    private Context context;

    public ImageAdapter(Context context){
        for(int i =0; i < AgeNames.AGES.length; ++i)
            ages.add(AgeNames.AGES[i]);
        this.context = context;
    }
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        final View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card__main_layout, viewGroup, false);
        return  new ImageViewHolder(itemView);

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
            vName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView textView = (TextView) v.findViewById(R.id.textView);
                    String title = textView.getText().toString();
                    Log.i("CLICKCLICK","CLICK: " + title);
                    if(title.compareTo("MEDIOEVO") == 0 ) {
                        Intent intent = new Intent(context, DescriptionActivity.class);
                        context.startActivity(intent);
                    }
                }
            });
        }

    }
}

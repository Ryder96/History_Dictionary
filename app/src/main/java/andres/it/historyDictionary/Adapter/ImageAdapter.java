package andres.it.historyDictionary.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import andres.it.dizionario.storico.R;
import andres.it.historyDictionary.Activities.DescriptionActivity;
import andres.it.historyDictionary.ListItems.TypeTerms;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private ArrayList<String> terms = new ArrayList<String>();
    private ArrayList<Integer> images = new ArrayList<Integer>();
    private Context context;

    public ImageAdapter(Context context) {
        for (int i = 0; i < TypeTerms.TERMS.length; ++i)
            terms.add(TypeTerms.TERMS[i]);

        images.add(R.drawable.medieval);
        images.add(R.drawable.card_background1);
        images.add(R.drawable.ic_launcher);
        this.context = context;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        final View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card__main_layout, viewGroup, false);
        return new ImageViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ImageViewHolder imageViewHolder, int i) {
        String term = terms.get(i);
        int image = images.get(i);
        imageViewHolder.vName.setText(term);
        imageViewHolder.vImage.setImageResource(image);

    }

    @Override
    public int getItemCount() {
        return terms.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected ImageView vImage;

        public ImageViewHolder(final View itemView) {
            super(itemView);
            vName = (TextView) itemView.findViewById(R.id.twSubtitle);
            vImage = (ImageView) itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,DescriptionActivity.class);
                    switch (vName.getText().toString()){
                        case "Cultura":
                            intent.putExtra("TypeOfTerm",vName.getText().toString());
                            break;
                        case "Politica":
                            intent.putExtra("TypeOfTerm",vName.getText().toString());
                            break;
                        case "Religione":
                            intent.putExtra("TypeOfTerm",vName.getText().toString());
                            break;

                    }
                    context.startActivity(intent);
                }
            });

        }

    }
}

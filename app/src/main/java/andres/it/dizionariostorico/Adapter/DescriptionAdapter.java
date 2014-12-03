package andres.it.dizionariostorico.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import andres.it.dizionario.storico.R;

/**
 * Created by ryder on 02/12/14.
 */
public class DescriptionAdapter  extends RecyclerView.Adapter<DescriptionAdapter.DescriptionViewHolder>{

;

        public DescriptionAdapter(){

        }
        @Override
        public DescriptionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

            final View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.persona_card_layout, viewGroup, false);
            return  new DescriptionViewHolder(itemView);

        }

        @Override
        public void onBindViewHolder(DescriptionViewHolder imageViewHolder, int i) {



        }

        @Override
        public int getItemCount() {
            return 1;
        }


        public class DescriptionViewHolder extends RecyclerView.ViewHolder {

            protected TextView vName;

            public DescriptionViewHolder(final View itemView) {
                super(itemView);
                vName = (TextView) itemView.findViewById(R.id.textView2);

            }

        }

}

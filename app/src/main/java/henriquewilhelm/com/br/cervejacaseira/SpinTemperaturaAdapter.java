package henriquewilhelm.com.br.cervejacaseira;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import henriquewilhelm.com.br.models.Temperaturas;

public class SpinTemperaturaAdapter extends ArrayAdapter<Temperaturas> {

    // Your sent context
    private Context context;
    // Your custom values for the spinner (User)
    private List<Temperaturas> temperaturas;

    public SpinTemperaturaAdapter(Context context, int textViewResourceId, List<Temperaturas> temperaturas) {
        super(context, textViewResourceId, temperaturas);
        this.context = context;
        this.temperaturas = temperaturas;
    }

    @Override
    public int getCount(){
        return temperaturas.size();
    }

    @Override
    public Temperaturas getItem(int position){
        return temperaturas.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }


    // And the "magic" goes here
    // This is for the "passive" state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.setText(temperaturas.get(position).getNomeEnzimas());

        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);

        if (position != 0)
            label.setText(temperaturas.get(position).getNomeEnzimas() +" Temp. " + temperaturas.get(position).getTemperaturaMin() + " - " +temperaturas.get(position).getTemperaturaMax() +
                " - pH " + temperaturas.get(position).getPhMax() + " - " +temperaturas.get(position).getPhMin());
        else
            label.setText(temperaturas.get(position).getNomeEnzimas());

        return label;
    }
}
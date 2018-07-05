package henriquewilhelm.com.br.cervejacaseira;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import henriquewilhelm.com.br.models.Estilo;
import henriquewilhelm.com.br.models.Fermento;

public class SpinFermentoAdapter extends ArrayAdapter<Fermento> {

    // Your sent context
    private Context context;
    // Your custom values for the spinner (User)
    private List<Fermento> fermentos;

    public SpinFermentoAdapter(Context context, int textViewResourceId, List<Fermento> fermentos) {
        super(context, textViewResourceId, fermentos);
        this.context = context;
        this.fermentos = fermentos;
    }

    @Override
    public int getCount(){
        return fermentos.size();
    }

    @Override
    public Fermento getItem(int position){
        return fermentos.get(position);
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
        label.setText(fermentos.get(position).getNome());

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
        label.setText(fermentos.get(position).getNome() + " - Atenuação: "+fermentos.get(position).getAtenuacao());

        return label;
    }
}
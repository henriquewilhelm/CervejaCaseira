package henriquewilhelm.com.br.cervejacaseira;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import henriquewilhelm.com.br.models.Temperaturas;

public class AdapterTemperaturasView extends BaseAdapter {

    private List<Temperaturas> temperaturas;
    private Activity act;

    public AdapterTemperaturasView(List<Temperaturas> temperaturas, Activity act) {
        this.temperaturas = temperaturas;
        this.act = act;
    }

    @Override
    public int getCount() {
        return temperaturas.size();
    }

    @Override
    public Object getItem(int position) {
        return temperaturas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return temperaturas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(act)
                .inflate(R.layout.adp_temperaturas_view, parent, false);

        TextView nome = (TextView)
                view.findViewById(R.id.lista_temperaturas_personalizada_nome);
        TextView phMin = (TextView)
                view.findViewById(R.id.lista_temperaturas_personalizada_ph_min);
        TextView phMax = (TextView)
                view.findViewById(R.id.lista_temperaturas_personalizada_ph_max);
        TextView tempMin = (TextView)
                view.findViewById(R.id.lista_temperaturas_personalizada_temperatura_min);
        TextView tempMax = (TextView)
                view.findViewById(R.id.lista_temperaturas_personalizada_temperatura_max);
        TextView temperatura = (TextView)
                view.findViewById(R.id.lista_temperaturas_personalizada_temperatura);
        TextView tempo = (TextView)
                view.findViewById(R.id.lista_temperaturas_personalizada_tempo);

        nome.setText(temperaturas.get(position).getNomeEnzimas());
        phMin.setText(temperaturas.get(position).getPhMin()+ "");
        phMax.setText(temperaturas.get(position).getPhMax()+ "");
        tempMin.setText(temperaturas.get(position).getTemperaturaMin()+ "");
        tempMax.setText(temperaturas.get(position).getTemperaturaMax()+ "");
        temperatura.setText(temperaturas.get(position).getTemperatura()+ "");
        tempo.setText(temperaturas.get(position).getTempo()+ "");

        return view;
    }
}

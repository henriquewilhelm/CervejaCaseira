package henriquewilhelm.com.br.cervejacaseira;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import henriquewilhelm.com.br.models.Lupulo;

public class AdapterLupulosPersonalizado extends BaseAdapter {

        private List<Lupulo> lupulos;
        private Activity act;

        public AdapterLupulosPersonalizado(List<Lupulo> lupulos, Activity act) {
            this.lupulos = lupulos;
            this.act = act;
        }

        @Override
        public int getCount() {
            return lupulos.size();
        }

        @Override
        public Object getItem(int position) {
            return lupulos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return lupulos.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = LayoutInflater.from(act)
                    .inflate(R.layout.adp_lupulos, parent, false);

            TextView nome = (TextView)
                    view.findViewById(R.id.lista_lupulos_personalizada_nome);
            TextView alpha = (TextView)
                    view.findViewById(R.id.lista_lupulos_personalizada_alpha);
            TextView gramas = (TextView)
                    view.findViewById(R.id.lista_lupulos_personalizada_gramas);
            TextView tempo = (TextView)
                    view.findViewById(R.id.lista_lupulos_personalizada_tempo);
            TextView tipo = (TextView)
                    view.findViewById(R.id.lista_lupulos_personalizada_tipo);

            nome.setText(lupulos.get(position).getNome());
            alpha.setText(lupulos.get(position).getAlphaAcidos()+" Alpha Ácidos");
            gramas.setText(lupulos.get(position).getGramas()+ "g");
            tempo.setText(lupulos.get(position).getTempo()+ " min");
            tipo.setText(""+lupulos.get(position).getTipo());

            return view;
        }
    }

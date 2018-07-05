package henriquewilhelm.com.br.cervejacaseira;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import henriquewilhelm.com.br.models.Lupulo;
import henriquewilhelm.com.br.models.Outros;

public class AdapterOutrosPersonalizado extends BaseAdapter {

        private List<Outros> outros;
        private Activity act;

        public AdapterOutrosPersonalizado(List<Outros> outros, Activity act) {
            this.outros = outros;
            this.act = act;
        }

        @Override
        public int getCount() {
            return outros.size();
        }

        @Override
        public Outros getItem(int position) {
            return outros.get(position);
        }

        @Override
        public long getItemId(int position) {
            return outros.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = LayoutInflater.from(act)
                    .inflate(R.layout.adp_outros, parent, false);

            TextView nome = (TextView)
                    view.findViewById(R.id.lista_outros_personalizada_nome);
            TextView alpha = (TextView)
                    view.findViewById(R.id.lista_outros_personalizada_uso);
            TextView gramas = (TextView)
                    view.findViewById(R.id.lista_outros_personalizada_gramas);
            TextView tempo = (TextView)
                    view.findViewById(R.id.lista_outros_personalizada_tempo);

            nome.setText(outros.get(position).getNome());
            alpha.setText(outros.get(position).getUso());
            gramas.setText(outros.get(position).getGramas()+ "");
            tempo.setText(outros.get(position).getTempo()+ "");

            return view;
        }
    }

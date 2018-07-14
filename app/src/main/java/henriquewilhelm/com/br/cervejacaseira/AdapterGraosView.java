package henriquewilhelm.com.br.cervejacaseira;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

import henriquewilhelm.com.br.models.Graos;
import henriquewilhelm.com.br.models.Lupulo;

public class AdapterGraosPersonalizado extends BaseAdapter {

        private List<Graos> graos;
        private Activity act;

        public AdapterGraosPersonalizado(List<Graos> graos, Activity act) {
            this.graos = graos;
            this.act = act;
        }

        @Override
        public int getCount() {
            return graos.size();
        }

        @Override
        public Object getItem(int position) {
            return graos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return graos.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = LayoutInflater.from(act)
                    .inflate(R.layout.adp_graos, parent, false);

            TextView nome = (TextView)
                    view.findViewById(R.id.lista_graos_personalizada_nome);
            TextView potencialExtracao = (TextView)
                    view.findViewById(R.id.lista_graos_personalizada_potencial_extracao);
            TextView cor = (TextView)
                    view.findViewById(R.id.lista_graos_personalizada_cor);
            TextView kilos = (TextView)
                    view.findViewById(R.id.lista_graos_personalizada_kilos);
            TextView percentagem = (TextView)
                    view.findViewById(R.id.lista_graos_personalizada_percentagem);

            nome.setText(graos.get(position).getNome());
            potencialExtracao.setText(graos.get(position).getPotencialExtracao()+"");
            cor.setText(graos.get(position).getCor()+ " EBC");
            Double aux = graos.get(position).getKilos();
            DecimalFormat df = new DecimalFormat("#.0");
            try {
                Number numberMask = df.parse(df.format(aux));
                aux = numberMask.doubleValue();
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            kilos.setText(aux+ " Kg");
            aux = graos.get(position).getPercentagem();
            try {
                Number numberMask = df.parse(df.format(aux));
                aux = numberMask.doubleValue();
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            percentagem.setText(aux+ " %");
            return view;
        }
    }

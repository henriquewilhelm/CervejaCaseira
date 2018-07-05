package henriquewilhelm.com.br.cervejacaseira;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import henriquewilhelm.com.br.models.Estilo;
import henriquewilhelm.com.br.models.Fermento;
import henriquewilhelm.com.br.models.Graos;
import henriquewilhelm.com.br.models.Lupulo;
import henriquewilhelm.com.br.models.Outros;
import henriquewilhelm.com.br.models.Receita;
import henriquewilhelm.com.br.models.Temperaturas;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    private Graos graoSelecionado;
    private Lupulo lupuloSelecionado;
    private Temperaturas temperaturaSelecionada;
    private Outros outroSelecionado;

    private List<Graos> graos = new ArrayList<Graos>();
    private List<Lupulo> lupulos = new ArrayList<Lupulo>();
    private List<Outros> outros = new ArrayList<Outros>();
    private List<Temperaturas> temperaturas = new ArrayList<Temperaturas>();
    private List<Fermento> fermentos = new ArrayList<Fermento>();
    private List<Estilo> estilos = new ArrayList<Estilo>();

    private AdapterGraosPersonalizado listGraosAdapter;
    private AdapterLupulosPersonalizado listLupulosAdapter;
    private AdapterTemperaturasPersonalizado listTemperaturasAdapter;
    private AdapterOutrosPersonalizado listOutroAdapter;

    private Dialog dialog;

    private ListView listViewGraos;
    private ListView listViewLupulos;
    private ListView listViewTemperaturas;
    private ListView listViewOutro;

    private Spinner spinnerGrao;
    private Spinner spinnerEstilo;
    private Spinner spinnerLupulo;
    private Spinner spinnerTemperatura;
    private Spinner spinnerFermento;
    private Spinner spinnerOutro;

    private SpinEstiloAdapter spinAdapterEstilo;
    private SpinGraoAdapter spinAdapterGrao;
    private SpinLupuloAdapter spinAdapterLupulo;
    private SpinTemperaturaAdapter spinAdapterTemperatura;
    private SpinFermentoAdapter spinAdapterFermento;
    private SpinOutroAdapter spinAdapterOutro;

    private EditText editTextPercentGraoDialog;
    private EditText editTextQntdGraoDialog;
    private EditText editTextAplhaLupuloDialog;
    private EditText editTextQntdLupuloDialog;
    private EditText editTextTempoLupuloDialog;
    private EditText editTextTempoTemperaturaDialog;
    private EditText editTextTempTemperaturaDialog;
    private EditText editTextUsoOutroDialog;
    private EditText editTextQntdOutroDialog;
    private EditText editTextTempoOutroDialog;
    private EditText editTextQuantidade;
    private EditText editTextEficiencia;
    private EditText editTextOG;
    private EditText editTextFG;
    private EditText editTextABV;
    private EditText editTextIBU;
    private EditText editTextBUGU;
    private EditText editTextAguaVolumeMostura;
    private EditText editTextAguaVolumeTotal;
    private EditText editTextAguaRelacao;
    private EditText editTextGraosTotal;
    private EditText editTextGraosTemperatura;
    private EditText editTextGraosAbsorcao;
    private EditText editTextMosturaQuantidade;
    private EditText editTextMosturaTemperaturaDesejada;
    private EditText editTextMosturaTemperaturaIndica;
    private EditText editTextLavagemQuantidade;
    private EditText editTextLavagemTemperaturaDesejada;
    private EditText editTextLavagemTemperaturaIndica;
    private EditText editTextPerdasLavagem;
    private EditText editTextPerdasFervura;
    private EditText editTextPerdasFermentador;
    private EditText editTextParametrosTempoFervura;
    private EditText editTextParametrosTaxaEvaporação;
    private EditText editTextAntesQuantidade;
    private EditText editTextAntesGravidadeEspecifica;
    private EditText editTextDepoisQuantidade;
    private EditText editTextDepoisGravidadeEspecifica;
    private EditText editTextTotalVolumeFinal;
    private EditText editTextTotalDepoisEsfriar;

    private Button dialogButtonFervura;
    private Button dialogButtonBrassagem;
    private Button dialogButtonConfiguracao;

    private String tipoCor = "EBC";        // Spinner Drop down elements
    private List<String> listTiposCor = new ArrayList<String>();
    private String tipoLupulo = "PELLET";
    private List<String> listTipoLupulo = new ArrayList<String>();

    private String percentAux;
    private Integer positionAux;

    Receita receita = new Receita();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Button dialogButtonTop = (Button) findViewById(R.id.buttonTop);
        // if button is clicked, close the custom dialog
        dialogButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogConfig();
            }
        });
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
              //          .setAction("Action", null).show();
        listTipoLupulo.add("PELLET");
        listTipoLupulo.add("FLOR");

        listTiposCor.add("EBC");
        listTiposCor.add("SRM");

         try {
            jsonToObject();

        } catch (IOException e) {

            e.printStackTrace();
        } catch (JSONException e) {

            e.printStackTrace();
        }

        editTextQuantidade = (EditText) findViewById(R.id.quantidade);
        editTextQuantidade.setText(receita.getQuantidadeLitros()+"");
        editTextEficiencia = (EditText) findViewById(R.id.eficiencia);
        editTextEficiencia.setText(receita.getEficiencia()+"");

        editTextOG = (EditText) findViewById(R.id.og);
        editTextOG.setText(receita.getGravidadeOriginal()+"");
        editTextFG = (EditText) findViewById(R.id.fg);
        editTextFG.setText(receita.getGravidadeFinal()+"");
        editTextIBU = (EditText) findViewById(R.id.ibu);
        editTextIBU.setText(receita.getBitterness()+"");
        editTextBUGU = (EditText) findViewById(R.id.bugu);
        editTextBUGU.setText(receita.getIbuPorOg()+"");
        editTextABV = (EditText) findViewById(R.id.abv);
        editTextABV.setText(receita.getAbv()+"");
        // Adapter e Spinner Estilo
        spinAdapterEstilo = new SpinEstiloAdapter(this,
                android.R.layout.simple_spinner_item,
                estilos);
        spinnerEstilo = (Spinner) findViewById(R.id.spinnerEstilo);
        spinnerEstilo.setAdapter(spinAdapterEstilo); // Set the custom adapter to the spinner
        // You can create an anonymous listener to handle the event when is selected an spinner item
        spinnerEstilo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                if (position != 0)
                     receita.setEstilo(spinAdapterEstilo.getItem(position));
                // Here you can do the action you want to...
                Toast.makeText(getApplicationContext(), "O Estilo "+ receita.getEstilo().getNome()+ " foi selecionado...",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {  }
        });
        // Layout, Adapter e Spinner Graos <------------------------------------------------------->

        spinAdapterGrao = new SpinGraoAdapter(this,
                android.R.layout.simple_spinner_item,
                graos);
        spinnerGrao = (Spinner) findViewById(R.id.spinnerGrao);
        spinnerGrao.setAdapter(spinAdapterGrao);

        spinnerGrao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                if (position != 0) {

                    if (receita.getGraos().size()!=0){
                        boolean status = false;
                        for (int i=0; i<receita.getGraos().size(); i++){
                            if (spinAdapterGrao.getItem(position).getId() != receita.getGraos().get(i).getId())
                                status = true;
                            else
                                status = false;
                        }
                        if(status) {
                            // Here you can do the action you want to...
                            Toast.makeText(getApplicationContext(), "O Grão " + spinAdapterGrao.getItem(position).getNome() + " foi Adicionado...",
                                    Toast.LENGTH_SHORT).show();
                            receita.getGraos().add(spinAdapterGrao.getItem(position));
                        }
                        else
                            Toast.makeText(getApplicationContext(), "O grão " + spinAdapterGrao.getItem(position).getNome() + " já foi adicionado anteriormente...",
                                    Toast.LENGTH_SHORT).show();


                    }
                    else
                        receita.getGraos().add(spinAdapterGrao.getItem(position));

                    dialogGrao(spinAdapterGrao.getItem(position), position);
                    spinnerGrao.setSelection(0);
                    setListViewHeightBasedOnChildren(listViewGraos);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {  }
        });

        listViewGraos = (ListView) findViewById(R.id.list_graos);
        listViewGraos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getApplicationContext(), "O Grão "+ receita.getGraos().get(position).getNome() + " foi selecionado...",
                        Toast.LENGTH_SHORT).show();
                dialogGrao(receita.getGraos().get(position), position);
            }
        });
        listGraosAdapter = new AdapterGraosPersonalizado(receita.getGraos(), this);
        listViewGraos.setAdapter(listGraosAdapter);

        // Layout, Adapter e Spinner Lupulos <----------------------------------------------------->

        spinAdapterLupulo = new SpinLupuloAdapter(this,
                android.R.layout.simple_spinner_item,
                lupulos);
        spinnerLupulo = (Spinner) findViewById(R.id.spinnerLupulo);
        spinnerLupulo.setAdapter(spinAdapterLupulo);

        spinnerLupulo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                if (position != 0) {
                    receita.getLupulos().add(spinAdapterLupulo.getItem(position));
                    dialogLupulo(spinAdapterLupulo.getItem(position));
                    // Here you can do the action you want to...
                    spinnerLupulo.setSelection(0);
                    setListViewHeightBasedOnChildren(listViewLupulos);
                    Toast.makeText(getApplicationContext(), "O Lupulo " + spinAdapterLupulo.getItem(position).getNome() + " foi selecionado...",
                            Toast.LENGTH_SHORT).show();
                }
            }
                @Override
                public void onNothingSelected(AdapterView<?> adapter) {  }
        });
        listViewLupulos = (ListView) findViewById(R.id.list_lupulos);
        listViewLupulos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getApplicationContext(), "O Lupulo "+ receita.getLupulos().get(position).getNome() + " foi selecionado...",
                        Toast.LENGTH_SHORT).show();
                dialogLupulo(receita.getLupulos().get(position));
            }
        });
        listLupulosAdapter = new AdapterLupulosPersonalizado(receita.getLupulos(), this);
        listViewLupulos.setAdapter(listLupulosAdapter);

        // Layout, Adapter e Spinner Temperatura <------------------------------------------------->


        spinAdapterTemperatura = new SpinTemperaturaAdapter(this,
                android.R.layout.simple_spinner_item,
                temperaturas);
        spinnerTemperatura = (Spinner) findViewById(R.id.spinnerTemperatura);
        spinnerTemperatura.setAdapter(spinAdapterTemperatura);

        spinnerTemperatura.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                    if (position != 0) {
                            receita.getTemperaturas().add(spinAdapterTemperatura.getItem(position));
                    dialogTemperatura(spinAdapterTemperatura.getItem(position));
                    // Here you can do the action you want to...
                    spinnerTemperatura.setSelection(0);
                    setListViewHeightBasedOnChildren(listViewTemperaturas);
                    Toast.makeText(getApplicationContext(), "A Temperatura " + spinAdapterTemperatura.getItem(position).getNomeEnzimas() + " foi selecionada...",
                            Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {  }
        });
        listViewTemperaturas = (ListView) findViewById(R.id.list_temperaturas);
        listViewTemperaturas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getApplicationContext(), "A Temperatura "+ receita.getTemperaturas().get(position).getNomeEnzimas() + " foi selecionado...",
                        Toast.LENGTH_SHORT).show();
                dialogTemperatura(receita.getTemperaturas().get(position));
            }
        });
        listTemperaturasAdapter = new AdapterTemperaturasPersonalizado(receita.getTemperaturas(), this);
        listViewTemperaturas.setAdapter(listTemperaturasAdapter);

        // Adapter e Spinner Fermento <---------------------------------------------------->

        spinAdapterFermento = new SpinFermentoAdapter(this,
                android.R.layout.simple_spinner_item,
                fermentos);
        spinnerFermento = (Spinner) findViewById(R.id.spinnerFermento);
        spinnerFermento.setAdapter(spinAdapterFermento); // Set the custom adapter to the spinner
        // You can create an anonymous listener to handle the event when is selected an spinner item
        spinnerFermento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                if (position != 0)
                    receita.setFermento(spinAdapterFermento.getItem(position));
                // Here you can do the action you want to...
                Toast.makeText(getApplicationContext(), "O Fermento "+ receita.getFermento().getNome()+ " foi selecionado...",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {  }
        });

        // Layout, Adapter e Spinner Outros <------------------------------------------------------->


        spinAdapterOutro = new SpinOutroAdapter(this,
                android.R.layout.simple_spinner_item,
                outros);
        spinnerOutro = (Spinner) findViewById(R.id.spinnerOutro);
        spinnerOutro.setAdapter(spinAdapterOutro);

        spinnerOutro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                if (position != 0) {
                    receita.getOutros().add(spinAdapterOutro.getItem(position));
                    dialogOutro(spinAdapterOutro.getItem(position));
                    setListViewHeightBasedOnChildren(listViewGraos);
                    spinnerOutro.setSelection(0);
                    // Here you can do the action you want to...
                    Toast.makeText(getApplicationContext(), "O Item " + spinAdapterOutro.getItem(position).getNome() + " foi selecionado...",
                            Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {  }
        });

        listViewOutro = (ListView) findViewById(R.id.list_outros);
        listViewOutro.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getApplicationContext(), "O item "+ receita.getOutros().get(position).getNome() + " foi selecionado...",
                        Toast.LENGTH_SHORT).show();
                dialogOutro(receita.getOutros().get(position));
            }
        });
        listOutroAdapter = new AdapterOutrosPersonalizado(receita.getOutros(), this);
        listViewOutro.setAdapter(listOutroAdapter);

        dialogButtonBrassagem = (Button) findViewById(R.id.buttonBrassagem);
        // if button is clicked, close the custom dialog
        dialogButtonBrassagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogBrassagem();
                calcular();
            }
        });

        dialogButtonFervura = (Button) findViewById(R.id.buttonFervura);

        // if button is clicked, close the custom dialog
        dialogButtonFervura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogFervura();
                calcular();
            }
        });

        dialogButtonConfiguracao = (Button) findViewById(R.id.buttonConfiguracao);

        // if button is clicked, close the custom dialog
        dialogButtonConfiguracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogConfig();

            }
        });
    }

    public void dialogGrao (final Graos grao, Integer position){
        graoSelecionado = grao;
        positionAux = position;
        // custom dialog
        dialog = new Dialog(ScrollingActivity.this);
        dialog.setContentView(R.layout.dialog_grao);
        dialog.setTitle(graoSelecionado.getNome());
        dialog.getWindow()
                .setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
        editTextQntdGraoDialog = (EditText) dialog.findViewById(R.id.editQntdGraoText);
        editTextQntdGraoDialog.setText(graoSelecionado.getKilos()+"");
        editTextPercentGraoDialog = (EditText) dialog.findViewById(R.id.editQntdPercentGraoText);
        editTextPercentGraoDialog.setText(graoSelecionado.getPercentagem()+"");

        percentAux = editTextPercentGraoDialog.getText().toString();
        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonGraoOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                graoSelecionado.setKilos(Double.valueOf(editTextQntdGraoDialog.getText().toString()));


                if (!percentAux.equals(editTextPercentGraoDialog.getText().toString())){
                    corrigePercentagem(receita.getGraos(), positionAux, Double.valueOf(percentAux),  Double.valueOf(editTextPercentGraoDialog.getText().toString()));
                    verificaQuantidadeGraos();
                 }
                 else {
                    calculaOG(receita.getGraos(), receita.getLupulos(), receita.getEficiencia(), receita.getQuantidadeLitros());
                    verificaQuantidadeGraos();
                }
                listGraosAdapter.notifyDataSetChanged();
                calcular();
            }
        });

        Button dialogButtonRemover = (Button) dialog.findViewById(R.id.dialogButtonGraoRemover);
        // if button is clicked, close the custom dialog
        dialogButtonRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                receita.getGraos().remove(graoSelecionado);
                listGraosAdapter.notifyDataSetChanged();
                calcular();
            }
        });

        dialog.show();
    }

    public void dialogLupulo (final Lupulo lupulo){
        lupuloSelecionado = lupulo;
        // custom dialog
        dialog = new Dialog(ScrollingActivity.this);
        dialog.setContentView(R.layout.dialog_lupulo);
        dialog.setTitle(lupuloSelecionado.getNome() + " - " + lupuloSelecionado.getAlphaAcidos());
        dialog.getWindow()
                .setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
        editTextAplhaLupuloDialog = (EditText) dialog.findViewById(R.id.editAplhaLupuloText);
        editTextQntdLupuloDialog = (EditText) dialog.findViewById(R.id.editQntdLupuloText);
        editTextTempoLupuloDialog = (EditText) dialog.findViewById(R.id.editTempoLupuloText);

        editTextAplhaLupuloDialog.setText(lupuloSelecionado.getAlphaAcidos()+"");
        editTextQntdLupuloDialog.setText(lupuloSelecionado.getGramas()+"");
        editTextTempoLupuloDialog.setText(lupuloSelecionado.getTempo()+"");

        // Spinner element
        Spinner spinnerLupulo = (Spinner) dialog.findViewById(R.id.spinnerTipoLululo);
        spinnerLupulo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                lupuloSelecionado.setTipo( listTipoLupulo.get(position) );
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {  }
        });
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterLupulo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTipoLupulo);
        dataAdapterLupulo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLupulo.setAdapter(dataAdapterLupulo);

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonLupuloOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                lupuloSelecionado.setGramas(Double.valueOf(editTextQntdLupuloDialog.getText().toString()));
                lupuloSelecionado.setTempo(Integer.valueOf(editTextTempoLupuloDialog.getText().toString()));
                lupuloSelecionado.setAlphaAcidos(Double.valueOf(editTextAplhaLupuloDialog.getText().toString()));
                listLupulosAdapter.notifyDataSetChanged();
                calcular();
            }
        });
        Button dialogButtonRemover = (Button) dialog.findViewById(R.id.dialogButtonLupuloRemover);
        // if button is clicked, close the custom dialog
        dialogButtonRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                receita.getLupulos().remove(lupuloSelecionado);
                listLupulosAdapter.notifyDataSetChanged();
                calcular();
            }
        });
        dialog.show();
    }

    public void dialogTemperatura (final Temperaturas temperatura){
        this.temperaturaSelecionada = temperatura;
        // custom dialog
        dialog = new Dialog(ScrollingActivity.this);
        dialog.setContentView(R.layout.dialog_temperatura);
        dialog.setTitle(temperaturaSelecionada.getNomeEnzimas());
        dialog.getWindow()
                .setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
        TextView textViewTempMinTemperaturaDialog = (TextView) dialog.findViewById(R.id.dialog_temperaturas_personalizada_temperatura_min);
        TextView textViewTempMaxTemperaturaDialog = (TextView) dialog.findViewById(R.id.dialog_temperaturas_personalizada_temperatura_max);
        editTextTempoTemperaturaDialog = (EditText) dialog.findViewById(R.id.editTempoTemperaturaText);
        editTextTempTemperaturaDialog = (EditText) dialog.findViewById(R.id.editTempTemperaturaText);

        textViewTempMinTemperaturaDialog.setText(temperaturaSelecionada.getTemperaturaMin()+"");
        textViewTempMaxTemperaturaDialog.setText(" - "+temperaturaSelecionada.getTemperaturaMax());
        editTextTempTemperaturaDialog.setText(temperaturaSelecionada.getTemperatura()+"");
        editTextTempoTemperaturaDialog.setText(temperaturaSelecionada.getTempo()+"");

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonTemperaturaOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double temperatura = Double.valueOf(editTextTempTemperaturaDialog.getText().toString());

                if (temperatura >= temperaturaSelecionada.getTemperaturaMin() && temperatura <= temperaturaSelecionada.getTemperaturaMax()) {
                    dialog.dismiss();
                    temperaturaSelecionada.setTemperatura(temperatura);
                    temperaturaSelecionada.setTempo(Integer.valueOf(editTextTempoTemperaturaDialog.getText().toString()));
                    listTemperaturasAdapter.notifyDataSetChanged();

                 }
                 else {
                    // Here you can do the action you want to...
                    Toast.makeText(getApplicationContext(), "A temperatura deve estar dentro da faixa...",
                            Toast.LENGTH_SHORT).show();
                }
                receita.setTemperaturaBrassagem(receita.getTemperaturas().get(0).getTemperatura());
                for (int i=0; i< receita.getTemperaturas().size(); i++) {
                    if (receita.getTemperaturaBrassagem() > receita.getTemperaturas().get(i).getTemperatura())
                        receita.setTemperaturaBrassagem(receita.getTemperaturas().get(i).getTemperatura());
                }
                calcular();
            }
        });
        Button dialogButtonRemover = (Button) dialog.findViewById(R.id.dialogButtonTemperaturaRemover);
        // if button is clicked, close the custom dialog
        dialogButtonRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                receita.getTemperaturas().remove(temperaturaSelecionada);
                listTemperaturasAdapter.notifyDataSetChanged();
                calcular();
            }
        });
        dialog.show();
    }

    public void dialogOutro (final Outros outro){
        outroSelecionado = outro;
        // custom dialog
        dialog = new Dialog(ScrollingActivity.this);
        dialog.setContentView(R.layout.dialog_outro);
        dialog.setTitle(outroSelecionado.getNome());
        dialog.getWindow()
                .setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
        editTextUsoOutroDialog = (EditText) dialog.findViewById(R.id.editUsoOutroText);
        editTextQntdOutroDialog = (EditText) dialog.findViewById(R.id.editQntdOutroText);
        editTextTempoOutroDialog = (EditText) dialog.findViewById(R.id.editTempoOutroText);

        editTextUsoOutroDialog.setText(outroSelecionado.getUso());
        editTextQntdOutroDialog.setText(outroSelecionado.getGramas()+"");
        editTextTempoOutroDialog.setText(outroSelecionado.getTempo()+"");

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOutroOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                outroSelecionado.setGramas(Double.valueOf(editTextQntdOutroDialog.getText().toString()));
                outroSelecionado.setTempo(Integer.valueOf(editTextTempoOutroDialog.getText().toString()));
                outroSelecionado.setUso(editTextUsoOutroDialog.getText().toString());
                listOutroAdapter.notifyDataSetChanged();
                calcular();
            }
        });
        Button dialogButtonRemover = (Button) dialog.findViewById(R.id.dialogButtonOutroRemover);
        // if button is clicked, close the custom dialog
        dialogButtonRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                receita.getOutros().remove(outroSelecionado);
                listOutroAdapter.notifyDataSetChanged();
                calcular();
            }
        });
        dialog.show();
    }

    public void dialogBrassagem (){
        dialog = new Dialog(ScrollingActivity.this);
        dialog.setContentView(R.layout.dialog_brassagem);
        dialog.setTitle("BRASSAGEM");
        dialog.getWindow()
                .setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
        editTextAguaVolumeMostura = (EditText) dialog.findViewById(R.id.editTextAguaVolumeMostura);
        editTextAguaVolumeMostura.setText(receita.getQntdTotalMostoLitros()+"");
        editTextAguaVolumeTotal = (EditText)  dialog.findViewById(R.id.editTextAguaVolumeTotal);
        editTextAguaVolumeTotal.setText(receita.getQntdTotalLitros()+"");
        editTextAguaRelacao = (EditText)  dialog.findViewById(R.id.editTextAguaRelacao);
        editTextAguaRelacao.setText(receita.getRelacaoAguaGrao()+"");
        editTextGraosTotal = (EditText)  dialog.findViewById(R.id.editTextGraosTotal);
        editTextGraosTotal.setText(receita.getQuantidadeGraos()+"");
        editTextGraosTemperatura = (EditText)  dialog.findViewById(R.id.editTextGraosTemperatura);
        editTextGraosTemperatura.setText(receita.getTemperaturaGraos()+"");
        editTextGraosAbsorcao = (EditText)  dialog.findViewById(R.id.editTextGraosAbsorcao);
        editTextGraosAbsorcao.setText(receita.getAbsorcaoGraos()+"");

        editTextMosturaQuantidade = (EditText)  dialog.findViewById(R.id.editTextMosturaQuantidade);
        editTextMosturaQuantidade.setText(receita.getQntdInicialLitros()+"");
        editTextMosturaTemperaturaDesejada = (EditText)  dialog.findViewById(R.id.editTextMosturaTemperaturaDesejada);
        editTextMosturaTemperaturaDesejada.setText(receita.getTemperaturaBrassagem()+"");
        editTextMosturaTemperaturaIndica = (EditText)  dialog.findViewById(R.id.editTextMosturaTemperaturaIndica);
        editTextMosturaTemperaturaIndica.setText(receita.getTemperaturaBrassagem()+"");

        editTextLavagemQuantidade = (EditText)  dialog.findViewById(R.id.editTextLavagemQuantidade);
        editTextLavagemQuantidade.setText(receita.getQntdLavagemLitros()+"");
        editTextLavagemTemperaturaDesejada = (EditText)  dialog.findViewById(R.id.editTextLavagemTemperaturaDesejada);
        editTextLavagemTemperaturaDesejada.setText(receita.getTemperaturaLavagemDesejada()+"");
        editTextLavagemTemperaturaIndica = (EditText)  dialog.findViewById(R.id.editTextLavagemTemperaturaIndica);
        editTextLavagemTemperaturaIndica.setText(receita.getTemperaturaLavagemIdeal()+"");

        editTextPerdasLavagem = (EditText)  dialog.findViewById(R.id.editTextPerdasLavagem);
        editTextPerdasLavagem.setText(receita.getPerdaPanelaBrassagem()+"");
        editTextPerdasFervura = (EditText)  dialog.findViewById(R.id.editTextPerdasFervura);
        editTextPerdasFervura.setText(receita.getPerdaPanelaFervura()+"");
        editTextPerdasFermentador = (EditText)  dialog.findViewById(R.id.editTextPerdasFermentador);
        editTextPerdasFermentador.setText(receita.getPerdaFermentador()+"");

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonBrassagemOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                //listOutroAdapter.notifyDataSetChanged();
                calcular();
            }
        });

        dialog.show();
    }

    public void dialogFervura (){
        dialog = new Dialog(ScrollingActivity.this);

        dialog.setContentView(R.layout.dialog_fervura);
        dialog.setTitle("FERVURA");
        dialog.getWindow()
                .setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
        editTextParametrosTempoFervura = (EditText)  dialog.findViewById(R.id.editTextParametrosTempoFervura);
        editTextParametrosTempoFervura.setText(receita.getTempoFervura()+"");
        editTextParametrosTaxaEvaporação = (EditText)  dialog.findViewById(R.id.editTextParametrosTaxaEvaporação);
        editTextParametrosTaxaEvaporação.setText(receita.getTaxaEvaporacao()+"");

        editTextAntesQuantidade = (EditText)  dialog.findViewById(R.id.editTextAntesQuantidade);
        editTextAntesQuantidade.setText(receita.getQuantidadeAntesFerver()+"");
        editTextAntesGravidadeEspecifica = (EditText)  dialog.findViewById(R.id.editTextAntesGravidadeEspecifica);
        editTextAntesGravidadeEspecifica.setText(receita.getSgAntesFerver()+"");

        editTextDepoisQuantidade = (EditText)  dialog.findViewById(R.id.editTextDepoisQuantidade);
        editTextDepoisQuantidade.setText(receita.getQuantidadeDepoisFerver()+"");
        editTextDepoisGravidadeEspecifica = (EditText)  dialog.findViewById(R.id.editTextDepoisGravidadeEspecifica);
        editTextDepoisGravidadeEspecifica.setText(receita.getSdDepoisFerver()+"");

        editTextTotalVolumeFinal = (EditText)  dialog.findViewById(R.id.editTextTotalVolumeFinal);
        editTextTotalVolumeFinal.setText(receita.getVolumeAntesEsfriar()+"");
        editTextTotalDepoisEsfriar = (EditText)  dialog.findViewById(R.id.editTextTotalDepoisEsfriar);
        editTextTotalDepoisEsfriar.setText(receita.getQuantidadeLitros()+"");
        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonFervuraOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                //listOutroAdapter.notifyDataSetChanged();
                calcular();
            }
        });

        dialog.show();
    }

    public void dialogConfig (){
        dialog = new Dialog(ScrollingActivity.this);

        dialog.setContentView(R.layout.dialog_config);
        dialog.setTitle("CONFIG");
        dialog.getWindow()
                .setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );


        // Spinner element
        Spinner spinnerLupulo = (Spinner) dialog.findViewById(R.id.spinnerLupuloConfig);

        spinnerLupulo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                tipoLupulo = listTipoLupulo.get(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {  }
        });
         // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterLupulo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTipoLupulo);
        dataAdapterLupulo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLupulo.setAdapter(dataAdapterLupulo);

        if (tipoLupulo.equals("PELLET"))
            spinnerLupulo.setSelection(0);
        else
            spinnerLupulo.setSelection(1);

        // Spinner element
        Spinner spinnerCor = (Spinner) dialog.findViewById(R.id.spinnerCorConfig);
        spinnerCor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                tipoCor = listTiposCor.get(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {  }
        });
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterCor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTiposCor);
        dataAdapterCor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCor.setAdapter(dataAdapterCor);

        if (tipoCor.equals("EBC"))
            spinnerCor.setSelection(0);
        else
            spinnerCor.setSelection(1);

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonConfigOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                //listOutroAdapter.notifyDataSetChanged();
                calcular();
            }
        });
        dialog.show();
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    public void jsonToObject () throws IOException, JSONException {
        estilos.add(new Estilo("Escolha um Estilo"));
        graos.add(new Graos("Escolha um Grao"));
        lupulos.add(new Lupulo("Escolha um Lupulo"));
        outros.add(new Outros("Outros Ingredientes"));
        temperaturas.add(new Temperaturas("Escolha a faixa de Temperatura"));
        fermentos.add(new Fermento("Escolha o Fermento"));

        String jsonData;
        jsonData = readFileJson("graos.json");
        JSONArray arrayGraos = new JSONArray(jsonData);
        for (int i = 0; i < arrayGraos.length(); i++) {

            Graos grao = new Graos();
            grao.setId(arrayGraos.getJSONObject(i).getInt("id"));
            grao.setNome(arrayGraos.getJSONObject(i).getString("nome"));
            grao.setPotencialExtracao(arrayGraos.getJSONObject(i).getDouble("potencialExtracao"));
            grao.setCor(arrayGraos.getJSONObject(i).getDouble("cor"));
            grao.setPercentagem(arrayGraos.getJSONObject(i).getDouble("percentagem"));
            grao.setKilos(arrayGraos.getJSONObject(i).getDouble("kilos"));
            grao.setMashable(arrayGraos.getJSONObject(i).getBoolean("mashable"));
            grao.setAdicaoTardia(arrayGraos.getJSONObject(i).getBoolean("adicaoTardia"));

            graos.add(grao);
        };

        jsonData = readFileJson("lupulos.json");
        JSONArray arrayLupulos = new JSONArray(jsonData);
        for (int i = 0; i < arrayLupulos.length(); i++) {

            Lupulo lupulo = new Lupulo();
            lupulo.setId(arrayLupulos.getJSONObject(i).getInt("id"));
            lupulo.setNome(arrayLupulos.getJSONObject(i).getString("nome"));
            lupulo.setAlphaAcidos(arrayLupulos.getJSONObject(i).getDouble("alphaAcidos"));
            lupulo.setRelacaoGramasPorLitro(arrayLupulos.getJSONObject(i).getDouble("relacaoGramasPorLitro"));
            lupulo.setPercentagem(arrayLupulos.getJSONObject(i).getDouble("percentagem"));
            lupulo.setGramas(arrayLupulos.getJSONObject(i).getDouble("gramas"));
            lupulo.setUso(arrayLupulos.getJSONObject(i).getString("uso"));
            lupulo.setTempo(arrayLupulos.getJSONObject(i).getInt("tempo"));
            lupulo.setIbu(arrayLupulos.getJSONObject(i).getDouble("ibu"));
            lupulo.setTipo(arrayLupulos.getJSONObject(i).getString("tipo"));
            lupulos.add(lupulo);
        }

        jsonData = readFileJson("outros.json");
        JSONArray arrayOutros = new JSONArray(jsonData);
        for (int i = 0; i < arrayOutros.length(); i++) {

            Outros outro = new Outros();
            outro.setId(arrayOutros.getJSONObject(i).getInt("id"));
            outro.setNome(arrayOutros.getJSONObject(i).getString("nome"));
            outro.setGramas(arrayOutros.getJSONObject(i).getDouble("gramas"));
            outro.setUso(arrayOutros.getJSONObject(i).getString("uso"));
            outro.setTempo(arrayOutros.getJSONObject(i).getInt("tempo"));
            outro.setTipo(arrayOutros.getJSONObject(i).getString("tipo"));
            outros.add(outro);
        }

        jsonData = readFileJson("temperaturas.json");
        JSONArray arrayTemperaturas = new JSONArray(jsonData);
        for (int i = 0; i < arrayTemperaturas.length(); i++) {

            Temperaturas temperatura = new Temperaturas();
            temperatura.setId(arrayTemperaturas.getJSONObject(i).getInt("id"));
            temperatura.setNomeEnzimas(arrayTemperaturas.getJSONObject(i).getString("nomeEnzimas"));
            temperatura.setTemperaturaMin(arrayTemperaturas.getJSONObject(i).getDouble("temperaturaMin"));
            temperatura.setTemperaturaMax(arrayTemperaturas.getJSONObject(i).getDouble("temperaturaMax"));
            temperatura.setTemperatura(arrayTemperaturas.getJSONObject(i).getDouble("temperatura"));
            temperatura.setPhMin(arrayTemperaturas.getJSONObject(i).getDouble("phMin"));
            temperatura.setPhMax(arrayTemperaturas.getJSONObject(i).getDouble("phMax"));
            temperatura.setTempo(arrayTemperaturas.getJSONObject(i).getInt("tempo"));
            temperatura.setUnidade(arrayTemperaturas.getJSONObject(i).getString("unidade"));
            temperatura.setSobre(arrayTemperaturas.getJSONObject(i).getString("sobre"));
            temperaturas.add(temperatura);
        }
        jsonData = readFileJson("fermentos.json");
        JSONArray arrayFermentos = new JSONArray(jsonData);
        for (int i = 0; i < arrayFermentos.length(); i++) {
            Fermento fermento = new Fermento();

            fermento.setId(arrayFermentos.getJSONObject(i).getInt("id"));
            fermento.setNome(arrayFermentos.getJSONObject(i).getString("nome"));
            fermento.setBrand(arrayFermentos.getJSONObject(i).getString("brand"));
            fermento.setCategoria(arrayFermentos.getJSONObject(i).getString("categoria"));
            fermento.setAtenuacao(arrayFermentos.getJSONObject(i).getDouble("atenuacao"));
            fermento.setFloculacao(arrayFermentos.getJSONObject(i).getString("floculacao"));
            fermento.setMinTemp(arrayFermentos.getJSONObject(i).getDouble("minTemp"));
            fermento.setMaxTemp(arrayFermentos.getJSONObject(i).getDouble("maxTemp"));
            fermento.setAlcoolTolerancia(arrayFermentos.getJSONObject(i).getString("alcoolTolerancia"));

            fermentos.add(fermento);
        }
        jsonData = readFileJson("estilos.json");
        JSONArray arrayEstilos = new JSONArray(jsonData);
        for (int i = 0; i < arrayEstilos.length(); i++) {
            Estilo estilo = new Estilo();

            estilo.setId(arrayEstilos.getJSONObject(i).getInt("id"));
            estilo.setBjcp(arrayEstilos.getJSONObject(i).getString("bjcp"));
            estilo.setCategoria(arrayEstilos.getJSONObject(i).getString("categoria"));
            estilo.setNome(arrayEstilos.getJSONObject(i).getString("nome"));
            estilo.setGravidadeOriginalMin(arrayEstilos.getJSONObject(i).getDouble("gravidadeOriginalMin"));
            estilo.setGravidadeFinalMin(arrayEstilos.getJSONObject(i).getDouble("gravidadeFinalMin"));
            estilo.setBitternessMin(arrayEstilos.getJSONObject(i).getDouble("bitternessMin"));
            estilo.setIbuPorOgMin(arrayEstilos.getJSONObject(i).getDouble("ibuPorOgMin"));
            estilo.setBalancoMin(arrayEstilos.getJSONObject(i).getDouble("balancoMin"));
            estilo.setAbvMin(arrayEstilos.getJSONObject(i).getDouble("abvMin"));
            estilo.setCorMin(arrayEstilos.getJSONObject(i).getDouble("corMin"));
            estilo.setGravidadeOriginalMax(arrayEstilos.getJSONObject(i).getDouble("gravidadeOriginalMax"));
            estilo.setGravidadeFinalMax(arrayEstilos.getJSONObject(i).getDouble("gravidadeFinalMax"));
            estilo.setBitternessMax(arrayEstilos.getJSONObject(i).getDouble("bitternessMax"));
            estilo.setIbuPorOgMax(arrayEstilos.getJSONObject(i).getDouble("ibuPorOgMax"));
            estilo.setBalancoMax(arrayEstilos.getJSONObject(i).getDouble("balancoMax"));
            estilo.setAbvMax(arrayEstilos.getJSONObject(i).getDouble("abvMax"));
            estilo.setCorMax(arrayEstilos.getJSONObject(i).getDouble("corMax"));

            estilos.add(estilo);
        }
    }

    public String readFileJson(String name) {
        String json = "";
        try {
            InputStream inputStream = getAssets().open(name);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void setCores() {
        LinearLayout corCopo = (LinearLayout) findViewById(R.id.corCerveja);
        corCopo.setBackground(ContextCompat.getDrawable(getApplicationContext(), getCorHexaDecimal()));
        LinearLayout corLayout = (LinearLayout) findViewById(R.id.linearLayoutFervura);
        corLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(), getCorHexaDecimal()));
    }



    public int getCorHexaDecimal(){

        int[] srm = new int[42];
        srm[0] = R.drawable.COR_FFF4D4;
        srm[1]= R.drawable.COR_FFE699;
        srm[2]= R.drawable.COR_FFD878;
        srm[3]= R.drawable.COR_FFCA5A;
        srm[4]= R.drawable.COR_FFBF42;
        srm[5]= R.drawable.COR_FBB123;
        srm[6]= R.drawable.COR_F8A600;
        srm[7]= R.drawable.COR_F39C00;
        srm[8]= R.drawable.COR_EA8F00;
        srm[9]= R.drawable.COR_E58500;
        srm[10]= R.drawable.COR_DE7C00;
        srm[11]= R.drawable.COR_D77200;
        srm[12]= R.drawable.COR_CF6900;
        srm[13]= R.drawable.COR_CB6200;
        srm[14]= R.drawable.COR_C35900;
        srm[15]= R.drawable.COR_BB5100;
        srm[16]= R.drawable.COR_B54C00;
        srm[17]= R.drawable.COR_B04500;
        srm[18]= R.drawable.COR_A63E00;
        srm[19]= R.drawable.COR_A13700;
        srm[20]= R.drawable.COR_9B3200;
        srm[21]= R.drawable.COR_952D00;
        srm[22]= R.drawable.COR_8E2900;
        srm[23]= R.drawable.COR_882300;
        srm[24]= R.drawable.COR_CF6900;
        srm[25]= R.drawable.COR_7B1A00;
        srm[26]= R.drawable.COR_771900;
        srm[27]= R.drawable.COR_701400;
        srm[28]= R.drawable.COR_6A0E00;
        srm[29]= R.drawable.COR_660D00;
        srm[30]= R.drawable.COR_5E0B00;
        srm[31]= R.drawable.COR_5A0A02;
        srm[32]= R.drawable.COR_600903;
        srm[33]= R.drawable.COR_520907;
        srm[34]= R.drawable.COR_4C0505;
        srm[35]= R.drawable.COR_470606;
        srm[36]= R.drawable.COR_420607;
        srm[37]= R.drawable.COR_3D0708;
        srm[38]= R.drawable.COR_370607;
        srm[39]= R.drawable.COR_2D0607;
        srm[40]= R.drawable.COR_1F0506;

        Double cor = receita.getCor();
        if (cor > 40)
            cor = 40d;
        else if (cor < 0)
            cor = 0d;
        return srm[cor.intValue()];
    }

    public boolean hasHop(List<Lupulo> a) {
        if (a.size() == 0) {
            return false;
        }
        for (int b = 0; b < a.size(); b++) {
            System.out.println("lupulo "+a.get(b).getNome());
            if (a.get(b) != null) {
                if (a.get(b).getGramas() > 0
                        && a.get(b).getAlphaAcidos() > 0
                        && ((a.get(b).getTempo() != null && a.get(b).getTempo() >= 0)
                        || a.get(b).getUso().equals("First Wort") || a.get(b).getUso().equals("Mash"))) {
                    System.out.println("true hops");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasFermentable(List<Graos> b) {
        if (b.size() == 0) {
            return false;
        }
        for (int a = 0; a < b.size(); a++) {
            if (b.get(a) != null) {
                if (b.get(a).getKilos() > 0 && b.get(a).getPotencialExtracao() > 0 && b.get(a).getCor() >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public Double calculateBoilGravity(Double b, Double a, Double c) {
        if (a <= 0) {
            return 0d;
        }
        if (c <= 0) {
            return 0d;
        }
        if (b <= 0) {
            return 0d;
        }
        return ((b / a) * (c - 1) + 1);
    }
    public Double convertGravityToPlato(Double b) {

        Double a = (-1 * 616.868) + (1111.14 * b) - (630.272 * Math.pow(b, 2))
                + (135.997 * Math.pow(b, 3));
        return rounddecimal(a, 1d);
    }

    public Double convertGravityToPlato(Double b, Double c) {
        if (c != null) {
            c = 1d;
        }
        Double a = (-1 * 616.868) + (1111.14 * b) - (630.272 * Math.pow(b, 2))
                + (135.997 * Math.pow(b, 3));
        return rounddecimal(a, c);
    }

    public Double rounddecimal(Double e, Double c) {

        Double a = Math.round(e * Math.pow(10, c)) / Math.pow(10, c);

        return a;
    }

    public Double computeCaloriesPer12oz(Double a, Double e) {

        if (e <= -12) {
            return 0d;
        }
        Double b = (0.1808 * a) + (0.8192 * e);
        Double c = (a - b) / (2.0665 - (0.010665 * a));
        Double d = convertPlatoToGravity(e);
        Double f = ((6.9 * c) + 4 * (b - 0.1)) * d * 3.55;
        return f;
    }

    public Double convertPlatoToGravity(Double a) {
        return (a / (258.6 - ((a / 258.2) * 227.1))) + 1;
    }

    public Double calculaABV(Double FG, Double OG) {
        return (FG - OG) * (125 * 1.05);
    }

    public Double calculaIbuPorOg(Double IBU, Double OG) {
        Double min = (receita.getEstilo().getBitternessMin() / (receita.getEstilo().getGravidadeOriginalMin() - 1d) * 1000);
        receita.getEstilo().setIbuPorOgMin(min);
        Double max = (receita.getEstilo().getBitternessMax() / (receita.getEstilo().getGravidadeOriginalMax() - 1d) * 1000);
        receita.getEstilo().setIbuPorOgMax(max);

        OG = (OG - 1d) * 1000;
        //System.out.println("OG "+OG);
        //System.out.println("IBU "+IBU);
        Double BUGU =((IBU / OG));
        //System.out.println("BUGU " +BUGU);
        return BUGU;
    }

    public Double calculaABVAlternativo(Double d, Double a) {
        Double b = 76.08 * (d - a) / (1.775 - d);
        Double c = b * (a / 0.794);
        return rounddecimal(c, 10d);
    }
    public Double calculateMCUtotal(List<Graos> e, Double d) {

        Double a = 0d;
        for (int c = 0; c < e.size(); c++) {
            if (e.get(c) != null) {
                Double b = calculateMCU(e.get(c), d);
                a = a + b;
            }
        }
        return a;
    }

    public Double calculateMCU(Graos a, Double b) {

        return (a.getKilos() * 2.20462) * (a.getCor() / (b*0.264172));
    }
    public Double calculateSRMMorey(List<Graos> c, Double b) {

        Double d = 0d;
        Double a = calculateMCUtotal(c, b);
        d = 1.4922 * Math.pow(a, 0.6859);
        if (d >= 50) {
            d = 50d;
        }


        DecimalFormat df = new DecimalFormat("#.0");
        try {
            Number numberMask = df.parse(df.format(d));
            d = numberMask.doubleValue();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return d;
    }
    public Double calculateSRMDaniels(List<Graos> c, Double b) {

        Double d = 0d;
        Double a = calculateMCUtotal(c, b);
        d = (a * 0.2) + 8.4;
        if (d >= 40) {
            d = 40d;
        }
        return d;
    }
    public Double calculateSRMMosher(List<Graos> c, Double b) {

        Double d = 0d;
        Double a = calculateMCUtotal(c, b);
        d = (a * 0.3) + 4.7;
        if (d >= 40) {
            d = 40d;
        }
        return d;
    }
    public Double srmToEBC(Double a) {
        return 1.97 * a;
    }

    public Double calculaOG(List<Graos> graos, List<Lupulo> lupulos, Double eficiencia, Double quantidadeLitros) {

        Double gTotal = 0d;
        Double OG = 0d;
        Double gravidade = 0d;

        for (int i=0; i< graos.size(); i++){
            graos.get(i).setPercentagem( graos.get(i).getKilos() / receita.getQuantidadeGraos() * 100);
            receita.setPercentagemGraos(receita.getPercentagemGraos() + graos.get(i).getPercentagem());
            gTotal =  ((graos.get(i).getKilos() / 1000) * ( (receita.getEficiencia()/100) * ((graos.get(i).getPotencialExtracao() - 1) * 8.35) ));

            OG = (gTotal / quantidadeLitros) + 1.000;

            gravidade = gravidade + (OG - 1.000);

        }

        DecimalFormat df = new DecimalFormat("#.000");
        try {
            Number numberMask = df.parse(df.format(gravidade + 1.000));
            gravidade = numberMask.doubleValue();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        receita.setGraos(graos);
//         System.out.println("cor Morey "+calculateSRMMorey(receita.getGraos(), quantidadeLitros));
//         System.out.println("cor Daniels "+calculateSRMDaniels(receita.getGraos(), quantidadeLitros));
//         System.out.println("cor Mosher "+calculateSRMMosher(receita.getGraos(), quantidadeLitros));

        return gravidade;
    }

    public void corrigePercentagem(List<Graos> graos, int indexRow,  Double oldValue, Double newValue) {

        graos.get(indexRow).setPercentagem(newValue);
        Double umPercento = receita.getQuantidadeGraos()/100;
        graos.get(indexRow).setKilos(newValue*umPercento);

        Double diferenca = 0d;
        //System.out.println("anterior: "+oldValue+" atual "+newValue);
        if (oldValue > newValue)
            diferenca = oldValue - newValue;
        else
            diferenca = newValue - oldValue;

        diferenca = diferenca / (graos.size()-1);
        //System.out.println("diferenca "+diferenca);
        for (int i=0; i<graos.size(); i++){

            if (i != indexRow){
                if (oldValue > newValue){
                    graos.get(i).setPercentagem(graos.get(i).getPercentagem()+diferenca < 100 ? graos.get(i).getPercentagem()+diferenca : 100d);
                    graos.get(i).setKilos(graos.get(i).getKilos()+(diferenca*umPercento) < 100 ? graos.get(i).getKilos()+(diferenca*umPercento) : 100d);
                }
                else{
                    graos.get(i).setPercentagem(graos.get(i).getPercentagem()-diferenca > 0 ? graos.get(i).getPercentagem()-diferenca : 0d);
                    graos.get(i).setKilos(graos.get(i).getKilos()-(diferenca*umPercento) > 0 ? graos.get(i).getKilos()-(diferenca*umPercento) : 0d);
                }
            }
            System.out.println(i+" = "+graos.get(i).getPercentagem() +"% "+ graos.get(i).getKilos()+"Kg");
        }
        receita.setGraos(graos);
        calcular();
    }

    public void calculaOGPorPercentagem(List<Graos> graos, List<Lupulo> lupulos, Double eficiencia, Double quantidadeLitros) {

        Double gTotal = 0d;
        Double OG = 0d;
        receita.setQuantidadeGraos(0d);
        receita.setGravidadeOriginal(0d);
        for (int i=0; i< graos.size(); i++){
            receita.setQuantidadeGraos(receita.getQuantidadeGraos()+graos.get(i).getKilos());
        }

        Double kilos = 0d;
        for (int i=0; i< graos.size(); i++){
            kilos = 1000 * ((graos.get(i).getPercentagem()/100)) / ( (receita.getEficiencia()/100) * ((graos.get(i).getPotencialExtracao() - 1) * 8.35) );
            graos.get(i).setKilos(kilos);
            gTotal =  ((graos.get(i).getKilos() / 1000) * ( (receita.getEficiencia()/100) * ((graos.get(i).getPotencialExtracao() - 1) * 8.35) ));


            OG = (gTotal / receita.getQuantidadeLitros()) + 1.000;

            receita.setGravidadeOriginal(receita.getGravidadeOriginal() + (OG - 1.000));

        }


        DecimalFormat df = new DecimalFormat("#.000");
        try {
            Number numberMask = df.parse(df.format(receita.getGravidadeOriginal() + 1.000));
            receita.setGravidadeOriginal(numberMask.doubleValue());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        receita.setGraos(graos);

        calculaFG();
    }

    public Double calculaIBU(List<Lupulo> lupulos) {

        Double cinco[] = {0.055,0.050,0.046,0.042,0.038,0.035,0.032,0.029,0.027,0.025};
        Double dez[] = {0.100,0.091,0.084,0.076,0.070,0.064,0.058,0.053,0.049,0.045};
        Double quinze[] = {0.137,0.125,0.114,0.105,0.096,0.087,0.080,0.073,0.067,0.061};
        Double vinte[] = {0.167,0.153,0.140,0.128,0.117,0.107,0.098,0.089,0.081,0.074};
        Double vintecinco[] = {0.192,0.175,0.160,0.147,0.134,0.122,0.112,0.102,0.094,0.085};
        Double trinta[] = {0.212,0.194,0.177,0.162,0.148,0.135,0.124,0.113,0.103,0.094};
        Double trintacinco[] = {0.229,0.209,0.191,0.175,0.160,0.146,0.133,0.122,0.111,0.102};
        Double quarenta[] = {0.242,0.221,0.202,0.185,0.169,0.155,0.141,0.129,0.118,0.108};
        Double quarentacinco[] = {0.253,0.232,0.212,0.194,0.177,0.162,0.148,0.135,0.123,0.113};
        Double cincoenta[] = {0.263,0.240,0.219,0.200,0.183,0.168,0.153,0.140,0.128,0.117};
        Double cincoentacinco[] = {0.270,0.247,0.226,0.206,0.188,0.172,0.157,0.144,0.132,0.120};
        Double sesenta[] = {0.276,0.252,0.231,0.211,0.193,0.176,0.161,0.147,0.135,0.123};
        Double setenta[] = {0.261,0.238,0.218,0.199,0.182,0.166,0.152,0.139,0.127};
        Double oitenta[] = {0.266,0.243,0.222,0.203,0.186,0.170,0.155,0.142,0.130};
        Double noventa[] = {0.270,0.247,0.226,0.206,0.188,0.172,0.157,0.144,0.132};
        Double cem[] = {0.298,0.272,0.249,0.228,0.208,0.190,0.174,0.159,0.145,0.133};
        Double centodez[] = {0.300,0.274,0.251,0.229,0.209,0.191,0.175,0.160,0.146,0.134};
        Double centovinte[] = {0.301,0.275,0.252,0.230,0.210,0.192,0.176,0.161,0.147,0.134};

        Double IBU = 0d;
        Double U = 0d;
        for (int i=0; i<lupulos.size(); i++){

            if (lupulos.get(i).getTempo() >= 1 && lupulos.get(i).getTempo() <= 5){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j<cinco.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = cinco[j];
                            if (j+1<cinco.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((cinco[j]-cinco[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = cinco[0];
            }
            else if (lupulos.get(i).getTempo() >= 6 && lupulos.get(i).getTempo() <= 10){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j<dez.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = dez[j];
                            if (j+1<dez.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((dez[j]-dez[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = dez[0];
            }
            else if (lupulos.get(i).getTempo() >= 11 && lupulos.get(i).getTempo() <= 15){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j<quinze.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = quinze[j];
                            if (j+1<quinze.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((quinze[j]-quinze[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = quinze[0];
            }
            else if (lupulos.get(i).getTempo() >= 16 && lupulos.get(i).getTempo() <= 20){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j< vinte.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = vinte[j];
                            if (j+1<vinte.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((vinte[j]-vinte[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = vinte[0];
            }
            else if (lupulos.get(i).getTempo() >= 21 && lupulos.get(i).getTempo() <= 25){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j< vintecinco.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = vintecinco[j];
                            if (j+1<vintecinco.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((vintecinco[j]-vintecinco[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = vintecinco[0];
            }
            else if (lupulos.get(i).getTempo() >= 26 && lupulos.get(i).getTempo() <= 30){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j< trinta.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = trinta[j];
                            if (j+1<trinta.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((trinta[j]-trinta[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = trinta[0];
            }
            else if (lupulos.get(i).getTempo() >= 31 && lupulos.get(i).getTempo() <= 35){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j<trintacinco.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = trintacinco[j];
                            if (j+1<trintacinco.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((trintacinco[j]-trintacinco[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = trintacinco[0];
            }
            else if (lupulos.get(i).getTempo() >= 36 && lupulos.get(i).getTempo() <= 40){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j<quarenta.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = quarenta[j];
                            if (j+1<quarenta.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((quarenta[j]-quarenta[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = quarenta[0];
            }
            else if (lupulos.get(i).getTempo() >= 41 && lupulos.get(i).getTempo() <= 45){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j<quarentacinco.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = quarentacinco[j];
                            if (j+1<quarentacinco.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((quarentacinco[j]-quarentacinco[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = quarentacinco[0];
            }
            else if (lupulos.get(i).getTempo() >= 46 && lupulos.get(i).getTempo() <= 50){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j<cincoenta.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = cincoenta[j];
                            if (j+1<cincoenta.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((cincoenta[j]-cincoenta[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = cincoenta[0];
            }
            else if (lupulos.get(i).getTempo() >= 51 && lupulos.get(i).getTempo() <= 55){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j<cincoentacinco.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = cincoentacinco[j];
                            if (j+1<cincoentacinco.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((cincoentacinco[j]-cincoentacinco[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = cincoentacinco[0];
            }
            else if (lupulos.get(i).getTempo() >= 56 && lupulos.get(i).getTempo() <= 60){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j<sesenta.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = sesenta[j];
                            if (j+1<sesenta.length && OG != receita.getGravidadeOriginal()){
                                //								System.out.println("Diferenca da tabela 1.040 para 1.050: "+sesenta[j] + " - "+sesenta[j+1]+" = "+(sesenta[j]-sesenta[j+1]));
                                //								System.out.println("Valor por unidade gravitacional: "+(sesenta[j]-sesenta[j+1]) / 10);
                                //								System.out.println("OG: "+receita.getGravidadeOriginal()+ " Faixa "+ (OG) +" Diferenca: "+(receita.getGravidadeOriginal() - OG));
                                //								System.out.println("Valor para multiplicar: "+(receita.getGravidadeOriginal()-OG)*1000);
                                //	System.out.println(((sesenta[j]-sesenta[j+1]) / 10)*((receita.getGravidadeOriginal()-(OG+0.010))*100));
                                //
                                U = U - ((sesenta[j]-sesenta[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = sesenta[0];
            }
            else if (lupulos.get(i).getTempo() >= 61 && lupulos.get(i).getTempo() <= 70){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j<setenta.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = setenta[j];
                            if (j+1<setenta.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((setenta[j]-setenta[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = setenta[0];
            }
            else if (lupulos.get(i).getTempo() >= 71 && lupulos.get(i).getTempo() <= 80){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j<oitenta.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = oitenta[j];
                            if (j+1<oitenta.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((oitenta[j]-oitenta[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = oitenta[0];
            }
            else if (lupulos.get(i).getTempo() >= 81 && lupulos.get(i).getTempo() <= 90){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j<noventa.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = noventa[j];
                            if (j+1<noventa.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((noventa[j]-noventa[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = noventa[0];
            }
            else if (lupulos.get(i).getTempo() >= 91 && lupulos.get(i).getTempo() <= 100){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j<cem.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = cem[j];
                            if (j+1<cem.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((cem[j]-cem[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = cem[0];
            }
            else if (lupulos.get(i).getTempo() >= 101 && lupulos.get(i).getTempo() <= 110){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j<centodez.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = centodez[j];
                            if (j+1<centodez.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((centodez[j]-centodez[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = centodez[0];
            }
            else if (lupulos.get(i).getTempo() >= 110){
                double OG = 1.030;
                if (receita.getGravidadeOriginal() >= OG) {
                    for (int j=0; j<centovinte.length; j++){
                        if (receita.getGravidadeOriginal() >= OG && receita.getGravidadeOriginal() < (OG + 0.010)){
                            U = centovinte[j];
                            if (j+1<centovinte.length && OG != receita.getGravidadeOriginal()){
                                U = U - ((centovinte[j]-centovinte[j+1]) / 10)*((receita.getGravidadeOriginal()-OG)*1000);
                            }
                        }
                        OG = OG + 0.010;
                    }
                }
                else
                    U = centovinte[0];
            }

            lupulos.get(i).setIbu(((U * (lupulos.get(i).getAlphaAcidos() / 100) * lupulos.get(i).getGramas() * 1000) / receita.getQuantidadeLitros()));
//			System.out.println(U + " * " +(lupulos.get(i).getAlphaAcidos() / 100)+" * "+lupulos.get(i).getGramas()+" * "+1000+ " / "+receita.getQuantidadeLitros());
            if (lupulos.get(i).getTipo().equals("PELLET"))
                lupulos.get(i).setIbu(lupulos.get(i).getIbu()+(lupulos.get(i).getIbu()*0.1));

            IBU = IBU + lupulos.get(i).getIbu();
//			System.out.println(IBU);
        }

        return IBU;
    }

    public String calculaQntdAgua(){


        receita.setQntdTotalLitros(receita.getQuantidadeLitros() + receita.getQuantidadeGraos() + receita.getPerdaPanelaBrassagem() + receita.getPerdaPanelaFervura()+ receita.getPerdaFermentador());
        receita.setQntdTotalLitros(receita.getQntdTotalLitros() + ((receita.getQntdTotalLitros() / 100) * receita.getTaxaEvaporacao()));

        receita.setQntdInicialLitros(receita.getQuantidadeGraos() * receita.getRelacaoAguaGrao());
        receita.setQntdLavagemLitros(receita.getQntdTotalLitros()-receita.getQntdInicialLitros());

        receita.setTemperaturaInicial( (receita.getQuantidadeGraos()/receita.getQuantidadeLitros()) * (receita.getTemperaturaBrassagem() - receita.getTemperaturaGraos()) + receita.getTemperaturaBrassagem() );
        receita.setTemperaturaLavagemIdeal((receita.getQntdInicialLitros()/receita.getQntdLavagemLitros()) * (receita.getTemperaturaLavagemDesejada() - receita.getTemperaturaBrassagem()) + receita.getTemperaturaLavagemDesejada());
        receita.setQntdTotalMostoLitros( receita.getQntdInicialLitros()+(receita.getQuantidadeGraos()*receita.getAbsorcaoGraos()) );

        System.out.println(receita.getQuantidadeLitros() + " " +receita.getQuantidadeGraos() + " " + (receita.getQuantidadeLitros()-(receita.getQuantidadeLitros() * receita.getTaxaContracao())));

        receita.setQuantidadeAntesFerver(receita.getQuantidadeLitros()+receita.getQuantidadeGraos()+(receita.getQuantidadeLitros() -(receita.getQuantidadeLitros() * receita.getTaxaContracao())));
        receita.setSgAntesFerver(calculaOG(receita.getGraos(), receita.getLupulos(), receita.getEficiencia(),  receita.getQuantidadeAntesFerver()));

        receita.setQuantidadeDepoisFerver( receita.getQuantidadeAntesFerver()-((receita.getQuantidadeLitros() / 100 )* receita.getTaxaEvaporacao()));
        receita.setSdDepoisFerver(receita.getGravidadeOriginal());
        receita.setVolumeAntesEsfriar(receita.getQuantidadeLitros() + (receita.getQuantidadeLitros()-(receita.getQuantidadeLitros() * receita.getTaxaContracao())));

        return "";
    }

    public Double calculaFG() {

        Double OG = receita.getGravidadeOriginal();
        OG = OG - 1;
        Double FG = receita.getGravidadeOriginal() - (OG * (receita.getFermento().getAtenuacao()/100d));

        DecimalFormat df = new DecimalFormat("#.000");
        try {
            Number numberMask = df.parse(df.format(FG));
            FG = numberMask.doubleValue();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return FG;
    }

    public String limpar(){
        receita = new Receita();

        return "";
    }

    public String calcular(){

        verificaQuantidadeGraos();
        verificaQuantidadeLupulo();

        TextView textViewGraos = (TextView) findViewById(R.id.textViewGraos);
        textViewGraos.setText(getString(R.string.graos)+ " ("+ receita.getQuantidadeGraos() +"Kg)");
        TextView textViewLupulo = (TextView) findViewById(R.id.textViewLupulos);
        textViewLupulo.setText(getString(R.string.lupulo)+ " ("+ receita.getQuantidadeLupulo() +"g)");

        receita.setGravidadeOriginal(calculaOG(receita.getGraos(), receita.getLupulos(), receita.getEficiencia(), receita.getQuantidadeLitros()));

        receita.setGravidadeFinal(calculaFG());
        receita.setAbv(calculaABV(receita.getGravidadeOriginal() , receita.getGravidadeFinal()));
        receita.setIbuPorOg(calculaIbuPorOg(receita.getBitterness(), receita.getGravidadeOriginal()));
        receita.setBitterness(calculaIBU(receita.getLupulos()));

        calculaQntdAgua();

        // Atualiza campos
        editTextQuantidade.setText(receita.getQuantidadeLitros()+"");
        editTextEficiencia.setText(receita.getEficiencia()+"");
        editTextOG.setText(receita.getGravidadeOriginal()+"");
        editTextOG.setEnabled(false);
        editTextFG.setText(receita.getGravidadeFinal()+"");
        editTextFG.setEnabled(false);
        editTextIBU.setText(receita.getBitterness()+"");
        editTextIBU.setEnabled(false);
        editTextBUGU.setText(receita.getIbuPorOg()+"");
        editTextBUGU.setEnabled(false);
        editTextABV.setText(receita.getAbv()+"");
        editTextABV.setEnabled(false);

        if (tipoCor.equals("EBC"))
            receita.setCor(srmToEBC(calculateSRMMorey(receita.getGraos(), receita.getQuantidadeLitros())));
        else
            receita.setCor(calculateSRMMorey(receita.getGraos(), receita.getQuantidadeLitros()));

        setCores();

        dialogButtonFervura.setText(receita.getCor()+" "+tipoCor);
        return "";
    }

    private void verificaQuantidadeLupulo() {
        Double qntdLupulo = 0d;
        for (int i=0; i<receita.getLupulos().size(); i++){
            qntdLupulo = qntdLupulo +receita.getLupulos().get(i).getGramas();
        }
        receita.setQuantidadeLupulo(qntdLupulo);
    }

    private void verificaQuantidadeGraos() {
        Double qntdGraos = 0d;
        for (int i=0; i<receita.getGraos().size(); i++){
            qntdGraos = qntdGraos +receita.getGraos().get(i).getKilos();
        }
        receita.setQuantidadeGraos(qntdGraos);
    }
}
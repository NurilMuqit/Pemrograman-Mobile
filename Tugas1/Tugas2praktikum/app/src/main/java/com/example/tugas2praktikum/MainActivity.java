package com.example.tugas2praktikum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextInputEditText jariJari, tinggi, lebar, panjang;
    private Button hitung;
    private TextView hasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        jariJari = findViewById(R.id.jariJari);
        tinggi = findViewById(R.id.tinggi);
        lebar = findViewById(R.id.lebar);
        panjang = findViewById(R.id.panjang);
        hitung = findViewById(R.id.hitung);
        hasil = findViewById(R.id.hasil);

        String[] daftarBangunRuang = {"Pilih Bangun Ruang","Bola", "Balok", "Kerucut"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, daftarBangunRuang);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 1:
                        panjang.setVisibility(View.GONE);
                        lebar.setVisibility(View.GONE);
                        tinggi.setVisibility(View.GONE);
                        jariJari.setVisibility(View.VISIBLE);
                        hitung.setVisibility(View.VISIBLE);
                        hasil.setVisibility(View.VISIBLE);

                        hitung.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String jariJariInput = jariJari.getText().toString();

                                if (jariJariInput.isEmpty()){
                                    jariJari.setError("Tidak boleh kosong");
                                } else{
                                    double jariJariBola = Double.parseDouble(jariJariInput);
                                    double volume = (4.0/3.0 * Math.PI * Math.pow(jariJariBola, 3));
                                    hasil.setText(String.format("%.2f", volume));
                                }
                            }
                        });
                        break;

                    case 2:
                        panjang.setVisibility(View.VISIBLE);
                        lebar.setVisibility(View.VISIBLE);
                        tinggi.setVisibility(View.VISIBLE);
                        jariJari.setVisibility(View.GONE);
                        hitung.setVisibility(View.VISIBLE);
                        hasil.setVisibility(View.VISIBLE);

                        hitung.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String panjangInput = panjang.getText().toString();
                                String lebarInput = lebar.getText().toString();
                                String tinggiInput = tinggi.getText().toString();

                                if(panjangInput.isEmpty() && lebarInput.isEmpty() && tinggiInput.isEmpty()){
                                    panjang.setError("Tidak boleh kosong");
                                    lebar.setError("Tidak boleh kosong");
                                    tinggi.setError("Tidak boleh kosong");
                                } else if (panjangInput.isEmpty() && lebarInput.isEmpty()) {
                                    panjang.setError("Tidak boleh kosong");
                                    lebar.setError("Tidak boleh kosong");
                                } else if (panjangInput.isEmpty() && tinggiInput.isEmpty()) {
                                    panjang.setError("Tidak boleh kosong");
                                    tinggi.setError("Tidak boleh kosong");
                                } else if (lebarInput.isEmpty() && tinggiInput.isEmpty()) {
                                    lebar.setError("Tidak boleh kosong");
                                    tinggi.setError("Tidak boleh kosong");
                                } else if (panjangInput.isEmpty()) {
                                    panjang.setError("Tidak boleh kosong");
                                } else if (lebarInput.isEmpty()) {
                                    lebar.setError("Tidak boleh kosong");
                                } else if (tinggiInput.isEmpty()) {
                                    tinggi.setError("Tidak boleh kosong");
                                } else {
                                    double panjangBalok = Double.parseDouble(panjangInput);
                                    double lebarBalok = Double.parseDouble(lebarInput);
                                    double tinggiBalok = Double.parseDouble(tinggiInput);
                                    double volume = panjangBalok * lebarBalok * tinggiBalok;
                                    hasil.setText(String.format("%.2f", volume));
                                }
                            }
                        });

                        break;

                    case 3:
                        panjang.setVisibility(View.GONE);
                        lebar.setVisibility(View.GONE);
                        tinggi.setVisibility(View.VISIBLE);
                        jariJari.setVisibility(View.VISIBLE);
                        hitung.setVisibility(View.VISIBLE);
                        hasil.setVisibility(View.VISIBLE);

                        hitung.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String jariJariInput = jariJari.getText().toString();
                                String tinggiInput = tinggi.getText().toString();

                                if(jariJariInput.isEmpty() && tinggiInput.isEmpty()) {
                                    jariJari.setError("Tidak boleh kosong");
                                    tinggi.setError("Tidak boleh kosong");
                                } else if(jariJariInput.isEmpty()) {
                                    jariJari.setError("Tidak boleh kosong");
                                } else if(tinggiInput.isEmpty()) {
                                    tinggi.setError("Tidak boleh kosong");
                                } else {
                                    double radiusKerucut = Double.parseDouble(jariJariInput);
                                    double tinggiKerucut = Double.parseDouble(tinggiInput);
                                    double volume = (1.0/3.0) * Math.PI * Math.pow(radiusKerucut, 2) * tinggiKerucut;
                                    hasil.setText(String.format("%.2f", volume));
                                }
                            }
                        });
                        break;

                    default :
                        panjang.setVisibility(View.GONE);
                        lebar.setVisibility(View.GONE);
                        tinggi.setVisibility(View.GONE);
                        jariJari.setVisibility(View.GONE);
                        hitung.setVisibility(View.GONE);
                        break;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
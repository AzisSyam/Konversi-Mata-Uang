package com.android.aplikasikonversi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
	Spinner jenisMataUangSatu;
	Button tombolKonversi;
	EditText nilaiMataUangDua;
	TextView nilaiMataUangSatu, jenisMataUangDua;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		jenisMataUangDua = findViewById(R.id.jenis_mata_uang_dua);
		jenisMataUangSatu = findViewById(R.id.jenis_mata_uang_satu);
		nilaiMataUangSatu = findViewById(R.id.mata_uang_satu);
		nilaiMataUangDua = findViewById(R.id.mata_uang_dua);
		tombolKonversi = findViewById(R.id.tombol_konversi);

		ArrayAdapter<CharSequence> adapterMataUangSatu = ArrayAdapter.createFromResource(this,
						R.array.jenis_mata_uang, android.R.layout.simple_spinner_item);
		adapterMataUangSatu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		jenisMataUangSatu.setAdapter(adapterMataUangSatu);

		tombolKonversi.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String nilaiJenisMataUangSatu = jenisMataUangSatu.getSelectedItem().toString();
				String inputNilaiMataUangDua = nilaiMataUangDua.getText().toString();

				if(inputNilaiMataUangDua.length() == 0){
					nilaiMataUangDua.setError("Isi bidang ini!");
				}else{
					int konversiMataUangDua = Integer.parseInt(inputNilaiMataUangDua);
					String nilaiToast = String.valueOf(konversiMataUang(konversiMataUangDua, nilaiJenisMataUangSatu));
					nilaiMataUangSatu.setText(nilaiToast);
				}
			}
		});
	}

	public double konversiMataUang(double nilaiMataUangDua, String jenisMataUangSatu) {
		if (Objects.equals(jenisMataUangSatu, "USD")) {
			return nilaiMataUangDua * 14000;
		} else {
			return nilaiMataUangDua * 115.86;
		}
	}
}


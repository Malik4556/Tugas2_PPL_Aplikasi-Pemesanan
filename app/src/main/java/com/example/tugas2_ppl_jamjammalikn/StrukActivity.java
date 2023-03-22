package com.example.tugas2_ppl_jamjammalikn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StrukActivity extends AppCompatActivity implements View.OnClickListener   {

    //Kodingan Jamjam Malik Nurjaman
    TextView txtNama, txtDate, txtMakanan, txtQyt,
            txtSub, txtPajak, txtTotal, txtBayar, txtKembalian;
    Button btnKembali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_struk);

        txtDate = (TextView) findViewById(R.id.txt_date);
        txtNama = (TextView) findViewById(R.id.txt_nama);
        txtMakanan = (TextView) findViewById(R.id.txt_makanan);
        txtQyt = (TextView) findViewById(R.id.txt_qyt);
        txtSub = (TextView) findViewById(R.id.txt_sub);
        txtPajak = (TextView) findViewById(R.id.txt_pajak);
        txtTotal = (TextView) findViewById(R.id.txt_total);
        txtBayar = (TextView) findViewById(R.id.txt_tunai);
        txtKembalian = (TextView) findViewById(R.id.txt_kembalian);

        String tgl = getIntent().getExtras().getString("tanggal");
        String nama = getIntent().getExtras().getString("nama");
        String barang = getIntent().getExtras().getString("text");
        String qyt = getIntent().getExtras().getString("qyt");
        String subtotal = getIntent().getExtras().getString("subtotal");
        String pajak = getIntent().getExtras().getString("pajak");
        String total = getIntent().getExtras().getString("total");
        String tunai= getIntent().getExtras().getString("tunai");
        String kembalian = getIntent().getExtras().getString("kembalian");

        txtDate.setText("" + tgl);
        txtNama.setText("Nama  : " + nama);
        txtMakanan.setText("" + barang);
        txtQyt.setText("" + qyt);
        txtSub.setText("Sub Total : " + subtotal);
        txtPajak.setText("Pajak : " + pajak);
        txtTotal.setText("Total : IDR " + total);
        txtBayar.setText("Jumlah Bayar : IDR " + tunai);
        txtKembalian.setText("Jumlah Kembalian :" + kembalian);

        this.setTitle("STRUK PEMBAYARAN");
        btnKembali = findViewById(R.id.btn_kembali);
        btnKembali.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_kembali:
                Intent m = new Intent(this, PesananActivity.class);
                startActivity(m);
                break;
        }
    }
}
package com.example.tugas2_ppl_jamjammalikn;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class PesananActivity extends AppCompatActivity {

    //Kodingan Jamjam Malik Nurjaman

    TextView txtMakanan, txtTanggal, txtHasilTgl, txtHasilSub, txtHasilPajak,
            txtHasilTotal, txtHasilKembalian;
    EditText editNama, editTunai, editJumMak1, editJumMak2, editJumMak3,
            editJumMin1, editJumMin2, editJumMin3;
    CheckBox cbMakanan1, cbMakanan2, cbMakanan3, cbMinuman1, cbMinuman2, cbMinuman3;
    Button btnHitung, btnHitungKembalian;
    private Calendar calendar;
    private DatePicker datePicker;
    private int day, month, year;
    int hargamak1 = 35000;
    int hargamak2 = 30000;
    int hargamak3 = 25000;
    int hargamin1 = 10000;
    int hargamin2 = 18000;
    int hargamin3 = 15000;
    String text = "";
    String qyt = "";

    private void initUI() {
        txtTanggal = (TextView) findViewById(R.id.txt_tanggal);
        txtHasilTgl = (TextView) findViewById(R.id.txt_hasiltgl);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan);

        this.setTitle("PT.ABC WOW");

        initUI();

        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        //TextView
        txtMakanan = (TextView) findViewById(R.id.txt_makanan);
        txtHasilSub = (TextView) findViewById(R.id.txt_hasilsub);
        txtHasilPajak = (TextView) findViewById(R.id.txt_hasilpajak);
        txtHasilTotal = (TextView) findViewById(R.id.txt_hasiltotal);
        txtHasilKembalian = (TextView) findViewById(R.id.txt_hasilkembalian);

        //EditText
        editNama = (EditText) findViewById(R.id.edit_nama);
        editTunai = (EditText) findViewById(R.id.edit_tunai);
        editJumMak1 = (EditText) findViewById(R.id.edit_jummak1);
        editJumMak2 = (EditText) findViewById(R.id.edit_jummak2);
        editJumMak3 = (EditText) findViewById(R.id.edit_jummak3);
        editJumMin1 = (EditText) findViewById(R.id.edit_jummin1);
        editJumMin2 = (EditText) findViewById(R.id.edit_jummin2);
        editJumMin3 = (EditText) findViewById(R.id.edit_jummin3);

        //CheckBoc
        cbMakanan1 = (CheckBox) findViewById(R.id.cb_makanan1);
        cbMakanan2 = (CheckBox) findViewById(R.id.cb_makanan2);
        cbMakanan3 = (CheckBox) findViewById(R.id.cb_makanan3);
        cbMinuman1 = (CheckBox) findViewById(R.id.cb_minuman1);
        cbMinuman2 = (CheckBox) findViewById(R.id.cb_minuman2);
        cbMinuman3 = (CheckBox) findViewById(R.id.cb_minuman3);

        btnHitung = (Button) findViewById(R.id.btn_hitung);
        btnHitungKembalian = (Button) findViewById(R.id.btn_hitungkembalian);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = "Nama Pembeli : " + editNama.getText().toString();
                int toOrder = 0;
                if (cbMakanan1.isChecked()) {
                    String hasil = "Uleg";
                    int jml = Integer.parseInt(editJumMak1.getText().toString());
                    int cal = jml * hargamak1;
                    text += hasil + "\t\t\t\t\t"  + "\n";
                    qyt += jml + "\t\t\t\t\t"  + "IDR " + cal  + "\n";
                    toOrder = toOrder + cal;
                }
                if (cbMakanan2.isChecked()) {
                    String hasil = "urab";
                    int jml = Integer.parseInt(editJumMak2.getText().toString());
                    int cal = jml * hargamak2;
                    text += hasil + "\t\t\t\t\t"  + "\n";
                    qyt += jml + "\t\t\t\t\t"  + "IDR " + cal  + "\n";
                    toOrder = toOrder + cal;

                }
                if (cbMakanan3.isChecked()) {
                    String hasil = "Karedok";
                    int jml = Integer.parseInt(editJumMak3.getText().toString());
                    int cal = jml * hargamak3;
                    text += hasil + "\t\t\t\t\t"  + "\n";
                    qyt += jml + "\t\t\t\t\t"  + "IDR " + cal  + "\n";
                    toOrder = toOrder + cal;

                }
                if (cbMinuman1.isChecked()) {
                    String hasil = "Es Teh";
                    int jml = Integer.parseInt(editJumMin1.getText().toString());
                    int cal = jml * hargamin1;
                    text += hasil + "\t\t\t\t\t"  + "\n";
                    qyt += jml + "\t\t\t\t\t"  + "IDR " + cal  + "\n";
                    toOrder = toOrder + cal;
                }
                if (cbMinuman2.isChecked()) {
                    String hasil = "Es Teh Manis";
                    int jml = Integer.parseInt(editJumMin2.getText().toString());
                    int cal = jml * hargamin2;
                    text += hasil + "\t\t\t\t\t"  + "\n";
                    qyt += jml + "\t\t\t\t\t"  + "IDR " + cal  + "\n";
                    toOrder = toOrder + cal;
                }
                if (cbMinuman3.isChecked()) {
                    String hasil = "Es Teh Lemon";
                    int jml = Integer.parseInt(editJumMin3.getText().toString());
                    int cal = jml * hargamin3;
                    text += hasil + "\t\t\t\t\t"  + "\n";
                    qyt += jml + "\t\t\t\t\t"  + "IDR " + cal  + "\n";
                    toOrder = toOrder + cal;
                }


                txtHasilSub.setText("IDR " + toOrder);

                int pajak = (int) (toOrder * 0.10);
                txtHasilPajak.setText("IDR " + pajak);

                int total = (int) (toOrder + pajak);
                txtHasilTotal.setText("" + total);
            }
        });

        btnHitungKembalian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int tunai = Integer.parseInt(String.valueOf(editTunai.getText()));
                int hasiltotal = Integer.parseInt(txtHasilTotal.getText().toString());
                int kembalian = tunai - hasiltotal;
                txtHasilKembalian.setText("IDR " + kembalian);
            }
        });

        showDate(day, month + 1, year);
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int dayOfMonth, int month, int year) {
            showDate(dayOfMonth, month + 1, year);
        }
    };

    private void showDate(int day, int month, int year) {
        txtHasilTgl.setText(new StringBuilder()
                .append(day).append("/")
                .append(month).append("/")
                .append(year));
    }

    public void BuatStruk(View view) {


        Intent hubung = new Intent(PesananActivity.this, StrukActivity.class);

        hubung.putExtra("tanggal", txtHasilTgl.getText().toString());
        hubung.putExtra("nama", editNama.getText().toString());
        hubung.putExtra("text", text);
        hubung.putExtra("qyt", qyt);
        hubung.putExtra("subtotal", txtHasilSub.getText().toString());
        hubung.putExtra("pajak", txtHasilPajak.getText().toString());
        hubung.putExtra("total", txtHasilTotal.getText().toString());
        hubung.putExtra("tunai", editTunai.getText().toString());
        hubung.putExtra("kembalian", txtHasilKembalian.getText().toString());
        startActivity(hubung);


    }
}




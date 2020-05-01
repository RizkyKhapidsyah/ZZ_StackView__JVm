package com.rk.sv;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.StackView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    StackView SVw_1_IDJAVA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SVw_1_IDJAVA = findViewById(R.id.SVw_1_ID_XML);
        SVw_1_IDJAVA.setInAnimation(this, android.R.animator.fade_in);
        SVw_1_IDJAVA.setOutAnimation(this, android.R.animator.fade_out);

        StackViewAdapter pencocokAlbum = new StackViewAdapter(dapatkanPenyimpanan(), R.layout.item, MainActivity.this);
        SVw_1_IDJAVA.setAdapter(pencocokAlbum);
    }

    private List<String> dapatkanPenyimpanan() {
        List<String> X = new ArrayList<String>();
        X.add("gambar1");
        X.add("gambar2");
        X.add("gambar3");
        X.add("gambar4");
        return X;
    }
}

class StackViewAdapter extends ArrayAdapter {
    private List<String> ListPenyimpanan_Var1;
    private Context Konteks_Var1;
    private int ItemLayout_Var1;

    public StackViewAdapter(List<String> ListPenyimpanan_Var2, int ItemLayout_Var2, Context Konteks_Var2) {
        super(Konteks_Var2, ItemLayout_Var2, ListPenyimpanan_Var2);
        ListPenyimpanan_Var1 = ListPenyimpanan_Var2;
        Konteks_Var1 = Konteks_Var2;
        ItemLayout_Var1 = ItemLayout_Var2;
    }

    @Override
    public int getCount() {
        return ListPenyimpanan_Var1.size();
    }

    @Nullable
    @Override
    public Object getItem(int Posisi) {
        return ListPenyimpanan_Var1.get(Posisi);
    }

    @NonNull
    @Override
    public View getView(int Posisi, @Nullable View Tampilan, @NonNull ViewGroup Induk) {
        if (Tampilan == null) {
            Tampilan = LayoutInflater.from(Induk.getContext()).inflate(ItemLayout_Var1, Induk, false);
        }

        String Penampungan = ListPenyimpanan_Var1.get(Posisi);

        TextView TV_1_IDJAVA = Tampilan.findViewById(R.id.TV_1_IDXML);
        ImageView IV_1_IDJAVA = Tampilan.findViewById(R.id.IV_1_IDXML);

        TV_1_IDJAVA.setText(Penampungan);

        int ID_Sumber = Konteks_Var1.getResources().getIdentifier(Penampungan, "drawable", Konteks_Var1.getPackageName());

        IV_1_IDJAVA.setImageResource(ID_Sumber);
        return Tampilan;
    }
}

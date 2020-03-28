package com.jugal.rest_a_sure;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class restaurant_list extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"MASTEE", "THEOBROMA", "Barbeque Nation ", "Biryani Barbeque Chinese", "Burger King", "McDonald's", "CAFÉ HYDRO", "Grandmama's All Day Cafe", "KAILASH PARBAT", "AROUND D’GLOBE", "BRAIN FREEZE ICE CREAM & DESERTS", "Bombay Kulfi", "The Messy House - Dessert Bar & Cafe", "The Chocolate Heaven", "Huber & Holly – Juhu Tara Road, Mumbai", "K Bhagat Tarachand", "90FT ABOVE",  "Girgaon Katta", "The Fusion Kitchen",  "Mehman Nawazi", "Maharaja Bhog", "Shreeji's The Fusion Kitchen", "PANGAT", "Banana Leaf Restaurant"};
    int[] cuisines_img = {R.drawable.mastee, R.drawable.theobroma, R.drawable.barbeque_nation, R.drawable.biryani_barbeque_chinese, R.drawable.burger_king, R.drawable.mcdonalds, R.drawable.cafe_hydro, R.drawable.grandmama_cafe, R.drawable.kailash_parbat, R.drawable.around_d_globe, R.drawable.brain_freeze, R.drawable.bombay_kulfi, R.drawable.the_messy_house, R.drawable.chocolate_heaven, R.drawable.huber_holly, R.drawable.k_bhagat_tarachand, R.drawable.w_90_ft_above, R.drawable.girgaon_katta, R.drawable.fusion_kitchen, R.drawable.mehman_nawazi, R.drawable.maharaja_bhog, R.drawable.shreeji_fusion_kitchen, R.drawable.pangat,R.drawable.banana_leaf};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        listView = findViewById(R.id.list_view);
        MyAdapter adapter = new MyAdapter(this,mTitle,cuisines_img);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        int rImgs[];
        MyAdapter (Context c, String title[],int imgs[])
        {
            super(c,R.layout.row,R.id.textView1,title);
            this.context=c;
            this.rTitle = title;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            return row;
        }
    }
}
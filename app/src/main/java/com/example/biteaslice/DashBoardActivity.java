package com.example.biteaslice;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biteaslice.DRVInterface.LoadMore;

import java.util.ArrayList;
import java.util.UUID;

public class DashBoardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaticRvAdapter staticRvAdapter;
    private ArrayList<StaticRvModelClass> item;
    private ArrayList<DynamicRvModelClass> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        recyclerView = findViewById(R.id.rv_1);
        item = new ArrayList<>();

        item.add(new StaticRvModelClass(R.drawable.ic_pizza, "Pizza"));
        item.add(new StaticRvModelClass(R.drawable.ic_pizza, "Burger"));
        item.add(new StaticRvModelClass(R.drawable.ic_pizza, "Noodles"));
        item.add(new StaticRvModelClass(R.drawable.ic_pizza, "Chicken"));
        item.add(new StaticRvModelClass(R.drawable.ic_pizza, "Fires"));
        item.add(new StaticRvModelClass(R.drawable.ic_pizza, "IceCream"));

        staticRvAdapter = new StaticRvAdapter(DashBoardActivity.this, item);
        staticRvAdapter.notifyDataSetChanged();

        LinearLayoutManager layoutManager = new LinearLayoutManager(DashBoardActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(staticRvAdapter);

        items = new ArrayList<>();

        items.add(new DynamicRvModelClass("Burger"));
        items.add(new DynamicRvModelClass("Burger"));
        items.add(new DynamicRvModelClass("Burger"));
        items.add(new DynamicRvModelClass("Burger"));
        items.add(new DynamicRvModelClass("Burger"));
        items.add(new DynamicRvModelClass("Burger"));
        items.add(new DynamicRvModelClass("Burger"));
        items.add(new DynamicRvModelClass("Burger"));
        items.add(new DynamicRvModelClass("Burger"));
        items.add(new DynamicRvModelClass("Burger"));
        items.add(new DynamicRvModelClass("Burger"));

        RecyclerView dynamicRv = findViewById(R.id.rv_2);
        dynamicRv.setLayoutManager(new LinearLayoutManager(this));
        DynamicRvAdapter dynamicRvAdapter = new DynamicRvAdapter(dynamicRv, DashBoardActivity.this, items);
        dynamicRvAdapter.notifyDataSetChanged();
        dynamicRv.setAdapter(dynamicRvAdapter);

        dynamicRvAdapter.setLoadMore(new LoadMore() {
            @Override
            public void onLoadMore() {

                if (items.size() <= 50) {
                    items.add(null);
                    dynamicRvAdapter.notifyItemInserted(items.size() - 1);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            items.remove(items.size() - 1);
                            dynamicRvAdapter.notifyItemRemoved(items.size());

                            int index = items.size();
                            int end = index + 10;

                            for (int i = index; i < end; i++) {
                                String name = UUID.randomUUID().toString();
                                DynamicRvModelClass item = new DynamicRvModelClass(name);
                                items.add(item);
                            }
                            dynamicRvAdapter.notifyDataSetChanged();
                            dynamicRvAdapter.setLoaded();
                        }
                    }, 4000);
                } else {
                    Toast.makeText(DashBoardActivity.this, "Data Completed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
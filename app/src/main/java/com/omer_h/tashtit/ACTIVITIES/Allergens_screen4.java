package com.omer_h.tashtit.ACTIVITIES;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.omer_h.model.Allergen;
import com.omer_h.model.Allergens;
import com.omer_h.tashtit.ADPTERS.AllergenAdapter;
import com.omer_h.tashtit.ADPTERS.BASE.GenericAdapter;
import com.omer_h.tashtit.ADPTERS.BASE.SwipeCallback;
import com.omer_h.tashtit.ADPTERS.BASE.SwipeConfig;
import com.omer_h.tashtit.R;
import com.omer_h.viewmodel.AllergenViewModel;

import java.util.ArrayList;
import java.util.List;

public class Allergens_screen4 extends AppCompatActivity {
    TextView textViewResult;
    SearchView searchView;
    Button Save;
    RecyclerView rvAllergens;
    RecyclerView rvSearch;
    // On create this will be the list of allergens from the Api and then will change by the search
    ArrayList<Allergen> allergenList = new ArrayList<>();//for the search
    ArrayList<Allergen> allergensUser = new ArrayList<>();//for the adapter of the recycler view of the allergen list
    AllergenAdapter adapterAllergens;
    AllergenAdapter adapterSearch;
    AllergenViewModel viewModel;
    String userIdFs="-1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_allergens_screen4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        makeApiRequest();
        setViewModel();
        initializeViews();
        setListeners();
        setRecyclerView();
        setSearchView();
        Intent intent = getIntent();
        if(intent.hasExtra("userIdFs"))//get the user id from the signUp activity
        {
            userIdFs = intent.getStringExtra("userIdFs");
        }
    }

    private void setViewModel() {//set the view model that get the allergens from the database and arange them into list and recyclerviews
        viewModel = new ViewModelProvider(this).get(AllergenViewModel.class);
        viewModel.getAll();
        viewModel.getLiveDataCollection().observe(this, new Observer<Allergens>() {
            @Override
            public void onChanged(Allergens allergens) {
                if(allergens!=null) {
                    allergenList = allergens.allergensByUserIdFs("0");
                    adapterSearch.setItems(allergenList);
                    adapterSearch.notifyDataSetChanged();
                    allergensUser = allergens.allergensByUserIdFs(userIdFs);
                    adapterAllergens.setItems(allergensUser);
                    adapterAllergens.notifyDataSetChanged();
                }
            }
        });
    }

    private void setRecyclerView() {
        adapterAllergens = new AllergenAdapter(null, R.layout.allergen_simple_item,
            //starts the recyclerView of the users allergens
                holder -> {
                holder.putView("txtName", holder.itemView.findViewById(R.id.tvName));
            },
                    ((holder, item, position) -> {
                        // Bind data to ViewHolder - this runs for every item
                        ((TextView)holder.getView("txtName")).setText(item.getName());
                    }));
        rvAllergens.setAdapter(adapterAllergens);
        rvAllergens.setLayoutManager(new LinearLayoutManager(this));
        adapterAllergens.setOnItemSwipeListener(new GenericAdapter.OnItemSwipeListener<Allergen>() {
            @Override
            public void onItemSwipeRight(Allergen item, int position) {

            }

            @Override
            public void onItemSwipeLeft(Allergen item, int position) {

                viewModel.delete(item);
            }
        });
        SwipeCallback<Allergen> swipeCallback=new SwipeCallback<>(adapterAllergens,this,new SwipeConfig(), ItemTouchHelper.LEFT
        );
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(swipeCallback);
        itemTouchHelper.attachToRecyclerView(rvAllergens);


        adapterSearch = new AllergenAdapter(null, R.layout.allergen_simple_item, holder -> {                holder.putView("txtName", holder.itemView.findViewById(R.id.tvName));
        //starts the recyclerView of the search bar
            },
                ((holder, item, position) -> {
                    // Bind data to ViewHolder - this runs for every item
                    ((TextView)holder.getView("txtName")).setText(item.getName());
                }));
        rvSearch.setAdapter(adapterSearch);
        rvSearch.setLayoutManager(new LinearLayoutManager(this));
        adapterSearch.setOnItemClickListener(new GenericAdapter.OnItemClickListener<Allergen>() {
            @Override
            public void onItemClick(Allergen item, int position)
            {
                Allergen newAllergen = new Allergen(item.getName(), userIdFs);
                // קוד לביצוע בלחיצה על פריט ברשימה
                if(!allergensUser.contains(newAllergen)) {
                    viewModel.add(newAllergen);
                }
                else
                    Toast.makeText(Allergens_screen4.this, "This allergen already exists", Toast.LENGTH_SHORT).show();
                //reset allergenList to the static list
                searchView.setQuery("", false); // Clear the text without submitting
                searchView.clearFocus();//clears keyboard
            }
        });


    }

    private void initializeViews() {
        textViewResult = findViewById(R.id.textViewResult);
        searchView = findViewById(R.id.searchView);
        Save = findViewById(R.id.btnSave);
        rvAllergens = findViewById(R.id.rvAllergens);
        rvSearch= findViewById(R.id.rvSearch);
    }
    public void setSearchView()
    {//set the search bar to filter the list of allergens from the database according to the users input
        searchView.clearFocus();
        filterList("");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String text) {
        List<Allergen> filteredList = new ArrayList<>();
        for(Allergen allergen : allergenList)
        {
            if(allergen.getName().toLowerCase().contains(text.toLowerCase()))
            {
                filteredList.add(allergen);
            }
        }
        if(filteredList.isEmpty())
        {
            if(text.isEmpty()&&allergenList!=null)
            {
                //add here the list of allergens from the api
                adapterSearch.setItems(allergenList);
            }
            else
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else
        {
            adapterSearch.setItems(filteredList);
        }
    }

    private void setListeners() {
        Save.setOnClickListener(v -> {
            Intent intent = new Intent(Allergens_screen4.this, signUp_screen_3.class);
            intent.putExtra("Allergens", allergensUser);
            startActivity(intent);
        });
    }

    private void makeApiRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.fda.gov/drug/drugsfda.json?limit=1";// finish api call
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        textViewResult.setText("Response is: " + response.substring(0,500));
                    }
                },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textViewResult.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
    private void showAlertDialog(Allergen allergen) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set the dialog title and message
        builder.setTitle("Delete Allergen");
        builder.setMessage("Are you sure you want to delete "+allergen.getName()+" from your allergen list?");
        builder.setIcon(R.drawable.ic_trash);
        // Add a positive button and its action
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Action when OK button is clicked
                Toast.makeText(getApplicationContext(), "Allergen deleted", Toast.LENGTH_SHORT).show();
                viewModel.delete(allergen);
                dialog.dismiss();
            }
        });

        // Add a negative button and its action (optional)
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Action when Cancel button is clicked
                dialog.dismiss();
            }
        });

        // Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
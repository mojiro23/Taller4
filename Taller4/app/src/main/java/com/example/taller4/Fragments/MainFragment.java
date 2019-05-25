package com.example.taller4.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.taller4.Adapters.PersonaAdapter;
import com.example.taller4.Models.Persona;
import com.example.taller4.R;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        setupUI(view);

        return view;

    }


    public void setupUI( final View view){

        FirstList(view);

        Button btnDatos = (Button) view.findViewById(R.id.btnllenardatos);
        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

                LlenadatosFragment fragment2 = new LlenadatosFragment();
                ft.replace(android.R.id.content, fragment2);
                ft.addToBackStack(null); //Add fragment in back stack
                ft.commit();

            //SecondList(view);
            }
        });

       SecondList(view);

    }

    private void FirstList(View view){
        ArrayList<String> mItems = new ArrayList<String>();

        for (int i = 1; i <= 10; i++){
            mItems.add("Item : " + i);
        }

        int layoutId = android.R.layout.simple_list_item_1;
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>( getContext(), layoutId, mItems);
        ListView mListView = (ListView) view.findViewById(R.id.listfragment);
        mListView.setAdapter(mAdapter);
    }

   public void SecondList( View view){

      Bundle bundle = getArguments();

      if (bundle!=null){
          Persona obj= (Persona) bundle.getSerializable("Datos");
          if (obj!=null){
              ArrayList<Persona> mItems = new ArrayList<Persona>();
              PersonaAdapter adapter = new PersonaAdapter(getContext(), R.layout.list_element_pesona,mItems);
              Persona newUser = new Persona(obj.getName().toString(), obj.getLastname().toString(), obj.getEmail().toString(),obj.getPhonenumber().toString());
              adapter.addAll(newUser);
              ListView listView = (ListView) view.findViewById(R.id.listview2);
              listView.setAdapter(adapter);
          }
       }

    }



}

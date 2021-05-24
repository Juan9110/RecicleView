package com.juan.recicleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PalabrasAdapter extends RecyclerView.Adapter<PalabrasAdapter.PalabraHolder>{
    private final ArrayList<String> ListaPalabras;
    private Context context;
    private LayoutInflater inflater;

    public PalabrasAdapter(ArrayList<String>ListaPalabra, Context context) {
        this.ListaPalabras = ListaPalabra;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public PalabraHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View item = inflater.inflate(R.layout.palabras_item, parent, false);//METODO QUE SE LLAMA CADA VEZ RENDERIZA UN ITEM
        return new PalabraHolder(item);
    }


    @Override
    public void onBindViewHolder(@NonNull PalabraHolder holder, int position) {
        String palabra = ListaPalabras.get(position); //ESTE METODO SE ACTUALIZAN LOS DATOS DEL ITEM
        holder.txtPalabra.setText(palabra);
    }

    @Override
    public int getItemCount() {
        return ListaPalabras.size(); //DEVUELVE EL TAMAÑO  DE LA LISTA
    }


    class PalabraHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtPalabra;
        public PalabraHolder( View itemView) {
            super(itemView);
            txtPalabra = itemView.findViewById(R.id.txtPalabra);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int posision = getLayoutPosition();
            String palabra = ListaPalabras.get(posision);
            ListaPalabras.set(posision, "Seleccionado " + palabra);
             PalabrasAdapter.this.notifyDataSetChanged();

        }
    }
}

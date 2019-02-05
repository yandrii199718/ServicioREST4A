package edu.uoc.android.restservice.ui.enter;

import android.app.Application;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

import java.util.ArrayList;
import java.util.List;

import edu.uoc.android.restservice.R;
import edu.uoc.android.restservice.rest.model.Followers;
import edu.uoc.android.restservice.rest.model.Owner;

/**
 * Created by edgardopanchana on 4/29/18.
 */

public class AdaptadorFollowers extends RecyclerView.Adapter<AdaptadorFollowers.ViewHolderFollowers> {
    // Generampos Lista de tipo Followers
    List<Followers> listaFollowers;
    Context context;

    public AdaptadorFollowers(List<Followers> listaFollowers) { // Linea de Codigo para agregar Metodo constructor que asigna los datos obtenidos a una variable
        this.listaFollowers = listaFollowers;
    }

    @NonNull
    @Override
    public ViewHolderFollowers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        context = parent.getContext(); // Linea de codigo para obtener el contexto de la aplicación
        return new ViewHolderFollowers(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFollowers holder, int position) {
        holder.etiNombre.setText(listaFollowers.get(position).getLogin());  // Codigo para el envío de nombre de seguidor a TextView
        Picasso.get().load(listaFollowers.get(position).getAvatarUrl()).into(holder.imagen); //Codigo para el envío de imagen de seguidor a ImageView
    }

    @Override
    public int getItemCount() {
        return listaFollowers.size();
    }

    public class ViewHolderFollowers extends RecyclerView.ViewHolder {
        // variable para obtener ImageView
        TextView etiNombre;
        ImageView imagen;

        public ViewHolderFollowers(View itemView) {
            super(itemView);

            etiNombre = (TextView) itemView.findViewById(R.id.textViewLista);
            // Imageview almacenada en variiable
            imagen = (ImageView) itemView.findViewById(R.id.imageViewLista);

        }
    }
}

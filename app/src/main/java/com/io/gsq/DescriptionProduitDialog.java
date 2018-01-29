package com.io.gsq;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Hp on 24-Jan-18.
 */

public class DescriptionProduitDialog extends AppCompatDialogFragment {
    private TextView nomProduit;
    private TextView prixProduit;
    private TextView quantiteProduit;
    private TextView detailProduit;

    ProductDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.description_dialog,null);
        builder.setView(view)
                .setTitle("Adding product")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("enregistre", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String produit=nomProduit.getText().toString();
                        String prix=prixProduit.getText().toString();
                        String quantite=quantiteProduit.getText().toString();
                        String detail=detailProduit.getText().toString();
                        listener.applyProdactDetail(produit,prix,quantite,detail);

                    }
                });

        nomProduit=view.findViewById(R.id.nom_produit_dialog);
        prixProduit=view.findViewById(R.id.price_dialog);
        quantiteProduit=view.findViewById(R.id.quantite_dialog);
        detailProduit=view.findViewById(R.id.detail_dialog);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener=(ProductDialogListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+" must implement ProductDialogListener");
        }
    }

    public interface ProductDialogListener{
        void applyProdactDetail(String produit,String prix,String quantite, String detail);
    }
}

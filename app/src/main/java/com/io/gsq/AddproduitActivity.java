package com.io.gsq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddproduitActivity extends AppCompatActivity implements DescriptionProduitDialog.ProductDialogListener {

    private TextView nomProduit;
    private TextView prixProduit;
    private TextView quantiteProduit;
    private TextView detailProduit;
    private Button modifierProduit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproduit);

        nomProduit=(TextView)findViewById(R.id.nom_produit);
        prixProduit=(TextView)findViewById(R.id.prix_intiale);
        quantiteProduit=(TextView)findViewById(R.id.quantite_disponible);
        detailProduit=(TextView)findViewById(R.id.detail);
        modifierProduit=(Button) findViewById(R.id.modifier_produit);
        modifierProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void openDialog() {
        DescriptionProduitDialog produitDialog=new DescriptionProduitDialog();
        produitDialog.show(getSupportFragmentManager(),"product Dialog");
    }

    @Override
    public void applyProdactDetail(String produit, String prix, String quantite, String detail) {
        nomProduit.setText(produit);
        prixProduit.setText(prix);
        quantiteProduit.setText(quantite);
        detailProduit.setText(detail );
    }
}

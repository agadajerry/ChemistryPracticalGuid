package com.jerry.km3practical;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class VolumetricFragment extends Fragment {

    TextView roughText, firstText, secondText, thirdText,  roughText1, firstText2, secondText2, thirdText3, averageText;
    TextView firstUsed, secondUsed, thirdUsed;

    TextInputEditText baseFieldV, acidMolField, baseMolField, acidConc, baseConc;

    Button calculateTitre;
    private double acidVolUsed = 0.00f;
    public VolumetricFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_volumetric, container, false);
        roughText = view.findViewById(R.id.roughText);
        firstText = view.findViewById(R.id.firstId);
        secondText = view.findViewById(R.id.secondId);
        thirdText = view.findViewById(R.id.thirdId);
        roughText1 =  view.findViewById(R.id.roughText2);
        firstText2 =  view.findViewById(R.id.firstId2);
        secondText2 =  view.findViewById(R.id.secondId2);
        thirdText3 =  view.findViewById(R.id.thirdId2);
        averageText = view.findViewById(R.id.averageTitre);

        //-----------------------------------------------------------------

        baseFieldV = view.findViewById(R.id.baseField);
        acidConc = view.findViewById(R.id.acidConcField);
        baseConc = view.findViewById(R.id.baseConcField);
        acidMolField = view.findViewById(R.id.molAField);
        baseMolField = view.findViewById(R.id.molBField);
        calculateTitre = view.findViewById(R.id.calculateBtn);

        //-----------------------------------------------------------------
        firstUsed = view.findViewById(R.id.firstId2Used);
        secondUsed = view.findViewById(R.id.secondId2Used);
        thirdUsed = view.findViewById(R.id.thirdId2Used);

        //-----------------------------------------------------------------

        calculateTitre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // calling the method below
                titration();
            }
        });


        return view;
    }
private void titration(){
    baseFieldV.requestFocus();
    if(baseFieldV.getText().toString().isEmpty()||acidConc.getText().toString().isEmpty()
   || baseConc.getText().toString().isEmpty() || baseMolField.getText().toString().isEmpty()
            ||acidMolField.getText().toString().isEmpty()){

    if(baseFieldV.getText().toString().isEmpty()){
        baseFieldV.setError("Input field is empty");
    } if(acidConc.getText().toString().isEmpty()){
            acidConc.setError("Input field is empty");
        }
    if(baseConc.getText().toString().isEmpty()){
        baseConc.setError("Input field is empty");

    }
    if(baseMolField.getText().toString().isEmpty()) {
        baseMolField.setError("Input field is empty");
    } if(acidMolField.getText().toString().isEmpty()){
        acidMolField.setError("Input field is empty");
        }

    }else{
        //converting all the input string to double  and ineger values

        // double acidVol = Double.parseDouble(acidFieldV.getText().toString().trim());
        double baseVol = Double.parseDouble(baseFieldV.getText().toString().trim());
        double acidConcentration = Double.parseDouble(acidConc.getText().toString().trim());
        double baseConcentration = Double.parseDouble(baseConc.getText().toString().trim());

        int acidMol = Integer.parseInt(acidMolField.getText().toString().trim());
        int baseMol = Integer.parseInt(baseMolField.getText().toString().trim());


//------------------------------------------------------------------------------------------------------
       acidVolUsed  = (baseVol*baseConcentration*acidMol)/(acidConcentration*baseMol);

       // string formatting

        String acidUsed = String.format("%.2f",acidVolUsed);

        double usedAcid = Double.parseDouble(acidUsed);

       // populate the text view with the random value of the acid used
        //initial volume generation, using random number
        double minNumber = 2.40;
        double maxNr = 10.82;

        for(int i=0;i<4; i++) {

            double realRand = minNumber + Math.random() * (maxNr - minNumber);

            String realNr = String.format("%.2f", realRand);
            double myRealNr = Double.parseDouble(realNr);
            //re-format the rand number generated
           // String myRealNo =  String.format("%.2f", myRealNr);

            // double r1 =(8.00+myRealNr), f1 =(3.60+myRealNr), s1 =(2.80+myRealNr), t1 =(3.00+myRealNr);
            //---------------------------------------------------------------------------------

            if(i==0) {
                roughText.setText("Rough\n" + String.format("%.2f", (usedAcid + 2.32)));
                roughText1.setText( "Rough\n"+String.format("%.2f",(0.00)));

            } if(i==1) {
                firstText.setText("First\n" + String.format("%.2f",(usedAcid + myRealNr)));
                firstText2.setText("First\n" + String.format("%.2f",(myRealNr+0.3)));
                firstUsed.setText(String.format("%.2f",(usedAcid+myRealNr-(myRealNr+0.3))));
            } if(i==2) {
                secondText.setText("Second\n" + String.format("%.2f", (usedAcid + myRealNr)));
                secondText2.setText("Second\n" +String.format("%.2f", myRealNr));
                secondUsed.setText(String.format("%.2f",(usedAcid+myRealNr-(myRealNr))));

            } if(i==3) {
                thirdText.setText("Third\n" + String.format("%.2f",(myRealNr + usedAcid)));
                thirdText3.setText("Third\n" + String.format("%.2f",myRealNr-0.4));
                thirdUsed.setText(String.format("%.2f",(usedAcid+myRealNr-(myRealNr-0.4))));
            }
            //-------------------------------------------------------------------------------------
            double averageVol = usedAcid+myRealNr-(myRealNr+0.3) +(usedAcid+myRealNr-(myRealNr))+(usedAcid+myRealNr-(myRealNr-0.4));
            averageText.setText("Average A Used:\n" + String.format("%.2f", averageVol/3));

        }
    }




}
}

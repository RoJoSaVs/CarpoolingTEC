//Codigo tomado de: https://www.youtube.com/watch?v=_wy7AvQAIrE&t=8s
package tec.datos1.studentapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    EditText etCodigo;
    Button btnEscaner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCodigo = findViewById(R.id.etCodigo);
        btnEscaner = findViewById(R.id.btnEscaner);

        //Accion para el boton de escaner
        btnEscaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escaner();
            }
        });
    }


    public void maps(View view){
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }

    //Metodo para escanear
    public void escaner() {
        IntentIntegrator intent = new IntentIntegrator(this);
        intent.setDesiredBarcodeFormats(IntentIntegrator.PRODUCT_CODE_TYPES);

        intent.setPrompt("ESCANEAR CODIGO");
        intent.setCameraId(0);
        intent.setBeepEnabled(false);
        intent.setBarcodeImageEnabled(false);
        intent.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(result != null){
            if (result.getContents() == null){
                Toast.makeText(this, "Cancelaste el escaneo", Toast.LENGTH_LONG).show();
            }else{
                etCodigo.setText(result.getContents().toString());
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}

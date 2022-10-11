
package com.example.NILUHNIADEVIF55121058;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtWidth;
    private EditText edtheight;
    private EditText edtLength;
    private Button btnCalculate;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.edt_width);
        edtheight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_length);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String inputLength =
                    edtLength.getText() .toString() .trim();
            String inputwidth =
                    edtWidth.getText() .toString() .trim();
            String inputheight =
                    edtheight.getText().toString().trim();


            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                edtLength.setError("Field ini tidak boleh Kosong");
            }

            if (TextUtils.isEmpty(inputwidth)) {
                isEmptyFields = true;
                edtWidth.setError("Field ini tidak boleh Kosong");
            }

            if (TextUtils.isEmpty(inputheight)){
                isEmptyFields = true;
                edtheight.setError("Field ini tidak boleh Kosong");
            }
            if (!isEmptyFields) {
                Double volume = Double.parseDouble(inputLength) *
                        Double.parseDouble(inputwidth) * Double.parseDouble(inputheight);
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState (outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }
}
package br.edu.ifsp.ads.pdm.ciclopdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import br.edu.ifsp.ads.pdm.ciclopdm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    companion object {
        val CICLO_PDM_TAG = "CICLO_PDM"
        val SOBRENOME = "SOBRENOME"
    }

    private lateinit var sobrenomeEt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(activityMainBinding.root)

        sobrenomeEt = EditText(this)
        sobrenomeEt.width = LinearLayout.LayoutParams.MATCH_PARENT
        sobrenomeEt.inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
        sobrenomeEt.height = LinearLayout.LayoutParams.WRAP_CONTENT
        activityMainBinding.root.addView(sobrenomeEt)

        if (savedInstanceState != null) {
            sobrenomeEt.setText(savedInstanceState.getString(SOBRENOME, ""))
        }

        Log.v(CICLO_PDM_TAG, "onCreate: Iniciando o ciclo de vida COMPLETO")
    }

    override fun onStart() {
        super.onStart()
        Log.v(CICLO_PDM_TAG, "onStart: Iniciando o ciclo de vida VISÍVEL")
    }

    override fun onResume() {
        super.onResume()
        Log.v(CICLO_PDM_TAG, "onResume: Iniciando o ciclo de vida em PRIMEIRO PLANO")
    }

    override fun onPause() {
        super.onPause()
        Log.v(CICLO_PDM_TAG, "onPause: Finalizando o ciclo de vida em PRIMEIRO PLANO")
    }

    override fun onStop() {
        super.onStop()
        Log.v(CICLO_PDM_TAG, "onStop: Finalizando o ciclo de vida VISÍVEL")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(CICLO_PDM_TAG, "onDestroy: Finalizando o ciclo de vida COMPLETO")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(CICLO_PDM_TAG, "onRestart: Preparando a execução do onStart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(SOBRENOME, sobrenomeEt.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
//        sobrenomeEt.setText("Restaurado: ${savedInstanceState.getString(SOBRENOME, "")}")
    }
}
package mx.edu.tecmm.moviles.spinner_05

import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import java.text.FieldPosition
import java.text.ParsePosition

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener{
    //Usamos una herencia, mire la línea 9 :3
    var lenguaje= arrayOf("JAVA", "RUBY", "PHP", "SWIFT","C#", "JAVASCRIPT", "PYTHON", "VISUAL BASIC");
    lateinit var spLenguaje :Spinner
    lateinit var txtOpcionSeleccionada: TextView
    lateinit var txtCaracteristicas: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Inicialización
        spLenguaje= findViewById(R.id.spLenguaje);
        txtOpcionSeleccionada= findViewById(R.id.txtOpcion);
        txtCaracteristicas= findViewById(R.id.txtCaracteristicas)
        //
        spLenguaje.onItemSelectedListener= this //Hace que los dos métodos siguientes actuen cuando tenga cambios este componente
        val adaptador= ArrayAdapter(this, android.R.layout.simple_spinner_item, lenguaje);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item)
        //Lo aignamos a nuestro texto
        spLenguaje.adapter= adaptador; //Con esto tenemos trabajando nuestro spinner
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {//Regresa el adaptador en caso de querer tomarlo, segundo va a regresar la vista (petición),y petición
       //Se quita el T0D0, es una llamada a una exepción
        var valor: String = lenguaje[position];
        txtOpcionSeleccionada.text= valor
        if (valor.equals("PHP")){
            txtCaracteristicas.text="Permite desarrollar aplicaciones del lado del servidor, garantizando una excelente comunicación con la web."
        }else if (valor.equals("SWIFT")){
            txtCaracteristicas.text="Lenguaje multiparadigma de Apple fue creado para desarrollar" +
                    " aplicaciones para iOS y macOS, con una sintaxis simple y concisa."
        }else if (valor.equals("C#")){
            txtCaracteristicas.text="Lenguaje de programación muy versátil, creado por Microsoft, con características similares al Lenguaje C, pero orientado a objetos." +
                    " Es muy usado en la industria de los juegos, robótica, impresión 3D, internet de las cosas y desarrollo de aplicaciones web y móviles. ";
        }else if (valor.equals("JAVA")){
            txtCaracteristicas.text="Lenguaje orientado a objetos que funciona independientemente de la plataforma de hardware," +
                    " el código escrito en una máquina corre en otra, sin problemas, el código Java funciona gracias a la Máquina Virtual Java o JVM.";
        }else if (valor.equals("RUBY")){
            txtCaracteristicas.text="Lenguaje de alto nivel, multiparadigma y multipropósito, se enfoca en la productividad. Esa sencillez que le caracteriza hace que sea uno de los lenguajes ideales para comenzar a aprender programación" +
                    "También emplea un lenguaje muy cercano al inglés y es open source.";
        }else if (valor.equals("JAVASCRIPT")){
            txtCaracteristicas.text="JavaScript es un lenguaje de programación que se utiliza principalmente para crear páginas web dinámicas. " +
                    "Permite a los programadores implementar funciones complejas en las páginas web para añadirles  más interactividad.";
        }else if (valor.equals("PYTHON")){
            txtCaracteristicas.text="Lenguaje usado para proyectos de inteligencia artificial o para desarrollar aplicaciones de big data. " +
                    "Su éxito radica en varios factores, principalmente en que ofrece código abierto y es un lenguaje versátil y sencillo.";
        }else if (valor.equals("VISUAL BASIC")){
            txtCaracteristicas.text="Visual Basic es un lenguaje de programación orientado a objetos desarrollado por Microsoft. " +
                    "El uso de Visual Basic agiliza y simplifica la creación de aplicaciones .NET con seguridad de tipos. " +
                    "Te da la opción de automatizar tus propios procesos y crear tus propias aplicaciones web, especialmente de bases de datos.";
        }


    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}
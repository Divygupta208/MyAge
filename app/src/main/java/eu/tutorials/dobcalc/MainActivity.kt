package eu.tutorials.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate : TextView? = null
    private var ageInMinutes : TextView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
          tvSelectedDate = findViewById(R.id.tvSelectedDate)
          ageInMinutes = findViewById(R.id.ageInMinutes)
        btnDatePicker.setOnClickListener {

           clickDatePicker()
        }


    }

    private fun clickDatePicker(){


    val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

         DatePickerDialog(
             this , DatePickerDialog.OnDateSetListener
                 { view , year , month , dayOfMonth ->
                     Toast.makeText(this , "Clicked :)" , Toast.LENGTH_LONG).show()

                val selelctedDate = "$dayOfMonth/${month+1}/$year"
                     tvSelectedDate?.text = selelctedDate

                     val sdf = SimpleDateFormat("dd/MM/yyyy" , Locale.ENGLISH)

                     val theDate = sdf.parse(selelctedDate)
                     theDate?.let {
                         val selectedDateInMinutes = theDate.time/60000


                         val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                         currentDate?.let {
                             val currentInMinutes = currentDate.time/60000

                             val differenceInMinutes = (currentInMinutes-selectedDateInMinutes)

                             ageInMinutes?.text=differenceInMinutes.toString()
                         }

                     }

                 },
                 year ,
                 month ,
                 day).show()

             }

    }

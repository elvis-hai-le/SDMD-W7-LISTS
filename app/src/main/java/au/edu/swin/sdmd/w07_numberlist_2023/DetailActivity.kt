package au.edu.swin.sdmd.w07_numberlist_2023

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val number = intent.getIntExtra("NUMBER", 0)
        val showFact = findViewById<TextView>(R.id.numberFact)
        showFact.text = if (number % 4 == 0) "$number is a multiple of 4" else "$number is not a multiple of 4"
    }
}
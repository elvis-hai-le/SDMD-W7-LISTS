package au.edu.swin.sdmd.w07_numberlist_2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var data = IntArray(100) { it }.filter { it % 3 == 0 || it % 5 == 0}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        return when (item.itemId) {
            R.id.multi3 -> {
                data = IntArray(100) { it }.filter { it % 3 == 0 }
                updateList()
                true
            }
            R.id.multi5 -> {
                data = IntArray(100) { it }.filter { it % 5 == 0 }
                updateList()
                true
            }
            R.id.resetMenu -> {
                data = IntArray(100) { it }.filter { it % 3 == 0 || it % 5 == 0}
                updateList()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateList() {
        val numberList = findViewById<RecyclerView>(R.id.numberList)

        numberList.adapter = NumberAdapter(data) { showDetail(it)}
        numberList.layoutManager = LinearLayoutManager(this)
    }

    private fun showDetail(item: Int) {
        val i = Intent(this, DetailActivity::class.java)
        i.putExtra("NUMBER", item)
        startActivity(i)
    }


}
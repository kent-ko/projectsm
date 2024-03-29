package com.job.istation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.job.istation.commoners.Tools
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    fun toSaleActivity(v: View){
        startActivity(SalesActivity.newIntent(this))
    }

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()
    }

    private fun initToolbar() {

        setSupportActionBar(toolbar)
        Tools.setSystemBarColor(this, R.color.purple_A700)
        Tools.setSystemBarLight(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        Tools.changeMenuIconColor(menu, resources.getColor(R.color.grey_60))
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === android.R.id.home) {
            finish()
        } else {
           // Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
            startActivity(LoginActivity.newIntent(this))
        }
        return super.onOptionsItemSelected(item)
    }

    fun toProfile(v: View){
        startActivity(ProfileActivity.newIntent(this))
    }

    fun toStuff(v:View){
        startActivity(StuffActivity.newIntent(this))
    }


    fun toTrans(v:View){
        Snackbar.make(
            findViewById(android.R.id.content)!!,
            "Hold up! No transactions generated yet",
            Snackbar.LENGTH_SHORT
        ).show()
    }

    fun toBills(v:View){
        Snackbar.make(
            findViewById(android.R.id.content)!!,
            "Hold up! No Bills incurred yet",
            Snackbar.LENGTH_SHORT
        ).show()
    }

    fun toInvoices(v:View){
        Snackbar.make(
            findViewById(android.R.id.content)!!,
            "Hold up! No Invoices available yet",
            Snackbar.LENGTH_SHORT
        ).show()
    }

    fun toData(v:View){
        startActivity(EnterDataActivity.newIntent(this))
    }
}

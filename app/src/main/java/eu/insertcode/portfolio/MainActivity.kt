package eu.insertcode.portfolio

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import eu.insertcode.portfolio.comms.GetDataAsync

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        intent = Intent(this, ProjectsActivity::class.java)
//        startActivity(intent)

    }

    override fun onStart() {
        super.onStart()

        if (isNetworkConnected()) {
            GetDataAsync(this).execute(resources.getString(R.string.url_getData))
        } else {
            AlertDialog.Builder(this)
                    .setTitle("No Internet Connection")
                    .setMessage("Please check your internet connection and try again.")
                    .setPositiveButton(android.R.string.ok) { dialog, which -> }
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show()
        }
    }


    private fun isNetworkConnected(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}

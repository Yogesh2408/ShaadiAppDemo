package yogesh.com.shaadiassignment.Activity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import yogesh.com.shaadiassignment.Adapter.RecyclerItemClickListener
import yogesh.com.shaadiassignment.Adapter.UserRecyclerViewAdapter
import yogesh.com.shaadiassignment.R
import yogesh.com.shaadiassignment.Utils


class MainActivity : AppCompatActivity(), RecyclerItemClickListener {

    private lateinit var mProgressBar: ProgressBar
    private lateinit var mRecyclerViewAdapter: UserRecyclerViewAdapter
    lateinit var countryRecyclerView: RecyclerView
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countryRecyclerView = findViewById(R.id.countryRecyclerView)
        mProgressBar = findViewById(R.id.progressBar)
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        setUpRecyclerView()

        if (Utils.isNetworkConnected(this)) {
            mainActivityViewModel.getUsersFromAPIAndStore()
        } else {
            Toast.makeText(this, "No internet found. Showing cached list in the view", Toast.LENGTH_LONG).show()
        }

        observableData("")
    }

    fun setUpRecyclerView() {
        mRecyclerViewAdapter = UserRecyclerViewAdapter(this, this)
        countryRecyclerView.adapter = mRecyclerViewAdapter
        countryRecyclerView.layoutManager = LinearLayoutManager(this)
        countryRecyclerView.setHasFixedSize(true)
    }

    private fun observableData(string: String) {
        mainActivityViewModel.getUserData(string).observe(this, Observer { countryList ->
            Log.e(MainActivity::class.java.simpleName, countryList.toString())
            mRecyclerViewAdapter.setUserList(countryList)
            mProgressBar.visibility = View.GONE
        })
    }

    override fun onItemClickListener(position: Int, emailId: String, string: String) {
        Toast.makeText(this, "Member $string", Toast.LENGTH_LONG).show()
        mainActivityViewModel.updateUserData(emailId, string);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var stringValue = ""
        when (item!!.itemId) {
            R.id.decline -> {
                stringValue = getString(R.string.declined)
            }
            R.id.accept -> {
                stringValue = getString(R.string.accepted)
            }
        }

        observableData(stringValue)
        return super.onOptionsItemSelected(item)
    }

}

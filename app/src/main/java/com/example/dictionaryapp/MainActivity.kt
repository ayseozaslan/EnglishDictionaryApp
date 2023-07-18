package com.example.dictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionaryapp.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() ,SearchView.OnQueryTextListener {
    private lateinit var binding:ActivityMainBinding

    private lateinit var wordList:ArrayList<Words>
    private lateinit var adapter: WordsAdapter
    private lateinit var vt:DatabaseAssistance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        CopyDatabase()

        binding.toolbar.title="Dictionary App"
        setSupportActionBar(binding.toolbar)

        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager=LinearLayoutManager(this)

       vt= DatabaseAssistance(this)
        wordList=WordsDao().allWords(vt)

        adapter= WordsAdapter(this,wordList)
        binding.rv.adapter=adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        val item=menu?.findItem(R.id.action_ara)
        val searchView=item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)



        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        call(query.toString())
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        call(newText.toString())
        return true
    }

    fun CopyDatabase(){

        val db=DatabaseCopyHelper(this)
        try {
            db.createDataBase()
            db.openDataBase()

        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    fun call(searchedWord:String){
        wordList=WordsDao().makeACall(vt,searchedWord)
        adapter=WordsAdapter(this,wordList)
        binding.rv.adapter=adapter

    }
}

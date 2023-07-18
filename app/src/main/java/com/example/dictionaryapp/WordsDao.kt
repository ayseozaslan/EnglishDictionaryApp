package com.example.dictionaryapp

class WordsDao {

    fun allWords(vt:DatabaseAssistance) :ArrayList<Words>{
        val words=ArrayList<Words>()
        val db=vt.writableDatabase
        val cursor=db.rawQuery("SELECT * FROM words",null)

        while (cursor.moveToNext()){
            val word=Words(cursor.getInt(cursor.getColumnIndex("word_id"))
            ,cursor.getString(cursor.getColumnIndex("englısh"))
            ,cursor.getString(cursor.getColumnIndex("turkısh")))

            words.add(word)
        }
        return words
    }

    fun makeACall(vt:DatabaseAssistance,call:String) :ArrayList<Words>{
        val words=ArrayList<Words>()
        val db=vt.writableDatabase
        val cursor=db.rawQuery("SELECT * FROM words WHERE englısh like '%$call%'",null)

        while (cursor.moveToNext()){
            val word=Words(cursor.getInt(cursor.getColumnIndex("word_id"))
                ,cursor.getString(cursor.getColumnIndex("englısh"))
                ,cursor.getString(cursor.getColumnIndex("turkısh")))

            words.add(word)
        }
        return words
    }
}
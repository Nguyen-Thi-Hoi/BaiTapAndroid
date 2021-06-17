package vn.udn.vku.nhhai.uedn4l11_sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
val DATABASE_NAME = "UserDB"
val TABLE_NAME = "User"
val COL_ID = "id"
val COL_NAME = "name"
val COL_YEAR = "birthYear"
class DatabaseHandler(context: Context)
    : SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " VARCHAR(256), " +
                COL_YEAR + " INTEGER)";
        db?.execSQL(createTableQuery)
    }
    fun insertData(user: User){
        val db = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put(COL_NAME,user.name)
        contentValues.put(COL_YEAR,user.birthYear)
        db.insert(TABLE_NAME,null,contentValues)
        db.close()
    }
    fun readData(): ArrayList<User>{
        var users = ArrayList<User>()
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                val user = User()
                user.name = result.getString(result.getColumnIndex(COL_NAME))
                user.birthYear = result.getInt(result.getColumnIndex(COL_YEAR))
                users.add(user)
            }
            while (result.moveToNext())
        }
        db.close()
        return users
    }
    fun updateData(){
        val db = this.writableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var contentValue = ContentValues()
                contentValue.put(COL_YEAR,result.getInt(result.getColumnIndex(COL_YEAR))+1)
                db.update(TABLE_NAME,contentValue, "$COL_ID = ?",
                    arrayOf(result.getString(result.getColumnIndex(COL_ID))))
            }
            while (result.moveToNext())
        }
        db.close()
    }
    fun deleteData(username: String){
        val db = this.writableDatabase
        db.delete(TABLE_NAME,"$COL_NAME = ?", arrayOf(username))
        db.close()
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}
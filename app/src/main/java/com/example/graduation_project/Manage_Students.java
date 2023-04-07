package com.example.graduation_project;

import android.Manifest;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.ByteArrayOutputStream;

public class Manage_Students extends AppCompatActivity {
private EditText EditTextFileName;
private EditText StudentName;
private EditText StudentID;
private EditText CourseID;
private EditText CourseName;
private ImageView ImageView;
private DataBase dataBase;
private SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_students);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE},PackageManager.PERMISSION_GRANTED);


        EditTextFileName=findViewById(R.id.EditTextFileName);
        StudentName=findViewById(R.id.StudentName);
        StudentID=findViewById(R.id.StudentID);
        CourseID=findViewById(R.id.CourseID);
        CourseName=findViewById(R.id.CourseName);
        ImageView=findViewById(R.id.ImageView);

        dataBase=new DataBase(this,"Manage_Students",null,1);
        sqLiteDatabase= dataBase.getWritableDatabase();
        sqLiteDatabase.execSQL("Create table manage_Students(StudentName text , StudentID integer primary key,ImageName text , Image BLOB,CourseName text,CourseID text )");

    }
    public void Insert(View view){
        String FilePath= Environment.getExternalStorageDirectory().getPath()+"/Download/"+EditTextFileName.getText().toString()+".jpeg";
        Bitmap bitmap= BitmapFactory.decodeFile(FilePath);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,0,byteArrayOutputStream);
        byte[] ImageByte=byteArrayOutputStream.toByteArray();
        ContentValues contentValues=new ContentValues();
        contentValues.put("StudentName","StudentName");
        contentValues.put("StudentID","StudentID");
        contentValues.put("CourseID","CourseID");
        contentValues.put("CourseName","CourseName");
        contentValues.put("ImageName","EditTextFileName");
        contentValues.put("Image","ImageByte");
        sqLiteDatabase.insert("manage_Students",null, contentValues);

    }
    public void Update(View view){
        String FilePath= Environment.getExternalStorageDirectory().getPath()+"/Download/"+EditTextFileName.getText().toString()+".jpeg";
        Bitmap bitmap= BitmapFactory.decodeFile(FilePath);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,0,byteArrayOutputStream);
        byte[] ImageByte=byteArrayOutputStream.toByteArray();
        ContentValues contentValues=new ContentValues();
        contentValues.put("StudentName","StudentName");
        contentValues.put("StudentID","StudentID");
        contentValues.put("CourseID","CourseID");
        contentValues.put("CourseName","CourseName");
        contentValues.put("ImageName","EditTextFileName");
        contentValues.put("Image","ImageByte");
        sqLiteDatabase.update("manage_Students", contentValues,null,null);

    }
    public void Delete (View view){
        sqLiteDatabase.delete("manage_Students","StudentID=\"StudentID\"",null);

    }
    public void Fatch (View view){
        String stringQuery="Select Image from manage_Students where StudentID=\"StudentID\"";
        Cursor cursor = sqLiteDatabase.rawQuery(stringQuery,null);
        cursor.moveToFirst();
        byte[] ImageByte=cursor.getBlob(0);
        cursor.close();
        Bitmap bitmap= BitmapFactory.decodeByteArray(ImageByte,0,ImageByte.length);
        ImageView.setImageBitmap(bitmap);
    }





}
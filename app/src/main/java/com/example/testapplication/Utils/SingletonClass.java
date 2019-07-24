package com.example.testapplication.Utils;

import java.io.File;

public class SingletonClass {

    private static SingletonClass sSoleInstance;

    public File cacheLocation = new File(android.os.Environment.getExternalStorageDirectory(),"Tovala/");
    //private constructor.
    private SingletonClass(){

        //Prevent form the reflection api.
        if (sSoleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SingletonClass getInstance(){
        if (sSoleInstance == null){ //if there is no instance available... create new one
            sSoleInstance = new SingletonClass();
        }

        return sSoleInstance;
    }
}

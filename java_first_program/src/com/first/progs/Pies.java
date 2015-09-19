package com.first.progs;

import org.omg.CORBA_2_3.portable.OutputStream;

public class Pies {
    String name;

    public void input_name(String imie){
        name=imie;
    }

    public void show_name(){
        System.out.print("A imie jego to:" + name);
    }

    void szczekaj(){
        System.out.print("Hau Hau!!!");
    }
}

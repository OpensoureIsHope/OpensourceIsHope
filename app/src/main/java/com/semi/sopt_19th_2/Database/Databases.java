package com.semi.sopt_19th_2.Database;

import android.provider.BaseColumns;

/**
 * Created by hyejin on 2016-11-26.
 */
public class Databases {
    public static final class CreateDB implements BaseColumns {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String IMAGE = "image";
        public static final String PWD = "pwd";
        public static final String MAJOR = "major";
        public static final String GENDER = "gender";
        public static final String _TABLENAME = "memberinfo";
        // id name number time image
        public static final String _s =
                "create table "+_TABLENAME+"("
                        +_ID+" integer primary key autoincrement, "
                        +ID+" text , "
                        +PWD+" text , "
                        +NAME+" text , "
                        +MAJOR+" text , "
                        +GENDER+" text , "
                        +IMAGE+" text );";
    }
    }


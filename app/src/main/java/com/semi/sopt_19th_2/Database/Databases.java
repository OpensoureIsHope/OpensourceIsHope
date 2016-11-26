package com.semi.sopt_19th_2.Database;

import android.provider.BaseColumns;

/**
 * Created by hyejin on 2016-11-26.
 */
public class Databases {
    public static final class CreateDB implements BaseColumns {
        public static final String ID = "id";
        public static final String PASSWORD = "pwd";
        public static final String NAME ="name";
        public static final String MAJOR = "major";
        public static final String GENDER = "gender";
        public static final String IMAGE = "image";
        public static final String _TABLENAME = "join";
        // id name number time image
        public static final String _CREATE =
                "create table "+_TABLENAME+"("
                        +_ID+" integer primary key autoincrement, "
                        +ID+" varchar(25) not null, "
                        +PASSWORD+" varchar(25) not null, "
                        +NAME+" varchar(25) not null, "
                        +MAJOR+" varchar(25) not null, "
                        +GENDER+" varchar(25) not null, "
                        +IMAGE+" varchar(25));";

    }
}

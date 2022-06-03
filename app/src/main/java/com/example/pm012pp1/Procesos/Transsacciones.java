package com.example.pm012pp1.Procesos;

public class Transsacciones {

    /* Nombre de la bsae de datos*/
    public static final String NameDataBase = "DBPM01";
    /*Creacion de la tablas de la BD */
    public static final String tablaEmpleados = "empleados";

    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";


    public static final String CreateTableEmpleados = "CREATE TABLE empleados " +
                                                      "( id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                                      " nombres TEXT, apellidos TEXT, edad INTEGER, "+
                                                      " correo TEXT)";

    public static final String DropTableEmpleados = "DROP TABLE IF EXISTS empleados";

}

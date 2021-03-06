/*
 *  This file was autogenerated by the GPUdb schema processor.
 *
 *  DO NOT EDIT DIRECTLY.
 */
package com.gpudb.protocol;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.IndexedRecord;


/**
 * A set of results returned by {@link
 * com.gpudb.GPUdb#hasTable(HasTableRequest)}.
 */
public class HasTableResponse implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("HasTableResponse")
            .namespace("com.gpudb")
            .fields()
                .name("tableName").type().stringType().noDefault()
                .name("tableExists").type().booleanType().noDefault()
            .endRecord();


    /**
     * This method supports the Avro framework and is not intended to be called
     * directly by the user.
     * 
     * @return  the schema for the class.
     * 
     */
    public static Schema getClassSchema() {
        return schema$;
    }


    /**
     * Indicates whether the table exists or not. Values: true, false.

     * A set of string constants for the parameter {@code tableExists}.
     */
    public static final class TableExists {
        public static final String TRUE = "true";
        public static final String FALSE = "false";

        private TableExists() {  }
    }

    private String tableName;
    private boolean tableExists;


    /**
     * Constructs a HasTableResponse object with default parameters.
     */
    public HasTableResponse() {
    }

    /**
     * 
     * @return Value of {@code tableName}
     * 
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 
     * @param tableName  Value of {@code tableName}
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public HasTableResponse setTableName(String tableName) {
        this.tableName = (tableName == null) ? "" : tableName;
        return this;
    }

    /**
     * 
     * @return Indicates whether the table exists or not. Values: true, false.
     * 
     */
    public boolean getTableExists() {
        return tableExists;
    }

    /**
     * 
     * @param tableExists  Indicates whether the table exists or not. Values:
     *                     true, false.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public HasTableResponse setTableExists(boolean tableExists) {
        this.tableExists = tableExists;
        return this;
    }

    /**
     * This method supports the Avro framework and is not intended to be called
     * directly by the user.
     * 
     * @return the schema object describing this class.
     * 
     */
    @Override
    public Schema getSchema() {
        return schema$;
    }

    /**
     * This method supports the Avro framework and is not intended to be called
     * directly by the user.
     * 
     * @param index  the position of the field to get
     * 
     * @return value of the field with the given index.
     * 
     * @throws IndexOutOfBoundsException
     * 
     */
    @Override
    public Object get(int index) {
        switch (index) {
            case 0:
                return this.tableName;

            case 1:
                return this.tableExists;

            default:
                throw new IndexOutOfBoundsException("Invalid index specified.");
        }
    }

    /**
     * This method supports the Avro framework and is not intended to be called
     * directly by the user.
     * 
     * @param index  the position of the field to set
     * @param value  the value to set
     * 
     * @throws IndexOutOfBoundsException
     * 
     */
    @Override
    @SuppressWarnings("unchecked")
    public void put(int index, Object value) {
        switch (index) {
            case 0:
                this.tableName = (String)value;
                break;

            case 1:
                this.tableExists = (Boolean)value;
                break;

            default:
                throw new IndexOutOfBoundsException("Invalid index specified.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == this ) {
            return true;
        }

        if( (obj == null) || (obj.getClass() != this.getClass()) ) {
            return false;
        }

        HasTableResponse that = (HasTableResponse)obj;

        return ( this.tableName.equals( that.tableName )
                 && ( this.tableExists == that.tableExists ) );
    }

    @Override
    public String toString() {
        GenericData gd = GenericData.get();
        StringBuilder builder = new StringBuilder();
        builder.append( "{" );
        builder.append( gd.toString( "tableName" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.tableName ) );
        builder.append( ", " );
        builder.append( gd.toString( "tableExists" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.tableExists ) );
        builder.append( "}" );

        return builder.toString();
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = (31 * hashCode) + this.tableName.hashCode();
        hashCode = (31 * hashCode) + ((Boolean)this.tableExists).hashCode();
        return hashCode;
    }

}

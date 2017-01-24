
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


public class CreateProjectionResponse implements IndexedRecord {

    private static final Schema schema$ = SchemaBuilder
            .record("CreateProjectionResponse")
            .namespace("com.gpudb")
            .fields()
                .name("projectionName").type().stringType().noDefault()
            .endRecord();


    public static Schema getClassSchema() {
        return schema$;
    }


    private String projectionName;


    public CreateProjectionResponse() {
    }

    public String getProjectionName() {
        return projectionName;
    }

    public CreateProjectionResponse setProjectionName(String projectionName) {
        this.projectionName = (projectionName == null) ? "" : projectionName;
        return this;
    }

    @Override
    public Schema getSchema() {
        return schema$;
    }

    @Override
    public Object get(int index) {
        switch (index) {
            case 0:
                return this.projectionName;

            default:
                throw new IndexOutOfBoundsException("Invalid index specified.");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void put(int index, Object value) {
        switch (index) {
            case 0:
                this.projectionName = (String)value;
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

        CreateProjectionResponse that = (CreateProjectionResponse)obj;

        return ( this.projectionName.equals( that.projectionName ) );
    }


    @Override
    public String toString() {
        GenericData gd = GenericData.get();
        StringBuilder builder = new StringBuilder();
        builder.append( "{" );
        builder.append( gd.toString( "projectionName" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.projectionName ) );
        builder.append( "}" );

        return builder.toString();
    }


    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = (31 * hashCode) + this.projectionName.hashCode();
        return hashCode;
    }


}
/*
 *  This file was autogenerated by the GPUdb schema processor.
 *
 *  DO NOT EDIT DIRECTLY.
 */
package com.gpudb.protocol;

import java.util.ArrayList;
import java.util.List;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.IndexedRecord;


/**
 * A set of results returned by {@link
 * com.gpudb.GPUdb#adminVerifyDb(AdminVerifyDbRequest)}.
 */
public class AdminVerifyDbResponse implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("AdminVerifyDbResponse")
            .namespace("com.gpudb")
            .fields()
                .name("verifiedOk").type().booleanType().noDefault()
                .name("errorList").type().array().items().stringType().noDefault()
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

    private boolean verifiedOk;
    private List<String> errorList;


    /**
     * Constructs an AdminVerifyDbResponse object with default parameters.
     */
    public AdminVerifyDbResponse() {
    }

    /**
     * 
     * @return True if no errors were found, false otherwise.
     * 
     */
    public boolean getVerifiedOk() {
        return verifiedOk;
    }

    /**
     * 
     * @param verifiedOk  True if no errors were found, false otherwise.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public AdminVerifyDbResponse setVerifiedOk(boolean verifiedOk) {
        this.verifiedOk = verifiedOk;
        return this;
    }

    /**
     * 
     * @return List of errors found while validating the database internal
     *         state.
     * 
     */
    public List<String> getErrorList() {
        return errorList;
    }

    /**
     * 
     * @param errorList  List of errors found while validating the database
     *                   internal state.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public AdminVerifyDbResponse setErrorList(List<String> errorList) {
        this.errorList = (errorList == null) ? new ArrayList<String>() : errorList;
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
                return this.verifiedOk;

            case 1:
                return this.errorList;

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
                this.verifiedOk = (Boolean)value;
                break;

            case 1:
                this.errorList = (List<String>)value;
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

        AdminVerifyDbResponse that = (AdminVerifyDbResponse)obj;

        return ( ( this.verifiedOk == that.verifiedOk )
                 && this.errorList.equals( that.errorList ) );
    }

    @Override
    public String toString() {
        GenericData gd = GenericData.get();
        StringBuilder builder = new StringBuilder();
        builder.append( "{" );
        builder.append( gd.toString( "verifiedOk" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.verifiedOk ) );
        builder.append( ", " );
        builder.append( gd.toString( "errorList" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.errorList ) );
        builder.append( "}" );

        return builder.toString();
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = (31 * hashCode) + ((Boolean)this.verifiedOk).hashCode();
        hashCode = (31 * hashCode) + this.errorList.hashCode();
        return hashCode;
    }

}

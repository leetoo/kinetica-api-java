/*
 *  This file was autogenerated by the GPUdb schema processor.
 *
 *  DO NOT EDIT DIRECTLY.
 */
package com.gpudb.protocol;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.IndexedRecord;


/**
 * A set of parameters for {@link
 * com.gpudb.GPUdb#clearTableMonitor(ClearTableMonitorRequest)}.
 * <p>
 * Deactivates a table monitor previously created with {@link
 * com.gpudb.GPUdb#createTableMonitor(CreateTableMonitorRequest)}.
 */
public class ClearTableMonitorRequest implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("ClearTableMonitorRequest")
            .namespace("com.gpudb")
            .fields()
                .name("topicId").type().stringType().noDefault()
                .name("options").type().map().values().stringType().noDefault()
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

    private String topicId;
    private Map<String, String> options;


    /**
     * Constructs a ClearTableMonitorRequest object with default parameters.
     */
    public ClearTableMonitorRequest() {
        topicId = "";
        options = new LinkedHashMap<>();
    }

    /**
     * Constructs a ClearTableMonitorRequest object with the specified
     * parameters.
     * 
     * @param topicId  The topic ID returned by {@link
     *                 com.gpudb.GPUdb#createTableMonitor(CreateTableMonitorRequest)}.
     * @param options  Optional parameters.
     * 
     */
    public ClearTableMonitorRequest(String topicId, Map<String, String> options) {
        this.topicId = (topicId == null) ? "" : topicId;
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
    }

    /**
     * 
     * @return The topic ID returned by {@link
     *         com.gpudb.GPUdb#createTableMonitor(CreateTableMonitorRequest)}.
     * 
     */
    public String getTopicId() {
        return topicId;
    }

    /**
     * 
     * @param topicId  The topic ID returned by {@link
     *                 com.gpudb.GPUdb#createTableMonitor(CreateTableMonitorRequest)}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ClearTableMonitorRequest setTopicId(String topicId) {
        this.topicId = (topicId == null) ? "" : topicId;
        return this;
    }

    /**
     * 
     * @return Optional parameters.
     * 
     */
    public Map<String, String> getOptions() {
        return options;
    }

    /**
     * 
     * @param options  Optional parameters.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ClearTableMonitorRequest setOptions(Map<String, String> options) {
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
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
                return this.topicId;

            case 1:
                return this.options;

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
                this.topicId = (String)value;
                break;

            case 1:
                this.options = (Map<String, String>)value;
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

        ClearTableMonitorRequest that = (ClearTableMonitorRequest)obj;

        return ( this.topicId.equals( that.topicId )
                 && this.options.equals( that.options ) );
    }

    @Override
    public String toString() {
        GenericData gd = GenericData.get();
        StringBuilder builder = new StringBuilder();
        builder.append( "{" );
        builder.append( gd.toString( "topicId" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.topicId ) );
        builder.append( ", " );
        builder.append( gd.toString( "options" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.options ) );
        builder.append( "}" );

        return builder.toString();
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = (31 * hashCode) + this.topicId.hashCode();
        hashCode = (31 * hashCode) + this.options.hashCode();
        return hashCode;
    }

}

/*
 *  This file was autogenerated by the GPUdb schema processor.
 *
 *  DO NOT EDIT DIRECTLY.
 */
package com.gpudb.protocol;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.IndexedRecord;


/**
 * A set of results returned by {@link
 * com.gpudb.GPUdb#getRecordsFromCollectionRaw(GetRecordsFromCollectionRequest)}.
 */
public class RawGetRecordsFromCollectionResponse implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("RawGetRecordsFromCollectionResponse")
            .namespace("com.gpudb")
            .fields()
                .name("tableName").type().stringType().noDefault()
                .name("typeNames").type().array().items().stringType().noDefault()
                .name("recordsBinary").type().array().items().bytesType().noDefault()
                .name("recordsJson").type().array().items().stringType().noDefault()
                .name("recordIds").type().array().items().stringType().noDefault()
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

    private String tableName;
    private List<String> typeNames;
    private List<ByteBuffer> recordsBinary;
    private List<String> recordsJson;
    private List<String> recordIds;


    /**
     * Constructs a RawGetRecordsFromCollectionResponse object with default
     * parameters.
     */
    public RawGetRecordsFromCollectionResponse() {
    }

    /**
     * 
     * @return Value of {@code tableName}.
     * 
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 
     * @param tableName  Value of {@code tableName}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public RawGetRecordsFromCollectionResponse setTableName(String tableName) {
        this.tableName = (tableName == null) ? "" : tableName;
        return this;
    }

    /**
     * 
     * @return The type IDs of the corresponding records in {@code
     *         recordsBinary} or {@code recordsJson}. This is useful when
     *         {@code tableName} is a heterogeneous collection (collections
     *         containing tables of different types).
     * 
     */
    public List<String> getTypeNames() {
        return typeNames;
    }

    /**
     * 
     * @param typeNames  The type IDs of the corresponding records in {@code
     *                   recordsBinary} or {@code recordsJson}. This is useful
     *                   when {@code tableName} is a heterogeneous collection
     *                   (collections containing tables of different types).
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public RawGetRecordsFromCollectionResponse setTypeNames(List<String> typeNames) {
        this.typeNames = (typeNames == null) ? new ArrayList<String>() : typeNames;
        return this;
    }

    /**
     * 
     * @return If the encoding parameter of the request was 'binary' then this
     *         list contains the binary encoded records retrieved from the
     *         table/collection. Otherwise, empty list.
     * 
     */
    public List<ByteBuffer> getRecordsBinary() {
        return recordsBinary;
    }

    /**
     * 
     * @param recordsBinary  If the encoding parameter of the request was
     *                       'binary' then this list contains the binary
     *                       encoded records retrieved from the
     *                       table/collection. Otherwise, empty list.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public RawGetRecordsFromCollectionResponse setRecordsBinary(List<ByteBuffer> recordsBinary) {
        this.recordsBinary = (recordsBinary == null) ? new ArrayList<ByteBuffer>() : recordsBinary;
        return this;
    }

    /**
     * 
     * @return If the encoding parameter of the request was 'json', then this
     *         list contains the JSON encoded records retrieved from the
     *         table/collection. Otherwise, empty list.
     * 
     */
    public List<String> getRecordsJson() {
        return recordsJson;
    }

    /**
     * 
     * @param recordsJson  If the encoding parameter of the request was 'json',
     *                     then this list contains the JSON encoded records
     *                     retrieved from the table/collection. Otherwise,
     *                     empty list.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public RawGetRecordsFromCollectionResponse setRecordsJson(List<String> recordsJson) {
        this.recordsJson = (recordsJson == null) ? new ArrayList<String>() : recordsJson;
        return this;
    }

    /**
     * 
     * @return If the 'return_record_ids' option of the request was 'true',
     *         then this list contains the internal ID for each object.
     *         Otherwise it will be empty.
     * 
     */
    public List<String> getRecordIds() {
        return recordIds;
    }

    /**
     * 
     * @param recordIds  If the 'return_record_ids' option of the request was
     *                   'true', then this list contains the internal ID for
     *                   each object. Otherwise it will be empty.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public RawGetRecordsFromCollectionResponse setRecordIds(List<String> recordIds) {
        this.recordIds = (recordIds == null) ? new ArrayList<String>() : recordIds;
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
                return this.typeNames;

            case 2:
                return this.recordsBinary;

            case 3:
                return this.recordsJson;

            case 4:
                return this.recordIds;

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
                this.typeNames = (List<String>)value;
                break;

            case 2:
                this.recordsBinary = (List<ByteBuffer>)value;
                break;

            case 3:
                this.recordsJson = (List<String>)value;
                break;

            case 4:
                this.recordIds = (List<String>)value;
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

        RawGetRecordsFromCollectionResponse that = (RawGetRecordsFromCollectionResponse)obj;

        return ( this.tableName.equals( that.tableName )
                 && this.typeNames.equals( that.typeNames )
                 && this.recordsBinary.equals( that.recordsBinary )
                 && this.recordsJson.equals( that.recordsJson )
                 && this.recordIds.equals( that.recordIds ) );
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
        builder.append( gd.toString( "typeNames" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.typeNames ) );
        builder.append( ", " );
        builder.append( gd.toString( "recordsBinary" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.recordsBinary ) );
        builder.append( ", " );
        builder.append( gd.toString( "recordsJson" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.recordsJson ) );
        builder.append( ", " );
        builder.append( gd.toString( "recordIds" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.recordIds ) );
        builder.append( "}" );

        return builder.toString();
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = (31 * hashCode) + this.tableName.hashCode();
        hashCode = (31 * hashCode) + this.typeNames.hashCode();
        hashCode = (31 * hashCode) + this.recordsBinary.hashCode();
        hashCode = (31 * hashCode) + this.recordsJson.hashCode();
        hashCode = (31 * hashCode) + this.recordIds.hashCode();
        return hashCode;
    }

}

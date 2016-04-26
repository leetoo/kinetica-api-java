/*
 *  This file was autogenerated by the GPUdb schema processor.
 *
 *  DO NOT EDIT DIRECTLY.
 */
package com.gpudb.protocol;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.IndexedRecord;


/**
 * A set of parameters for {@link
 * com.gpudb.GPUdb#deleteRecords(DeleteRecordsRequest)}.
 * <p>
 * Deletes record(s) matching the provided criteria from the given table. The
 * record selection criteria can either be one or more  {@code expressions}
 * (matching multiple records) or a single record identified by {@code
 * record_id} optiona.  Note that the two selection criteria are mutually
 * exclusive.  This operation cannot be run on a collection or a view.  The
 * operation is synchronous meaning that a response will not be available until
 * the request is completely processed and all the matching records are
 * deleted.
 */
public class DeleteRecordsRequest implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("DeleteRecordsRequest")
            .namespace("com.gpudb")
            .fields()
                .name("tableName").type().stringType().noDefault()
                .name("expressions").type().array().items().stringType().noDefault()
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


    /**
     * Optional parameters.
     * A set of string constants for the parameter {@code options}.
     */
    public static final class Options {

        /**
         * An optional global expression to reduce the search space of the
         * {@code expressions}.
         */
        public static final String GLOBAL_EXPRESSION = "global_expression";

        /**
         * A record id identifying a single record, obtained at the time of
         * {@link com.gpudb.GPUdb#insertRecordsRaw(RawInsertRecordsRequest)
         * insertion of the record} or by calling {@link
         * com.gpudb.GPUdb#getRecordsFromCollectionRaw(GetRecordsFromCollectionRequest)}
         * with the *return_record_ids* option.
         */
        public static final String RECORD_ID = "record_id";

        private Options() {  }
    }

    private String tableName;
    private List<String> expressions;
    private Map<String, String> options;


    /**
     * Constructs a DeleteRecordsRequest object with default parameters.
     */
    public DeleteRecordsRequest() {
        tableName = "";
        expressions = new ArrayList<>();
        options = new LinkedHashMap<>();
    }

    /**
     * Constructs a DeleteRecordsRequest object with the specified parameters.
     * 
     * @param tableName  Name of the table from which to delete records. The
     *                   set must be a currently existing table and not a
     *                   collection or a view.
     * @param expressions  A list of the actual predicates, one for each
     *                     select; format should follow the guidelines provided
     *                     {@link com.gpudb.GPUdb#filter(FilterRequest) here}.
     *                     Specifying one or more {@code expressions} is
     *                     mutually exclusive to specifying {@code record_id}
     *                     in the {@code options}.
     * @param options  Optional parameters.
     * 
     */
    public DeleteRecordsRequest(String tableName, List<String> expressions, Map<String, String> options) {
        this.tableName = (tableName == null) ? "" : tableName;
        this.expressions = (expressions == null) ? new ArrayList<String>() : expressions;
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
    }

    /**
     * 
     * @return Name of the table from which to delete records. The set must be
     *         a currently existing table and not a collection or a view.
     * 
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 
     * @param tableName  Name of the table from which to delete records. The
     *                   set must be a currently existing table and not a
     *                   collection or a view.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public DeleteRecordsRequest setTableName(String tableName) {
        this.tableName = (tableName == null) ? "" : tableName;
        return this;
    }

    /**
     * 
     * @return A list of the actual predicates, one for each select; format
     *         should follow the guidelines provided {@link
     *         com.gpudb.GPUdb#filter(FilterRequest) here}. Specifying one or
     *         more {@code expressions} is mutually exclusive to specifying
     *         {@code record_id} in the {@code options}.
     * 
     */
    public List<String> getExpressions() {
        return expressions;
    }

    /**
     * 
     * @param expressions  A list of the actual predicates, one for each
     *                     select; format should follow the guidelines provided
     *                     {@link com.gpudb.GPUdb#filter(FilterRequest) here}.
     *                     Specifying one or more {@code expressions} is
     *                     mutually exclusive to specifying {@code record_id}
     *                     in the {@code options}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public DeleteRecordsRequest setExpressions(List<String> expressions) {
        this.expressions = (expressions == null) ? new ArrayList<String>() : expressions;
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
    public DeleteRecordsRequest setOptions(Map<String, String> options) {
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
                return this.tableName;

            case 1:
                return this.expressions;

            case 2:
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
                this.tableName = (String)value;
                break;

            case 1:
                this.expressions = (List<String>)value;
                break;

            case 2:
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

        DeleteRecordsRequest that = (DeleteRecordsRequest)obj;

        return ( this.tableName.equals( that.tableName )
                 && this.expressions.equals( that.expressions )
                 && this.options.equals( that.options ) );
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
        builder.append( gd.toString( "expressions" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.expressions ) );
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
        hashCode = (31 * hashCode) + this.tableName.hashCode();
        hashCode = (31 * hashCode) + this.expressions.hashCode();
        hashCode = (31 * hashCode) + this.options.hashCode();
        return hashCode;
    }

}
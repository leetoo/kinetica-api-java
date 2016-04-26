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
 * com.gpudb.GPUdb#createTable(CreateTableRequest)}.
 * <p>
 * Creates a new table or collection in GPUdb. If a new table is being created
 * then type of the table is given by {@code typeId} which must the be the type
 * id of a currently registered type (i.e. one created via {@link
 * com.gpudb.GPUdb#createType(CreateTypeRequest)}). The table will be created
 * inside a collection if the option *collection_name* is specified. If that
 * collection does not already exist then it will be created. To create a new,
 * empty collection specify the collection name in {@code tableName}, leave
 * {@code typeId} blank, and set the *is_collection* option to 'true'.
 */
public class CreateTableRequest implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("CreateTableRequest")
            .namespace("com.gpudb")
            .fields()
                .name("tableName").type().stringType().noDefault()
                .name("typeId").type().stringType().noDefault()
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
         * If {@code true}, prevents an error from occurring if the table
         * already exists and is of the given type.  If a table with the same
         * ID but a different type exists, it is still an error.
         */
        public static final String NO_ERROR_IF_EXISTS = "no_error_if_exists";
        public static final String TRUE = "true";
        public static final String FALSE = "false";

        /**
         * Name of a collection in GPUdb to which the newly created table is to
         * be assigned as a child table. If empty, then the newly created table
         * will be a top level table. If the collection does not allow
         * duplicate children, then this table creation request will fail if
         * there is an existing child table with the same type id specified in
         * this request.
         */
        public static final String COLLECTION_NAME = "collection_name";

        /**
         * Indicates whether the new table to be created will be a collection.
         * If false, the created table will be a top level table.
         */
        public static final String IS_COLLECTION = "is_collection";

        /**
         * For a collection, indicates whether multiple children of exactly the
         * same data type will be allowed.
         */
        public static final String DISALLOW_HOMOGENEOUS_TABLES = "disallow_homogeneous_tables";

        /**
         * For a Table, this is an indication to GPUdb to replicate the table
         * to all the ranks. This is only required when the table will be used
         * to join with other tables in a query.
         */
        public static final String IS_REPLICATED = "is_replicated";

        /**
         * Semicolon-separated list of foreign key constraints, of the format
         * 'my_field references primary_table(primary_key_field)'.
         */
        public static final String FOREIGN_KEYS = "foreign_keys";

        private Options() {  }
    }

    private String tableName;
    private String typeId;
    private Map<String, String> options;


    /**
     * Constructs a CreateTableRequest object with default parameters.
     */
    public CreateTableRequest() {
        tableName = "";
        typeId = "";
        options = new LinkedHashMap<>();
    }

    /**
     * Constructs a CreateTableRequest object with the specified parameters.
     * 
     * @param tableName  Name of the table to be created. Must not be the name
     *                   of a currently existing GPUdb table of a different
     *                   type.  Error for requests with existing table of the
     *                   same name and type id may be suppressed by using the
     *                   {@code no_error_if_exists} option.  Cannot be an empty
     *                   string.
     * @param typeId  ID of a currently registered type in GPUdb. All objects
     *                added to the newly created table will be of this type.
     *                Must be an empty string if the *is_collection* is 'true'.
     * @param options  Optional parameters.
     * 
     */
    public CreateTableRequest(String tableName, String typeId, Map<String, String> options) {
        this.tableName = (tableName == null) ? "" : tableName;
        this.typeId = (typeId == null) ? "" : typeId;
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
    }

    /**
     * 
     * @return Name of the table to be created. Must not be the name of a
     *         currently existing GPUdb table of a different type.  Error for
     *         requests with existing table of the same name and type id may be
     *         suppressed by using the {@code no_error_if_exists} option.
     *         Cannot be an empty string.
     * 
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 
     * @param tableName  Name of the table to be created. Must not be the name
     *                   of a currently existing GPUdb table of a different
     *                   type.  Error for requests with existing table of the
     *                   same name and type id may be suppressed by using the
     *                   {@code no_error_if_exists} option.  Cannot be an empty
     *                   string.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public CreateTableRequest setTableName(String tableName) {
        this.tableName = (tableName == null) ? "" : tableName;
        return this;
    }

    /**
     * 
     * @return ID of a currently registered type in GPUdb. All objects added to
     *         the newly created table will be of this type.  Must be an empty
     *         string if the *is_collection* is 'true'.
     * 
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * 
     * @param typeId  ID of a currently registered type in GPUdb. All objects
     *                added to the newly created table will be of this type.
     *                Must be an empty string if the *is_collection* is 'true'.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public CreateTableRequest setTypeId(String typeId) {
        this.typeId = (typeId == null) ? "" : typeId;
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
    public CreateTableRequest setOptions(Map<String, String> options) {
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
                return this.typeId;

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
                this.typeId = (String)value;
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

        CreateTableRequest that = (CreateTableRequest)obj;

        return ( this.tableName.equals( that.tableName )
                 && this.typeId.equals( that.typeId )
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
        builder.append( gd.toString( "typeId" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.typeId ) );
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
        hashCode = (31 * hashCode) + this.typeId.hashCode();
        hashCode = (31 * hashCode) + this.options.hashCode();
        return hashCode;
    }

}

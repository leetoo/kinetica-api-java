/*
 *  This file was autogenerated by the GPUdb schema processor.
 *
 *  DO NOT EDIT DIRECTLY.
 */
package com.gpudb.protocol;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.IndexedRecord;


/**
 * A set of results returned by {@link
 * com.gpudb.GPUdb#showTable(ShowTableRequest)}.
 */
public class ShowTableResponse implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("ShowTableResponse")
            .namespace("com.gpudb")
            .fields()
                .name("tableName").type().stringType().noDefault()
                .name("tableNames").type().array().items().stringType().noDefault()
                .name("isCollection").type().array().items().booleanType().noDefault()
                .name("isView").type().array().items().booleanType().noDefault()
                .name("isJoin").type().array().items().booleanType().noDefault()
                .name("typeIds").type().array().items().stringType().noDefault()
                .name("typeSchemas").type().array().items().stringType().noDefault()
                .name("typeLabels").type().array().items().stringType().noDefault()
                .name("properties").type().array().items().map().values().array().items().stringType().noDefault()
                .name("ttls").type().array().items().intType().noDefault()
                .name("sizes").type().array().items().longType().noDefault()
                .name("fullSizes").type().array().items().longType().noDefault()
                .name("joinSizes").type().array().items().doubleType().noDefault()
                .name("totalSize").type().longType().noDefault()
                .name("totalFullSize").type().longType().noDefault()
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
    private List<String> tableNames;
    private List<Boolean> isCollection;
    private List<Boolean> isView;
    private List<Boolean> isJoin;
    private List<String> typeIds;
    private List<String> typeSchemas;
    private List<String> typeLabels;
    private List<Map<String, List<String>>> properties;
    private List<Integer> ttls;
    private List<Long> sizes;
    private List<Long> fullSizes;
    private List<Double> joinSizes;
    private long totalSize;
    private long totalFullSize;


    /**
     * Constructs a ShowTableResponse object with default parameters.
     */
    public ShowTableResponse() {
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
    public ShowTableResponse setTableName(String tableName) {
        this.tableName = (tableName == null) ? "" : tableName;
        return this;
    }

    /**
     * 
     * @return If the table is a child-type table, then the single element of
     *         the array is {@code tableName}. If the table is a parent table,
     *         then this array is populated with the names of all child tables
     *         of the given table. If {@code tableName} is an empty string,
     *         then the array contains the names of all top-level tables in
     *         GPUdb.
     * 
     */
    public List<String> getTableNames() {
        return tableNames;
    }

    /**
     * 
     * @param tableNames  If the table is a child-type table, then the single
     *                    element of the array is {@code tableName}. If the
     *                    table is a parent table, then this array is populated
     *                    with the names of all child tables of the given
     *                    table. If {@code tableName} is an empty string, then
     *                    the array contains the names of all top-level tables
     *                    in GPUdb.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setTableNames(List<String> tableNames) {
        this.tableNames = (tableNames == null) ? new ArrayList<String>() : tableNames;
        return this;
    }

    /**
     * 
     * @return Boolean values corresponding to whether the respective tables in
     *         {@code tableNames} are collections of tables or not.
     * 
     */
    public List<Boolean> getIsCollection() {
        return isCollection;
    }

    /**
     * 
     * @param isCollection  Boolean values corresponding to whether the
     *                      respective tables in {@code tableNames} are
     *                      collections of tables or not.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setIsCollection(List<Boolean> isCollection) {
        this.isCollection = (isCollection == null) ? new ArrayList<Boolean>() : isCollection;
        return this;
    }

    /**
     * 
     * @return Boolean values corresponding to whether the respective tables in
     *         {@code tableNames} are views of tables or not.
     * 
     */
    public List<Boolean> getIsView() {
        return isView;
    }

    /**
     * 
     * @param isView  Boolean values corresponding to whether the respective
     *                tables in {@code tableNames} are views of tables or not.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setIsView(List<Boolean> isView) {
        this.isView = (isView == null) ? new ArrayList<Boolean>() : isView;
        return this;
    }

    /**
     * 
     * @return Boolean values corresponding to whether the respective tables in
     *         {@code tableNames} are joined tables or not.
     * 
     */
    public List<Boolean> getIsJoin() {
        return isJoin;
    }

    /**
     * 
     * @param isJoin  Boolean values corresponding to whether the respective
     *                tables in {@code tableNames} are joined tables or not.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setIsJoin(List<Boolean> isJoin) {
        this.isJoin = (isJoin == null) ? new ArrayList<Boolean>() : isJoin;
        return this;
    }

    /**
     * 
     * @return Type ids of the respective tables represented in {@code
     *         tableNames}.
     * 
     */
    public List<String> getTypeIds() {
        return typeIds;
    }

    /**
     * 
     * @param typeIds  Type ids of the respective tables represented in {@code
     *                 tableNames}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setTypeIds(List<String> typeIds) {
        this.typeIds = (typeIds == null) ? new ArrayList<String>() : typeIds;
        return this;
    }

    /**
     * 
     * @return Type schemas of the respective tables represented in {@code
     *         tableNames}.
     * 
     */
    public List<String> getTypeSchemas() {
        return typeSchemas;
    }

    /**
     * 
     * @param typeSchemas  Type schemas of the respective tables represented in
     *                     {@code tableNames}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setTypeSchemas(List<String> typeSchemas) {
        this.typeSchemas = (typeSchemas == null) ? new ArrayList<String>() : typeSchemas;
        return this;
    }

    /**
     * 
     * @return Type labels of the respective tables represented in {@code
     *         tableNames}.
     * 
     */
    public List<String> getTypeLabels() {
        return typeLabels;
    }

    /**
     * 
     * @param typeLabels  Type labels of the respective tables represented in
     *                    {@code tableNames}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setTypeLabels(List<String> typeLabels) {
        this.typeLabels = (typeLabels == null) ? new ArrayList<String>() : typeLabels;
        return this;
    }

    /**
     * 
     * @return Property maps that correspond, one for one, with the returned
     *         table names.
     * 
     */
    public List<Map<String, List<String>>> getProperties() {
        return properties;
    }

    /**
     * 
     * @param properties  Property maps that correspond, one for one, with the
     *                    returned table names.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setProperties(List<Map<String, List<String>>> properties) {
        this.properties = (properties == null) ? new ArrayList<Map<String, List<String>>>() : properties;
        return this;
    }

    /**
     * 
     * @return TTLs (time-to-live), in minutes, of the respective tables
     *         represented in {@code tableNames}. Will be -1 for parent tables
     *         and non-result tables.
     * 
     */
    public List<Integer> getTtls() {
        return ttls;
    }

    /**
     * 
     * @param ttls  TTLs (time-to-live), in minutes, of the respective tables
     *              represented in {@code tableNames}. Will be -1 for parent
     *              tables and non-result tables.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setTtls(List<Integer> ttls) {
        this.ttls = (ttls == null) ? new ArrayList<Integer>() : ttls;
        return this;
    }

    /**
     * 
     * @return Empty array if the 'get_sizes' option is 'false'. Otherwise,
     *         sizes of the respective tables represented in {@code
     *         tableNames}. For all but track data types, this is simply the
     *         number of total objects in a table. For track types, since each
     *         track semantically contains many individual objects, the 'size'
     *         is the count of 'conceptual' tracks (each of which may be
     *         associated with multiple objects).
     * 
     */
    public List<Long> getSizes() {
        return sizes;
    }

    /**
     * 
     * @param sizes  Empty array if the 'get_sizes' option is 'false'.
     *               Otherwise, sizes of the respective tables represented in
     *               {@code tableNames}. For all but track data types, this is
     *               simply the number of total objects in a table. For track
     *               types, since each track semantically contains many
     *               individual objects, the 'size' is the count of
     *               'conceptual' tracks (each of which may be associated with
     *               multiple objects).
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setSizes(List<Long> sizes) {
        this.sizes = (sizes == null) ? new ArrayList<Long>() : sizes;
        return this;
    }

    /**
     * 
     * @return Empty array if the 'get_sizes' option is 'false'. Otherwise,
     *         number of total objects in the respective tables represented in
     *         {@code tableNames}. For all but track data types, this is the
     *         same as sizes. For track types, since each track semantically
     *         contains many individual objects, the 'full size' is the count
     *         of total objects.
     * 
     */
    public List<Long> getFullSizes() {
        return fullSizes;
    }

    /**
     * 
     * @param fullSizes  Empty array if the 'get_sizes' option is 'false'.
     *                   Otherwise, number of total objects in the respective
     *                   tables represented in {@code tableNames}. For all but
     *                   track data types, this is the same as sizes. For track
     *                   types, since each track semantically contains many
     *                   individual objects, the 'full size' is the count of
     *                   total objects.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setFullSizes(List<Long> fullSizes) {
        this.fullSizes = (fullSizes == null) ? new ArrayList<Long>() : fullSizes;
        return this;
    }

    /**
     * 
     * @return Empty array if the 'get_sizes' option is 'false'. Otherwise,
     *         number of unfiltered objects in the cross product of the sub-
     *         tables in the joined-tables represented in {@code tableNames}.
     *         For simple tables this number will be the same as size.  For
     *         join-tables this value gives the number of joined-table rows
     *         that must be processed by any aggregate functions operating on
     *         the table.
     * 
     */
    public List<Double> getJoinSizes() {
        return joinSizes;
    }

    /**
     * 
     * @param joinSizes  Empty array if the 'get_sizes' option is 'false'.
     *                   Otherwise, number of unfiltered objects in the cross
     *                   product of the sub-tables in the joined-tables
     *                   represented in {@code tableNames}. For simple tables
     *                   this number will be the same as size.  For join-tables
     *                   this value gives the number of joined-table rows that
     *                   must be processed by any aggregate functions operating
     *                   on the table.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setJoinSizes(List<Double> joinSizes) {
        this.joinSizes = (joinSizes == null) ? new ArrayList<Double>() : joinSizes;
        return this;
    }

    /**
     * 
     * @return -1 if the 'get_sizes' option is 'false'. Otherwise, the sum of
     *         the elements of {@code sizes}.
     * 
     */
    public long getTotalSize() {
        return totalSize;
    }

    /**
     * 
     * @param totalSize  -1 if the 'get_sizes' option is 'false'. Otherwise,
     *                   the sum of the elements of {@code sizes}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setTotalSize(long totalSize) {
        this.totalSize = totalSize;
        return this;
    }

    /**
     * 
     * @return -1 if the 'get_sizes' option is 'false'. The sum of the elements
     *         of {@code fullSizes}.
     * 
     */
    public long getTotalFullSize() {
        return totalFullSize;
    }

    /**
     * 
     * @param totalFullSize  -1 if the 'get_sizes' option is 'false'. The sum
     *                       of the elements of {@code fullSizes}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setTotalFullSize(long totalFullSize) {
        this.totalFullSize = totalFullSize;
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
                return this.tableNames;

            case 2:
                return this.isCollection;

            case 3:
                return this.isView;

            case 4:
                return this.isJoin;

            case 5:
                return this.typeIds;

            case 6:
                return this.typeSchemas;

            case 7:
                return this.typeLabels;

            case 8:
                return this.properties;

            case 9:
                return this.ttls;

            case 10:
                return this.sizes;

            case 11:
                return this.fullSizes;

            case 12:
                return this.joinSizes;

            case 13:
                return this.totalSize;

            case 14:
                return this.totalFullSize;

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
                this.tableNames = (List<String>)value;
                break;

            case 2:
                this.isCollection = (List<Boolean>)value;
                break;

            case 3:
                this.isView = (List<Boolean>)value;
                break;

            case 4:
                this.isJoin = (List<Boolean>)value;
                break;

            case 5:
                this.typeIds = (List<String>)value;
                break;

            case 6:
                this.typeSchemas = (List<String>)value;
                break;

            case 7:
                this.typeLabels = (List<String>)value;
                break;

            case 8:
                this.properties = (List<Map<String, List<String>>>)value;
                break;

            case 9:
                this.ttls = (List<Integer>)value;
                break;

            case 10:
                this.sizes = (List<Long>)value;
                break;

            case 11:
                this.fullSizes = (List<Long>)value;
                break;

            case 12:
                this.joinSizes = (List<Double>)value;
                break;

            case 13:
                this.totalSize = (Long)value;
                break;

            case 14:
                this.totalFullSize = (Long)value;
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

        ShowTableResponse that = (ShowTableResponse)obj;

        return ( this.tableName.equals( that.tableName )
                 && this.tableNames.equals( that.tableNames )
                 && this.isCollection.equals( that.isCollection )
                 && this.isView.equals( that.isView )
                 && this.isJoin.equals( that.isJoin )
                 && this.typeIds.equals( that.typeIds )
                 && this.typeSchemas.equals( that.typeSchemas )
                 && this.typeLabels.equals( that.typeLabels )
                 && this.properties.equals( that.properties )
                 && this.ttls.equals( that.ttls )
                 && this.sizes.equals( that.sizes )
                 && this.fullSizes.equals( that.fullSizes )
                 && this.joinSizes.equals( that.joinSizes )
                 && ( this.totalSize == that.totalSize )
                 && ( this.totalFullSize == that.totalFullSize ) );
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
        builder.append( gd.toString( "tableNames" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.tableNames ) );
        builder.append( ", " );
        builder.append( gd.toString( "isCollection" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.isCollection ) );
        builder.append( ", " );
        builder.append( gd.toString( "isView" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.isView ) );
        builder.append( ", " );
        builder.append( gd.toString( "isJoin" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.isJoin ) );
        builder.append( ", " );
        builder.append( gd.toString( "typeIds" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.typeIds ) );
        builder.append( ", " );
        builder.append( gd.toString( "typeSchemas" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.typeSchemas ) );
        builder.append( ", " );
        builder.append( gd.toString( "typeLabels" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.typeLabels ) );
        builder.append( ", " );
        builder.append( gd.toString( "properties" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.properties ) );
        builder.append( ", " );
        builder.append( gd.toString( "ttls" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.ttls ) );
        builder.append( ", " );
        builder.append( gd.toString( "sizes" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.sizes ) );
        builder.append( ", " );
        builder.append( gd.toString( "fullSizes" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.fullSizes ) );
        builder.append( ", " );
        builder.append( gd.toString( "joinSizes" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.joinSizes ) );
        builder.append( ", " );
        builder.append( gd.toString( "totalSize" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.totalSize ) );
        builder.append( ", " );
        builder.append( gd.toString( "totalFullSize" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.totalFullSize ) );
        builder.append( "}" );

        return builder.toString();
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = (31 * hashCode) + this.tableName.hashCode();
        hashCode = (31 * hashCode) + this.tableNames.hashCode();
        hashCode = (31 * hashCode) + this.isCollection.hashCode();
        hashCode = (31 * hashCode) + this.isView.hashCode();
        hashCode = (31 * hashCode) + this.isJoin.hashCode();
        hashCode = (31 * hashCode) + this.typeIds.hashCode();
        hashCode = (31 * hashCode) + this.typeSchemas.hashCode();
        hashCode = (31 * hashCode) + this.typeLabels.hashCode();
        hashCode = (31 * hashCode) + this.properties.hashCode();
        hashCode = (31 * hashCode) + this.ttls.hashCode();
        hashCode = (31 * hashCode) + this.sizes.hashCode();
        hashCode = (31 * hashCode) + this.fullSizes.hashCode();
        hashCode = (31 * hashCode) + this.joinSizes.hashCode();
        hashCode = (31 * hashCode) + ((Long)this.totalSize).hashCode();
        hashCode = (31 * hashCode) + ((Long)this.totalFullSize).hashCode();
        return hashCode;
    }

}

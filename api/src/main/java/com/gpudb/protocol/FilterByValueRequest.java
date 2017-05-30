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
 * com.gpudb.GPUdb#filterByValue(FilterByValueRequest)}.
 * <p>
 * Calculates which objects from a table has a particular value for a
 * particular column. The input parameters provide a way to specify either a
 * String or a Double valued column and a desired value for the column on which
 * the filter is performed. The operation is synchronous, meaning that a
 * response will not be returned until all the objects are fully available. The
 * response payload provides the count of the resulting set. A new result view
 * which satisfies the input filter restriction specification is also created
 * with a view name passed in as part of the input payload.  Although this
 * functionality can also be accomplished with the standard filter function, it
 * is more efficient.
 */
public class FilterByValueRequest implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("FilterByValueRequest")
            .namespace("com.gpudb")
            .fields()
                .name("tableName").type().stringType().noDefault()
                .name("viewName").type().stringType().noDefault()
                .name("isString").type().booleanType().noDefault()
                .name("value").type().doubleType().noDefault()
                .name("valueStr").type().stringType().noDefault()
                .name("columnName").type().stringType().noDefault()
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

    private String tableName;
    private String viewName;
    private boolean isString;
    private double value;
    private String valueStr;
    private String columnName;
    private Map<String, String> options;


    /**
     * Constructs a FilterByValueRequest object with default parameters.
     */
    public FilterByValueRequest() {
        tableName = "";
        viewName = "";
        valueStr = "";
        columnName = "";
        options = new LinkedHashMap<>();
    }

    /**
     * Constructs a FilterByValueRequest object with the specified parameters.
     * 
     * @param tableName  Name of an existing table on which to perform the
     *                   calculation.
     * @param viewName  If provided, then this will be the name of the view
     *                  containing the results. Has the same naming
     *                  restrictions as <a
     *                  href="../../../../../concepts/tables.html"
     *                  target="_top">tables</a>.
     * @param isString  Indicates whether the value being searched for is
     *                  string or numeric.
     * @param value  The value to search for.
     * @param valueStr  The string value to search for.
     * @param columnName  Name of a column on which the filter by value would
     *                    be applied.
     * @param options  Optional parameters.
     * 
     */
    public FilterByValueRequest(String tableName, String viewName, boolean isString, double value, String valueStr, String columnName, Map<String, String> options) {
        this.tableName = (tableName == null) ? "" : tableName;
        this.viewName = (viewName == null) ? "" : viewName;
        this.isString = isString;
        this.value = value;
        this.valueStr = (valueStr == null) ? "" : valueStr;
        this.columnName = (columnName == null) ? "" : columnName;
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
    }

    /**
     * 
     * @return Name of an existing table on which to perform the calculation.
     * 
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 
     * @param tableName  Name of an existing table on which to perform the
     *                   calculation.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public FilterByValueRequest setTableName(String tableName) {
        this.tableName = (tableName == null) ? "" : tableName;
        return this;
    }

    /**
     * 
     * @return If provided, then this will be the name of the view containing
     *         the results. Has the same naming restrictions as <a
     *         href="../../../../../concepts/tables.html"
     *         target="_top">tables</a>.
     * 
     */
    public String getViewName() {
        return viewName;
    }

    /**
     * 
     * @param viewName  If provided, then this will be the name of the view
     *                  containing the results. Has the same naming
     *                  restrictions as <a
     *                  href="../../../../../concepts/tables.html"
     *                  target="_top">tables</a>.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public FilterByValueRequest setViewName(String viewName) {
        this.viewName = (viewName == null) ? "" : viewName;
        return this;
    }

    /**
     * 
     * @return Indicates whether the value being searched for is string or
     *         numeric.
     * 
     */
    public boolean getIsString() {
        return isString;
    }

    /**
     * 
     * @param isString  Indicates whether the value being searched for is
     *                  string or numeric.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public FilterByValueRequest setIsString(boolean isString) {
        this.isString = isString;
        return this;
    }

    /**
     * 
     * @return The value to search for.
     * 
     */
    public double getValue() {
        return value;
    }

    /**
     * 
     * @param value  The value to search for.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public FilterByValueRequest setValue(double value) {
        this.value = value;
        return this;
    }

    /**
     * 
     * @return The string value to search for.
     * 
     */
    public String getValueStr() {
        return valueStr;
    }

    /**
     * 
     * @param valueStr  The string value to search for.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public FilterByValueRequest setValueStr(String valueStr) {
        this.valueStr = (valueStr == null) ? "" : valueStr;
        return this;
    }

    /**
     * 
     * @return Name of a column on which the filter by value would be applied.
     * 
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 
     * @param columnName  Name of a column on which the filter by value would
     *                    be applied.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public FilterByValueRequest setColumnName(String columnName) {
        this.columnName = (columnName == null) ? "" : columnName;
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
    public FilterByValueRequest setOptions(Map<String, String> options) {
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
                return this.viewName;

            case 2:
                return this.isString;

            case 3:
                return this.value;

            case 4:
                return this.valueStr;

            case 5:
                return this.columnName;

            case 6:
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
                this.viewName = (String)value;
                break;

            case 2:
                this.isString = (Boolean)value;
                break;

            case 3:
                this.value = (Double)value;
                break;

            case 4:
                this.valueStr = (String)value;
                break;

            case 5:
                this.columnName = (String)value;
                break;

            case 6:
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

        FilterByValueRequest that = (FilterByValueRequest)obj;

        return ( this.tableName.equals( that.tableName )
                 && this.viewName.equals( that.viewName )
                 && ( this.isString == that.isString )
                 && ( (Double)this.value ).equals( (Double)that.value )
                 && this.valueStr.equals( that.valueStr )
                 && this.columnName.equals( that.columnName )
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
        builder.append( gd.toString( "viewName" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.viewName ) );
        builder.append( ", " );
        builder.append( gd.toString( "isString" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.isString ) );
        builder.append( ", " );
        builder.append( gd.toString( "value" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.value ) );
        builder.append( ", " );
        builder.append( gd.toString( "valueStr" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.valueStr ) );
        builder.append( ", " );
        builder.append( gd.toString( "columnName" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.columnName ) );
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
        hashCode = (31 * hashCode) + this.viewName.hashCode();
        hashCode = (31 * hashCode) + ((Boolean)this.isString).hashCode();
        hashCode = (31 * hashCode) + ((Double)this.value).hashCode();
        hashCode = (31 * hashCode) + this.valueStr.hashCode();
        hashCode = (31 * hashCode) + this.columnName.hashCode();
        hashCode = (31 * hashCode) + this.options.hashCode();
        return hashCode;
    }

}

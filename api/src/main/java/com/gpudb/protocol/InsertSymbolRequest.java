/*
 *  This file was autogenerated by the GPUdb schema processor.
 *
 *  DO NOT EDIT DIRECTLY.
 */
package com.gpudb.protocol;

import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.IndexedRecord;


/**
 * A set of parameters for {@link
 * com.gpudb.GPUdb#insertSymbol(InsertSymbolRequest)}.
 * <p>
 * Adds a symbol or icon (i.e. an image) to represent data points when data is
 * rendered visually. Users must provide the symbol identifier (string), a
 * format (currently supported: 'svg' and 'svg_path'), the data for the symbol,
 * and any additional optional parameter (e.g. color). To have a symbol used
 * for rendering create a table with a string column named 'SYMBOLCODE' (along
 * with 'x' or 'y' for example). Then when the table is rendered (via <a
 * href="../../../../../api/rest/wms_rest.html" target="_top">WMS</a>) if the
 * 'dosymbology' parameter is 'true' then the value of the 'SYMBOLCODE' column
 * is used to pick the symbol displayed for each point.
 */
public class InsertSymbolRequest implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("InsertSymbolRequest")
            .namespace("com.gpudb")
            .fields()
                .name("symbolId").type().stringType().noDefault()
                .name("symbolFormat").type().stringType().noDefault()
                .name("symbolData").type().bytesType().noDefault()
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
     * Specifies the symbol format. Must be either 'svg' or 'svg_path'. Values:
     * svg, svg_path.

     * A set of string constants for the parameter {@code symbolFormat}.
     */
    public static final class SymbolFormat {
        public static final String SVG = "svg";
        public static final String SVG_PATH = "svg_path";

        private SymbolFormat() {  }
    }


    /**
     * Optional parameters.
     * <ul>
     *         <li> color: If {@code symbolFormat} is 'svg' this is ignored. If
     * {@code symbolFormat} is 'svg_path' then this option specifies the color
     * (in RRGGBB hex format) of the path. For example, to have the path
     * rendered in red, used 'FF0000'. If 'color' is not provided then '00FF00'
     * (i.e. green) is used by default.
     * </ul>
     * A set of string constants for the parameter {@code options}.
     */
    public static final class Options {

        /**
         * If {@code symbolFormat} is 'svg' this is ignored. If {@code
         * symbolFormat} is 'svg_path' then this option specifies the color (in
         * RRGGBB hex format) of the path. For example, to have the path
         * rendered in red, used 'FF0000'. If 'color' is not provided then
         * '00FF00' (i.e. green) is used by default.
         */
        public static final String COLOR = "color";

        private Options() {  }
    }

    private String symbolId;
    private String symbolFormat;
    private ByteBuffer symbolData;
    private Map<String, String> options;


    /**
     * Constructs an InsertSymbolRequest object with default parameters.
     */
    public InsertSymbolRequest() {
        symbolId = "";
        symbolFormat = "";
        symbolData = ByteBuffer.wrap( new byte[0] );
        options = new LinkedHashMap<>();
    }

    /**
     * Constructs an InsertSymbolRequest object with the specified parameters.
     * 
     * @param symbolId  The id of the symbol being added. This is the same id
     *                  that should be in the 'SYMBOLCODE' column for objects
     *                  using this symbol
     * @param symbolFormat  Specifies the symbol format. Must be either 'svg'
     *                      or 'svg_path'. Values: svg, svg_path.
     * @param symbolData  The actual symbol data. If {@code symbolFormat} is
     *                    'svg' then this should be the raw bytes representing
     *                    an svg file. If {@code symbolFormat} is svg path then
     *                    this should be an svg path string, for example:
     *                    'M25.979,12.896,5.979,12.896,5.979,19.562,25.979,19.562z'
     * @param options  Optional parameters.
     *                 <ul>
     *                         <li> color: If {@code symbolFormat} is 'svg'
     *                 this is ignored. If {@code symbolFormat} is 'svg_path'
     *                 then this option specifies the color (in RRGGBB hex
     *                 format) of the path. For example, to have the path
     *                 rendered in red, used 'FF0000'. If 'color' is not
     *                 provided then '00FF00' (i.e. green) is used by default.
     *                 </ul>
     * 
     */
    public InsertSymbolRequest(String symbolId, String symbolFormat, ByteBuffer symbolData, Map<String, String> options) {
        this.symbolId = (symbolId == null) ? "" : symbolId;
        this.symbolFormat = (symbolFormat == null) ? "" : symbolFormat;
        this.symbolData = (symbolData == null) ? ByteBuffer.wrap( new byte[0] ) : symbolData;
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
    }

    /**
     * 
     * @return The id of the symbol being added. This is the same id that
     *         should be in the 'SYMBOLCODE' column for objects using this
     *         symbol
     * 
     */
    public String getSymbolId() {
        return symbolId;
    }

    /**
     * 
     * @param symbolId  The id of the symbol being added. This is the same id
     *                  that should be in the 'SYMBOLCODE' column for objects
     *                  using this symbol
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public InsertSymbolRequest setSymbolId(String symbolId) {
        this.symbolId = (symbolId == null) ? "" : symbolId;
        return this;
    }

    /**
     * 
     * @return Specifies the symbol format. Must be either 'svg' or 'svg_path'.
     *         Values: svg, svg_path.
     * 
     */
    public String getSymbolFormat() {
        return symbolFormat;
    }

    /**
     * 
     * @param symbolFormat  Specifies the symbol format. Must be either 'svg'
     *                      or 'svg_path'. Values: svg, svg_path.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public InsertSymbolRequest setSymbolFormat(String symbolFormat) {
        this.symbolFormat = (symbolFormat == null) ? "" : symbolFormat;
        return this;
    }

    /**
     * 
     * @return The actual symbol data. If {@code symbolFormat} is 'svg' then
     *         this should be the raw bytes representing an svg file. If {@code
     *         symbolFormat} is svg path then this should be an svg path
     *         string, for example:
     *         'M25.979,12.896,5.979,12.896,5.979,19.562,25.979,19.562z'
     * 
     */
    public ByteBuffer getSymbolData() {
        return symbolData;
    }

    /**
     * 
     * @param symbolData  The actual symbol data. If {@code symbolFormat} is
     *                    'svg' then this should be the raw bytes representing
     *                    an svg file. If {@code symbolFormat} is svg path then
     *                    this should be an svg path string, for example:
     *                    'M25.979,12.896,5.979,12.896,5.979,19.562,25.979,19.562z'
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public InsertSymbolRequest setSymbolData(ByteBuffer symbolData) {
        this.symbolData = (symbolData == null) ? ByteBuffer.wrap( new byte[0] ) : symbolData;
        return this;
    }

    /**
     * 
     * @return Optional parameters.
     *         <ul>
     *                 <li> color: If {@code symbolFormat} is 'svg' this is
     *         ignored. If {@code symbolFormat} is 'svg_path' then this option
     *         specifies the color (in RRGGBB hex format) of the path. For
     *         example, to have the path rendered in red, used 'FF0000'. If
     *         'color' is not provided then '00FF00' (i.e. green) is used by
     *         default.
     *         </ul>
     * 
     */
    public Map<String, String> getOptions() {
        return options;
    }

    /**
     * 
     * @param options  Optional parameters.
     *                 <ul>
     *                         <li> color: If {@code symbolFormat} is 'svg'
     *                 this is ignored. If {@code symbolFormat} is 'svg_path'
     *                 then this option specifies the color (in RRGGBB hex
     *                 format) of the path. For example, to have the path
     *                 rendered in red, used 'FF0000'. If 'color' is not
     *                 provided then '00FF00' (i.e. green) is used by default.
     *                 </ul>
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public InsertSymbolRequest setOptions(Map<String, String> options) {
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
                return this.symbolId;

            case 1:
                return this.symbolFormat;

            case 2:
                return this.symbolData;

            case 3:
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
                this.symbolId = (String)value;
                break;

            case 1:
                this.symbolFormat = (String)value;
                break;

            case 2:
                this.symbolData = (ByteBuffer)value;
                break;

            case 3:
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

        InsertSymbolRequest that = (InsertSymbolRequest)obj;

        return ( this.symbolId.equals( that.symbolId )
                 && this.symbolFormat.equals( that.symbolFormat )
                 && this.symbolData.equals( that.symbolData )
                 && this.options.equals( that.options ) );
    }

    @Override
    public String toString() {
        GenericData gd = GenericData.get();
        StringBuilder builder = new StringBuilder();
        builder.append( "{" );
        builder.append( gd.toString( "symbolId" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.symbolId ) );
        builder.append( ", " );
        builder.append( gd.toString( "symbolFormat" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.symbolFormat ) );
        builder.append( ", " );
        builder.append( gd.toString( "symbolData" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.symbolData ) );
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
        hashCode = (31 * hashCode) + this.symbolId.hashCode();
        hashCode = (31 * hashCode) + this.symbolFormat.hashCode();
        hashCode = (31 * hashCode) + this.symbolData.hashCode();
        hashCode = (31 * hashCode) + this.options.hashCode();
        return hashCode;
    }

}

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
 * com.gpudb.GPUdb#visualizeImageClassbreak(VisualizeImageClassbreakRequest)}.
 * <p>
 * Generates 'class break' rasterized image tiles for an area of interest using
 * the given tables and the provided parameters.
 * <p>
 * A class break rendering is where data from one or more GPUdb tables is
 * rasterized with styling applied on a per-class basis. GPUdb supports class
 * breaks based on one or more data columns. Distinct values (for strings) or
 * ranges (for numeric attributes) must be provided in the
 * cb_column_name1/cb_vals1 and cb_column_name2/cb_vals2 parameters. The
 * styling parameters must be specified for each class.
 * <p>
 * All color values must be in the format RRGGBB or AARRGGBB (to specify the
 * alpha value).
 * The image is contained in the {@code imageData} field.
 */
public class VisualizeImageClassbreakRequest implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("VisualizeImageClassbreakRequest")
            .namespace("com.gpudb")
            .fields()
                .name("tableNames").type().array().items().stringType().noDefault()
                .name("worldTableNames").type().array().items().stringType().noDefault()
                .name("xColumnName").type().stringType().noDefault()
                .name("yColumnName").type().stringType().noDefault()
                .name("trackIds").type().array().items().array().items().stringType().noDefault()
                .name("cbColumnName1").type().stringType().noDefault()
                .name("cbVals1").type().array().items().stringType().noDefault()
                .name("cbColumnName2").type().array().items().stringType().noDefault()
                .name("cbVals2").type().array().items().array().items().stringType().noDefault()
                .name("minX").type().doubleType().noDefault()
                .name("maxX").type().doubleType().noDefault()
                .name("minY").type().doubleType().noDefault()
                .name("maxY").type().doubleType().noDefault()
                .name("width").type().intType().noDefault()
                .name("height").type().intType().noDefault()
                .name("projection").type().stringType().noDefault()
                .name("bgColor").type().longType().noDefault()
                .name("styleOptions").type().map().values().array().items().stringType().noDefault()
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
     * Spatial Reference System (i.e. EPSG Code).
     * A set of string constants for the parameter {@code projection}.
     */
    public static final class Projection {
        public static final String EPSG_4326 = "EPSG:4326";
        public static final String PLATE_CARREE = "PLATE_CARREE";
        public static final String _900913 = "900913";
        public static final String EPSG_900913 = "EPSG:900913";
        public static final String _102100 = "102100";
        public static final String EPSG_102100 = "EPSG:102100";
        public static final String _3857 = "3857";
        public static final String EPSG_3857 = "EPSG:3857";
        public static final String WEB_MERCATOR = "WEB_MERCATOR";

        private Projection() {  }
    }


    /**
     * Styling options for the image.
     * A set of string constants for the parameter {@code styleOptions}.
     */
    public static final class StyleOptions {

        /**
         * Rasterize point data toggle.
         */
        public static final String DO_POINTS = "do_points";
        public static final String TRUE = "true";
        public static final String FALSE = "false";

        /**
         * Rasterize shapes toggle.
         */
        public static final String DO_SHAPES = "do_shapes";

        /**
         * Rasterize tracks toggle.
         */
        public static final String DO_TRACKS = "do_tracks";

        /**
         * Rasterize symbols toggle.
         */
        public static final String DO_SYMBOLOGY = "do_symbology";

        /**
         * RGB color value in hex for the points.
         */
        public static final String POINTCOLORS = "pointcolors";

        /**
         * Size of points.
         */
        public static final String POINTSIZES = "pointsizes";

        /**
         * Shape of the point.
         */
        public static final String POINTSHAPES = "pointshapes";
        public static final String NONE = "none";
        public static final String CIRCLE = "circle";
        public static final String SQUARE = "square";
        public static final String DIAMOND = "diamond";
        public static final String HOLLOWCIRCLE = "hollowcircle";
        public static final String HOLLOWSQUARE = "hollowsquare";
        public static final String HOLLOWDIAMOND = "hollowdiamond";
        public static final String SYMBOLCODE = "SYMBOLCODE";

        /**
         * Width of the lines.
         */
        public static final String SHAPELINEWIDTHS = "shapelinewidths";

        /**
         * RGB color values in hex for the line.
         */
        public static final String SHAPELINECOLORS = "shapelinecolors";

        /**
         * RGB color values in hex for the fill color of the shapes. Use '-1'
         * for no fill.
         */
        public static final String SHAPEFILLCOLORS = "shapefillcolors";

        /**
         * Width of the track lines. '0' implies do not draw track lines.
         */
        public static final String TRACKLINEWIDTHS = "tracklinewidths";

        /**
         * RGB color values for the track lines.
         */
        public static final String TRACKLINECOLORS = "tracklinecolors";

        /**
         * Size of the track point markers.
         */
        public static final String TRACKMARKERSIZES = "trackmarkersizes";

        /**
         * Color of the track point markers.
         */
        public static final String TRACKMARKERCOLORS = "trackmarkercolors";

        /**
         * Shape of track point markers.
         */
        public static final String TRACKMARKERSHAPES = "trackmarkershapes";

        /**
         * Color of track head markers.
         */
        public static final String TRACKHEADCOLORS = "trackheadcolors";

        /**
         * Size of track head markers.
         */
        public static final String TRACKHEADSIZES = "trackheadsizes";

        /**
         * Shape of track head markers.
         */
        public static final String TRACKHEADSHAPES = "trackheadshapes";

        private StyleOptions() {  }
    }

    private List<String> tableNames;
    private List<String> worldTableNames;
    private String xColumnName;
    private String yColumnName;
    private List<List<String>> trackIds;
    private String cbColumnName1;
    private List<String> cbVals1;
    private List<String> cbColumnName2;
    private List<List<String>> cbVals2;
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private int width;
    private int height;
    private String projection;
    private long bgColor;
    private Map<String, List<String>> styleOptions;
    private Map<String, String> options;


    /**
     * Constructs a VisualizeImageClassbreakRequest object with default
     * parameters.
     */
    public VisualizeImageClassbreakRequest() {
        tableNames = new ArrayList<>();
        worldTableNames = new ArrayList<>();
        xColumnName = "";
        yColumnName = "";
        trackIds = new ArrayList<>();
        cbColumnName1 = "";
        cbVals1 = new ArrayList<>();
        cbColumnName2 = new ArrayList<>();
        cbVals2 = new ArrayList<>();
        projection = "";
        styleOptions = new LinkedHashMap<>();
        options = new LinkedHashMap<>();
    }

    /**
     * Constructs a VisualizeImageClassbreakRequest object with the specified
     * parameters.
     * 
     * @param tableNames  Name of the table containing the data for the various
     *                    layers to be rendered.
     * @param worldTableNames  Optional name of the tables containing the data
     *                         for the entire track when the {@code tableNames}
     *                         contains only part of the track data, but the
     *                         entire track has to be rendered.
     * @param xColumnName  Name of the column containing the x coordinates.
     * @param yColumnName  Name of the column containing the y coordinates.
     * @param trackIds  Tracks from the {@code tableNames} to be rendered.
     * @param cbColumnName1  Name of the column for the first class break.
     * @param cbVals1  Comma separated list of values or ranges (e.g.
     *                 '0:5,5:10,15:30').
     * @param cbColumnName2  Optional comma seperated list of valid column
     *                       names. An empty string implies not using more than
     *                       one column for the class break. For a non-empty
     *                       list, there needs to be as many entries in the
     *                       list as there are classes for the first column
     *                       ({@code cbColumnName1}). However, the column names
     *                       can be empty to indicate that for the
     *                       corresponding class of the first attribute, no
     *                       secondary class break will be applied. All the
     *                       column names in this list must be different from
     *                       the first column {@code cbColumnName1}. For
     *                       example, 'col2,col3,col2'.
     * @param cbVals2  Comma separated list of []-enclosed lists of values or
     *                 ranges; e.g. '[0:5,5:10],[of,on,so],[-50:-20]'. Each
     *                 square bracket enclosed list describes the secondary
     *                 classes for the respective attribute in {@code
     *                 cbColumnName2} and the respective class in {@code
     *                 cbColumnName1} / {@code cbVals1}.
     * @param minX  Lower bound for the x values.
     * @param maxX  Upper bound for the x values.
     * @param minY  Lower bound for the y values.
     * @param maxY  Upper bound for the y values.
     * @param width  Width of the generated image.
     * @param height  Height of the generated image.
     * @param projection  Spatial Reference System (i.e. EPSG Code).
     * @param bgColor  Background color of the generated image.
     * @param styleOptions  Styling options for the image.
     * @param options  Optional parameters.
     * 
     */
    public VisualizeImageClassbreakRequest(List<String> tableNames, List<String> worldTableNames, String xColumnName, String yColumnName, List<List<String>> trackIds, String cbColumnName1, List<String> cbVals1, List<String> cbColumnName2, List<List<String>> cbVals2, double minX, double maxX, double minY, double maxY, int width, int height, String projection, long bgColor, Map<String, List<String>> styleOptions, Map<String, String> options) {
        this.tableNames = (tableNames == null) ? new ArrayList<String>() : tableNames;
        this.worldTableNames = (worldTableNames == null) ? new ArrayList<String>() : worldTableNames;
        this.xColumnName = (xColumnName == null) ? "" : xColumnName;
        this.yColumnName = (yColumnName == null) ? "" : yColumnName;
        this.trackIds = (trackIds == null) ? new ArrayList<List<String>>() : trackIds;
        this.cbColumnName1 = (cbColumnName1 == null) ? "" : cbColumnName1;
        this.cbVals1 = (cbVals1 == null) ? new ArrayList<String>() : cbVals1;
        this.cbColumnName2 = (cbColumnName2 == null) ? new ArrayList<String>() : cbColumnName2;
        this.cbVals2 = (cbVals2 == null) ? new ArrayList<List<String>>() : cbVals2;
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.width = width;
        this.height = height;
        this.projection = (projection == null) ? "" : projection;
        this.bgColor = bgColor;
        this.styleOptions = (styleOptions == null) ? new LinkedHashMap<String, List<String>>() : styleOptions;
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
    }

    /**
     * 
     * @return Name of the table containing the data for the various layers to
     *         be rendered.
     * 
     */
    public List<String> getTableNames() {
        return tableNames;
    }

    /**
     * 
     * @param tableNames  Name of the table containing the data for the various
     *                    layers to be rendered.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setTableNames(List<String> tableNames) {
        this.tableNames = (tableNames == null) ? new ArrayList<String>() : tableNames;
        return this;
    }

    /**
     * 
     * @return Optional name of the tables containing the data for the entire
     *         track when the {@code tableNames} contains only part of the
     *         track data, but the entire track has to be rendered.
     * 
     */
    public List<String> getWorldTableNames() {
        return worldTableNames;
    }

    /**
     * 
     * @param worldTableNames  Optional name of the tables containing the data
     *                         for the entire track when the {@code tableNames}
     *                         contains only part of the track data, but the
     *                         entire track has to be rendered.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setWorldTableNames(List<String> worldTableNames) {
        this.worldTableNames = (worldTableNames == null) ? new ArrayList<String>() : worldTableNames;
        return this;
    }

    /**
     * 
     * @return Name of the column containing the x coordinates.
     * 
     */
    public String getXColumnName() {
        return xColumnName;
    }

    /**
     * 
     * @param xColumnName  Name of the column containing the x coordinates.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setXColumnName(String xColumnName) {
        this.xColumnName = (xColumnName == null) ? "" : xColumnName;
        return this;
    }

    /**
     * 
     * @return Name of the column containing the y coordinates.
     * 
     */
    public String getYColumnName() {
        return yColumnName;
    }

    /**
     * 
     * @param yColumnName  Name of the column containing the y coordinates.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setYColumnName(String yColumnName) {
        this.yColumnName = (yColumnName == null) ? "" : yColumnName;
        return this;
    }

    /**
     * 
     * @return Tracks from the {@code tableNames} to be rendered.
     * 
     */
    public List<List<String>> getTrackIds() {
        return trackIds;
    }

    /**
     * 
     * @param trackIds  Tracks from the {@code tableNames} to be rendered.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setTrackIds(List<List<String>> trackIds) {
        this.trackIds = (trackIds == null) ? new ArrayList<List<String>>() : trackIds;
        return this;
    }

    /**
     * 
     * @return Name of the column for the first class break.
     * 
     */
    public String getCbColumnName1() {
        return cbColumnName1;
    }

    /**
     * 
     * @param cbColumnName1  Name of the column for the first class break.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setCbColumnName1(String cbColumnName1) {
        this.cbColumnName1 = (cbColumnName1 == null) ? "" : cbColumnName1;
        return this;
    }

    /**
     * 
     * @return Comma separated list of values or ranges (e.g.
     *         '0:5,5:10,15:30').
     * 
     */
    public List<String> getCbVals1() {
        return cbVals1;
    }

    /**
     * 
     * @param cbVals1  Comma separated list of values or ranges (e.g.
     *                 '0:5,5:10,15:30').
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setCbVals1(List<String> cbVals1) {
        this.cbVals1 = (cbVals1 == null) ? new ArrayList<String>() : cbVals1;
        return this;
    }

    /**
     * 
     * @return Optional comma seperated list of valid column names. An empty
     *         string implies not using more than one column for the class
     *         break. For a non-empty list, there needs to be as many entries
     *         in the list as there are classes for the first column ({@code
     *         cbColumnName1}). However, the column names can be empty to
     *         indicate that for the corresponding class of the first
     *         attribute, no secondary class break will be applied. All the
     *         column names in this list must be different from the first
     *         column {@code cbColumnName1}. For example, 'col2,col3,col2'.
     * 
     */
    public List<String> getCbColumnName2() {
        return cbColumnName2;
    }

    /**
     * 
     * @param cbColumnName2  Optional comma seperated list of valid column
     *                       names. An empty string implies not using more than
     *                       one column for the class break. For a non-empty
     *                       list, there needs to be as many entries in the
     *                       list as there are classes for the first column
     *                       ({@code cbColumnName1}). However, the column names
     *                       can be empty to indicate that for the
     *                       corresponding class of the first attribute, no
     *                       secondary class break will be applied. All the
     *                       column names in this list must be different from
     *                       the first column {@code cbColumnName1}. For
     *                       example, 'col2,col3,col2'.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setCbColumnName2(List<String> cbColumnName2) {
        this.cbColumnName2 = (cbColumnName2 == null) ? new ArrayList<String>() : cbColumnName2;
        return this;
    }

    /**
     * 
     * @return Comma separated list of []-enclosed lists of values or ranges;
     *         e.g. '[0:5,5:10],[of,on,so],[-50:-20]'. Each square bracket
     *         enclosed list describes the secondary classes for the respective
     *         attribute in {@code cbColumnName2} and the respective class in
     *         {@code cbColumnName1} / {@code cbVals1}.
     * 
     */
    public List<List<String>> getCbVals2() {
        return cbVals2;
    }

    /**
     * 
     * @param cbVals2  Comma separated list of []-enclosed lists of values or
     *                 ranges; e.g. '[0:5,5:10],[of,on,so],[-50:-20]'. Each
     *                 square bracket enclosed list describes the secondary
     *                 classes for the respective attribute in {@code
     *                 cbColumnName2} and the respective class in {@code
     *                 cbColumnName1} / {@code cbVals1}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setCbVals2(List<List<String>> cbVals2) {
        this.cbVals2 = (cbVals2 == null) ? new ArrayList<List<String>>() : cbVals2;
        return this;
    }

    /**
     * 
     * @return Lower bound for the x values.
     * 
     */
    public double getMinX() {
        return minX;
    }

    /**
     * 
     * @param minX  Lower bound for the x values.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setMinX(double minX) {
        this.minX = minX;
        return this;
    }

    /**
     * 
     * @return Upper bound for the x values.
     * 
     */
    public double getMaxX() {
        return maxX;
    }

    /**
     * 
     * @param maxX  Upper bound for the x values.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setMaxX(double maxX) {
        this.maxX = maxX;
        return this;
    }

    /**
     * 
     * @return Lower bound for the y values.
     * 
     */
    public double getMinY() {
        return minY;
    }

    /**
     * 
     * @param minY  Lower bound for the y values.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setMinY(double minY) {
        this.minY = minY;
        return this;
    }

    /**
     * 
     * @return Upper bound for the y values.
     * 
     */
    public double getMaxY() {
        return maxY;
    }

    /**
     * 
     * @param maxY  Upper bound for the y values.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setMaxY(double maxY) {
        this.maxY = maxY;
        return this;
    }

    /**
     * 
     * @return Width of the generated image.
     * 
     */
    public int getWidth() {
        return width;
    }

    /**
     * 
     * @param width  Width of the generated image.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setWidth(int width) {
        this.width = width;
        return this;
    }

    /**
     * 
     * @return Height of the generated image.
     * 
     */
    public int getHeight() {
        return height;
    }

    /**
     * 
     * @param height  Height of the generated image.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setHeight(int height) {
        this.height = height;
        return this;
    }

    /**
     * 
     * @return Spatial Reference System (i.e. EPSG Code).
     * 
     */
    public String getProjection() {
        return projection;
    }

    /**
     * 
     * @param projection  Spatial Reference System (i.e. EPSG Code).
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setProjection(String projection) {
        this.projection = (projection == null) ? "" : projection;
        return this;
    }

    /**
     * 
     * @return Background color of the generated image.
     * 
     */
    public long getBgColor() {
        return bgColor;
    }

    /**
     * 
     * @param bgColor  Background color of the generated image.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setBgColor(long bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    /**
     * 
     * @return Styling options for the image.
     * 
     */
    public Map<String, List<String>> getStyleOptions() {
        return styleOptions;
    }

    /**
     * 
     * @param styleOptions  Styling options for the image.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeImageClassbreakRequest setStyleOptions(Map<String, List<String>> styleOptions) {
        this.styleOptions = (styleOptions == null) ? new LinkedHashMap<String, List<String>>() : styleOptions;
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
    public VisualizeImageClassbreakRequest setOptions(Map<String, String> options) {
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
                return this.tableNames;

            case 1:
                return this.worldTableNames;

            case 2:
                return this.xColumnName;

            case 3:
                return this.yColumnName;

            case 4:
                return this.trackIds;

            case 5:
                return this.cbColumnName1;

            case 6:
                return this.cbVals1;

            case 7:
                return this.cbColumnName2;

            case 8:
                return this.cbVals2;

            case 9:
                return this.minX;

            case 10:
                return this.maxX;

            case 11:
                return this.minY;

            case 12:
                return this.maxY;

            case 13:
                return this.width;

            case 14:
                return this.height;

            case 15:
                return this.projection;

            case 16:
                return this.bgColor;

            case 17:
                return this.styleOptions;

            case 18:
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
                this.tableNames = (List<String>)value;
                break;

            case 1:
                this.worldTableNames = (List<String>)value;
                break;

            case 2:
                this.xColumnName = (String)value;
                break;

            case 3:
                this.yColumnName = (String)value;
                break;

            case 4:
                this.trackIds = (List<List<String>>)value;
                break;

            case 5:
                this.cbColumnName1 = (String)value;
                break;

            case 6:
                this.cbVals1 = (List<String>)value;
                break;

            case 7:
                this.cbColumnName2 = (List<String>)value;
                break;

            case 8:
                this.cbVals2 = (List<List<String>>)value;
                break;

            case 9:
                this.minX = (Double)value;
                break;

            case 10:
                this.maxX = (Double)value;
                break;

            case 11:
                this.minY = (Double)value;
                break;

            case 12:
                this.maxY = (Double)value;
                break;

            case 13:
                this.width = (Integer)value;
                break;

            case 14:
                this.height = (Integer)value;
                break;

            case 15:
                this.projection = (String)value;
                break;

            case 16:
                this.bgColor = (Long)value;
                break;

            case 17:
                this.styleOptions = (Map<String, List<String>>)value;
                break;

            case 18:
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

        VisualizeImageClassbreakRequest that = (VisualizeImageClassbreakRequest)obj;

        return ( this.tableNames.equals( that.tableNames )
                 && this.worldTableNames.equals( that.worldTableNames )
                 && this.xColumnName.equals( that.xColumnName )
                 && this.yColumnName.equals( that.yColumnName )
                 && this.trackIds.equals( that.trackIds )
                 && this.cbColumnName1.equals( that.cbColumnName1 )
                 && this.cbVals1.equals( that.cbVals1 )
                 && this.cbColumnName2.equals( that.cbColumnName2 )
                 && this.cbVals2.equals( that.cbVals2 )
                 && ( (Double)this.minX ).equals( (Double)that.minX )
                 && ( (Double)this.maxX ).equals( (Double)that.maxX )
                 && ( (Double)this.minY ).equals( (Double)that.minY )
                 && ( (Double)this.maxY ).equals( (Double)that.maxY )
                 && ( this.width == that.width )
                 && ( this.height == that.height )
                 && this.projection.equals( that.projection )
                 && ( this.bgColor == that.bgColor )
                 && this.styleOptions.equals( that.styleOptions )
                 && this.options.equals( that.options ) );
    }

    @Override
    public String toString() {
        GenericData gd = GenericData.get();
        StringBuilder builder = new StringBuilder();
        builder.append( "{" );
        builder.append( gd.toString( "tableNames" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.tableNames ) );
        builder.append( ", " );
        builder.append( gd.toString( "worldTableNames" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.worldTableNames ) );
        builder.append( ", " );
        builder.append( gd.toString( "xColumnName" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.xColumnName ) );
        builder.append( ", " );
        builder.append( gd.toString( "yColumnName" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.yColumnName ) );
        builder.append( ", " );
        builder.append( gd.toString( "trackIds" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.trackIds ) );
        builder.append( ", " );
        builder.append( gd.toString( "cbColumnName1" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.cbColumnName1 ) );
        builder.append( ", " );
        builder.append( gd.toString( "cbVals1" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.cbVals1 ) );
        builder.append( ", " );
        builder.append( gd.toString( "cbColumnName2" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.cbColumnName2 ) );
        builder.append( ", " );
        builder.append( gd.toString( "cbVals2" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.cbVals2 ) );
        builder.append( ", " );
        builder.append( gd.toString( "minX" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.minX ) );
        builder.append( ", " );
        builder.append( gd.toString( "maxX" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.maxX ) );
        builder.append( ", " );
        builder.append( gd.toString( "minY" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.minY ) );
        builder.append( ", " );
        builder.append( gd.toString( "maxY" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.maxY ) );
        builder.append( ", " );
        builder.append( gd.toString( "width" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.width ) );
        builder.append( ", " );
        builder.append( gd.toString( "height" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.height ) );
        builder.append( ", " );
        builder.append( gd.toString( "projection" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.projection ) );
        builder.append( ", " );
        builder.append( gd.toString( "bgColor" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.bgColor ) );
        builder.append( ", " );
        builder.append( gd.toString( "styleOptions" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.styleOptions ) );
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
        hashCode = (31 * hashCode) + this.tableNames.hashCode();
        hashCode = (31 * hashCode) + this.worldTableNames.hashCode();
        hashCode = (31 * hashCode) + this.xColumnName.hashCode();
        hashCode = (31 * hashCode) + this.yColumnName.hashCode();
        hashCode = (31 * hashCode) + this.trackIds.hashCode();
        hashCode = (31 * hashCode) + this.cbColumnName1.hashCode();
        hashCode = (31 * hashCode) + this.cbVals1.hashCode();
        hashCode = (31 * hashCode) + this.cbColumnName2.hashCode();
        hashCode = (31 * hashCode) + this.cbVals2.hashCode();
        hashCode = (31 * hashCode) + ((Double)this.minX).hashCode();
        hashCode = (31 * hashCode) + ((Double)this.maxX).hashCode();
        hashCode = (31 * hashCode) + ((Double)this.minY).hashCode();
        hashCode = (31 * hashCode) + ((Double)this.maxY).hashCode();
        hashCode = (31 * hashCode) + this.width;
        hashCode = (31 * hashCode) + this.height;
        hashCode = (31 * hashCode) + this.projection.hashCode();
        hashCode = (31 * hashCode) + ((Long)this.bgColor).hashCode();
        hashCode = (31 * hashCode) + this.styleOptions.hashCode();
        hashCode = (31 * hashCode) + this.options.hashCode();
        return hashCode;
    }

}

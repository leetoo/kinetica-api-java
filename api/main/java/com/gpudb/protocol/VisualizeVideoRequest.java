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
 * com.gpudb.GPUdb#visualizeVideo(VisualizeVideoRequest)}.
 * <p>
 * Creates raster images of data in the given table based on provided input
 * parameters. Numerous parameters are required to call this function. Some of
 * the important parameters are the attributes of the generated images ({@code
 * bgColor}, {@code width}, @{input height{), the collection of GPUdb table
 * names on which this function is to be applied, for which shapes (point,
 * polygon, tracks) the images are to be created and a user specified session
 * key. This session key is later used to fetch the generated images stored by
 * GPUdb. The operation is synchronous meaning that GPUdb will not return the
 * request until the images for all the frames of the video are fully
 * available.
 * <p>
 * Once the request has been processed then the generated video frames are
 * available for download via WMS using STYLES=cached. In this request the
 * LAYERS parameter should be populated with the session key passed in {@code
 * sessionKey} of the visualize video request and the FRAME parameter indicates
 * which 0-based frame of the video should be returned. All other WMS
 * parameters are ignored for this mode.
 * <p>
 * For instance, if a 20 frame video with the session key 'MY-SESSION-KEY' was
 * generated, the first frame could be retrieved with the URL::
 * <p>
 *      http://<gpudb-ip-address>:9191/wms?REQUEST=GetMap&STYLES=cached&LAYERS
 * =MY-SESSION-KEY&FRAME=0
 * <p>
 * and the last frame could be retrieved with::
 * <p>
 *     http://gpudb-ip-address:9191/wms?REQUEST=GetMap&STYLES=cached&LAYERS=MY-
 * SESSION-KEY&FRAME=19
 * <p>

 * <p>

 * The response payload provides, among other things, the number of frames
 * which were created by GPUdb.
 */
public class VisualizeVideoRequest implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("VisualizeVideoRequest")
            .namespace("com.gpudb")
            .fields()
                .name("tableNames").type().array().items().stringType().noDefault()
                .name("worldTableNames").type().array().items().stringType().noDefault()
                .name("trackIds").type().array().items().array().items().stringType().noDefault()
                .name("xColumnName").type().stringType().noDefault()
                .name("yColumnName").type().stringType().noDefault()
                .name("minX").type().doubleType().noDefault()
                .name("maxX").type().doubleType().noDefault()
                .name("minY").type().doubleType().noDefault()
                .name("maxY").type().doubleType().noDefault()
                .name("width").type().intType().noDefault()
                .name("height").type().intType().noDefault()
                .name("projection").type().stringType().noDefault()
                .name("bgColor").type().longType().noDefault()
                .name("timeIntervals").type().array().items().array().items().doubleType().noDefault()
                .name("videoStyle").type().stringType().noDefault()
                .name("sessionKey").type().stringType().noDefault()
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
    private List<List<String>> trackIds;
    private String xColumnName;
    private String yColumnName;
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private int width;
    private int height;
    private String projection;
    private long bgColor;
    private List<List<Double>> timeIntervals;
    private String videoStyle;
    private String sessionKey;
    private Map<String, List<String>> styleOptions;
    private Map<String, String> options;


    /**
     * Constructs a VisualizeVideoRequest object with default parameters.
     */
    public VisualizeVideoRequest() {
        tableNames = new ArrayList<>();
        worldTableNames = new ArrayList<>();
        trackIds = new ArrayList<>();
        xColumnName = "";
        yColumnName = "";
        projection = "";
        timeIntervals = new ArrayList<>();
        videoStyle = "";
        sessionKey = "";
        styleOptions = new LinkedHashMap<>();
        options = new LinkedHashMap<>();
    }

    /**
     * Constructs a VisualizeVideoRequest object with the specified parameters.
     * 
     * @param tableNames  Names of the tables containing the data for various
     *                    layers of the resulting video.
     * @param worldTableNames  Optional name of the tables containing the data
     *                         for the entire track when the {@code tableNames}
     *                         contains only part of the track data, but the
     *                         entire track has to be rendered. The number of
     *                         tables should match the number of tables in the
     *                         {@code tableNames}
     * @param trackIds  Tracks from the {@code tableNames} to be rendered.
     * @param xColumnName  Name of the column containing the x coordinates.
     * @param yColumnName  Name of the column containing the y coordinates.
     * @param minX  Lower bound for the x values.
     * @param maxX  Upper bound for the x values.
     * @param minY  Lower bound for the y values.
     * @param maxY  Upper bound for the y values.
     * @param width  Width of the generated image.
     * @param height  Height of the generated image.
     * @param projection  Spatial Reference System (i.e. EPSG Code).
     * @param bgColor  Background color of the generated image.
     * @param timeIntervals
     * @param videoStyle
     * @param sessionKey  User Provided session key that is later used to
     *                    retrieve the generated video from the WMS.
     * @param styleOptions  Styling options for the image.
     * @param options  Optional parameters.
     * 
     */
    public VisualizeVideoRequest(List<String> tableNames, List<String> worldTableNames, List<List<String>> trackIds, String xColumnName, String yColumnName, double minX, double maxX, double minY, double maxY, int width, int height, String projection, long bgColor, List<List<Double>> timeIntervals, String videoStyle, String sessionKey, Map<String, List<String>> styleOptions, Map<String, String> options) {
        this.tableNames = (tableNames == null) ? new ArrayList<String>() : tableNames;
        this.worldTableNames = (worldTableNames == null) ? new ArrayList<String>() : worldTableNames;
        this.trackIds = (trackIds == null) ? new ArrayList<List<String>>() : trackIds;
        this.xColumnName = (xColumnName == null) ? "" : xColumnName;
        this.yColumnName = (yColumnName == null) ? "" : yColumnName;
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.width = width;
        this.height = height;
        this.projection = (projection == null) ? "" : projection;
        this.bgColor = bgColor;
        this.timeIntervals = (timeIntervals == null) ? new ArrayList<List<Double>>() : timeIntervals;
        this.videoStyle = (videoStyle == null) ? "" : videoStyle;
        this.sessionKey = (sessionKey == null) ? "" : sessionKey;
        this.styleOptions = (styleOptions == null) ? new LinkedHashMap<String, List<String>>() : styleOptions;
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
    }

    /**
     * 
     * @return Names of the tables containing the data for various layers of
     *         the resulting video.
     * 
     */
    public List<String> getTableNames() {
        return tableNames;
    }

    /**
     * 
     * @param tableNames  Names of the tables containing the data for various
     *                    layers of the resulting video.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeVideoRequest setTableNames(List<String> tableNames) {
        this.tableNames = (tableNames == null) ? new ArrayList<String>() : tableNames;
        return this;
    }

    /**
     * 
     * @return Optional name of the tables containing the data for the entire
     *         track when the {@code tableNames} contains only part of the
     *         track data, but the entire track has to be rendered. The number
     *         of tables should match the number of tables in the {@code
     *         tableNames}
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
     *                         entire track has to be rendered. The number of
     *                         tables should match the number of tables in the
     *                         {@code tableNames}
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeVideoRequest setWorldTableNames(List<String> worldTableNames) {
        this.worldTableNames = (worldTableNames == null) ? new ArrayList<String>() : worldTableNames;
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
    public VisualizeVideoRequest setTrackIds(List<List<String>> trackIds) {
        this.trackIds = (trackIds == null) ? new ArrayList<List<String>>() : trackIds;
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
    public VisualizeVideoRequest setXColumnName(String xColumnName) {
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
    public VisualizeVideoRequest setYColumnName(String yColumnName) {
        this.yColumnName = (yColumnName == null) ? "" : yColumnName;
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
    public VisualizeVideoRequest setMinX(double minX) {
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
    public VisualizeVideoRequest setMaxX(double maxX) {
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
    public VisualizeVideoRequest setMinY(double minY) {
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
    public VisualizeVideoRequest setMaxY(double maxY) {
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
    public VisualizeVideoRequest setWidth(int width) {
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
    public VisualizeVideoRequest setHeight(int height) {
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
    public VisualizeVideoRequest setProjection(String projection) {
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
    public VisualizeVideoRequest setBgColor(long bgColor) {
        this.bgColor = bgColor;
        return this;
    }
    public List<List<Double>> getTimeIntervals() {
        return timeIntervals;
    }

    /**
     * 
     * @param timeIntervals
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeVideoRequest setTimeIntervals(List<List<Double>> timeIntervals) {
        this.timeIntervals = (timeIntervals == null) ? new ArrayList<List<Double>>() : timeIntervals;
        return this;
    }
    public String getVideoStyle() {
        return videoStyle;
    }

    /**
     * 
     * @param videoStyle
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeVideoRequest setVideoStyle(String videoStyle) {
        this.videoStyle = (videoStyle == null) ? "" : videoStyle;
        return this;
    }

    /**
     * 
     * @return User Provided session key that is later used to retrieve the
     *         generated video from the WMS.
     * 
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * 
     * @param sessionKey  User Provided session key that is later used to
     *                    retrieve the generated video from the WMS.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public VisualizeVideoRequest setSessionKey(String sessionKey) {
        this.sessionKey = (sessionKey == null) ? "" : sessionKey;
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
    public VisualizeVideoRequest setStyleOptions(Map<String, List<String>> styleOptions) {
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
    public VisualizeVideoRequest setOptions(Map<String, String> options) {
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
                return this.trackIds;

            case 3:
                return this.xColumnName;

            case 4:
                return this.yColumnName;

            case 5:
                return this.minX;

            case 6:
                return this.maxX;

            case 7:
                return this.minY;

            case 8:
                return this.maxY;

            case 9:
                return this.width;

            case 10:
                return this.height;

            case 11:
                return this.projection;

            case 12:
                return this.bgColor;

            case 13:
                return this.timeIntervals;

            case 14:
                return this.videoStyle;

            case 15:
                return this.sessionKey;

            case 16:
                return this.styleOptions;

            case 17:
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
                this.trackIds = (List<List<String>>)value;
                break;

            case 3:
                this.xColumnName = (String)value;
                break;

            case 4:
                this.yColumnName = (String)value;
                break;

            case 5:
                this.minX = (Double)value;
                break;

            case 6:
                this.maxX = (Double)value;
                break;

            case 7:
                this.minY = (Double)value;
                break;

            case 8:
                this.maxY = (Double)value;
                break;

            case 9:
                this.width = (Integer)value;
                break;

            case 10:
                this.height = (Integer)value;
                break;

            case 11:
                this.projection = (String)value;
                break;

            case 12:
                this.bgColor = (Long)value;
                break;

            case 13:
                this.timeIntervals = (List<List<Double>>)value;
                break;

            case 14:
                this.videoStyle = (String)value;
                break;

            case 15:
                this.sessionKey = (String)value;
                break;

            case 16:
                this.styleOptions = (Map<String, List<String>>)value;
                break;

            case 17:
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

        VisualizeVideoRequest that = (VisualizeVideoRequest)obj;

        return ( this.tableNames.equals( that.tableNames )
                 && this.worldTableNames.equals( that.worldTableNames )
                 && this.trackIds.equals( that.trackIds )
                 && this.xColumnName.equals( that.xColumnName )
                 && this.yColumnName.equals( that.yColumnName )
                 && ( (Double)this.minX ).equals( (Double)that.minX )
                 && ( (Double)this.maxX ).equals( (Double)that.maxX )
                 && ( (Double)this.minY ).equals( (Double)that.minY )
                 && ( (Double)this.maxY ).equals( (Double)that.maxY )
                 && ( this.width == that.width )
                 && ( this.height == that.height )
                 && this.projection.equals( that.projection )
                 && ( this.bgColor == that.bgColor )
                 && this.timeIntervals.equals( that.timeIntervals )
                 && this.videoStyle.equals( that.videoStyle )
                 && this.sessionKey.equals( that.sessionKey )
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
        builder.append( gd.toString( "trackIds" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.trackIds ) );
        builder.append( ", " );
        builder.append( gd.toString( "xColumnName" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.xColumnName ) );
        builder.append( ", " );
        builder.append( gd.toString( "yColumnName" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.yColumnName ) );
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
        builder.append( gd.toString( "timeIntervals" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.timeIntervals ) );
        builder.append( ", " );
        builder.append( gd.toString( "videoStyle" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.videoStyle ) );
        builder.append( ", " );
        builder.append( gd.toString( "sessionKey" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.sessionKey ) );
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
        hashCode = (31 * hashCode) + this.trackIds.hashCode();
        hashCode = (31 * hashCode) + this.xColumnName.hashCode();
        hashCode = (31 * hashCode) + this.yColumnName.hashCode();
        hashCode = (31 * hashCode) + ((Double)this.minX).hashCode();
        hashCode = (31 * hashCode) + ((Double)this.maxX).hashCode();
        hashCode = (31 * hashCode) + ((Double)this.minY).hashCode();
        hashCode = (31 * hashCode) + ((Double)this.maxY).hashCode();
        hashCode = (31 * hashCode) + this.width;
        hashCode = (31 * hashCode) + this.height;
        hashCode = (31 * hashCode) + this.projection.hashCode();
        hashCode = (31 * hashCode) + ((Long)this.bgColor).hashCode();
        hashCode = (31 * hashCode) + this.timeIntervals.hashCode();
        hashCode = (31 * hashCode) + this.videoStyle.hashCode();
        hashCode = (31 * hashCode) + this.sessionKey.hashCode();
        hashCode = (31 * hashCode) + this.styleOptions.hashCode();
        hashCode = (31 * hashCode) + this.options.hashCode();
        return hashCode;
    }

}

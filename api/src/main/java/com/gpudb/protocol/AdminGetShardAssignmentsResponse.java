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
 * com.gpudb.GPUdb#adminGetShardAssignments(AdminGetShardAssignmentsRequest)}.
 */
public class AdminGetShardAssignmentsResponse implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("AdminGetShardAssignmentsResponse")
            .namespace("com.gpudb")
            .fields()
                .name("version").type().longType().noDefault()
                .name("shardAssignmentsRank").type().array().items().intType().noDefault()
                .name("shardAssignmentsTom").type().array().items().intType().noDefault()
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

    private long version;
    private List<Integer> shardAssignmentsRank;
    private List<Integer> shardAssignmentsTom;


    /**
     * Constructs an AdminGetShardAssignmentsResponse object with default
     * parameters.
     */
    public AdminGetShardAssignmentsResponse() {
    }
    public long getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public AdminGetShardAssignmentsResponse setVersion(long version) {
        this.version = version;
        return this;
    }
    public List<Integer> getShardAssignmentsRank() {
        return shardAssignmentsRank;
    }

    /**
     * 
     * @param shardAssignmentsRank
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public AdminGetShardAssignmentsResponse setShardAssignmentsRank(List<Integer> shardAssignmentsRank) {
        this.shardAssignmentsRank = (shardAssignmentsRank == null) ? new ArrayList<Integer>() : shardAssignmentsRank;
        return this;
    }
    public List<Integer> getShardAssignmentsTom() {
        return shardAssignmentsTom;
    }

    /**
     * 
     * @param shardAssignmentsTom
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public AdminGetShardAssignmentsResponse setShardAssignmentsTom(List<Integer> shardAssignmentsTom) {
        this.shardAssignmentsTom = (shardAssignmentsTom == null) ? new ArrayList<Integer>() : shardAssignmentsTom;
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
                return this.version;

            case 1:
                return this.shardAssignmentsRank;

            case 2:
                return this.shardAssignmentsTom;

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
                this.version = (Long)value;
                break;

            case 1:
                this.shardAssignmentsRank = (List<Integer>)value;
                break;

            case 2:
                this.shardAssignmentsTom = (List<Integer>)value;
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

        AdminGetShardAssignmentsResponse that = (AdminGetShardAssignmentsResponse)obj;

        return ( ( this.version == that.version )
                 && this.shardAssignmentsRank.equals( that.shardAssignmentsRank )
                 && this.shardAssignmentsTom.equals( that.shardAssignmentsTom ) );
    }

    @Override
    public String toString() {
        GenericData gd = GenericData.get();
        StringBuilder builder = new StringBuilder();
        builder.append( "{" );
        builder.append( gd.toString( "version" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.version ) );
        builder.append( ", " );
        builder.append( gd.toString( "shardAssignmentsRank" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.shardAssignmentsRank ) );
        builder.append( ", " );
        builder.append( gd.toString( "shardAssignmentsTom" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.shardAssignmentsTom ) );
        builder.append( "}" );

        return builder.toString();
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = (31 * hashCode) + ((Long)this.version).hashCode();
        hashCode = (31 * hashCode) + this.shardAssignmentsRank.hashCode();
        hashCode = (31 * hashCode) + this.shardAssignmentsTom.hashCode();
        return hashCode;
    }

}
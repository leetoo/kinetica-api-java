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
 * com.gpudb.GPUdb#revokePermissionSystem(RevokePermissionSystemRequest)}.
 * <p>
 * Revokes a system-level permission from a user or role.
 */
public class RevokePermissionSystemRequest implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("RevokePermissionSystemRequest")
            .namespace("com.gpudb")
            .fields()
                .name("name").type().stringType().noDefault()
                .name("permission").type().stringType().noDefault()
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
     * Permission to revoke from the user or role. Values: system_admin,
     * system_write, system_read.

     * A set of string constants for the parameter {@code permission}.
     */
    public static final class Permission {

        /**
         * Full access to all data and system functions.
         */
        public static final String SYSTEM_ADMIN = "system_admin";

        /**
         * Read and write access to all tables.
         */
        public static final String SYSTEM_WRITE = "system_write";

        /**
         * Read-only access to all tables.
         */
        public static final String SYSTEM_READ = "system_read";

        private Permission() {  }
    }

    private String name;
    private String permission;
    private Map<String, String> options;


    /**
     * Constructs a RevokePermissionSystemRequest object with default
     * parameters.
     */
    public RevokePermissionSystemRequest() {
        name = "";
        permission = "";
        options = new LinkedHashMap<>();
    }

    /**
     * Constructs a RevokePermissionSystemRequest object with the specified
     * parameters.
     * 
     * @param name  Name of the user or role from which the permission will be
     *              revoked. Must be an existing user or role.
     * @param permission  Permission to revoke from the user or role. Values:
     *                    system_admin, system_write, system_read.
     * @param options  Optional parameters.
     * 
     */
    public RevokePermissionSystemRequest(String name, String permission, Map<String, String> options) {
        this.name = (name == null) ? "" : name;
        this.permission = (permission == null) ? "" : permission;
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
    }

    /**
     * 
     * @return Name of the user or role from which the permission will be
     *         revoked. Must be an existing user or role.
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name  Name of the user or role from which the permission will be
     *              revoked. Must be an existing user or role.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public RevokePermissionSystemRequest setName(String name) {
        this.name = (name == null) ? "" : name;
        return this;
    }

    /**
     * 
     * @return Permission to revoke from the user or role. Values:
     *         system_admin, system_write, system_read.
     * 
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 
     * @param permission  Permission to revoke from the user or role. Values:
     *                    system_admin, system_write, system_read.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public RevokePermissionSystemRequest setPermission(String permission) {
        this.permission = (permission == null) ? "" : permission;
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
    public RevokePermissionSystemRequest setOptions(Map<String, String> options) {
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
                return this.name;

            case 1:
                return this.permission;

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
                this.name = (String)value;
                break;

            case 1:
                this.permission = (String)value;
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

        RevokePermissionSystemRequest that = (RevokePermissionSystemRequest)obj;

        return ( this.name.equals( that.name )
                 && this.permission.equals( that.permission )
                 && this.options.equals( that.options ) );
    }

    @Override
    public String toString() {
        GenericData gd = GenericData.get();
        StringBuilder builder = new StringBuilder();
        builder.append( "{" );
        builder.append( gd.toString( "name" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.name ) );
        builder.append( ", " );
        builder.append( gd.toString( "permission" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.permission ) );
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
        hashCode = (31 * hashCode) + this.name.hashCode();
        hashCode = (31 * hashCode) + this.permission.hashCode();
        hashCode = (31 * hashCode) + this.options.hashCode();
        return hashCode;
    }

}

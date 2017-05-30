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
 * com.gpudb.GPUdb#revokePermissionTable(RevokePermissionTableRequest)}.
 * <p>
 * Revokes a table-level permission from a user or role.
 */
public class RevokePermissionTableRequest implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("RevokePermissionTableRequest")
            .namespace("com.gpudb")
            .fields()
                .name("name").type().stringType().noDefault()
                .name("permission").type().stringType().noDefault()
                .name("tableName").type().stringType().noDefault()
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
     * Permission to revoke from the user or role. Values: table_admin,
     * table_insert, table_update, table_delete, table_read.

     * A set of string constants for the parameter {@code permission}.
     */
    public static final class Permission {

        /**
         * Full read/write and administrative access to the table.
         */
        public static final String TABLE_ADMIN = "table_admin";

        /**
         * Insert access to the table.
         */
        public static final String TABLE_INSERT = "table_insert";

        /**
         * Update access to the table.
         */
        public static final String TABLE_UPDATE = "table_update";

        /**
         * Delete access to the table.
         */
        public static final String TABLE_DELETE = "table_delete";

        /**
         * Read access to the table.
         */
        public static final String TABLE_READ = "table_read";

        private Permission() {  }
    }

    private String name;
    private String permission;
    private String tableName;
    private Map<String, String> options;


    /**
     * Constructs a RevokePermissionTableRequest object with default
     * parameters.
     */
    public RevokePermissionTableRequest() {
        name = "";
        permission = "";
        tableName = "";
        options = new LinkedHashMap<>();
    }

    /**
     * Constructs a RevokePermissionTableRequest object with the specified
     * parameters.
     * 
     * @param name  Name of the user or role from which the permission will be
     *              revoked. Must be an existing user or role.
     * @param permission  Permission to revoke from the user or role. Values:
     *                    table_admin, table_insert, table_update,
     *                    table_delete, table_read.
     * @param tableName  Name of the table to which the permission grants
     *                   access. Must be an existing table, collection, or
     *                   view.
     * @param options  Optional parameters.
     * 
     */
    public RevokePermissionTableRequest(String name, String permission, String tableName, Map<String, String> options) {
        this.name = (name == null) ? "" : name;
        this.permission = (permission == null) ? "" : permission;
        this.tableName = (tableName == null) ? "" : tableName;
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
    public RevokePermissionTableRequest setName(String name) {
        this.name = (name == null) ? "" : name;
        return this;
    }

    /**
     * 
     * @return Permission to revoke from the user or role. Values: table_admin,
     *         table_insert, table_update, table_delete, table_read.
     * 
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 
     * @param permission  Permission to revoke from the user or role. Values:
     *                    table_admin, table_insert, table_update,
     *                    table_delete, table_read.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public RevokePermissionTableRequest setPermission(String permission) {
        this.permission = (permission == null) ? "" : permission;
        return this;
    }

    /**
     * 
     * @return Name of the table to which the permission grants access. Must be
     *         an existing table, collection, or view.
     * 
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 
     * @param tableName  Name of the table to which the permission grants
     *                   access. Must be an existing table, collection, or
     *                   view.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public RevokePermissionTableRequest setTableName(String tableName) {
        this.tableName = (tableName == null) ? "" : tableName;
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
    public RevokePermissionTableRequest setOptions(Map<String, String> options) {
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
                return this.tableName;

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
                this.name = (String)value;
                break;

            case 1:
                this.permission = (String)value;
                break;

            case 2:
                this.tableName = (String)value;
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

        RevokePermissionTableRequest that = (RevokePermissionTableRequest)obj;

        return ( this.name.equals( that.name )
                 && this.permission.equals( that.permission )
                 && this.tableName.equals( that.tableName )
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
        builder.append( gd.toString( "tableName" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.tableName ) );
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
        hashCode = (31 * hashCode) + this.tableName.hashCode();
        hashCode = (31 * hashCode) + this.options.hashCode();
        return hashCode;
    }

}

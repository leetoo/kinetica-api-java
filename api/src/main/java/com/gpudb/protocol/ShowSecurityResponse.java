/*
 *  This file was autogenerated by the GPUdb schema processor.
 *
 *  DO NOT EDIT DIRECTLY.
 */
package com.gpudb.protocol;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.IndexedRecord;


/**
 * A set of results returned by {@link
 * com.gpudb.GPUdb#showSecurity(ShowSecurityRequest)}.
 */
public class ShowSecurityResponse implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("ShowSecurityResponse")
            .namespace("com.gpudb")
            .fields()
                .name("types").type().map().values().stringType().noDefault()
                .name("roles").type().map().values().array().items().stringType().noDefault()
                .name("permissions").type().map().values().array().items().map().values().stringType().noDefault()
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
     * Map of user/role name to the type of that user/role.
     * A set of string constants for the parameter {@code types}.
     */
    public static final class Types {

        /**
         * A user whose credentials are managed by the database system.
         */
        public static final String INTERNAL_USER = "internal_user";

        /**
         * A user whose credentials are managed by an external LDAP.
         */
        public static final String EXTERNAL_USER = "external_user";

        /**
         * A role.
         */
        public static final String ROLE = "role";

        private Types() {  }
    }

    private Map<String, String> types;
    private Map<String, List<String>> roles;
    private Map<String, List<Map<String, String>>> permissions;


    /**
     * Constructs a ShowSecurityResponse object with default parameters.
     */
    public ShowSecurityResponse() {
    }

    /**
     * 
     * @return Map of user/role name to the type of that user/role.
     * 
     */
    public Map<String, String> getTypes() {
        return types;
    }

    /**
     * 
     * @param types  Map of user/role name to the type of that user/role.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowSecurityResponse setTypes(Map<String, String> types) {
        this.types = (types == null) ? new LinkedHashMap<String, String>() : types;
        return this;
    }

    /**
     * 
     * @return Map of user/role name to a list of names of roles of which that
     *         user/role is a member.
     * 
     */
    public Map<String, List<String>> getRoles() {
        return roles;
    }

    /**
     * 
     * @param roles  Map of user/role name to a list of names of roles of which
     *               that user/role is a member.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowSecurityResponse setRoles(Map<String, List<String>> roles) {
        this.roles = (roles == null) ? new LinkedHashMap<String, List<String>>() : roles;
        return this;
    }

    /**
     * 
     * @return Map of user/role name to a list of permissions directly granted
     *         to that user/role.
     * 
     */
    public Map<String, List<Map<String, String>>> getPermissions() {
        return permissions;
    }

    /**
     * 
     * @param permissions  Map of user/role name to a list of permissions
     *                     directly granted to that user/role.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowSecurityResponse setPermissions(Map<String, List<Map<String, String>>> permissions) {
        this.permissions = (permissions == null) ? new LinkedHashMap<String, List<Map<String, String>>>() : permissions;
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
                return this.types;

            case 1:
                return this.roles;

            case 2:
                return this.permissions;

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
                this.types = (Map<String, String>)value;
                break;

            case 1:
                this.roles = (Map<String, List<String>>)value;
                break;

            case 2:
                this.permissions = (Map<String, List<Map<String, String>>>)value;
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

        ShowSecurityResponse that = (ShowSecurityResponse)obj;

        return ( this.types.equals( that.types )
                 && this.roles.equals( that.roles )
                 && this.permissions.equals( that.permissions ) );
    }

    @Override
    public String toString() {
        GenericData gd = GenericData.get();
        StringBuilder builder = new StringBuilder();
        builder.append( "{" );
        builder.append( gd.toString( "types" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.types ) );
        builder.append( ", " );
        builder.append( gd.toString( "roles" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.roles ) );
        builder.append( ", " );
        builder.append( gd.toString( "permissions" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.permissions ) );
        builder.append( "}" );

        return builder.toString();
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = (31 * hashCode) + this.types.hashCode();
        hashCode = (31 * hashCode) + this.roles.hashCode();
        hashCode = (31 * hashCode) + this.permissions.hashCode();
        return hashCode;
    }

}

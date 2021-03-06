package com.gpudb;

import com.gpudb.protocol.ShowTableResponse;
import com.gpudb.protocol.ShowTypesResponse;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;
import org.apache.avro.generic.GenericData;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

/**
 * Immutable collection of metadata about a GPUdb type.
 */
public final class Type {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * Immutable collection of metadata about a column that is part of a GPUdb
     * type.
     */
    public static final class Column {
        private String name;
        private Class<?> type;
        private boolean isNullable;
        private List<String> properties;

        /**
         * Creates a {@link Column} object with the specified metadata.
         *
         * @param name        the name of the column
         * @param type        the Java data type of the column
         * @param properties  the list of properties that apply to the column;
         *                    defaults to none
         *
         * @throws IllegalArgumentException if {@code name} or any
         * {@code properties} are invalid, or if {@code type} is not one of the
         * following: {@link ByteBuffer}, {@link Double}, {@link Float},
         * {@link Integer}, {@link Long}, or {@link String}
         *
         * @see ColumnProperty
         */
        public Column(String name, Class<?> type, String... properties) {
            this(name, type, Arrays.asList(properties));
        }

        /**
         * Creates a {@link Column} object with the specified metadata.
         *
         * @param name        the name of the column
         * @param type        the Java data type of the column
         * @param properties  the list of properties that apply to the column;
         *                    defaults to none
         *
         * @throws IllegalArgumentException if {@code name} or any
         * {@code properties} are invalid, or if {@code type} is not one of the
         * following: {@link ByteBuffer}, {@link Double}, {@link Float},
         * {@link Integer}, {@link Long}, or {@link String}
         *
         * @see ColumnProperty
         */
        public Column(String name, Class<?> type, List<String> properties) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("Name must not be empty.");
            }

            if (type != ByteBuffer.class && type != Double.class
                    && type != Float.class && type != Integer.class
                    && type != Long.class && type != String.class) {
                throw new IllegalArgumentException("Column " + name + " must be of type ByteBuffer, Double, Float, Integer, Long or String.");
            }

            if (properties != null) {
                for (String property : properties) {
                    if (property == null) {
                        throw new IllegalArgumentException("Properties must not be null.");
                    }

                    if (property.isEmpty()) {
                        throw new IllegalArgumentException("Properties must not be empty.");
                    }

                    if (!isNullable && property.equals("nullable")) {
                        isNullable = true;
                    }
                }
            }

            this.name = name;
            this.type = type;
            this.properties = Collections.unmodifiableList(properties == null || properties.isEmpty() ? new ArrayList<String>() : new ArrayList<>(properties));
        }

        /**
         * Gets the name of the column.
         *
         * @return  the name of the column
         */
        public String getName() {
            return name;
        }

        /**
         * Gets the Java data type of the column.
         *
         * @return  the Java data type of the column
         */
        public Class<?> getType() {
            return type;
        }

        /**
         * Gets whether the column is nullable.
         *
         * @return  whether the column is nullable
         */
        public boolean isNullable() {
            return isNullable;
        }

        /**
         * Gets the list of properties that apply to the column.
         *
         * @return  the list of properties that apply to the column
         *
         * @see ColumnProperty
         */
        public List<String> getProperties() {
            return properties;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }

            Column that = (Column)obj;

            return that.name.equals(this.name)
                    && that.type == this.type
                    && that.properties.equals(this.properties);
        }

        @Override
        public int hashCode() {
            return (name.hashCode() * 31 + type.hashCode()) * 31 + properties.hashCode();
        }

        @Override
        public String toString() {
            GenericData gd = GenericData.get();
            StringBuilder builder = new StringBuilder();
            builder.append("{");
            builder.append("\"name\":").append(gd.toString(name)).append(",");
            builder.append("\"type\":\"").append(type.getSimpleName()).append("\",");
            builder.append("\"properties\":[");
            boolean output = false;

            for (String property : properties) {
                if (output) {
                    builder.append(",");
                }

                builder.append(gd.toString(property));
                output = true;
            }

            builder.append("]}");
            return builder.toString();
        }
    }

    /**
     * Creates a {@link Type} object containing metadata for the GPUdb type of
     * an existing table in GPUdb. Note that this method makes a request to
     * GPUdb to obtain the metadata.
     *
     * @param gpudb      the {@link GPUdb} instance from which to obtain the
     *                   metadata
     * @param tableName  the name of the table in GPUdb
     * @return           the created {@link Type} object
     *
     * @throws GPUdbException if the table does not exist or is not homogeneous,
     * or if an error occurs during the request for metadata
     */
    public static Type fromTable(GPUdb gpudb, String tableName) throws GPUdbException {
        ShowTableResponse response = gpudb.showTable(tableName, null);

        if (response.getTypeIds().isEmpty()) {
            throw new GPUdbException("Table " + tableName + " does not exist.");
        }

        if (response.getTypeIds().size() > 1) {
            String typeId = response.getTypeIds().get(0);

            for (int i = 1; i < response.getTypeIds().size(); i++) {
                if (!response.getTypeIds().get(i).equals(typeId)) {
                    throw new GPUdbException("Table " + tableName + " is not homogeneous.");
                }
            }
        }

        return new Type(response.getTypeLabels().get(0), response.getTypeSchemas().get(0), response.getProperties().get(0));
    }

    /**
     * Creates a {@link Type} object containing metadata for an existing type
     * in GPUdb. Note that this method makes a request to GPUdb to obtain the
     * metadata.
     *
     * @param gpudb   the {@link GPUdb} instance from which to obtain the
     *                metadata
     * @param typeId  the type ID of the type in GPUdb
     * @return        the created {@link Type} object
     *
     * @throws GPUdbException if the type does not exist or if an error occurs
     * during the request for metadata
     */
    public static Type fromType(GPUdb gpudb, String typeId) throws GPUdbException {
        ShowTypesResponse response = gpudb.showTypes(typeId, null, null);

        if (response.getTypeIds().isEmpty()) {
            throw new GPUdbException("Type " + typeId + " does not exist.");
        }

        return new Type(response.getLabels().get(0), response.getTypeSchemas().get(0), response.getProperties().get(0));
    }

    private String label;
    private List<Column> columns;
    private Map<String, Integer> columnMap;
    private Schema schema;

    /**
     * Creates a {@link Type} object with the specified column metadata and an
     * empty type label.
     *
     * @param columns  the list of columns that the type comprises
     *
     * @throws IllegalArgumentException if no columns are specified
     */
    public Type(Column... columns) {
        this("", Arrays.asList(columns));
    }

    /**
     * Creates a {@link Type} object with the specified column metadata and an
     * empty type label.
     *
     * @param columns  the list of columns that the type comprises
     *
     * @throws IllegalArgumentException if no columns are specified
     */
    public Type(List<Column> columns) {
        this("", columns);
    }

    /**
     * Creates a {@link Type} object with the specified metadata.
     *
     * @param label    a user-defined description string which can be used to
     *                 differentiate between data with otherwise identical
     *                 schemas
     * @param columns  the list of columns that the type comprises
     *
     * @throws IllegalArgumentException if no columns are specified
     */
    public Type(String label, Column... columns) {
        this(label, Arrays.asList(columns));
    }

    /**
     * Creates a {@link Type} object with the specified metadata.
     *
     * @param label    a user-defined description string which can be used to
     *                 differentiate between data with otherwise identical
     *                 schemas
     * @param columns  the list of columns that the type comprises
     *
     * @throws IllegalArgumentException if no columns are specified
     */
    public Type(String label, List<Column> columns) {
        if (columns == null || columns.isEmpty()) {
            throw new IllegalArgumentException("At least one column must be specified.");
        }

        this.label = label;
        this.columns = Collections.unmodifiableList(new ArrayList<>(columns));
        columnMap = new HashMap<>();

        for (int i = 0; i < columns.size(); i++) {
            Column column = columns.get(i);
            String columnName = column.getName();

            if (columnMap.containsKey(columnName)) {
                throw new IllegalArgumentException("Duplicate column name " + columnName+ " specified.");
            }

            columnMap.put(columnName, i);
        }

        createSchema();
    }

    /**
     * Creates a {@link Type} object with column metadata from an Avro record
     * schema and an empty type label.
     *
     * @param typeSchema  the Avro record schema for the type
     *
     * @throws IllegalArgumentException if {@code typeSchema} is invalid or
     * contains unsupported field types
     */
    public Type(String typeSchema) {
        this("", typeSchema, null);
    }

    /**
     * Creates a {@link Type} object with metadata in the format returned from
     * the GPUdb /show/table or /show/types endpoints.
     *
     * @param label       a user-defined description string which can be used to
     *                    differentiate between data with otherwise identical
     *                    schemas
     * @param typeSchema  the Avro record schema for the type
     * @param properties  an optional map of column names to lists of properties
     *                    that apply to those columns
     *
     * @throws IllegalArgumentException if {@code typeSchema} is invalid or
     * contains unsupported field types, or if any {@code properties} are
     * invalid
     */
    public Type(String label, String typeSchema, Map<String, List<String>> properties) {
        this.label = label;
        columns = new ArrayList<>();
        columnMap = new HashMap<>();
        JsonNode root;

        try {
            root = MAPPER.readTree(typeSchema);
        } catch (IOException ex) {
            throw new IllegalArgumentException("Schema is invalid.", ex);
        }

        JsonNode rootType = root.get("type");

        if (rootType == null || !"record".equals(rootType.getTextValue())) {
            throw new IllegalArgumentException("Schema must be of type record.");
        }

        JsonNode fields = root.get("fields");

        if (fields == null || !fields.isArray() || fields.size() == 0) {
            throw new IllegalArgumentException("Schema has no fields.");
        }

        Iterator<JsonNode> fieldIterator = fields.getElements();

        while (fieldIterator.hasNext()) {
            JsonNode field = fieldIterator.next();

            if (!field.isObject()) {
                throw new IllegalArgumentException("Schema has invalid field.");
            }

            JsonNode fieldName = field.get("name");

            if (fieldName == null || !fieldName.isTextual()) {
                throw new IllegalArgumentException("Schema has unnamed field.");
            }

            String columnName = fieldName.getTextValue();

            if (columnMap.containsKey(columnName)) {
                 throw new IllegalArgumentException("Duplicate field name " + columnName + ".");
            }

            JsonNode fieldType = field.get("type");

            if (fieldType == null) {
                throw new IllegalArgumentException("Field " + columnName + " has no type.");
            }

            if (!fieldType.isTextual() && !fieldType.isArray()) {
                throw new IllegalArgumentException("Field " + columnName + " has invalid type.");
            }

            String fieldTypeString = null;

            if (fieldType.isTextual()) {
                fieldTypeString = fieldType.getTextValue();
            } else {
                Iterator<JsonNode> fieldTypeIterator = fieldType.getElements();

                while (fieldTypeIterator.hasNext()) {
                    JsonNode fieldTypeElement = fieldTypeIterator.next();
                    boolean valid = false;

                    if (fieldTypeElement.isTextual()) {
                        String fieldTypeElementString = fieldTypeElement.getTextValue();

                        if (fieldTypeString != null && fieldTypeElementString.equals("null")) {
                            valid = true;
                        } else if (fieldTypeString == null) {
                            fieldTypeString = fieldTypeElementString;
                            valid = true;
                        }
                    }

                    if (!valid) {
                        throw new IllegalArgumentException("Field " + columnName + " has invalid type.");
                    }
                }

                if (fieldTypeString == null) {
                    throw new IllegalArgumentException("Field " + columnName + " has invalid type.");
                }
            }

            Class<?> columnType;

            switch (fieldTypeString) {
                case "bytes":
                    columnType = ByteBuffer.class;
                    break;

                case "double":
                    columnType = Double.class;
                    break;

                case "float":
                    columnType = Float.class;
                    break;

                case "int":
                    columnType = Integer.class;
                    break;

                case "long":
                    columnType = Long.class;
                    break;

                case "string":
                    columnType = String.class;
                    break;

                default:
                    throw new IllegalArgumentException("Field " + columnName + " must be of type bytes, double, float, int, long or string.");
            }

            columns.add(new Column(columnName, columnType, properties != null ? properties.get(columnName) : null));
            columnMap.put(columnName, columns.size() - 1);
        }

        columns = Collections.unmodifiableList(columns);
        createSchema();
    }

    private void createSchema() {
        schema = Schema.createRecord("type_name", null, null, false);
        List<Field> fields = new ArrayList<>();

        for (int i = 0; i < columns.size(); i++) {
            Column column = columns.get(i);
            String columnName = column.getName();
            StringBuilder fieldNameBuilder = new StringBuilder(columnName);

            for (int j = 0; j < fieldNameBuilder.length(); j++) {
                char c = fieldNameBuilder.charAt(j);

                if (!(j > 0 && c >= '0' && c <= '9')
                        && !(c >= 'A' && c <= 'Z')
                        && !(c >= 'a' && c <= 'z')
                        && c != '_') {
                    fieldNameBuilder.setCharAt(j, '_');
                }
            }

            String fieldName;

            for (int n = 1; ; n++) {
                fieldName = fieldNameBuilder.toString() + (n > 1 ? "_" + n : "");
                boolean found = false;

                for (int j = 0; j < columns.size(); j++) {
                    if (j == i) {
                        continue;
                    }

                    if (columns.get(j).getName().equals(fieldName)) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    for (Field field : fields) {
                        if (field.name().equals(fieldName)) {
                            found = true;
                            break;
                        }
                    }
                }

                if (!found) {
                    break;
                }
            }

            Class<?> columnType = column.getType();
            Schema fieldSchema;

            if (columnType == ByteBuffer.class) {
                fieldSchema = Schema.create(Schema.Type.BYTES);
            } else if (columnType == Double.class) {
                fieldSchema = Schema.create(Schema.Type.DOUBLE);
            } else if (columnType == Float.class) {
                fieldSchema = Schema.create(Schema.Type.FLOAT);
            } else if (columnType == Integer.class) {
                fieldSchema = Schema.create(Schema.Type.INT);
            } else if (columnType == Long.class) {
                fieldSchema = Schema.create(Schema.Type.LONG);
            } else if (columnType == String.class) {
                fieldSchema = Schema.create(Schema.Type.STRING);
            } else {
                throw new IllegalArgumentException("Column " + columnName + " must be of type ByteBuffer, Double, Float, Integer, Long or String.");
            }

            if (column.isNullable()) {
                fieldSchema = Schema.createUnion(fieldSchema, Schema.create(Schema.Type.NULL));
            }

            Field field = new Field(fieldName, fieldSchema, null, (Object)null);
            fields.add(field);
        }

        schema.setFields(fields);
    }

    /**
     * Gets the user-defined description string which can be used to
     * differentiate between data with otherwise identical schemas.
     *
     * @return  the label string
     */
    public String getLabel() {
        return label;
    }

    /**
     * Gets the list of columns that the type comprises.
     *
     * @return  the list of columns that the type comprises
     */
    public List<Column> getColumns() {
        return columns;
    }

    /**
     * Gets the column with the specified index.
     *
     * @param index  the column index
     * @return       the column with the specified index
     *
     * @throws IndexOutOfBoundsException if the specified index is out of range
     */
    public Column getColumn(int index) {
        return columns.get(index);
    }

    /**
     * Gets the column with the specified name.
     *
     * @param name  the column name
     * @return      the column with the specified name, or null if no such
     *              column exists
     */
    public Column getColumn(String name) {
        Integer index = columnMap.get(name);
        return index == null ? null : columns.get(index);
    }

    /**
     * Gets the number of columns.
     *
     * @return  the number of columns
     */
    public int getColumnCount() {
        return columns.size();
    }

    /**
     * Gets the index of the column with the specified name.
     *
     * @param name  the column name
     * @return      the index of the column with the specified name, or -1 if no
     *              such column exists
     */
    public int getColumnIndex(String name) {
        Integer result = columnMap.get(name);
        return result == null ? -1 : result;
    }

    /**
     * Gets the Avro record schema for the type.
     *
     * @return  the Avro record schema for the type
     */
    public Schema getSchema() {
        return schema;
    }

    /**
     * Creates a new {@link Record} based on the type.
     *
     * @return  a new {@link Record}
     */
    public Record newInstance() {
        return new GenericRecord(this);
    }

    /**
     * Creates a type in GPUdb based on the metadata in the {@link Type} object
     * and returns the type ID for reference. If an identical type already
     * exists in GPUdb, the type ID of the existing type will be returned and
     * no new type will be created.
     *
     * @param gpudb  the {@link GPUdb} instance in which to create the type
     * @return       the type ID of the type in GPUdb
     *
     * @throws GPUdbException if an error occurs while creating the type
     */
    public String create(GPUdb gpudb) throws GPUdbException {
        ObjectNode root = MAPPER.createObjectNode();
        root.put("type", "record");
        root.put("name", "type_name");
        ArrayNode fields = MAPPER.createArrayNode();
        LinkedHashMap<String, List<String>> properties = new LinkedHashMap<>();

        for (Column column : columns) {
            ObjectNode field = MAPPER.createObjectNode();
            String columnName = column.getName();
            field.put("name", columnName);
            Class<?> columnType = column.getType();
            String columnTypeString;

            if (columnType == ByteBuffer.class) {
                columnTypeString = "bytes";
            } else if (columnType == Double.class) {
                columnTypeString = "double";
            } else if (columnType == Float.class) {
                columnTypeString = "float";
            } else if (columnType == Integer.class) {
                columnTypeString = "int";
            } else if (columnType == Long.class) {
                columnTypeString = "long";
            } else if (columnType == String.class) {
                columnTypeString = "string";
            } else {
                throw new IllegalArgumentException("Column " + columnName + " must be of type ByteBuffer, Double, Float, Integer, Long or String.");
            }

            if (column.isNullable())
            {
                ArrayNode fieldArray = MAPPER.createArrayNode();
                fieldArray.add(columnTypeString);
                fieldArray.add("null");
                field.put("type", fieldArray);
            }
            else
            {
                field.put("type", columnTypeString);
            }

            fields.add(field);

            List<String> columnProperties = column.getProperties();

            if (!columnProperties.isEmpty()) {
                properties.put(columnName, columnProperties);
            }
        }

        root.put("fields", fields);
        return gpudb.createType(root.toString(), label, properties, null).getTypeId();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Type that = (Type)obj;

        return that.label.equals(this.label)
                && that.columns.equals(this.columns);
    }

    @Override
    public int hashCode() {
        return label.hashCode() * 31 + columns.hashCode();
    }

    @Override
    public String toString() {
        GenericData gd = GenericData.get();
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("\"label\":").append(gd.toString(label)).append(",");
        builder.append("\"columns\":[");
        boolean output = false;

        for (Column column : columns) {
            if (output) {
                builder.append(",");
            }

            builder.append(column.toString());
            output = true;
        }

        builder.append("]}");
        return builder.toString();
    }
}
//
// Java Client Library for Treasure Data Cloud
//
// Copyright (C) 2011 - 2012 Muga Nishizawa
//
//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at
//
//        http://www.apache.org/licenses/LICENSE-2.0
//
//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//
package com.treasure_data.model;

public class Table extends AbstractModel {
    public static enum Type {
        LOG, ITEM, UNKNOWN,
    }

    public static Type toType(String typeName) {
        if (typeName.equals("log")) {
            return Type.LOG;
        } else if (typeName.equals("item")) {
            return Type.ITEM;
        } else {
            return Type.UNKNOWN;
        }
    }

    public static String toTypeName(Type type) {
        switch (type) {
        case LOG:
            return "log";
        case ITEM:
            return "item";
        default:
            return "unknown";
        }
    }

    private Database database;

    private Type type;

    public Table(Database database, String name) {
        this(database, name, Table.Type.LOG);
    }

    public Table(Database database, String name, Type type) {
        super(name);
        this.database = database;
        this.type = type;
    }

    public Database getDatabase() {
        return database;
    }

    public String getName() {
        return super.getName();
    }

    public Type getType() {
        return type;
    }

}

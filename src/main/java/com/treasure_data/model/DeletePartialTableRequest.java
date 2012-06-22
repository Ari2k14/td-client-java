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

public class DeletePartialTableRequest extends TableSpecifyRequest<Table> {

    private long from;

    private long to;

    public DeletePartialTableRequest(Table table, long from, long to) {
        super(table);
        this.from = from;
        this.to = to;
        validateParameters();
    }

    private void validateParameters() {
        if (to <= 0 || to % 3600 != 0) {
            throw new IllegalArgumentException("Invalid parameter: to = " + from);
        }
        if (from <= 0 || to - from <= 0 || from % 3600 != 0) {
            throw new IllegalArgumentException("Invalid parameter: from = " + from);
        }
    }

    public long getFrom() {
        return from;
    }

    public long getTo() {
        return to;
    }
}

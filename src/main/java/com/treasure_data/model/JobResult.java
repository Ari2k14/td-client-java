//
// Java Client Library for Treasure Data Cloud
//
// Copyright (C) 2011 - 2013 Muga Nishizawa
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

import org.msgpack.unpacker.Unpacker;

public class JobResult extends AbstractModel {

    public static enum Format {
        MSGPACK, MSGPACKGZ, JSON, UNKNOWN,
    }

    public static Format toFormat(String formatName) {
        if (formatName.equals("msgpack")) {
            return Format.MSGPACK;
        } else if (formatName.equals("msgpack.gz")) {
            return Format.MSGPACKGZ;
        } else if (formatName.equals("json")) {
            return Format.JSON;
        } else {
            return Format.UNKNOWN;
        }
    }

    public static String toFormatName(Format format) {
        switch (format) {
        case MSGPACK:
            return "msgpack";
        case MSGPACKGZ:
            return "msgpack.gz";
        case JSON:
            return "json";
        default:
            return "unknown";
        }
    }

    private Job job;

    private Format format;

    private long resultSize;

    private Unpacker result;

    public JobResult(Job job) {
        super(job.getJobID());
        this.job = job;
        this.format = Format.MSGPACKGZ;
    }

    public Job getJob() {
        return job;
    }

    public void setResultSize(long size) {
        this.resultSize = size;
    }

    public long getResultSize() {
        return resultSize;
    }

    public void setResult(Unpacker result) {
        this.result = result;
    }

    public Unpacker getResult() {
        return result;
    }

    public Format getFormat() {
        return format;
    }
}

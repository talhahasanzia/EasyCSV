package com.talhahasanzia.csv.lib;

import com.talhahasanzia.csv.core.ParseCallback;
import com.talhahasanzia.csv.core.Parser;
import com.talhahasanzia.csv.core.Source;
import com.talhahasanzia.csv.core.SourceCallback;
import com.talhahasanzia.csv.exceptions.ParseException;

/**
 * Created by Talha Hasan Zia on 12-Feb-18.
 * <p></p><b>Description:</b><p></p> Why class was created?
 * <p></p>
 * <b>Public Methods:</b><p></p> Only listing to public methods usage.
 */
public class EasyParser implements SourceCallback {

    private Source source;
    private Parser parser;
    private ParseCallback parseCallback;

    public EasyParser() {
    }

    public EasyParser(Source source, Parser parser, ParseCallback parseCallback) {
        this.source = source;
        this.parser = parser;
        this.parseCallback = parseCallback;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public void setParseCallback(ParseCallback parseCallback) {
        this.parseCallback = parseCallback;
    }

    public void parse() {
        source.getData(this);
    }

    @Override
    public void onSourceFound(String data) {
        parser.parse(data, parseCallback);
    }

    @Override
    public void onSourceError(ParseException parseException) {
        parseCallback.onParsingFailure(parseException);
    }
}

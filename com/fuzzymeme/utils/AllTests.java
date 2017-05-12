package com.fuzzymeme.utils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fuzzymeme.utils.io.StreamingTableReaderTests;
import com.fuzzymeme.utils.io.TableReaderTests;
import com.fuzzymeme.utils.models.tables.TableTests;
import com.fuzzymeme.utils.parsers.MapParserTests;

@RunWith(Suite.class)
@SuiteClasses({ CounterMapTests.class, StringUtilsTests.class, PairTests.class, StreamingTableReaderTests.class, 
	TableReaderTests.class, TableTests.class, MapParserTests.class })
public class AllTests {

}
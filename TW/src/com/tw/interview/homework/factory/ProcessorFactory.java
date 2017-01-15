package com.tw.interview.homework.factory;

import com.tw.interview.homework.model.PatternObject;
import com.tw.interview.homework.processor.GalaxyTranslateProcessor;
import com.tw.interview.homework.processor.IProcessor;
import com.tw.interview.homework.processor.MetalCostProcessor;
import com.tw.interview.homework.processor.NoIdeaProcessor;
import com.tw.interview.homework.processor.NumToNumProcessor;
import com.tw.interview.homework.processor.NumToUnitProcessor;

/**
 * get different Processor by type
 * 
 * @author zhuyang
 *
 */
public enum ProcessorFactory {
	INSTANCE;
	public IProcessor getProcessor(PatternObject.Type type) {
		switch (type) {
		case NUM_NUM_EQ:
			return new NumToNumProcessor();
		case NUM_UNIT_EQ:
			return new NumToUnitProcessor();
		case GALAXY_TRANSLATE_QUESTION:
			return new GalaxyTranslateProcessor();
		case METAL_COST_QUESTION:
			return new MetalCostProcessor();
		case NOIDEA:
			return new NoIdeaProcessor();
		default:
			return new NoIdeaProcessor();

		}
	}
}

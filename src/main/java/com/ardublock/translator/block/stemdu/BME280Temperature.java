package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class BME280Temperature extends TranslatorBlock {

	public BME280Temperature(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public BME280Temperature(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public BME280Temperature(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		translator.addHeaderFile("Wire.h");
		translator.addHeaderFile("SparkFunBME280.h");

		translator.addDefinitionCommand("BME280 _STEMDU_BME280_sensor;\n");
		    
		translator.addSetupCommand("Wire.begin();\n");
		translator.addSetupCommand("_STEMDU_BME280_sensor.beginI2C()\n");

		return codePrefix + "_STEMDU_BME280_sensor.readTempC()" + codeSuffix;
	}

}

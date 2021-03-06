package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class MPU6050TemperatureRead extends TranslatorBlock{

	public MPU6050TemperatureRead(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public MPU6050TemperatureRead(Long blockId, Translator translator,
			String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public MPU6050TemperatureRead(Long blockId, Translator translator,
			String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toCode() throws SocketNullException,
			SubroutineNotDeclaredException {
		// TODO Auto-generated method stub
		translator.addHeaderFile("Wire.h");
		translator.addHeaderFile("I2Cdev.h");
		translator.addHeaderFile("MPU6050.h");

		translator.addDefinitionCommand("MPU6050 _STEMDU_accelgyro;\n");
		translator.addSetupCommand("_STEMDU_accelgyro.initialize();\n");

		return codePrefix + "((_STEMDU_accelgyro.getTemperature()+ 12412.0) / 340.0)" + codeSuffix;
	}
}

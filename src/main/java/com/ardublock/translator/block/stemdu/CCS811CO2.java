package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

//#define CCS811_ADDR 0x5B //Default I2C Address
//#define CCS811_ADDR 0x5A //Alternate I2C Address <-- Keystudio


public class CCS811CO2 extends TranslatorBlock {

	public CCS811CO2(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public CCS811CO2(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public CCS811CO2(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	private final static String readCO2function = "int readCO2SensorCodeAutoGeneratedReturnCM()\n{\n  if(_STEMDU_CCS811_sensor.dataAvailable())\n{\n  _STEMDU_CCS811_sensor.readAlgorithmResults();\n return _STEMDU_CCS811_sensor.getCO2();\n}\n return -1;\n}\n";

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		translator.addHeaderFile("Wire.h");
		translator.addHeaderFile("SparkFunCCS811.h");

		translator.addDefinitionCommand("#define CCS811_ADDR 0x5A\n");
		translator.addDefinitionCommand(readCO2function);
		translator.addDefinitionCommand("CCS811 _STEMDU_CCS811_sensor(CCS811_ADDR);\n");

		translator.addSetupCommand(" if (_STEMDU_CCS811_sensor.begin() == false)\n" +
				"		  {\n" +
				"		    Serial.print(\"CCS811 error. Please check wiring. Freezing...\");\n" +
				"		    while (1);\n" +
				"		  }\n");

		return codePrefix + "readCO2SensorCodeAutoGeneratedReturnCM()" + codeSuffix;
	}

}

package com.ardublock.translator.block.esp32;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class IoTAmbientSetup extends TranslatorBlock {

	public IoTAmbientSetup(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public IoTAmbientSetup(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public IoTAmbientSetup(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		translator.addHeaderFile("Wifi.h");
		translator.addHeaderFile("Ambient.h");

		translator.addDefinitionCommand("Adafruit_BME680 _STEMDU_BME680_sensor;\n");
		    
		translator.addSetupCommand("  if (!_STEMDU_BME680_sensor.begin()) {\n" + 
				"    Serial.println(\"Could not find a valid BME680 sensor, check wiring!\");\n" + 
				"    while (1);\n" + 
				"  };\n");
		translator.addSetupCommand("_STEMDU_BME680_sensor.setIIRFilterSize(BME680_FILTER_SIZE_3);\n");
		translator.addSetupCommand("_STEMDU_BME680_sensor.setGasHeater(320, 150);\n");

		return codePrefix + "_STEMDU_BME680_sensor.gas_resistance" + codeSuffix;
	}

}

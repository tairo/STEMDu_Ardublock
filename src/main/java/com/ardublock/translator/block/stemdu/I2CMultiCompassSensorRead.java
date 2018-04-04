package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class I2CMultiCompassSensorRead extends TranslatorBlock {

	public I2CMultiCompassSensorRead(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public I2CMultiCompassSensorRead(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public I2CMultiCompassSensorRead(Long blockId, Translator translator, String codePrefix, String codeSuffix,
			String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	private final static String i2ccompassSetup = "while (!_stemdu_compass.begin()) {\n  delay(500);\n}\nif(_stemdu_compass.isHMC()){\n  _stemdu_compass.setRange(HMC5883L_RANGE_1_3GA);\n  _stemdu_compass.setMeasurementMode(HMC5883L_CONTINOUS);\n  _stemdu_compass.setDataRate(HMC5883L_DATARATE_15HZ);\n  _stemdu_compass.setSamples(HMC5883L_SAMPLES_8);\n}\nelse if(_stemdu_compass.isQMC()){\n  _stemdu_compass.setRange(QMC5883_RANGE_2GA);\n  _stemdu_compass.setMeasurementMode(QMC5883_CONTINOUS);\n  _stemdu_compass.setDataRate(QMC5883_DATARATE_50HZ);\n  _stemdu_compass.setSamples(QMC5883_SAMPLES_8);\n  }\n";
	private final static String i2ccompassReadFunc = "float ardublockI2CCompassRead(int format, int isRelative){\n  Vector norm = compass.readNormalize();\n  float heading = atan2(norm.YAxis, norm.XAxis);\n  float declinationAngle = (-7.0 + (29.0 / 60.0)) / (180 / PI);\n  heading += declinationAngle;\n  If (isRelative == 1){\n    heading -= _stemdu_compass_origin;\n  }\n  if (heading < 0){\n    heading += 2 * PI;\n  }\n  if (heading > 2 * PI){\n    heading -= 2 * PI;\n  }\n  if(format == 0){\n  return headingDegrees = heading * 180/M_PI; \n  } else{\n  return heading;\n  }\n}\n";
	
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String outputFormat = translatorBlock.toCode();
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		String isReletive = translatorBlock.toCode();

		translator.addHeaderFile("Wire.h");
		translator.addHeaderFile("DFRobot_QMC5883.h");
		
		translator.addDefinitionCommand(i2ccompassReadFunc);
		translator.addDefinitionCommand("DFRobot_QMC5883 _stemdu_compass;\n float _stemdu_compass_origin = 0;\n");

		translator.addSetupCommand(i2ccompassSetup);

		return codePrefix + "ardublockI2CCompassRead(" + outputFormat + ", " + isReletive + ")" + codeSuffix;
	}

}

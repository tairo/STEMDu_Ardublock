package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class MPU6050GyroZAxisRead extends TranslatorBlock{
	public MPU6050GyroZAxisRead(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public MPU6050GyroZAxisRead(Long blockId, Translator translator,
			String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public MPU6050GyroZAxisRead(Long blockId, Translator translator,
			String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	private final static String mpu6050Function = "int16_t ardublockMPU6050GyroZAxisReturnCM(){\n  _STEMDU_accelgyro.getRotation(&_STEMDU_gx, &_STEMDU_gy, &_STEMDU_gz);\n  return _STEMDU_gz / 131.0;\n}\n";
	
	@Override
	public String toCode() throws SocketNullException,
			SubroutineNotDeclaredException {
		translator.addHeaderFile("Wire.h");
		translator.addHeaderFile("I2Cdev.h");
		translator.addHeaderFile("MPU6050.h");

		translator.addDefinitionCommand("MPU6050 _STEMDU_accelgyro;\nint16_t _STEMDU_gx, _STEMDU_gy, _STEMDU_gz;\n");
		translator.addDefinitionCommand(mpu6050Function);
		
		translator.addSetupCommand("_STEMDU_accelgyro.initialize();\n");

		return codePrefix + "ardublockMPU6050GyroZAxisReturnCM()" + codeSuffix;
	}

}

package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class S11059IR extends TranslatorBlock {

	public S11059IR(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public S11059IR(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public S11059IR(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	private final static String _STEMDU_readIRFunction = "int _STEMDU_readIRFunction() {_STEMDU_colorSensor.delay(); if (_STEMDU_colorSensor.update()) { return _STEMDU_colorSensor.getIR(); }else{ return 0; }}";

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		translator.addHeaderFile("Wire.h");
		translator.addHeaderFile("S11059.h");

		translator.addDefinitionCommand(_STEMDU_readIRFunction);

		translator.addDefinitionCommand("S11059 _STEMDU_colorSensor;\n");
		translator.addSetupCommand("_STEMDU_colorSensor.begin();\n");
		// 積分モードを固定時間モードに設定
		translator.addSetupCommand("_STEMDU_colorSensor.setMode(S11059_MODE_FIXED);\n");
		// 1色あたりの積分時間設定(下記は指定可能な定数ごとの固定時間モードの場合の積分時間)
		// * S11059_TINT0: 87.5 us
		// * S11059_TINT1: 1.4 ms
		// * S11059_TINT2: 22.4 ms
		// * S11059_TINT3: 179.2 ms
		translator.addSetupCommand("_STEMDU_colorSensor.setGain(S11059_GAIN_HIGH);\n");
		// 色あたりの積分時間設定(下記は指定可能な定数ごとの固定時間モードの場合の積分時間)
		// * S11059_TINT0: 87.5 us
		// * S11059_TINT1: 1.4 ms
		// * S11059_TINT2: 22.4 ms
		// * S11059_TINT3: 179.2 ms
		translator.addSetupCommand("_STEMDU_colorSensor.setTint(S11059_TINT1);\n");
		translator.addSetupCommand("if (!_STEMDU_colorSensor.reset()) { Serial.println(\"reset failed\"); }\n");
		translator.addSetupCommand("if (!_STEMDU_colorSensor.start()) { Serial.println(\"start failed\"); }\n");

		return codePrefix + "_STEMDU_readIRFunction();" + codeSuffix;
	}

}

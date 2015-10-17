package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class UltrasonicSensorPingRead extends TranslatorBlock {

	public UltrasonicSensorPingRead(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public UltrasonicSensorPingRead(Long blockId, Translator translator,
			String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public UltrasonicSensorPingRead(Long blockId, Translator translator,
			String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	private final static String ultraSonicFunction = "int ardublockUltrasonicSensorCodeAutoGeneratedReturnCM(int pingPin)\n{\n  long duration;\n  pinMode(pingPin, OUTPUT);\n  digitalWrite(pingPin, LOW);\n  delayMicroseconds(2);\n  digitalWrite(pingPin, HIGH);\n  delayMicroseconds(5);\n  digitalWrite(pingPin, LOW);\n  pinMode(pingPin, INPUT);\n  duration = pulseIn(pingPin, HIGH);\n  duration = duration / 59;\n if ((duration < 2) || (duration > 300)) return false;\n return duration;\n}\n";

	@Override
	public String toCode() throws SocketNullException,
			SubroutineNotDeclaredException {
		// TODO Auto-generated method stub
		String pingPin;
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		pingPin = translatorBlock.toCode();

		translator.addHeaderFile("STEMDu.h");

		String definitionCode = "STEMDu _STEMDU_robot = STEMDu();";
		translator.addDefinitionCommand(definitionCode);

		translator.addDefinitionCommand(ultraSonicFunction);

		translator.addSetupCommand("digitalWrite( " + pingPin + " , LOW );\n");

		String ret = "ardublockUltrasonicSensorCodeAutoGeneratedReturnCM( " + pingPin + " )";

		return codePrefix + ret + codeSuffix;
	}

}

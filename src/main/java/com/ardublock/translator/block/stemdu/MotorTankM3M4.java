package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class MotorTankM3M4 extends TranslatorBlock {

	public MotorTankM3M4(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public MotorTankM3M4(Long blockId, Translator translator, String codePrefix,
			String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public MotorTankM3M4(Long blockId, Translator translator, String codePrefix,
			String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException,
			SubroutineNotDeclaredException {
		// TODO Auto-generated method stub
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String speed1 = translatorBlock.toCode();
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		String speed2 = translatorBlock.toCode();

		translator.addHeaderFile("STEMDu.h");

		String definitionCode = "STEMDu _STEMDU_robot = STEMDu();";
		translator.addDefinitionCommand(definitionCode);
		
		String ret = "\t_STEMDU_robot.tankM3M4(" + speed1 + "," + speed2 + ");\n";
		return ret;
	}

}

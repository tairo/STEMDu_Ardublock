package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class MotorForward extends TranslatorBlock {

	public MotorForward(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
		// TODO Auto-generated method stub
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String speed = translatorBlock.toCode();

		translator.addHeaderFile("STEMDu.h");

		String definitionCode = "STEMDu _STEMDU_robot = STEMDu();";
		translator.addDefinitionCommand(definitionCode);
		
		String ret = "\t_STEMDU_robot.forwardM1M2(" + speed + ");\n";
		return ret;
	}

}

package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SoundRead extends TranslatorBlock {

	public SoundRead(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public SoundRead(Long blockId, Translator translator, String codePrefix,
			String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public SoundRead(Long blockId, Translator translator, String codePrefix,
			String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException,
			SubroutineNotDeclaredException {
		// TODO Auto-generated method stub
		translator.addHeaderFile("STEMDu.h");

		String definitionCode = "STEMDu _STEMDU_robot = STEMDu();";
		translator.addDefinitionCommand(definitionCode);
		
		String ret = "_STEMDU_robot.readSound()";
		return codePrefix + ret + codeSuffix;
	}

}

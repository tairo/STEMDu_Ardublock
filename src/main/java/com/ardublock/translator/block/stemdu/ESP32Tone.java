package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class ESP32Tone extends TranslatorBlock {

	public ESP32Tone(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public ESP32Tone(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public ESP32Tone(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		TranslatorBlock pinBlock = this.getRequiredTranslatorBlockAtSocket(0);
		TranslatorBlock freqBlock = this.getRequiredTranslatorBlockAtSocket(1);

		translator.addHeaderFile("STEMDu.h");
		translator.addDefinitionCommand("STEMDu _STEMDU_robot = STEMDu();");
		
		String ret = "_STEMDU_robot.tone(" + pinBlock.toCode() + ", " + freqBlock.toCode() + ");\n";
		return ret;
	}

}

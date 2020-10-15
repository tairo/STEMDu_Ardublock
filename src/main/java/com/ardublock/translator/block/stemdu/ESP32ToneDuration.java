package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class ESP32ToneDuration extends TranslatorBlock {

	public ESP32ToneDuration(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public ESP32ToneDuration(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public ESP32ToneDuration(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		TranslatorBlock pinBlock = this.getRequiredTranslatorBlockAtSocket(0);
		TranslatorBlock freqBlock = this.getRequiredTranslatorBlockAtSocket(1);
		TranslatorBlock timeBlock = this.getRequiredTranslatorBlockAtSocket(2);
		/* NOTE: Tone() is non-blocking but beginners assume that it is.
		 * Playing multiple notes involves extra code to wait
		 * for each note to finish before playing the next.
		 * This wait is not always what is wanted and Delay() would cause massive problems with SCoop.
		 * Should we automate this - perhaps in s different block - Note ?*/

		translator.addHeaderFile("STEMDu.h");
		translator.addDefinitionCommand("STEMDu _STEMDU_robot = STEMDu();");

		String ret = "_STEMDU_robot.tone(" + pinBlock.toCode() + ", " + freqBlock.toCode() + ", " + timeBlock.toCode() + ");\n";
		return ret;	}

}

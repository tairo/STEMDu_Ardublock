package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class OLEDDrawLine extends TranslatorBlock {

	public OLEDDrawLine(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public OLEDDrawLine(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public OLEDDrawLine(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		String ret = "_stemdu_oled_display.drawLine(" + this.getTranslatorBlockAtSocket(0).toCode() + "," + this.getTranslatorBlockAtSocket(1).toCode() + "," + this.getTranslatorBlockAtSocket(2).toCode() + "," + this.getTranslatorBlockAtSocket(3).toCode() + ", SSD1306_WHITE);\n";

		return ret;
	}

}

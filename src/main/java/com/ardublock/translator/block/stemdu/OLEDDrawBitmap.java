package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class OLEDDrawBitmap extends TranslatorBlock {

	public OLEDDrawBitmap(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public OLEDDrawBitmap(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public OLEDDrawBitmap(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String bitmapNum = translatorBlock.toCode();

		translator.addHeaderFile("STEMDuArchade.h");

		String ret = "_stemdu_oled_display.drawBitmap(" + this.getTranslatorBlockAtSocket(1).toCode() + "," + this.getTranslatorBlockAtSocket(2).toCode() + ",_stemdu_bitmap" + this.getTranslatorBlockAtSocket(0).toCode() + ", 8, 8, SSD1306_WHITE);\n";
		
		return ret;
	}

}

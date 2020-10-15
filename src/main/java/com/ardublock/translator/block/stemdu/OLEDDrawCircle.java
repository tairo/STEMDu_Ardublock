package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class OLEDDrawCircle extends TranslatorBlock {

	public OLEDDrawCircle(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public OLEDDrawCircle(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public OLEDDrawCircle(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(4);
		String test = translatorBlock.toCode();

		String ret;
				
		if(test.equals("true")){
			ret = "_stemdu_oled_display.fillCircle(" + this.getTranslatorBlockAtSocket(0).toCode() + "," + this.getTranslatorBlockAtSocket(1).toCode() + "," + this.getTranslatorBlockAtSocket(2).toCode() + "," + this.getTranslatorBlockAtSocket(3).toCode() + ", SSD1306_WHITE);\n";
		}
		else {
			ret = "_stemdu_oled_display.drawCircle(" + this.getTranslatorBlockAtSocket(0).toCode() + "," + this.getTranslatorBlockAtSocket(1).toCode() + "," + this.getTranslatorBlockAtSocket(2).toCode() + "," + this.getTranslatorBlockAtSocket(3).toCode() + ", SSD1306_WHITE);\n";
		}
		return ret;
	}

}

package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class I2CLCDPrint  extends TranslatorBlock
{
	public I2CLCDPrint(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		translator.addHeaderFile("STEMDu.h");
		translator.addHeaderFile("I2CLiquidCrystal.h");
		translator.addHeaderFile("Wire.h");
		
		translator.addDefinitionCommand("I2CLiquidCrystal _stemdu_i2clcd(40, false);\n");

		translator.addSetupCommand("_stemdu_i2clcd.begin(STEMDU_I2CLCD_WIDTH, STEMDU_I2CLCD_HEIGHT);\n");

		String ret = "_stemdu_i2clcd.setCursor(" + this.getTranslatorBlockAtSocket(1).toCode() +","+this.getTranslatorBlockAtSocket(0).toCode()+");\n";

		TranslatorBlock translatorBlock = this.getTranslatorBlockAtSocket(2, "_stemdu_i2clcd.print(", ");\n");
		if (translatorBlock != null) {
			ret += translatorBlock.toCode();
		}		

		return ret;
	}
}

package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class I2CLCDClear extends TranslatorBlock {

	public I2CLCDClear(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public I2CLCDClear(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public I2CLCDClear(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		translator.addHeaderFile("STEMDu.h");
		translator.addHeaderFile("I2CLiquidCrystal.h");
		translator.addHeaderFile("Wire.h");
		
		translator.addDefinitionCommand("I2CLiquidCrystal _stemdu_i2clcd(40, false);\n");

		translator.addSetupCommand("_stemdu_i2clcd.begin(STEMDU_I2CLCD_WIDTH, STEMDU_I2CLCD_HEIGHT);\n");

		String ret = "_stemdu_i2clcd.clear();\n";

		return ret;
	}

}

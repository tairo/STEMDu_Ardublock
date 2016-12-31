package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SoftwareSerialPrintln extends TranslatorBlock {

	public SoftwareSerialPrintln(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public SoftwareSerialPrintln(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public SoftwareSerialPrintln(Long blockId, Translator translator, String codePrefix, String codeSuffix,
			String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		translator.addHeaderFile("SoftwareSerial.h");

		TranslatorBlock translatorBlock = this.getTranslatorBlockAtSocket(0);
		String RX = translatorBlock.toCode();
		translatorBlock = this.getTranslatorBlockAtSocket(1);
		String TX = translatorBlock.toCode();
		translator.addDefinitionCommand("SoftwareSerial _STEMDU_SoftwareSerial("+RX+","+TX+");");
		translator.addSetupCommand("_STEMDU_SoftwareSerial.begin(9600);");

		translatorBlock = this.getTranslatorBlockAtSocket(2, "_STEMDU_SoftwareSerial.print(", ");\n");
		
		String ret = "";
		if (translatorBlock != null) {
			ret = translatorBlock.toCode();
		}
		ret = ret + "_STEMDU_SoftwareSerial.println();\n";
		
		return ret;	}

}

package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class OLEDSetup extends TranslatorBlock {

	public OLEDSetup(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public OLEDSetup(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public OLEDSetup(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		translator.addHeaderFile("Wire.h");
		translator.addHeaderFile("Adafruit_GFX.h");
		translator.addHeaderFile("Adafruit_SSD1306.h");

		translator.addDefinitionCommand("#define OLED_RESET 4\n");
		translator.addDefinitionCommand("Adafruit_SSD1306 _stemdu_oled_display(" + this.getTranslatorBlockAtSocket(1).toCode() +"," + this.getTranslatorBlockAtSocket(2).toCode() + ", &Wire, OLED_RESET);\n");

		translator.addSetupCommand("\tif(!_stemdu_oled_display.begin(SSD1306_SWITCHCAPVCC, 0x" + this.getTranslatorBlockAtSocket(0).toCode() + ")) {\t\tfor(;;);\n\t}\n");
		
		return null;
	}

}

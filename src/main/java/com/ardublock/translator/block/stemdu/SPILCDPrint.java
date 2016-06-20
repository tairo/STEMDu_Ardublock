package com.ardublock.translator.block.stemdu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SPILCDPrint extends TranslatorBlock
{
	public SPILCDPrint(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	private final static String spilcdFunction = "void ardublockSPILCDDraw(String msg){\n  _STEMDU_u8g.setFont(u8g_font_unifont);\n  _STEMDU_u8g.firstPage();\n  do {\n    _STEMDU_u8g.setPrintPos(0,11);\n    _STEMDU_u8g.print(msg);\n  } while( _STEMDU_u8g.nextPage() );\n  delay(50);\n}\n";
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		translator.addHeaderFile("U8glib.h");
		translator.addHeaderFile("STEMDu.h");

		translator.addDefinitionCommand("U8GLIB_AQM1248A_2X _STEMDU_u8g(SPILCD_CS,SPILCD_RS);");
		translator.addDefinitionCommand(spilcdFunction);
		
		TranslatorBlock translatorBlock = this.getTranslatorBlockAtSocket(0, "ardublockSPILCDDraw(", ");\n");
		
		String ret = "";
		if (translatorBlock != null) {
			ret = translatorBlock.toCode();
		}
		
		return ret;
	}
}

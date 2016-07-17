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

	private final static String spilcdFunction1 = "int ardublockSPILCDDraw(int line, int pos, String msg){\n	  _STEMDU_u8g.setFont(u8g_font_unifont);\n	  _STEMDU_u8g.firstPage();\n	    do {\n	    	if(line < 1 || line > 4) line = 1;	        _STEMDU_u8g.setPrintPos(8*pos,11*line+(line-1));\n	        _STEMDU_u8g.print(msg);\n	    } while( _STEMDU_u8g.nextPage() );\n	    delay(50);\n	    return pos+msg.length();\n	  }\n";
	private final static String spilcdFunction2 = "int ardublockSPILCDDraw(int line, int pos, int msg){\n	  String msgstr = String(msg);	  _STEMDU_u8g.setFont(u8g_font_unifont);\n	  _STEMDU_u8g.firstPage();\n	    do {\n	    	if(line < 1 || line > 4) line = 1;	        _STEMDU_u8g.setPrintPos(8*pos,11*line+(line-1));\n	        _STEMDU_u8g.print(msgstr);\n	    } while( _STEMDU_u8g.nextPage() );\n	    delay(50);\n	    return pos+msgstr.length();\n	  }\n";
	private final static String spilcdFunction3 = "int ardublockSPILCDDraw(int line, int pos, double msg){\n	  String msgstr = String(msg);	  _STEMDU_u8g.setFont(u8g_font_unifont);\n	  _STEMDU_u8g.firstPage();\n	    do {\n	    	if(line < 1 || line > 4) line = 1;	        _STEMDU_u8g.setPrintPos(8*pos,11*line+(line-1));\n	        _STEMDU_u8g.print(msgstr);\n	    } while( _STEMDU_u8g.nextPage() );\n	    delay(50);\n	    return pos+msgstr.length();\n	  }\n";
	private final static String spilcdFunction4 = "int ardublockSPILCDDraw(int line, int pos, long msg){\n	  String msgstr = String(msg);	  _STEMDU_u8g.setFont(u8g_font_unifont);\n	  _STEMDU_u8g.firstPage();\n	    do {\n	    	if(line < 1 || line > 4) line = 1;	        _STEMDU_u8g.setPrintPos(8*pos,11*line+(line-1));\n	        _STEMDU_u8g.print(msgstr);\n	    } while( _STEMDU_u8g.nextPage() );\n	    delay(50);\n	    return pos+msgstr.length();\n	  }\n";
	private final static String spilcdFunction5 = "int ardublockSPILCDDraw(int line, int pos, boolean msg){\n	  String msgstr = String(msg);	  _STEMDU_u8g.setFont(u8g_font_unifont);\n	  _STEMDU_u8g.firstPage();\n	    do {\n	    	if(line < 1 || line > 4) line = 1;	        _STEMDU_u8g.setPrintPos(8*pos,11*line+(line-1));\n	        _STEMDU_u8g.print(msgstr);\n	    } while( _STEMDU_u8g.nextPage() );\n	    delay(50);\n	    return pos+msgstr.length();\n	  }\n";
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		translator.addHeaderFile("U8glib.h");
		translator.addHeaderFile("STEMDu.h");

		translator.addDefinitionCommand("U8GLIB_AQM1248A_2X _STEMDU_u8g(SPILCD_CS,SPILCD_RS);");
		translator.addDefinitionCommand(spilcdFunction1);
		translator.addDefinitionCommand(spilcdFunction2);
		translator.addDefinitionCommand(spilcdFunction3);
		translator.addDefinitionCommand(spilcdFunction4);
		translator.addDefinitionCommand(spilcdFunction5);
		translator.addDefinitionCommand("int _STEMDU_SPILCD_pos = 0;");
		translator.addDefinitionCommand("int _STEMDU_SPILCD_line = 0;");

		TranslatorBlock translatorBlock = this.getTranslatorBlockAtSocket(0, "_STEMDU_SPILCD_pos = ardublockSPILCDDraw(_STEMDU_SPILCD_line, _STEMDU_SPILCD_pos, ", ");\n");
		TranslatorBlock translatorBlock2 = this.getTranslatorBlockAtSocket(1);
		
		String ret = "_STEMDU_SPILCD_pos = 0;\n";
		ret = ret + "_STEMDU_SPILCD_line = " + translatorBlock2.toCode() +";\n";
		if (translatorBlock != null) {
			ret += translatorBlock.toCode();
		}
		
		return ret;
	}
}

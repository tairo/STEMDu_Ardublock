package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Loop2Block extends TranslatorBlock
{
	public Loop2Block(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
	    String ret="";
		TranslatorBlock translatorBlock = getTranslatorBlockAtSocket(0);
		while (translatorBlock != null)
		{
			ret += translatorBlock.toCode();
			translatorBlock = translatorBlock.nextTranslatorBlock();
		}
        translator.addSetupCommand(ret);
//		return "";
		ret="";
		ret = "void loop()\n{\n";
		TranslatorBlock translatorBlock2 = getTranslatorBlockAtSocket(1);
		while (translatorBlock2 != null)
		{
			ret = ret + translatorBlock2.toCode();
			translatorBlock2 = translatorBlock2.nextTranslatorBlock();
		}
		ret = ret + "}\n\n";
		return ret;
	}
}

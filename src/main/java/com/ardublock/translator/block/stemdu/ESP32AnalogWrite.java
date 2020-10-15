package com.ardublock.translator.block.stemdu;

import java.util.ResourceBundle;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.NumberBlock;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class ESP32AnalogWrite extends TranslatorBlock {
	
	private static ResourceBundle uiMessageBundle = ResourceBundle.getBundle("com/ardublock/block/ardublock");

	public ESP32AnalogWrite(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public ESP32AnalogWrite(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public ESP32AnalogWrite(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String portNum = translatorBlock.toCode();
		
		if ( ! ("12 13 14 18 19 25 26 27").contains(portNum.trim()) )
		{
			throw new BlockException(blockId, uiMessageBundle.getString("ardublock.error_msg.Digital_pin_slot"));
		}

		/*
		if (translatorBlock instanceof NumberBlock)
		{
			translator.addOutputPin(portNum.trim());
		}
		else
		{
			String setupCode = "pinMode( " + portNum + " , OUTPUT);";
			translator.addSetupCommand(setupCode);
		}
		*/
		
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		String value = translatorBlock.toCode();

		translator.addHeaderFile("STEMDu.h");
		translator.addDefinitionCommand("STEMDu _STEMDU_robot = STEMDu();");
		
		String ret = "_STEMDU_robot.analogWrite" + portNum + "(" + value + ");\n";
		return ret;
	}

}

package com.ardublock.translator.block.esp32;

import java.util.ResourceBundle;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class ESP32ServoSg90Block extends TranslatorBlock {

	private static ResourceBundle uiMessageBundle = ResourceBundle.getBundle("com/ardublock/block/ardublock");

	public ESP32ServoSg90Block(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public ESP32ServoSg90Block(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public ESP32ServoSg90Block(Long blockId, Translator translator, String codePrefix, String codeSuffix,
			String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket(0);

		String servoSpecs = ",1000,2000";

		String pinNumber = tb.toCode();
		String servoName = "servo_pin_" + pinNumber;

		//****** Bit long w but easy to see what's happening. Any other invalid pins? *********
		if ( ! ("12 13 14 18 19 25 26 27").contains(pinNumber.trim()) )
		{
			throw new BlockException(blockId, uiMessageBundle.getString("ardublock.error_msg.Digital_pin_slot"));
		}
		
		tb = this.getRequiredTranslatorBlockAtSocket(1);

		translator.addHeaderFile("ESP32Servo.h");
		translator.addDefinitionCommand("Servo " + servoName + ";");
		translator.addSetupCommand(servoName + ".setPeriodHertz(50);");
		translator.addSetupCommand(servoName + ".attach(" + pinNumber + servoSpecs + ");");

		String ret = servoName + ".write( " + tb.toCode() + " );\n";
		return ret;
	}
}

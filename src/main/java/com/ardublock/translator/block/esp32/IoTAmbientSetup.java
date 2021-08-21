package com.ardublock.translator.block.esp32;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class IoTAmbientSetup extends TranslatorBlock {

	public IoTAmbientSetup(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public IoTAmbientSetup(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public IoTAmbientSetup(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}


	
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		translator.addHeaderFile("Wifi.h");
		translator.addHeaderFile("Ambient.h");

		translator.addDefinitionCommand("WiFiClient _STEMDU_wifi_client;");
		translator.addDefinitionCommand("Ambient _STEMDU_ambient;");

		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String ssid = translatorBlock.toCode();
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		String password = translatorBlock.toCode();
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
		String channelId = translatorBlock.toCode();
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(3);
		String writeKey = translatorBlock.toCode();		
		
		/*
		String ssid = "TP-Link_C160";
		String password = "********";
		int channelId = 24701;
		String writeKey = "ee071499ebec6477";
		*/
		
		translator.addSetupCommand("WiFi.begin(" + ssid + "," + password + ");\n");
		
		translator.addSetupCommand("while (WiFi.status() != WL_CONNECTED) {\n"+
	        "delay(500);" +
	        "Serial.print(\".\");" +
	    "}");
	    
		translator.addSetupCommand("_STEMDU_ambient.begin(" + channelId +", " + writeKey + ", &_STEMDU_wifi_client);\n"); 
		
		return codePrefix + "" + codeSuffix;
	}

}

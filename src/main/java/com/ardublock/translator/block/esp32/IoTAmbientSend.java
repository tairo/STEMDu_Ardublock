package com.ardublock.translator.block.esp32;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

wifisetup = "void setup_wifi() {\n" + 
		"\n" + 
		"  delay(10);\n" + 
		"  // We start by connecting to a WiFi network\n" + 
		"  Serial.println();\n" + 
		"  Serial.print(\"Connecting to \");\n" + 
		"  Serial.println(ssid);\n" + 
		"\n" + 
		"  WiFi.begin(ssid, password);\n" + 
		"\n" + 
		"  while (WiFi.status() != WL_CONNECTED) {\n" + 
		"    delay(500);\n" + 
		"    Serial.print(\".\");\n" + 
		"  }\n" + 
		"\n" + 
		"  randomSeed(micros());\n" + 
		"\n" + 
		"  Serial.println(\"\");\n" + 
		"  Serial.println(\"WiFi connected\");\n" + 
		"  Serial.println(\"IP address: \");\n" + 
		"  Serial.println(WiFi.localIP());\n" + 
		"}";

public class IoTAmbientSend extends TranslatorBlock {

	public IoTAmbientSend(Long blockId, Translator translator) {
		super(blockId, translator);
		// TODO Auto-generated constructor stub
	}

	public IoTAmbientSend(Long blockId, Translator translator, String codePrefix, String codeSuffix) {
		super(blockId, translator, codePrefix, codeSuffix);
		// TODO Auto-generated constructor stub
	}

	public IoTAmbientSend(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException, BlockException {
		// TODO Auto-generated method stub
		return null;
	}

}

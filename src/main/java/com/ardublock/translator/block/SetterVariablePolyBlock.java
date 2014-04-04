package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SetterVariablePolyBlock extends TranslatorBlock
{
	public SetterVariablePolyBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket(0);
		if (!(tb instanceof VariablePolyBlock))
		{
			throw new BlockException(blockId, "digital var must be digital var");
		}
		
		String ret = tb.toCode();
		tb = this.getRequiredTranslatorBlockAtSocket(1);
		ret ="\t"+ ret + " = " ;
		if(tb.toCode().replace("\"","").length()>1){
    		ret+=tb.toCode() + ";\n";
    	}else{
    	    ret+="\'"+tb.toCode().replace("\"","") + "\';\n";
    	}
		return ret;
	}

}

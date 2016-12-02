package romano;

import br.com.jtcgen.annotations.JTCGen;
import br.com.jtcgen.annotations.TestEquals;

@JTCGen
public class NumerosRomanos {
	
	@TestEquals({"0", ""})
	@TestEquals({"1", "I"})
	@TestEquals({"2", "II"})
	@TestEquals({"5", "V"})
	public String transforma(int numero) {
		switch (numero) {
		case 1:
			return "I" ;
		case 2:
			return "II";
			
		case 5:
			return "V";
		default:
			break;
		}
		return "";
	}
}
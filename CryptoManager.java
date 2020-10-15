public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {

		boolean bound = true;
		
		for(int n = 0; n < plainText.length(); n++)
		{
			if(plainText.charAt(n) < LOWER_BOUND ||  plainText.charAt(n) > UPPER_BOUND)
			{
				
				bound = false;
				
			}
		}
		return bound;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {

		String CeasarText = "";
		
		if(stringInBounds(plainText))
		{
			for (int num = 0; num < plainText.length(); num++)
			{
				char n = plainText.charAt(num);
				
				int cryp = ((int) n + key);
				
				while(cryp > UPPER_BOUND)
				{
					cryp -= RANGE;
				}
				
				CeasarText += (char)cryp;
			}
		}
		return CeasarText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {

		String BellasoText = "";
		if(stringInBounds(plainText))
		{
		for(int num = 0; num < plainText.length(); num++)
		{
			
			char p = plainText.charAt(num);
			
			int crypted = (int)p+(int)bellasoStr.charAt(num % bellasoStr.length());
			
			while(crypted > (int)UPPER_BOUND)
			{
				crypted= crypted - RANGE;
			}
			BellasoText+=(char)crypted; 
		}
		}
		return BellasoText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {

		String decrypted = "";
		
		
		for(int num = 0; num < encryptedText.length(); num++)
		{
			char n = (char) (encryptedText.charAt(num)-key);
			
			while(n > UPPER_BOUND)
			{
				n -= RANGE;
			}
			decrypted += n;
		}
		
		return decrypted;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {

		int BellasoResult;
		
		String decrypted = "";
		
		for (int num = 0; num < encryptedText.length(); num++)
		{
			
			BellasoResult=(int)((int)encryptedText.charAt(num) - bellasoStr.charAt(num % bellasoStr.length()));
			
			while(BellasoResult < LOWER_BOUND)
			{
				BellasoResult=(char)(BellasoResult + RANGE);
			}
			
			decrypted+=(char)BellasoResult;
		}
		return decrypted;
	}
}
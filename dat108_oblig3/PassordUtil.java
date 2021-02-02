package no.hvl.dat108;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.ejb.EJB;
import javax.xml.bind.DatatypeConverter;


public class PassordUtil {
	
	@EJB
	DeltagerEAO delEAO;
	
	Hashing hash = new Hashing();
	

private static Hashing ph = new Hashing(); // the PBKDF uses its own algorithm (e.g. PBKDF2WithHmacSHA1) to derive a secret key
		
private static final int ITERATION = 120000;
private static final int KEYLENGTH = 256;		// we need 256 bits key length

		

		
		public boolean riktigPassord(String passord, Deltager del) throws NoSuchAlgorithmException, InvalidKeySpecException{

			int iteration = 120000;
			int keylength = 256;
			
			if(del != null) {
				String salt = del.getPassordSalt();
				System.out.println(salt);
				String hashPass = del.getPassordHash();
				System.out.println(hashPass);
				
				if(hash.validatePasswordWithSaltAndIteration(passord, salt, hashPass, keylength, iteration)) {
					return true;
				}
			}
			
			return false;
			
			
		}
		


	public boolean passordHash(String passord) throws NoSuchAlgorithmException, InvalidKeySpecException{
		
		byte[] saltBytes = hash.getSalt();
		hash.generateHashWithSaltAndIteration(passord,saltBytes,KEYLENGTH,ITERATION);
		
		
		
		return false;
	}
	
	


}

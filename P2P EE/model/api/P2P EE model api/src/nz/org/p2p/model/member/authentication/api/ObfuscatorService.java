/*
 * This software is offered under the 2007  GNU AFERO GENERAL PUBLIC LICENCE.
 * @see nz.org.p2p.model.member.authentication.api package documentation.
 */
package nz.org.p2p.model.member.authentication.api;

/**
 * The Interface <code>IObfuscator</code> provides data obfuscation either by encryption or
 * hashing algorithm. Data should obfuscated in such a away that recovery of
 * the original data by a third party is difficult or impossible.
 * @see nz.org.p2p.model.member.authentication.api

 */
public interface ObfuscatorService {

	/**
	 * Create, encrypt, encode, or hash value so that it's is not easily
	 * discernible to third parties.
	 *
	 * @param token the token
	 * @return an obfuscated representation of the supplied token.
	 */
	String obfuscate(String token);
}

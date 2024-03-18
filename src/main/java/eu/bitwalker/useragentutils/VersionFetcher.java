package eu.bitwalker.useragentutils;

/**
 * Interaface that gets string and returns extrancted version 
 * @author alexr
 */
@FunctionalInterface
interface VersionFetcher {
	/**
	 * parse version
	 *
	 * @param str
	 * @return
	 */
	Version version(String str);
}

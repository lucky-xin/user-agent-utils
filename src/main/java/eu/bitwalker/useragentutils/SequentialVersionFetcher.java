package eu.bitwalker.useragentutils;

/**
 * Implementation of {@link VersionFetcher} that holds a list of other {@link VersionFetcher}
 * and calls them sequentially until any of them manages to find version.  
 * @author alexr
 */
public class SequentialVersionFetcher implements VersionFetcher {
	private final VersionFetcher[] fetchers;
	
	public SequentialVersionFetcher(VersionFetcher first, VersionFetcher... others) {
		fetchers = new VersionFetcher[others.length + 1];
		fetchers[0] = first;
        System.arraycopy(others, 0, fetchers, 1, others.length);
	}

	@Override
	public Version version(String str) {
		for (VersionFetcher fetcher : fetchers) {
			Version version = fetcher.version(str);
			if (version != null) {
				return version;
			}
		}
		return null;
	}

}

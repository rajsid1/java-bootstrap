package com.app.service.sample;

/**
 * Created by rajdeep siddhapura.
 */
public class SampleServiceJPAImpl implements SampleService
{
	private static SampleServiceJPAImpl sInstance;

	private SampleServiceJPAImpl() {
	}

	public static SampleServiceJPAImpl getInstance() {
		if (sInstance == null) {
			synchronized (SampleServiceJPAImpl.class) {
				if (sInstance == null) {
					sInstance = new SampleServiceJPAImpl();
				}
			}
		}
		return sInstance;
	}

	@Override
	public void call(String foo, String bar)
	{
		//PersistenceAPI.get();
		//PersistenceAPI.saveOrUpdate();
		//PersistenceAPI.delete();
	}
}

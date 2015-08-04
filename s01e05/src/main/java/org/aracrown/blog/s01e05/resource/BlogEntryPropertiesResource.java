package org.aracrown.blog.s01e05.resource;

public class BlogEntryPropertiesResource {
	private boolean enabled;
	
	private boolean commentsEnabled;

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the commentsEnabled
	 */
	public boolean isCommentsEnabled() {
		return commentsEnabled;
	}

	/**
	 * @param commentsEnabled the commentsEnabled to set
	 */
	public void setCommentsEnabled(boolean commentsEnabled) {
		this.commentsEnabled = commentsEnabled;
	}
	
	
}

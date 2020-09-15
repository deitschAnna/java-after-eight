package org.codefx.java_after_eight.post;

import static java.util.Objects.requireNonNull;

public record VideoSlug(String value) implements Comparable<VideoSlug> {

	// use static factory method(s)
	@Deprecated
	public VideoSlug { }

	public static VideoSlug from(String value) {
		requireNonNull(value);
		if (value.isBlank())
			throw new IllegalArgumentException("Slugs can't have an empty value.");
		return new VideoSlug(value);
	}

	@Override
	public int compareTo(VideoSlug right) {
		return this.value.compareTo(right.value);
	}

}

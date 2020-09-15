package org.codefx.java_after_eight.post;

import static java.util.Objects.requireNonNull;

public record Repository(String identifier) {

	// use static factory method(s)
	@Deprecated
	public Repository { }

	public static Repository from(String identifier) {
		requireNonNull(identifier);
		if (identifier.isBlank())
			throw new IllegalArgumentException("Repositories can't have an empty identifier.");
		return new Repository(identifier);
	}

}

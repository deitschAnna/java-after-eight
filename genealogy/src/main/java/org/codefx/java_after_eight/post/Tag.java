package org.codefx.java_after_eight.post;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toUnmodifiableSet;

public record Tag(String text) {

	// use static factory method(s)
	@Deprecated
	public Tag { }

	public static Set<Tag> from(String tagsText) {
		return Stream.of(tagsText
				.replaceAll("^\\[|\\]$", "")
				.split(","))
				.map(String::strip)
				.filter(not(String::isBlank))
				.map(Tag::new)
				.collect(toUnmodifiableSet());
	}

}

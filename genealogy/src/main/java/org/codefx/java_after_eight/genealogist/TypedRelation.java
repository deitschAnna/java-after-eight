package org.codefx.java_after_eight.genealogist;

import org.codefx.java_after_eight.post.Post;

import static java.util.Objects.requireNonNull;

public record TypedRelation(
		Post post1,
		Post post2,
		RelationType type,
		long score) {

	// use static factory method(s)
	@Deprecated
	public TypedRelation { }

	public static TypedRelation from(Post post1, Post post2, RelationType type, long score) {
		if (score < 0 || 100 < score)
			throw new IllegalArgumentException("Score should be in interval [0; 100]: " + score);
		return new TypedRelation(
				requireNonNull(post1),
				requireNonNull(post2),
				requireNonNull(type),
				score);
	}

}

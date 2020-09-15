package org.codefx.java_after_eight.genealogists.type;

import org.codefx.java_after_eight.genealogist.Genealogist;
import org.codefx.java_after_eight.genealogist.RelationType;
import org.codefx.java_after_eight.genealogist.TypedRelation;
import org.codefx.java_after_eight.post.Post;

public class TypeGenealogist implements Genealogist {

	@Override
	public TypedRelation infer(Post post1, Post post2) {
		long score = switch (post2.getClass().getSimpleName()) {
			case "Article" -> 50;
			case "Video" -> 90;
			case "Talk" -> 20;
			default -> 0;
		};

		return TypedRelation.from(post1, post2, RelationType.from("type"), score);
	}

}

package org.codefx.java_after_eight.genealogists.repo;

import org.codefx.java_after_eight.genealogist.Genealogist;
import org.codefx.java_after_eight.genealogist.RelationType;
import org.codefx.java_after_eight.genealogist.TypedRelation;
import org.codefx.java_after_eight.post.Post;
import org.codefx.java_after_eight.post.Repository;
import org.codefx.java_after_eight.post.Article;
import org.codefx.java_after_eight.post.Video;

import java.util.Objects;
import java.util.Optional;

public class RepoGenealogist implements Genealogist {

	@Override
	public TypedRelation infer(Post post1, Post post2) {
		long score = determineScore(post1, post2);
		return TypedRelation.from(post1, post2, RelationType.from("repo"), score);
	}

	private long determineScore(Post post1, Post post2) {
		var repo1 = getRepository(post1);
		var repo2 = getRepository(post2);

		if (repo1.isPresent() != repo2.isPresent())
			return 0;
		// at this point, either both are empty or both are non-empty
		if (repo1.isEmpty())
			return 20;
		return Objects.equals(repo1, repo2) ? 100 : 50;
	}

	private Optional<Repository> getRepository(Post post) {
		if (post instanceof Article article)
			return article.repository();
		if (post instanceof Video video)
			video.repository();
		return Optional.empty();
	}

}

package org.codefx.demo.java_after_eight.genealogy;

import org.codefx.demo.java_after_eight.article.Article;

// REFACTOR 9: service
public interface Genealogist {

	TypedRelation infer(Article article1, Article article2);

}
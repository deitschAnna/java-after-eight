package org.codefx.java_after_eight.post;

import org.codefx.java_after_eight.TextParserTests;
import org.codefx.java_after_eight.post.Description;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DescriptionTests {

	@Test
	void emptyText_exception() {
		assertThatThrownBy(() -> Description.from("")).isInstanceOf(IllegalArgumentException.class);
	}

	@Nested
	class QuotationTests implements TextParserTests.QuotationTests {

		@Override
		public String parseCreateExtract(String text) {
			return Description.from(text).text();
		}

	}

}

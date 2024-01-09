package functional;

import bean.Book;

@FunctionalInterface
public interface BookPredicate {
	boolean test(Book book);
}
package org.colorfuldays.ssm.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: huxing(huxing1985@gmail.com)
 * Date: 12-5-22
 * Time: 下午4:43
 */
public class BookDO implements Serializable{
    private static final long serialVersionUID = 5937564722456140316L;

    private int id;
    private String name;
    private List<String> authorList;
    private String isbn;
    private long publishDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<String> authorList) {
        this.authorList = authorList;
    }

    public void addAuthor(String authorName) {
        if (authorList == null) {
            authorList = new ArrayList<String>();
        }
        authorList.add(authorName);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public long getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(long publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "BookDO{" +
                "name='" + name + '\'' +
                ", authorList=" + authorList +
                ", isbn='" + isbn + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}

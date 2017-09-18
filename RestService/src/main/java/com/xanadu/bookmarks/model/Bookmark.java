package com.xanadu.bookmarks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bookmark
{
    @ManyToOne
    @JsonIgnore
    private Account mAccount;

    @Id
    @GeneratedValue
    private Long mId;

    public String mUri;
    public String mDescription;

    Bookmark()
    {
    }

    public Bookmark(final Account account, final String uri, final String description)
    {
        this.mUri = uri;
        this.mDescription = description;
        this.mAccount = account;
    }

    public Account getAccount()
    {
        return mAccount;
    }

    public Long getId()
    {
        return mId;
    }

    public String getUri()
    {
        return mUri;
    }

    public String getDescription()
    {
        return mDescription;
    }
}

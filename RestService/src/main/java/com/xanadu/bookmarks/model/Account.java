package com.xanadu.bookmarks.model;
//import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account
{
    @OneToMany(mappedBy = "mAccount")
    private Set<Bookmark> mBookmarks = new HashSet<>();

    @JsonIgnore
    public String mPassword;
    public String mUsername;

    @Id
    @GeneratedValue
    private Long mId;

    public Account(final String name, final String password)
    {
        this.mUsername = name;
        this.mPassword = password;
    }

    Account()
    {
    }


    public Set<Bookmark> getBookmarks()
    {
        return mBookmarks;
    }

    public Long getId()
    {
        return mId;
    }

    public String getPassword()
    {
        return mPassword;
    }

    public String getUsername()
    {
        return mUsername;
    }

    @Override
    public String toString()
    {
        return String.format("Username: %s.", mUsername);
    }
}

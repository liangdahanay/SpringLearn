package com.xanadu.bookmarks.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long>
{
    Optional<Account> findByMUsername(final String username);
}

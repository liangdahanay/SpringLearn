package com.xanadu.bookmarks.rest;

import com.xanadu.bookmarks.model.Account;
import com.xanadu.bookmarks.model.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class DemoApplication
{
    private static final Logger sLogger = LoggerFactory.getLogger(DemoApplication.class);
    private static final String SEP = "-----------";

    public static void main(String[] args)
    {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(final AccountRepository repository)
    {
        return (args) ->
        {
            repository.save(new Account("account1", "password1"));
            repository.save(new Account("account2", "password2"));

            sLogger.info("Account found with findAll():");
            sLogger.info(SEP);
            for (final Account account : repository.findAll())
            {
                sLogger.info(account.toString());
            }
            sLogger.info("");

            Account account = repository.findOne(1L);
            sLogger.info("Account found with findOne(1L):");
            sLogger.info(SEP);
            sLogger.info(account.toString());
            sLogger.info("");

            sLogger.info("Account found with findByMUsername('account1')");
            sLogger.info(SEP);
            final Optional<Account> optional = repository.findByMUsername("account1");
            Account account1 = optional.get();
            sLogger.info(account1.toString());
            sLogger.info("");

        };
    }

}

package com.edu.sgestagio.sgestagio.Config;

import com.edu.sgestagio.sgestagio.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;

@Configuration
public class DBConfig {
    @Autowired
    private DBService dbService;

    @Bean
    public void instantiateDataBase() throws ParseException {
        dbService.InstantiateDataBase();
        dbService.InstantiateVagasDB();
    }
}

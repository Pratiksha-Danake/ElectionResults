package com.amaap.electionresult;

import com.amaap.electionresult.repository.ConstituencyRepository;
import com.amaap.electionresult.repository.db.InMemoryDatabase;
import com.amaap.electionresult.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.electionresult.repository.impl.InMemoryConstituencyRepository;
import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ConstituencyRepository.class).to(InMemoryConstituencyRepository.class);
        bind(InMemoryDatabase.class).to(FakeInMemoryDatabase.class).asEagerSingleton();
    }
}

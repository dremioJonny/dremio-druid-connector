/*
 * Copyright (C) 2017-2019 Dremio Corporation. This file is confidential and private property.
 */
package com.dremio.exec.store.jdbc.dialect;

import com.dremio.exec.store.jdbc.dialect.arp.ArpYaml;
import com.dremio.exec.store.jdbc.dialect.JdbcDremioSqlDialect;
import com.dremio.exec.store.jdbc.JdbcPluginConfig;
import com.dremio.exec.store.jdbc.dialect.arp.ArpDialect;
import com.dremio.exec.store.jdbc.JdbcSchemaFetcherImpl;

  public class DruidDialect extends ArpDialect {
    public DruidDialect(ArpYaml yaml) {
    super(yaml);
  }

  static class DruidSchemaFetcher extends JdbcSchemaFetcherImpl {

      public DruidSchemaFetcher(JdbcPluginConfig config) {
          super(config);
      }

      protected boolean usePrepareForColumnMetadata() {
          return true;
      }
  }

  @Override
  public JdbcSchemaFetcherImpl newSchemaFetcher(JdbcPluginConfig config) {
      return new DruidSchemaFetcher(config);
  }

  public boolean supportsNestedAggregations() {
      return false;
  }
}

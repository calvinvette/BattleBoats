BattleBoats

To install, first launch a Derby instance
Use the "data/create_tables.ddl" script to create the Player and Navy table with the schema "BattleBoats"

Launch JBoss or Tomcat and deploy the war file to it.

For now, the hibernate settings are set to RESOURCE_LOCAL; not using a JTA Data Source
Also not using a hibernate setting for auto-create tables



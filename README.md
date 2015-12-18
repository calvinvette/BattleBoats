BattleBoats

To install, first launch a Derby instance
Use the "data/create_tables.ddl" script to create the Player and Navy table with the schema "BattleBoats"

Launch JBoss or Tomcat and deploy the war file to it.

For now, the hibernate settings are set to RESOURCE_LOCAL; not using a JTA Data Source
Also not using a hibernate setting for auto-create tables





echo "# BattleBoats" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/calvinvette/BattleBoats.git
git push -u origin master


git remote add origin https://github.com/calvinvette/BattleBoats.git
git push -u origin master



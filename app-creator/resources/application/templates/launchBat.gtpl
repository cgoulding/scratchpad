java -Dapp.war.file=./../webapps/${appWarFile} -Dapp.context=/${appContext} -Dapp.server.threads.min=${appServerThreadsMin} -Dapp.server.threads.max=${appServerThreadsMax} -Dapp.server.port=${appServerPort} -jar ./../lib/app-package-1.0-SNAPSHOT-jar-with-dependencies.jar
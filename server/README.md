# XSN Block Explorer - Server

## Run
1. We need the xsn rpc server running, download the latest one from [xsn releases](https://github.com/X9Developers/XSN/releases), then, start the rpc server with: `bin/xsnd -txindex -addressindex -spentindex -rpcport=51473 -rpcuser=dummy -rpcpassword=replaceme`

2. Edit the [application.conf](server/conf/application.conf).

* In case you modified the parameters to start the xsn rpc server, update the credentials.

* Set the credentials to access a postgres database.

3. Run the application with: `sbt run`

## Test
Run the `sbt test` command to execute the tests.

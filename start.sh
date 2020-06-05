#!/bin/sh
export OKTA_CLIENT_ID=
export OKTA_CLIENT_SECRET=
export OKTA_ISSUER_URI=
export KEYVAULT_URI=https://advworkkv01.vault.azure.net/
export KEYVAULT_CLIENT_ID=
export KEYVAULT_TENANT_ID=
export KEYVAULT_KEY=

echo '==================='
echo 'Running : java ' '-jar aw-server.jar'
echo '==================='
exec java -jar aw-server.jar

@echo off
local

for %%s in (api-gateway appointment clinic config-server eurekaserver notification patient payment) do (
  echo Building image: %%s
  call "%~dp0%%s\mvnw.cmd" -f "%~dp0%%s\pom.xml" compile jib:dockerBuild || exit /b 1
)

echo All images were built successfully
docker images
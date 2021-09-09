#!/usr/bin/env bash
./gradlew --quiet "installDist" && "./build/install/release-cli/bin/release-cli" "$@"

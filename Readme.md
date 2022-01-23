# Zachtronics Leaderboard Bot

A discord & reddit bot for automating solution submission/display for [Zachtronics](http://www.zachtronics.com/) games.

Currently included:
 - [Opus Magnum](https://www.zachtronics.com/opus-magnum/)
 - [SpaceChem](https://www.zachtronics.com/spacechem/)
 - [Shenzhen I/O](https://www.zachtronics.com/shenzhen-io/)
 
## Use
The bot runs in the [unofficial Zachtronics Discord Server](https://discord.gg/98QNzdJ), usable from slash commands.  
The Opus Magnum graphical leaderboard and API is hosted at https://zlbb.faendir.com/ .  
The official leaderboard copies managed by the bot are in the wiki page of the game subreddits.

## Build
0. Set up docker-compose, create a discord bot, create a reddit app, get a github personal access token. Follow respective guides.

1. Run gradle:
```
./gradlew build
``` 
2. Run via `docker-compose`:
```yaml
version: "3.7"

services:
  om-discord-bot:
    build: .
    container_name: om-discord-bot
    environment:
      JDA_TOKEN: abc
      GIT_USERNAME: def
      GIT_ACCESS_TOKEN: ghi
      REDDIT_USERNAME: jkl
      REDDIT_ACCESS_TOKEN: mno
      REDDIT_CLIENT_ID: pqr
      REDDIT_PASSWORD: stu
```
Alternatively to `build .` you can use prebuilt `image: f43nd1r/zachtronics-leaderboard-bot:latest`. This makes the gradle build obsolete.

---

The used github repositories are hardcoded into each leaderboard. You'll need to change those if the supplied github account does not have access to the original ones.

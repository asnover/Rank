package me.snover.rank;

public enum Rank {
    DEFAULT(0, "Default", ""),
    MODERATOR(10, "Moderator", "§bMod"),
    ADMINISTRATOR(20, "Administrator", "§bAdmin"),
    DIRECTOR(30, "Director", "§1Director");

    final int rankID;
    final String name;
    final String displayName;
    Rank(int rankID, String name, String displayName) {
        this.rankID = rankID;
        this.name = name;
        this.displayName = displayName;
    }

    public int getRankID() {
        return this.rankID;
    }

    public String getName() {
        return this.name;
    }

    public String getDisplayName(){
        return this.displayName;
    }

    public boolean playerHasRank(Rank rank) {
        return rank.getRankID() == this.rankID;
    }

    public boolean playerHasRankMin(Rank rank) {
        return rank.getRankID() >= this.rankID;
    }

}

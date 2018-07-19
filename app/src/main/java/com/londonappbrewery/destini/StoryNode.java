package com.londonappbrewery.destini;

public class StoryNode {
    private int storyResId;
    private int ansTopResId;
    private int ansBottomResId;
    private int pathTopResId;
    private int pathBottomResId;
    private boolean end;

    public StoryNode(int storyResId) {
        this.storyResId = storyResId;
        this.end = true;
    }

    public StoryNode(int storyResId, int ansTopResId, int ansBottomResId, int pathTopResId, int pathBottomResId) {
        this.storyResId = storyResId;
        this.ansTopResId = ansTopResId;
        this.ansBottomResId = ansBottomResId;
        this.pathTopResId = pathTopResId;
        this.pathBottomResId = pathBottomResId;
        this.end = false;
    }

    public int getStoryResId() {
        return storyResId;
    }

    public int getAnsTopResId() {
        return ansTopResId;
    }

    public int getAnsBottomResId() {
        return ansBottomResId;
    }

    public int getPathTopResId() {
        return pathTopResId;
    }

    public int getPathBottomResId() {
        return pathBottomResId;
    }

    public boolean isEnd() {
        return end;
    }
}

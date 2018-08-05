package com.shiyuji.model;

public class NearbyItem {
    private int head;
    private String name;
    private boolean isFollowed;
    private String content;
    private int image;
    private String likeNum;
    private String commentNum;
    private String shareNum;

    public NearbyItem(int head, String name, boolean isFollowed, String content, int image, String likeNum, String commentNum, String shareNum) {
        this.head = head;
        this.name = name;
        this.isFollowed = isFollowed;
        this.content = content;
        this.image = image;
        this.likeNum = likeNum;
        this.commentNum = commentNum;
        this.shareNum = shareNum;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFollowed() {
        return isFollowed;
    }

    public void setFollowed(boolean followed) {
        isFollowed = followed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(String likeNum) {
        this.likeNum = likeNum;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }

    public String getShareNum() {
        return shareNum;
    }

    public void setShareNum(String shareNum) {
        this.shareNum = shareNum;
    }
}

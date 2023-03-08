package com.jones.goldenmonitor.controller;

public class BaseController {
    protected int size = 20;
    protected int page = 1;
    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}

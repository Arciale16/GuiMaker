package net.zartra.gui;
final class Pagination { private Pagination(){} static int pages(int entries,int pageSize){return Math.max(1,(entries+Math.max(1,pageSize)-1)/Math.max(1,pageSize));} static int offset(int page,int entries,int pageSize){return Math.max(0,Math.min(Math.max(0,page-1),pages(entries,pageSize)-1))*Math.max(1,pageSize);} }

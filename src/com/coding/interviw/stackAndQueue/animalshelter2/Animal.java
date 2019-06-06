package com.coding.interviw.stackAndQueue.animalshelter2;

public abstract  class Animal {
    private int order;
    protected String name;
    public Animal(String n){
        name = n;
    }
    public void setOrder(int ord){
        order = ord;
    }
    public int getOrder(){
        return order;
    }

    /* Compare orders of animals to return the older item

     */
    public boolean isOlderThan(Animal animal){
        return this.order < animal.getOrder();
    }
}
